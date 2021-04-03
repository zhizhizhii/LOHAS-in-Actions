package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;

public class Status {

    @ApiModelProperty("注册状态")
    private Boolean state;

    @ApiModelProperty("注册提示信息")
    private String msg;

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
}
