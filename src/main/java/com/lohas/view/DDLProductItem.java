package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.DDLProduct;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class DDLProductItem {
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

    @ApiModelProperty(value = "上传日期")
    @JsonProperty("productpubdate")
    private Date productPubdate;

    private Double discount;

    public DDLProductItem(DDLProduct ddlProduct){
        setCurrentCost(ddlProduct.getCurrentCost());
        setOriginCost(ddlProduct.getOriginCost());
        setExpiryDate(ddlProduct.getExpiryDate());
        setProductionDate(ddlProduct.getProductionDate());
        setProductPubdate(ddlProduct.getProductPubdate());
        setProductName(ddlProduct.getProductName());
        setProductIntro(ddlProduct.getProductIntro());
        setDiscount(ddlProduct.getDiscount());
        setProductId(ddlProduct.getProductId());
    }
}
