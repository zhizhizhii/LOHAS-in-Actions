package com.lohas.controller;

import com.lohas.request.ShopRequest;
import com.lohas.service.ShopService;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Api(tags = "商家账户模块")
@Controller
@RequestMapping(path="/api/shop")
public class ShopController {
    @Autowired
    ShopService shopService;

    @ApiOperation(value="商家注册",notes="保留接口，可用，请在后续登录时将token放入" +
            "（ 请求头！ ）中。")
    @PostMapping(path="/register")
    @ResponseBody
    public Status register(@RequestBody ShopRequest shopRequest, HttpServletResponse response){
        return shopService.register(shopRequest);
    }

    @ApiOperation(value="商家注册",notes="保留接口，可用，请在后续登录时将token放入" +
            "（ 请求头！ ）中。")
    @PostMapping(path="/login")
    @ResponseBody
    public Status login(@RequestBody ShopRequest shopRequest, HttpServletResponse response){
        return shopService.login(shopRequest,response);
    }




}
