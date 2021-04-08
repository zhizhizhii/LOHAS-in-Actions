package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationSend;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryShopInfoByTypeRequest extends PaginationSend {

    @ApiModelProperty(value = "查询的商店类型")
    @JsonProperty("shop_type")
    private String shopType;
}
