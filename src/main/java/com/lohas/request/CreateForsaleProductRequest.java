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
    @JsonProperty("productname")
    private String productName;

    @ApiModelProperty(value = "商品介绍")
    @JsonProperty("productintro")
    private String productIntro;

    private Double originCost;

    private Double currentCost;

    private String productPic;
}
