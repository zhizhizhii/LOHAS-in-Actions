package com.lohas.controller;

import com.lohas.common.PaginationSend;
import com.lohas.request.CreateAnnouncementRequest;
import com.lohas.request.CreateCollectionRequest;
import com.lohas.service.CollectionService;
import com.lohas.view.ShopBriefInfoPage;
import com.lohas.view.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户收藏商家模块")
@Controller
@RequestMapping(path="/api/collect")
public class CollectController {
    @Autowired
    CollectionService collectionService;

    @ApiOperation(value = "添加收藏（仅用户权限）")
    @PostMapping(path="/add")
    @ResponseBody
    public Status createCollection(@RequestBody CreateCollectionRequest createCollectionRequest, HttpServletRequest request){
        return collectionService.createCollection(createCollectionRequest, request);
    }

    @ApiOperation(value = "删除收藏（仅用户权限）")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteCollection(@RequestBody CreateCollectionRequest createCollectionRequest, HttpServletRequest request){
        return collectionService.deleteCollection(createCollectionRequest, request);
    }

    @ApiOperation(value = "获取收藏信息（仅用户权限）")
    @PostMapping(path="/get")
    @ResponseBody
    public ShopBriefInfoPage getCollection(@RequestBody PaginationSend paginationSend, HttpServletRequest request){
        return collectionService.getCollection(paginationSend, request);
    }

}
