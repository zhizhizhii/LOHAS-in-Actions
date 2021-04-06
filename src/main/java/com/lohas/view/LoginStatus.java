package com.lohas.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginStatus {

    @ApiModelProperty("登录状态")
    private Boolean state;

    @ApiModelProperty("登录提示信息")
    private String msg;

    @ApiModelProperty("是否第一次登录，是：1；否：0")
    private Integer login_for_first;

}
