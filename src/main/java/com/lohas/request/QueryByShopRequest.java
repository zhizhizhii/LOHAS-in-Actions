package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationSend;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryByShopRequest extends PaginationSend {

    @ApiModelProperty(value = "查询的商店id")
    @JsonProperty("shop_id")
    private Integer shopId;

}
