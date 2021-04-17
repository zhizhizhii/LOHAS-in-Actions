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
public class ShopDetailedInfoWithCollectPage extends PaginationReceive {

    @ApiModelProperty(value = "带是否收藏的商品信息列表")
    @JsonProperty("shop_briefinfo_items")
    private List<ShopDetailedInfoWithCollectItem> shopDetailedInfoWithCollectItems;

    public ShopDetailedInfoWithCollectPage(Page<ShopInfo> s, List<Integer> collect){
        setPageNum(s.getNumber() + 1);
        setTotalPage(s.getTotalPages());
        List<ShopInfo> shopInfos = s.getContent();
        List<ShopDetailedInfoWithCollectItem> list = new ArrayList<>();
        Integer size = shopInfos.size();
        for(int i = 0 ; i < size; i++){
            ShopDetailedInfoWithCollectItem collectItem = new ShopDetailedInfoWithCollectItem();
            ShopInfo si = shopInfos.get(i);
            collectItem.setShopId(si.getShop().getShopId());
            collectItem.setShopType(si.getShopType());
            collectItem.setShopName(si.getShopName());
            collectItem.setShopLohasInfo(si.getShopLohasInfo());
            collectItem.setAvatar(si.getAvatar());
            collectItem.setShopLongitude(si.getShopLongitude());
            collectItem.setShopLatitude(si.getShopLatitude());
            collectItem.setHeadPicture(si.getHeadPicture());
            collectItem.setShopIntro(si.getShopIntro());
            collectItem.setShopBusinessHours(si.getShopBusinessHours());
            collectItem.setShopAddress(si.getShopAddress());
            collectItem.setIsCollected(collect.get(i));
            list.add(collectItem);
        }
        setShopDetailedInfoWithCollectItems(list);
    }
}
