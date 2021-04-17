package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.CreateMysteryBoxRequest;
import com.lohas.request.DeleteProductRequest;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.UpdateMysteryBoxRequest;
import com.lohas.service.MysteryBoxService;
import com.lohas.view.ForsaleProductItem;
import com.lohas.view.MysteryBoxItem;
import com.lohas.view.MysteryBoxPage;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "盲盒模块")
@Controller
@RequestMapping(path="/api/mysterybox/")
public class MysteryBoxController {
    @Autowired
    MysteryBoxService mysteryBoxService;

    @ApiOperation(value = "发布盲盒（仅商户权限）")
    @PostMapping(path="/create")
    @ResponseBody
    public Status createMysteryBox(@RequestBody CreateMysteryBoxRequest mysteryBoxRequest, HttpServletRequest request){
        return mysteryBoxService.createMysteryBox(mysteryBoxRequest, request);
    }

    @ApiOperation(value = "修改盲盒（仅商户权限）")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateMysteryBox(@RequestBody UpdateMysteryBoxRequest updateMysteryBoxRequest, HttpServletRequest request){
        return mysteryBoxService.updateMysteryBox(updateMysteryBoxRequest, request);
    }

    @ApiOperation(value = "删除盲盒（仅商户权限）")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteMysteryBox(@RequestBody DeleteProductRequest deleteMysteryBoxRequest, HttpServletRequest request){
        return mysteryBoxService.deleteMysteryBox(deleteMysteryBoxRequest, request);
    }

    @ApiOperation(value = "查询店家的盲盒（仅用户权限）")
    @PostMapping(path="/query")
    @ResponseBody
    public MysteryBoxPage getMysteryBoxOfOneShop(@RequestBody QueryByShopRequest queryMysteryBoxByShopRequest, HttpServletRequest request){
        return mysteryBoxService.getMysteryBoxOfOneShop(queryMysteryBoxByShopRequest, request);
    }

    @ApiOperation(value="商家获取自己盲盒（仅商户权限）",notes="用于商家获取自己的盲盒" )
    @PostMapping(path="/getmine")
    @ResponseBody
    public MysteryBoxPage getMysteryBoxOfMine(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return mysteryBoxService.getMyProduct(paginationSend, request);
    }

    @ApiOperation(value = "根据ID查询盲盒")
    @GetMapping(path="/querybyId")
    @ResponseBody
    public MysteryBoxItem getMysteryBoxById(@RequestParam Integer product_id){
        return mysteryBoxService.getMysteryBoxById(product_id);
    }
}
