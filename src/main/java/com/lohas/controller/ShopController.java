package com.lohas.controller;

import com.lohas.request.ChangePasswordRequest;
import com.lohas.request.ShopRequest;
import com.lohas.service.ShopService;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags = "商家账户模块")
@Controller
@RequestMapping(path="/api/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @ApiOperation(value="商家注册（仅自己使用）",notes="保留接口，可用" )
    @PostMapping(path="/register")
    @ResponseBody
    public Status register(@RequestBody ShopRequest shopRequest, HttpServletResponse response){
        return shopService.register(shopRequest);
    }

    @ApiOperation(value="商家登录（不限权限）",notes="商家登录接口，token会放在header中返回" )
    @PostMapping(path="/login")
    @ResponseBody
    public Status login(@RequestBody ShopRequest shopRequest, HttpServletResponse response){
        return shopService.login(shopRequest,response);
    }

    @ApiOperation(value="商家修改密码（仅商户权限）",notes="用于商家修改密码" )
    @PostMapping(path="/changepwd")
    @ResponseBody
    public Status changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, HttpServletRequest request){
        return shopService.changePassword(changePasswordRequest,request);
    }


}
