package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteProductRequest {
    @ApiModelProperty(value = "商品id")
    @JsonProperty("product_id")
    private Integer productId;
}
