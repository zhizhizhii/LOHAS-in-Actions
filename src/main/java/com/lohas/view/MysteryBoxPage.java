package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.MysteryBox;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MysteryBoxPage extends PaginationReceive {
    @ApiModelProperty(value = "盲盒列表")
    @JsonProperty("mystery_box_list")
    private List<MysteryBoxItem> mysteryBoxItems;

    public MysteryBoxPage(Page<MysteryBox> mysteryBoxPage){
        setPageNum(mysteryBoxPage.getNumber() + 1);
        setTotalPage(mysteryBoxPage.getTotalPages());
        setMysteryBoxItems(mysteryBoxPage.stream().map(MysteryBoxItem::new).collect(Collectors.toList()));
    }
}
