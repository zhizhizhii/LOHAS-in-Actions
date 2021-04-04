package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class CreateCommentRequest {

    @ApiModelProperty(value = "店铺id")
    @JsonProperty("shopid")
    private Integer shopId;

    @ApiModelProperty(value = "内容")
    private String content;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
