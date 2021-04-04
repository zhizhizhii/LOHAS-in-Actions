package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UpdateCommentRequest {

    @ApiModelProperty(value = "要修改的评论id")
    @JsonProperty("commentid")
    private Integer commentId;

    @ApiModelProperty(value = "要修改的评论内容")
    private String content;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
