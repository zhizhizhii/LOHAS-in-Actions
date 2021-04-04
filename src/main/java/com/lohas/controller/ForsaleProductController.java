package com.lohas.controller;

import com.lohas.request.CreateForsaleProductRequest;
import com.lohas.request.DeleteForsaleProductRequest;
import com.lohas.request.QueryAnnouncementByShopRequest;
import com.lohas.request.UpdateForsaleProductRequest;
import com.lohas.service.ForsaleProductService;
import com.lohas.view.ForsaleProductPage;
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

@Api(tags = "折扣商品相关模块")
@Controller
@RequestMapping(path="/api/forsaleproduct/")
public class ForsaleProductController {
    @Autowired
    ForsaleProductService forsaleProductService;

    @ApiOperation(value = "发布折扣商品")
    @PostMapping(path="/create")
    @ResponseBody
    public Status createForsaleProduct(@RequestBody CreateForsaleProductRequest forsaleProductRequest, HttpServletRequest request){
        return forsaleProductService.createForsaleProduct(forsaleProductRequest, request);
    }

    @ApiOperation(value = "修改折扣商品")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateForsaleProduct(@RequestBody UpdateForsaleProductRequest updateForsaleProductRequest, HttpServletRequest request){
        return forsaleProductService.updateForsaleProduct(updateForsaleProductRequest, request);
    }

    @ApiOperation(value = "删除折扣商品")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteForsaleProduct(@RequestBody DeleteForsaleProductRequest deleteForsaleProductRequest, HttpServletRequest request){
        return forsaleProductService.deleteForsaleProduct(deleteForsaleProductRequest, request);
    }

    @ApiOperation(value = "查询店家的折扣商品")
    @PostMapping(path="/query")
    @ResponseBody
    public ForsaleProductPage getForsaleProductOfOneShop(@RequestBody QueryAnnouncementByShopRequest queryForsaleProductByShopRequest, HttpServletRequest request){
        return forsaleProductService.getForsaleProductOfOneShop(queryForsaleProductByShopRequest, request);
    }
}
