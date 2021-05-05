package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.MysteryBoxOrderRequest;
import com.lohas.request.PlaceMysteryBoxRequest;
import com.lohas.service.DDLProductOrderService;
import com.lohas.service.DDLProductService;
import com.lohas.view.GreenPointList;
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

@Api(tags = "订单模块")
@Controller
@RequestMapping(path="/api/ddlproductorder/")
public class DDLProductOrderController {
    @Autowired
    DDLProductOrderService ddlProductOrderService;

    @ApiOperation(value = "发布订单（仅用户权限）")
    @PostMapping(path="/place")
    @ResponseBody
    public Status placeDDLProductOrder(@RequestBody PlaceMysteryBoxRequest placeMysteryBoxRequest, HttpServletRequest request){
        return ddlProductOrderService.placeDDLProductOrder(placeMysteryBoxRequest,request);
    }

    @ApiOperation(value = "确认订单（仅商家）")
    @PostMapping(path="/deal")
    @ResponseBody
    public Status dealDDLProductTaken(@RequestBody MysteryBoxOrderRequest mysteryBoxOrderRequest, HttpServletRequest request){
        return ddlProductOrderService.dealDDLProductTaken(mysteryBoxOrderRequest,request);
    }

    @ApiOperation(value = "我的订单（仅商家）")
    @PostMapping(path="/shoporder")
    @ResponseBody
    public MysteryBoxOrderOfShopPage queryDDLProductOfMyShop(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return ddlProductOrderService.queryDDLProductOfMyShop(paginationSend, request);
    }

    @ApiOperation(value = "我的订单（仅用户）")
    @PostMapping(path="/userorder")
    @ResponseBody
    public MysteryBoxOrderOfUserPage queryDDLProductOfUser(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return ddlProductOrderService.queryDDLProductOfUser(paginationSend, request);
    }

    @ApiOperation(value = "查看分数（仅用户）")
    @PostMapping(path="/greenpoint")
    @ResponseBody
    public GreenPointList queryGreenPoint(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return ddlProductOrderService.queryGreenPoint(paginationSend, request);
    }
}
