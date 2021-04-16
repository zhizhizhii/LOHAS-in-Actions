package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.dao.inter.MysteryBoxOrderOfUserInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class MysteryBoxOrderOfUserItem {
    @ApiModelProperty(value = "订单id")
    @JsonProperty("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "商店ID")
    @JsonProperty("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    @JsonProperty("shop_name")
    private String shopName;

    @ApiModelProperty(value = "头像")
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

    public MysteryBoxOrderOfUserItem(MysteryBoxOrderOfUserInterface mysteryBoxOrderOfUserInterface){
        setAvatar(mysteryBoxOrderOfUserInterface.getAvatar());
        setIsTaken(mysteryBoxOrderOfUserInterface.getIs_Tsken());
        setOrderId(mysteryBoxOrderOfUserInterface.getOrder_Id());
        setOrderTime(mysteryBoxOrderOfUserInterface.getOrder_Time());
        setProductId(mysteryBoxOrderOfUserInterface.getProduct_Id());
        setProductName(mysteryBoxOrderOfUserInterface.getProduct_Name());
        setProductPic(mysteryBoxOrderOfUserInterface.getProduct_Pic());
        setShopId(mysteryBoxOrderOfUserInterface.getShop_Id());
        setShopName(mysteryBoxOrderOfUserInterface.getShop_Name());
    }
}
