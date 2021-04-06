package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.ForsaleProduct;
import com.lohas.model.ShopAnnouncement;
import com.lohas.model.ShopInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShopBriefInfoPage extends PaginationReceive {

    @ApiModelProperty(value = "商品信息列表")
    @JsonProperty("shop_briefinfo_items")
    private List<ShopBriefInfoItem> shopBriefInfoItems;

    public ShopBriefInfoPage(Page<ShopInfo> shopBriefInfoPage){
        setPageNum(shopBriefInfoPage.getNumber() + 1);
        setTotalPage(shopBriefInfoPage.getTotalPages());

        List<ShopBriefInfoItem> list = new ArrayList<>();
        for(ShopInfo item : shopBriefInfoPage){
            ShopBriefInfoItem s = new ShopBriefInfoItem();
            s.setShopId(item.getShop().getShopId());
            s.setShopType(item.getShopType());
            s.setShopName(item.getShopName());
            s.setShopLohasInfo(item.getShopLohasInfo());
            s.setAvatar(item.getAvatar());
            s.setShopLongitude(item.getShopLongitude());
            s.setShopLatitude(item.getShopLatitude());
            list.add(s);
        }
        setShopBriefInfoItems(list);
    }

}
