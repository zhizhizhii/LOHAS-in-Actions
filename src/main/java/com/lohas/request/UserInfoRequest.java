package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UserInfoRequest {

    @ApiModelProperty("想要修改的用户名")
    @JsonProperty("username")
    private String userName;

    @ApiModelProperty("想要修改的性别")
    private String sex;

    @ApiModelProperty("想要修改的手机号")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @ApiModelProperty("想要修改的头像存储地址")
    private String avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
