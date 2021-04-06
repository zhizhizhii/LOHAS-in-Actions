package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.ShopAnnouncement;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class AnnouncementPage extends PaginationReceive {

    @ApiModelProperty(value = "公告列表")
    @JsonProperty("shop_announcements")
    private List<AnnouncementItem> shopAnnouncements;

    public AnnouncementPage(Page<ShopAnnouncement> shopAnnouncementPage){
        setPageNum(shopAnnouncementPage.getNumber() + 1);
        setTotalPage(shopAnnouncementPage.getTotalPages());
        setShopAnnouncements(shopAnnouncementPage.stream().map(AnnouncementItem::new).collect(Collectors.toList()));
    }
}
