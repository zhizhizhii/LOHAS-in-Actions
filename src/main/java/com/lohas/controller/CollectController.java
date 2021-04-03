package com.lohas.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "用户收藏商家模块")
@Controller
@RequestMapping(path="/api/collect")
public class CollectController {
}
