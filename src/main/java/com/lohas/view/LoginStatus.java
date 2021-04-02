package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;

public class LoginStatus {

    @ApiModelProperty("登录状态")
    private Boolean state;

    @ApiModelProperty("登录提示信息")
    private String msg;

    @ApiModelProperty("是否第一次登录，是：1；否：0")
    private Integer login_for_first;

    public Integer getLogin_for_first() {
        return login_for_first;
    }

    public void setLogin_for_first(Integer login_for_first) {
        this.login_for_first = login_for_first;
    }

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
