package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;

public class ShopRequest {

    @ApiModelProperty(value="注册/登录用户名")
    private String username;

    @ApiModelProperty(value="注册/登录密码")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
