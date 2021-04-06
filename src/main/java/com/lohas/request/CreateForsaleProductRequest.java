package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateForsaleProductRequest {

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

    @ApiModelProperty(value = "商品图片")
    @JsonProperty("product_pic")
    private String productPic;

}
