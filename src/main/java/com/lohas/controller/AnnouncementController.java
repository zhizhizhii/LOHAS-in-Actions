package com.lohas.controller;

import com.lohas.request.CreateAnnouncementRequest;
import com.lohas.request.DeleteAnnouncementRequest;
import com.lohas.request.QueryAnnouncementByShopRequest;
import com.lohas.request.UpdateAnnouncementRequest;
import com.lohas.service.AnnouncementService;
import com.lohas.view.AnnouncementPage;
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

@Api(tags = "商家公告模块")
@Controller
@RequestMapping(path="/api/announcement/")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @ApiOperation(value = "发布公告")
    @PostMapping(path="/create")
    @ResponseBody
    public Status createAnnouncement(@RequestBody CreateAnnouncementRequest announcementRequest, HttpServletRequest request){
        return announcementService.createAnnouncement(announcementRequest, request);
    }

    @ApiOperation(value = "修改公告")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateAnnouncement(@RequestBody UpdateAnnouncementRequest updateAnnouncementRequest, HttpServletRequest request){
        return announcementService.updateAnnouncement(updateAnnouncementRequest, request);
    }

    @ApiOperation(value = "删除公告")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteAnnouncement(@RequestBody DeleteAnnouncementRequest deleteAnnouncementRequest, HttpServletRequest request){
        return announcementService.deleteAnnouncement(deleteAnnouncementRequest, request);
    }

    @ApiOperation(value = "查询店家的公告")
    @PostMapping(path="/query")
    @ResponseBody
    public AnnouncementPage getAnnouncementOfOneShop(@RequestBody QueryAnnouncementByShopRequest queryAnnouncementByShopRequest, HttpServletRequest request){
        return announcementService.getAnnouncementOfOneShop(queryAnnouncementByShopRequest, request);
    }
}
