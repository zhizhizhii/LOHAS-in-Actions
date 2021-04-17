package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PicUploadResult {

    @ApiModelProperty("图片存放的url")
    private String pic_url;

    @ApiModelProperty("存储成功与否")
    private String status;

}
