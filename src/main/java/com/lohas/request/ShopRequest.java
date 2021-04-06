package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ShopRequest {

    @ApiModelProperty(value="注册/登录用户名")
    private String username;

    @ApiModelProperty(value="注册/登录密码")
    private String password;

}
