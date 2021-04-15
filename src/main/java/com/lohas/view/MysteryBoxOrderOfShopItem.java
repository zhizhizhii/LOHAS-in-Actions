package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.dao.inter.MysteryBoxOrderOfShopInterface;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MysteryBoxOrderOfShopItem {
    @ApiModelProperty(value = "订单id")
    @JsonProperty("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "下单用户id")
    @JsonProperty("user_id")
    private Integer userId;

    @ApiModelProperty(value = "下单用户名")
    @JsonProperty("username")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "是否取货")
    @JsonProperty("is_taken")
    private Boolean isTaken;

    @ApiModelProperty(value = "下单时间")
    @JsonProperty("order_time")
    private Date orderTime;

    @ApiModelProperty(value = "商品id")
    @JsonProperty("product_id")
    private Integer productId;

    @ApiModelProperty(value = "商品名")
    @JsonProperty("product_name")
    private String productName;

    @ApiModelProperty(value = "商品图片")
    @JsonProperty("product_pic")
    private String productPic;

    public MysteryBoxOrderOfShopItem(MysteryBoxOrderOfShopInterface mysteryBoxOrderOfShopInterface){
        setAvatar(mysteryBoxOrderOfShopInterface.getAvatar());
        setIsTaken(mysteryBoxOrderOfShopInterface.getIs_Taken());
        setOrderId(mysteryBoxOrderOfShopInterface.getOrder_Id());
        setOrderTime(mysteryBoxOrderOfShopInterface.getOrder_Time());
        setProductId(mysteryBoxOrderOfShopInterface.getProduct_Id());
        setProductName(mysteryBoxOrderOfShopInterface.getProduct_Name());
        setProductPic(mysteryBoxOrderOfShopInterface.getProduct_Pic());
        setUserId(mysteryBoxOrderOfShopInterface.getUser_Id());
        setUserName(mysteryBoxOrderOfShopInterface.getUser_Name());
    }
}
