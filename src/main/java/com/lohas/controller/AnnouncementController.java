package com.lohas.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "商家公告模块")
@Controller
@RequestMapping(path="/api/announcement/")
public class AnnouncementController {
}
