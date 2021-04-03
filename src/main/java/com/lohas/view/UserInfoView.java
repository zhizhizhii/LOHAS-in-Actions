package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UserInfoView {

    @ApiModelProperty("用户名")
    @JsonProperty("username")
    private String userName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话号码")
    @JsonProperty("phonenumber")
    private String phoneNumber;

    @ApiModelProperty("头像存储地址")
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
