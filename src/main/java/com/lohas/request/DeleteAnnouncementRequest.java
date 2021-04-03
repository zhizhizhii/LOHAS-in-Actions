package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;

public class DeleteAnnouncementRequest {

    @ApiModelProperty(value = "要删除的公告id")
    private Integer announcementId;

    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }
}
