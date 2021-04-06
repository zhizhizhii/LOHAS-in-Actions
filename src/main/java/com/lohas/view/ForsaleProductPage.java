package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationReceive;
import com.lohas.model.ForsaleProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ForsaleProductPage extends PaginationReceive {

    @ApiModelProperty(value = "促销商品列表")
    @JsonProperty("forsaleproduct_item_list")
    private List<ForsaleProductItem> forsaleProductItems;

    public ForsaleProductPage(Page<ForsaleProduct> forsaleProductPage){
        setPageNum(forsaleProductPage.getNumber() + 1);
        setTotalPage(forsaleProductPage.getTotalPages());
        setForsaleProductItems(forsaleProductPage.stream().map(ForsaleProductItem::new).collect(Collectors.toList()));
    }
}
