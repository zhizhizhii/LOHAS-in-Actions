package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;

public class LoginStatus {

    @ApiModelProperty("登录状态")
    private Boolean state;

    @ApiModelProperty("登录提示信息")
    private String msg;

    @ApiModelProperty("获取的token")
    private String token;

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
