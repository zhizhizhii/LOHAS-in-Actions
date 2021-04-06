package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateCollectionRequest {

    @ApiModelProperty(value = "店铺id")
    @JsonProperty("shop_id")
    private Integer shopId;

}
