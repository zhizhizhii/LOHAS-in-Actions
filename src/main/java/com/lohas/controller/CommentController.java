package com.lohas.controller;

import com.lohas.request.CreateCommentRequest;
import com.lohas.request.DeleteCommentRequest;
import com.lohas.request.UpdateCommentRequest;
import com.lohas.service.CommentService;
import com.lohas.view.CommentPage;
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

@Api(tags = "用户评论商家模块")
@Controller
@RequestMapping(path="/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @ApiOperation(value = "发布评论")
    @PostMapping(path="/create")
    @ResponseBody
    public Status createComment(@RequestBody CreateCommentRequest commentRequest, HttpServletRequest request){
        return commentService.createComment(commentRequest, request);
    }

    @ApiOperation(value = "修改评论")
    @PostMapping(path="/update")
    @ResponseBody
    public Status updateComment(@RequestBody UpdateCommentRequest updateCommentRequest, HttpServletRequest request){
        return commentService.updateComment(updateCommentRequest, request);
    }

    @ApiOperation(value = "删除评论")
    @PostMapping(path="/delete")
    @ResponseBody
    public Status deleteComment(@RequestBody DeleteCommentRequest deleteCommentRequest, HttpServletRequest request){
        return commentService.deleteComment(deleteCommentRequest, request);
    }

//    @ApiOperation(value = "查询店家的评论")
//    @PostMapping(path="/query")
//    @ResponseBody
//    public CommentPage getCommentOfOneShop(@RequestBody QueryCommentByShopRequest queryCommentByShopRequest, HttpServletRequest request){
//        return CommentService.getCommentOfOneShop(queryCommentByShopRequest, request);
//    }
}
