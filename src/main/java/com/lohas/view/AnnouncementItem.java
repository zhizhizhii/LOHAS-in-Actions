package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ShopAnnouncement;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class AnnouncementItem {

    @ApiModelProperty(value = "公告id")
    @JsonProperty("announcement_id")
    private Integer announcementId;

    @ApiModelProperty(value = "公告标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("publish_time")
    private Date publishTime;



    public AnnouncementItem(ShopAnnouncement shopAnnouncement){
        setAnnouncementId(shopAnnouncement.getAnnouncementId());
        setContent(shopAnnouncement.getContent());
        setTitle(shopAnnouncement.getTitle());
        setPublishTime(shopAnnouncement.getPublishTime());
    }
}
