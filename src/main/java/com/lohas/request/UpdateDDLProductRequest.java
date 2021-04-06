package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDDLProductRequest {

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

    @ApiModelProperty(value = "生产日期")
    @JsonProperty("productiondate")
    private Date productionDate;

    @ApiModelProperty(value = "过期日期")
    @JsonProperty("expirtydate")
    private Date expiryDate;

    @ApiModelProperty(value = "过期日期")
    @JsonProperty("expirtydate")
    private String productPic;
}
