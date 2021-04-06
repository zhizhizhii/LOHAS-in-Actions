package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangePasswordRequest {

    @ApiModelProperty(value="旧密码")
    private String oldPassword;

    @ApiModelProperty(value="新密码")
    private String newPassword;

}
