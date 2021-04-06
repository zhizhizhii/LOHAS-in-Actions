package com.lohas.view;

import com.lohas.model.ShopInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ShopBriefInfoItem {

    @ApiModelProperty(value = "商店ID")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    private String shopName;

    @ApiModelProperty(value = "商店类型")
    private String shopType;

    @ApiModelProperty(value = "商店乐活信息")
    private String shopLohasInfo;

    @ApiModelProperty(value = "商店地理位置经度")
    private Float shopLongitude;

    @ApiModelProperty(value = "商店地理位置纬度")
    private Float shopLatitude;

    @ApiModelProperty(value = "头像")
    private String avatar;


}
