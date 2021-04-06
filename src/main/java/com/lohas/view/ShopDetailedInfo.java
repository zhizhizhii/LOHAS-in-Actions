package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShopDetailedInfo {

    @ApiModelProperty(value = "商店ID")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "商店类型")
    private String shopType;

    @ApiModelProperty(value = "商店简介")
    private String shopIntro;

    @ApiModelProperty(value = "商店乐活信息")
    private String shopLohasInfo;

    @ApiModelProperty(value = "商店地址")
    private String shopAddress;

    @ApiModelProperty(value = "商店营业时间")
    private String shopBusinessHours;

    @ApiModelProperty(value = "商店地理位置所在经度")
    private Float shopLongitude;

    @ApiModelProperty(value = "商店地理位置所在纬度")
    private Float shopLatitude;

    @ApiModelProperty(value = "商店头像")
    private String avatar;

    @ApiModelProperty(value = "商店头图")
    private String headPicture;
}
