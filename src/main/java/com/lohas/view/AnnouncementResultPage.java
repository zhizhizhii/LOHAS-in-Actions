package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ShopAnnouncement;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.util.List;

public class AnnouncementResultPage {
    @ApiModelProperty(value = "公告列表")
    @JsonProperty("shopannouncements")
    List<ShopAnnouncement>shopAnnouncements;

    public AnnouncementResultPage(Page<ShopAnnouncement> shopAnnouncementPage){

    }
}
