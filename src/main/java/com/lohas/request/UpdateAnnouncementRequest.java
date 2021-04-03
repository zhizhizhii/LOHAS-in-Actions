package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UpdateAnnouncementRequest {

    @ApiModelProperty(value = "要修改的公告id")
    @JsonProperty("announcementid")
    private Integer announcementId;

    @ApiModelProperty(value = "要修改的公告标题")
    private String title;

    @ApiModelProperty(value = "要修改的公告内容")
    private String context;

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
