package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChangePasswordRequest {

    @ApiModelProperty(value="旧密码")
    @JsonProperty("old_password")
    private String oldPassword;

    @ApiModelProperty(value="新密码")
    @JsonProperty("new_password")
    private String newPassword;

}
