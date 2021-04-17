package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
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

}
