package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationSend;
import io.swagger.annotations.ApiModelProperty;

public class QueryByShopRequest extends PaginationSend {

    @ApiModelProperty(value = "查询的商店id")
    @JsonProperty("shopid")
    private Integer shopId;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}
