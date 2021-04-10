package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.ShopInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;


@Data
public class ShopBriefInfoWithCollectPage extends PaginationReceive {

    @ApiModelProperty(value = "带是否收藏的商品信息列表")
    @JsonProperty("shop_briefinfo_items")
    private List<ShopBriefInfoWithCollectItem> shopBriefInfoWithCollectItems;

    public ShopBriefInfoWithCollectPage(Page<ShopInfo> s, List<Integer> collect){
        setPageNum(s.getNumber() + 1);
        setTotalPage(s.getTotalPages());
        List<ShopInfo> shopInfos = s.getContent();
        List<ShopBriefInfoWithCollectItem> list = new ArrayList<>();
        Integer size = shopInfos.size();
        for(int i = 0 ; i < size; i++){
            ShopBriefInfoWithCollectItem collectItem = new ShopBriefInfoWithCollectItem();
            ShopInfo si = shopInfos.get(i);
            collectItem.setShopId(si.getShop().getShopId());
            collectItem.setShopType(si.getShopType());
            collectItem.setShopName(si.getShopName());
            collectItem.setShopLohasInfo(si.getShopLohasInfo());
            collectItem.setAvatar(si.getAvatar());
            collectItem.setShopLongitude(si.getShopLongitude());
            collectItem.setShopLatitude(si.getShopLatitude());
            collectItem.setIsCollected(collect.get(i));
            list.add(collectItem);
        }
        setShopBriefInfoWithCollectItems(list);
    }
}
