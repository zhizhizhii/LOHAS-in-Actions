package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.QueryShopInfoByTypeRequest;
import com.lohas.request.UpdateShopInfoRequest;
import com.lohas.service.ShopInfoService;
import com.lohas.view.ShopBriefInfoPage;
import com.lohas.view.ShopDetailedInfo;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "商家信息模块")
@Controller
@RequestMapping(path="/api/shopinfo")
public class ShopInfoController {

    @Autowired
    ShopInfoService shopInfoService;

    @ApiOperation(value="用户获取商店简略信息（仅用户权限）")
    @PostMapping(path="/getbrief")
    @ResponseBody
    public ShopBriefInfoPage getShopBriefInfo(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return shopInfoService.getShopBriefInfo(paginationSend, request);
    }

    @ApiOperation(value="用户获取商店详细信息（仅用户权限）")
    @GetMapping(path="/getdetailed")
    @ResponseBody
    public ShopDetailedInfo getShopDetailedInfo(@RequestParam Integer shopId, HttpServletRequest request){
        return shopInfoService.getShopDetailedInfo(shopId);
    }

    @ApiOperation(value="商家修改商店信息（仅商店权限）")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateShopInfo(@RequestParam UpdateShopInfoRequest updateShopInfoRequest, HttpServletRequest request){
        return shopInfoService.updateShopInfo(updateShopInfoRequest,request);
    }


    @ApiOperation(value="商家获取个人商店信息（仅商店权限）")
    @GetMapping(path="/getmine")
    @ResponseBody
    public ShopDetailedInfo getShopInfoMine(HttpServletRequest request){
        return shopInfoService.getShopInfoMine(request);
    }


    @ApiOperation(value="用户获取商店简略信息（仅用户权限）")
    @PostMapping(path="/getbriefbytype")
    @ResponseBody
    public ShopBriefInfoPage getBriefbyType(@RequestBody QueryShopInfoByTypeRequest queryShopInfoByTypeRequest){
        return shopInfoService.getShopBriefInfoByType(queryShopInfoByTypeRequest);
    }


}
