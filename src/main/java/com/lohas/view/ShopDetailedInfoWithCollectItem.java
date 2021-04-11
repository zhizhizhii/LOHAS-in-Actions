package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShopDetailedInfoWithCollectItem {

    @ApiModelProperty(value = "商店ID")
    @JsonProperty("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    @JsonProperty("shop_name")
    private String shopName;

    @ApiModelProperty(value = "商店类型")
    @JsonProperty("shop_type")
    private String shopType;

    @ApiModelProperty(value = "商店简介")
    @JsonProperty("shop_intro")
    private String shopIntro;

    @ApiModelProperty(value = "商店乐活信息")
    @JsonProperty("shop_lohas_info")
    private String shopLohasInfo;

    @ApiModelProperty(value = "商店地址")
    @JsonProperty("shop_address")
    private String shopAddress;

    @ApiModelProperty(value = "商店营业时间")
    @JsonProperty("shop_business_hours")
    private String shopBusinessHours;

    @ApiModelProperty(value = "商店地理位置所在经度")
    @JsonProperty("shop_longitude")
    private Float shopLongitude;

    @ApiModelProperty(value = "商店地理位置所在纬度")
    @JsonProperty("shop_latitude")
    private Float shopLatitude;

    @ApiModelProperty(value = "商店头像")
    private String avatar;

    @ApiModelProperty(value = "商店头图")
    @JsonProperty("head_picture")
    private String headPicture;

    @ApiModelProperty(value = "用户是否收藏了本家店铺")
    @JsonProperty("is_collected")
    private Integer isCollected;
}
