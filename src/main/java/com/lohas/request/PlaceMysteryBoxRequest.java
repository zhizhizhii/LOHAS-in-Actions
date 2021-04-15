package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PlaceMysteryBoxRequest {
    @ApiModelProperty(value = "盲盒id")
    @JsonProperty("product_id")
    private Integer productId;
}
