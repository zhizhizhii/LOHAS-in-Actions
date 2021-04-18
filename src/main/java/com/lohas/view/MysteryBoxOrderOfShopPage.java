package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
@Data
public class MysteryBoxOrderOfShopPage extends PaginationReceive {
    @ApiModelProperty(value = "盲盒列表")
    @JsonProperty("mystery_boxes")
    private List<MysteryBoxOrderOfShopItem> mysteryBoxOrderOfShopItems;

    public MysteryBoxOrderOfShopPage(Page<MysteryBoxOrderOfShopInterface> mysteryBoxOrderOfShopInterfacePage){
        setPageNum(mysteryBoxOrderOfShopInterfacePage.getNumber() + 1);
        setTotalPage(mysteryBoxOrderOfShopInterfacePage.getTotalPages());
        List<MysteryBoxOrderOfShopItem> list = new ArrayList<>();
        for(MysteryBoxOrderOfShopInterface mysteryBoxOrderOfShopInterface : mysteryBoxOrderOfShopInterfacePage){
            MysteryBoxOrderOfShopItem mysteryBoxOrderOfShopItem = new MysteryBoxOrderOfShopItem(mysteryBoxOrderOfShopInterface);
            list.add(mysteryBoxOrderOfShopItem);
        }
        setMysteryBoxOrderOfShopItems(list);
    }
}
