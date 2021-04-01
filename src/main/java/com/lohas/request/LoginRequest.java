package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;


public class LoginRequest {

    @ApiModelProperty("wechat服务器返回前端的状态码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
