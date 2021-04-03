package com.lohas.controller;

import com.lohas.service.PicUploadService;
import com.lohas.view.PicUploadResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "图片上传模块(OSS)")
@Controller
@RequestMapping(path="/api/pic")
public class PicUploadController {

    @Autowired
    private PicUploadService picUploadService;

    @PostMapping(path="/upload")
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file") MultipartFile multipartFile){
        return picUploadService.upload(multipartFile);
    }
}
