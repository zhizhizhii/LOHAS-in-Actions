package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.MysteryBox;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class MysteryBoxItem {
    @ApiModelProperty(value = "商品id")
    @JsonProperty("product_id")
    private Integer productId;

    @ApiModelProperty(value = "商品名")
    @JsonProperty("product_name")
    private String productName;

    @ApiModelProperty(value = "商品介绍")
    @JsonProperty("product_intro")
    private String productIntro;

    @ApiModelProperty(value = "商品价格")
    private double price;

    @ApiModelProperty(value = "上传日期")
    @JsonProperty("product_pubdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date productPubdate;

    @ApiModelProperty(value = "商品图片")
    @JsonProperty("product_pic")
    private String productPic;

    public MysteryBoxItem(MysteryBox mysteryBox){
        setPrice(mysteryBox.getPrice());
        setProductId(mysteryBox.getProductId());
        setProductIntro(mysteryBox.getProductIntro());
        setProductName(mysteryBox.getProductName());
        setProductPic(mysteryBox.getProductPic());
        setProductPubdate(mysteryBox.getProductPubdate());
    }
}
