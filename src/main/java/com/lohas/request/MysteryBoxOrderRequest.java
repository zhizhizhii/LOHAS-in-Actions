package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MysteryBoxOrderRequest {
    @ApiModelProperty(value = "订单id")
    @JsonProperty("order_id")
    private Integer orderId;
}
