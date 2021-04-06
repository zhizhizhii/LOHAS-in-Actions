package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginRequest {

    @ApiModelProperty(value="wechat服务器返回前端的状态码")
    private String code;

}
