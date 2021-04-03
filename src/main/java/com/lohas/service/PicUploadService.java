package com.lohas.service;

import com.aliyun.oss.OSS;
import com.lohas.config.AliyunOSSConfig;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import com.lohas.view.PicUploadResult;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

@Service
public class PicUploadService {

    private PicUploadResult picUploadResult = new PicUploadResult();

    @Autowired
    private OSS ossClient;

    @Autowired
    private AliyunOSSConfig aliyunOSSConfig;

    private static final String[] IMAGE_TYPE = new String[]{
      ".bmp",".jpg",".jpeg",".gif",".png"
    };

    public PicUploadResult upload(MultipartFile uploadFile) {

        //判定图片格式是否合法
        boolean isLegal = false;
        for(String type : IMAGE_TYPE){
            if(StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(),type)){
                isLegal = true;
                break;
            }
        }

        if(!isLegal){
            picUploadResult.setStatus("error");
        }

        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);


        //上传至阿里云OSS
        try{
            //目录结构:images/(year)/(month)/(day)/filename（随机唯一文件名）
            ossClient.putObject(
                    aliyunOSSConfig.getBucketName(),
                    filePath,
                    new ByteArrayInputStream(uploadFile.getBytes())
            );

        }catch (Exception e){
            e.printStackTrace();
            picUploadResult.setStatus("error");
            return picUploadResult;
        }

        picUploadResult.setStatus("done");
        picUploadResult.setPic_url(aliyunOSSConfig.getUrlPrefix() + filePath);

        return picUploadResult;
    }

    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return "images/"+
                dateTime.toString("yyyy") + "/" +
                dateTime.toString("MM") + "/" +
                dateTime.toString("dd") + "/" +
                System.currentTimeMillis() + RandomUtils.nextInt(100,9999) + "." +
                StringUtils.substringAfterLast(sourceFileName,".");
    }
}
