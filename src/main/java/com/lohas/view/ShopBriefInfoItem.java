package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.ShopInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ShopBriefInfoItem {

    @ApiModelProperty(value = "商店ID")
    @JsonProperty("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    @JsonProperty("shop_name")
    private String shopName;

    @ApiModelProperty(value = "商店类型")
    @JsonProperty("shop_type")
    private String shopType;

    @ApiModelProperty(value = "商店乐活信息")
    @JsonProperty("shop_lohas_info")
    private String shopLohasInfo;

    @ApiModelProperty(value = "商店地理位置经度")
    @JsonProperty("shop_longitude")
    private Float shopLongitude;

    @ApiModelProperty(value = "商店地理位置纬度")
    @JsonProperty("shop_latitude")
    private Float shopLatitude;

    @ApiModelProperty(value = "头像")
    private String avatar;

}
