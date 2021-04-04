package com.lohas.request;

import com.lohas.model.Shop;
import io.swagger.annotations.ApiModelProperty;

public class CreateAnnouncementRequest {

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "公告内容")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
