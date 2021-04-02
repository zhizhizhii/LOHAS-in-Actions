package com.lohas.controller;

import com.lohas.request.UserInfoRequest;
import com.lohas.service.UserInfoService;
import com.lohas.view.UserInfoView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Api(tags = "个人信息模块")
@Controller
@RequestMapping(path="/api/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @ApiOperation(value="获取用户个人信息",notes="注意！请在header中携带token")
    @GetMapping(path="/getuserinfo")
    @ResponseBody
    public UserInfoView getUserInfo(HttpServletRequest request){
        return userInfoService.getUserInfo(request);
    }


    @ApiOperation(value="修改用户个人信息",notes="注意！请在header中携带token")
    @PostMapping(path="/updateuserinfo")
    @ResponseBody
    public Map<String,String> updateUserInfo(@RequestBody UserInfoRequest userInfoRequest, HttpServletRequest request){
        return userInfoService.updateUserInfo(userInfoRequest,request);
    }






}
