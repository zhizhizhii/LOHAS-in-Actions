package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserInfoView {

    @ApiModelProperty("用户名")
    @JsonProperty("username")
    private String userName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("电话号码")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @ApiModelProperty("头像存储地址")
    private String avatar;

}
