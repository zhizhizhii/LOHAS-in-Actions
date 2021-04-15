package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.CreateDDLProductRequest;
import com.lohas.request.DeleteProductRequest;
import com.lohas.request.QueryByShopRequest;
import com.lohas.request.UpdateDDLProductRequest;
import com.lohas.service.DDLProductService;
import com.lohas.view.DDLProductPage;
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

@Api(tags = "临期商品相关模块")
@Controller
@RequestMapping(path="/api/ddlproduct/")
public class DDLProductController {
    @Autowired
    DDLProductService ddlProductService;

    @ApiOperation(value = "发布临期商品（仅商店权限）")
    @PostMapping(path="/create")
    @ResponseBody
    public Status createDDLProduct(@RequestBody CreateDDLProductRequest ddlProductRequest, HttpServletRequest request){
        return ddlProductService.createDDLProduct(ddlProductRequest, request);
    }

    @ApiOperation(value = "修改临期商品（仅商店权限）")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateDDLProduct(@RequestBody UpdateDDLProductRequest updateDDLProductRequest, HttpServletRequest request){
        return ddlProductService.updateDDLProduct(updateDDLProductRequest, request);
    }

    @ApiOperation(value = "删除临期商品（仅商店权限）")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteDDLProduct(@RequestBody DeleteProductRequest deleteDDLProductRequest, HttpServletRequest request){
        return ddlProductService.deleteDDLProduct(deleteDDLProductRequest, request);
    }

    @ApiOperation(value = "用户查询店家的临期商品（仅用户权限）")
    @PostMapping(path="/query")
    @ResponseBody
    public DDLProductPage getDDLProductOfOneShop(@RequestBody QueryByShopRequest queryDDLProductByShopRequest, HttpServletRequest request){
        return ddlProductService.getDDLProductOfOneShop(queryDDLProductByShopRequest, request);
    }

    @ApiOperation(value="商家获取自己临期商品（仅商店权限）",notes="用于商家获取自己的临期商品" )
    @PostMapping(path="/getmine")
    @ResponseBody
    public DDLProductPage getDDLProductOfMine(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return ddlProductService.getMyProduct(paginationSend,request);
    }
}
