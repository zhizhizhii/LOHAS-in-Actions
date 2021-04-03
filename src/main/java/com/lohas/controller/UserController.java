package com.lohas.controller;

import com.lohas.model.User;
import com.lohas.request.LoginRequest;
import com.lohas.service.UserService;
import com.lohas.view.LoginStatus;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "普通用户登录模块")
@Controller
@RequestMapping(path="/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="普通用户登录",notes="登录接口，验证code后会签发token，请在后续登录时将token放入" +
            "（ 请求头！ ）中。")
    @PostMapping(path="/login")
    @ResponseBody
    public LoginStatus login(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        return userService.logIn(loginRequest,response);
    }


}
