package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class MysteryBoxOrderOfUserPage extends PaginationReceive {
    @ApiModelProperty(value = "盲盒订单列表")
    @JsonProperty("mystery_boxes")
    private List<MysteryBoxOrderOfUserItem> mysteryBoxOrderOfUserItems;

    public MysteryBoxOrderOfUserPage(Page<MysteryBoxOrderOfUserInterface> mysteryBoxOrderOfUserInterfacePage){
        setPageNum(mysteryBoxOrderOfUserInterfacePage.getNumber() + 1);
        setTotalPage(mysteryBoxOrderOfUserInterfacePage.getTotalPages());
        List<MysteryBoxOrderOfUserItem> list = new ArrayList<>();
        for(MysteryBoxOrderOfUserInterface mysteryBoxOrderOfUserInterface: mysteryBoxOrderOfUserInterfacePage){
            MysteryBoxOrderOfUserItem mysteryBoxOrderOfUserItem = new MysteryBoxOrderOfUserItem(mysteryBoxOrderOfUserInterface);
            list.add(mysteryBoxOrderOfUserItem);
        }
        setMysteryBoxOrderOfUserItems(list);
    }
}
