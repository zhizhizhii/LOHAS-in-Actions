package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.MysteryBoxOrderRequest;
import com.lohas.request.PlaceMysteryBoxRequest;
import com.lohas.service.MysteryBoxOrderService;
import com.lohas.view.MysteryBoxOrderOfShopPage;
import com.lohas.view.MysteryBoxOrderOfUserPage;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "盲盒订单模块")
@Controller
@RequestMapping(path="/api/mysteryboxorder/")
public class MysteryBoxOrderController {
    @Autowired
    MysteryBoxOrderService mysteryBoxOrderService;

    @ApiOperation(value = "发布订单（仅用户权限）")
    @PostMapping(path="/place")
    @ResponseBody
    public Status placeMysteryBoxOrder(@RequestBody PlaceMysteryBoxRequest placeMysteryBoxRequest, HttpServletRequest request){
        return mysteryBoxOrderService.placeMysteryBoxOrder(placeMysteryBoxRequest,request);
    }

    @ApiOperation(value = "确认订单（仅商家）")
    @PostMapping(path="/deal")
    @ResponseBody
    public Status dealMysteryBoxTaken(@RequestBody MysteryBoxOrderRequest mysteryBoxOrderRequest, HttpServletRequest request){
        return mysteryBoxOrderService.dealMysteryBoxTaken(mysteryBoxOrderRequest,request);
    }

    @ApiOperation(value = "我的订单（仅商家）")
    @PostMapping(path="/shoporder")
    @ResponseBody
    public MysteryBoxOrderOfShopPage queryMysteryBoxOfMyShop(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return mysteryBoxOrderService.queryMysteryBoxOfMyShop(paginationSend, request);
    }

    @ApiOperation(value = "我的订单（仅用户）")
    @PostMapping(path="/userorder")
    @ResponseBody
    public MysteryBoxOrderOfUserPage queryMysteryBoxOfUser(PaginationSend paginationSend, HttpServletRequest request){
        return mysteryBoxOrderService.queryMysteryBoxOfUser(paginationSend, request);
    }
}
