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

@Api(tags = "商家公告模块")
@Controller
@RequestMapping(path="/api/announcement/")
public class AnnouncementController {
    @Autowired
    AnnouncementService announcementService;

    @ApiOperation(value = "发布公告")
    @PostMapping(path="/createannouncement")
    @ResponseBody
    public Status createAnnouncement(@RequestBody CreateAnnouncementRequest announcementRequest){
        return announcementService.createAnnouncement(announcementRequest);
    }

    @ApiOperation(value = "修改公告")
    @PostMapping(path="/updateannouncement")
    @ResponseBody
    public Status updateAnnouncement(@RequestBody UpdateAnnouncementRequest updateAnnouncementRequest){
        return announcementService.updateAnnouncement(updateAnnouncementRequest);
    }

    @ApiOperation(value = "删除公告")
    @PostMapping(path="/deleteannouncement")
    @ResponseBody
    public Status deleteAnnouncement(@RequestBody DeleteAnnouncementRequest deleteAnnouncementRequest){
        return announcementService.deleteAnnouncement(deleteAnnouncementRequest);
    }

    @ApiOperation(value = "查询店家的公告")
    @PostMapping(path="/queryannouncement")
    @ResponseBody
    public AnnouncementPage getAnnouncementOfOneShop(@RequestBody QueryAnnouncementByShopRequest queryAnnouncementByShopRequest){
        return announcementService.getAnnouncementOfOneShop(queryAnnouncementByShopRequest);
    }
}
