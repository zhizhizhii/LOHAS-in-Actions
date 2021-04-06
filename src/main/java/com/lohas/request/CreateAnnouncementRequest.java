package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateAnnouncementRequest {

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "公告内容")
    private String content;

}
