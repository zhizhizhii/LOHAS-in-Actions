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
    @JsonProperty("product_id")
    private Integer productId;

    @ApiModelProperty(value = "商品名")
    @JsonProperty("product_name")
    private String productName;

    @ApiModelProperty(value = "商品介绍")
    @JsonProperty("product_intro")
    private String productIntro;

    @JsonProperty("origin_cost")
    private Double originCost;

    @JsonProperty("current_cost")
    private Double currentCost;

    @ApiModelProperty(value = "生产日期")
    @JsonProperty("production_date")
    private Date productionDate;

    @ApiModelProperty(value = "过期日期")
    @JsonProperty("expiry_date")
    private Date expiryDate;

    @ApiModelProperty(value = "上传日期")
    @JsonProperty("product_pubdate")
    private Date productPubdate;

    private Double discount;

    @ApiModelProperty(value = "商品图片")
    @JsonProperty("product_pic")
    private String productPic;

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
        setProductPic(ddlProduct.getProductPic());
    }
}
