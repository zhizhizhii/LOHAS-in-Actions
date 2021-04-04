package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ShopAnnouncement;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class AnnouncementItem {

    @ApiModelProperty(value = "公告id")
    @JsonProperty("announcementid")
    private Integer announcementId;

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("publishtime")
    private Date publishTime;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public AnnouncementItem(ShopAnnouncement shopAnnouncement){
        setAnnouncementId(shopAnnouncement.getAnnouncementId());
        setContent(shopAnnouncement.getContent());
        setTitle(shopAnnouncement.getTitle());
        setPublishTime(shopAnnouncement.getPublishTime());
    }
}
