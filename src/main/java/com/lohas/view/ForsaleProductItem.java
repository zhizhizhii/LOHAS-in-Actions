package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ForsaleProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@NoArgsConstructor
public class ForsaleProductItem {
    @ApiModelProperty(value = "商品id")
    @JsonProperty("product_id")
    private Integer productId;

    @ApiModelProperty(value = "商品名")
    @JsonProperty("product_name")
    private String productName;

    @ApiModelProperty(value = "商品介绍")
    @JsonProperty("product_intro")
    private String productIntro;

    @ApiModelProperty(value = "商品原价")
    @JsonProperty("origin_cost")
    private Double originCost;

    @ApiModelProperty(value = "商品现价")
    @JsonProperty("current_cost")
    private Double currentCost;

    @ApiModelProperty(value = "上传日期")
    @JsonProperty("product_pubdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date productPubdate;

    private Double discount;

    @ApiModelProperty(value = "商品图片")
    @JsonProperty("product_pic")
    private String productPic;

    public ForsaleProductItem(ForsaleProduct forsaleProduct){
        setProductId(forsaleProduct.getProductId());
        setCurrentCost(forsaleProduct.getCurrentCost());
        setOriginCost(forsaleProduct.getOriginCost());
        setProductIntro(forsaleProduct.getProductIntro());
        setProductName(forsaleProduct.getProductName());
        setDiscount(forsaleProduct.getDiscount());
        setProductPubdate(forsaleProduct.getProductPubdate());
        setProductPic(forsaleProduct.getProductPic());
    }
}
