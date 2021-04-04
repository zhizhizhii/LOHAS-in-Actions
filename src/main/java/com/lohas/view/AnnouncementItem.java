package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ShopAnnouncement;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class AnnouncementItem {

    @ApiModelProperty(value = "公告")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("publishtime")
    private Date publishTime;

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
        setContent(shopAnnouncement.getContent());
        setTitle(shopAnnouncement.getTitle());
        setPublishTime(shopAnnouncement.getPublishTime());
    }
}
