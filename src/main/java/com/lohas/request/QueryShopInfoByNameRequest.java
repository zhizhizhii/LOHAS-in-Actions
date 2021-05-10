package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.common.PaginationSend;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryShopInfoByNameRequest extends PaginationSend {
    @ApiModelProperty(value = "关键词")
    private String keyword;
}
