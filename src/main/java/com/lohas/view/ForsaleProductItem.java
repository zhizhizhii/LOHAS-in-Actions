package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ForsaleProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ForsaleProductItem {
    @ApiModelProperty(value = "商品id")
    @JsonProperty("productid")
    private Integer productId;

    @ApiModelProperty(value = "商品名")
    @JsonProperty("productname")
    private String productName;

    @ApiModelProperty(value = "商品介绍")
    @JsonProperty("productintro")
    private String productIntro;

    @JsonProperty("origincost")
    private Double originCost;

    @JsonProperty("currentcost")
    private Double currentCost;

    @ApiModelProperty(value = "上传日期")
    @JsonProperty("productpubdate")
    private Date productPubdate;

    private Double discount;

    public ForsaleProductItem(ForsaleProduct forsaleProduct){
        setProductId(forsaleProduct.getProductId());
        setCurrentCost(forsaleProduct.getCurrentCost());
        setOriginCost(forsaleProduct.getOriginCost());
        setProductIntro(forsaleProduct.getProductIntro());
        setProductName(forsaleProduct.getProductName());
        setDiscount(forsaleProduct.getDiscount());
        setProductPubdate(forsaleProduct.getProductPubdate());
    }
}
