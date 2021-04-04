package com.lohas.request;

import io.swagger.annotations.ApiModelProperty;

public class DeleteCommentRequest {

    @ApiModelProperty(value = "要删除的评论id")
    private Integer commentId;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
