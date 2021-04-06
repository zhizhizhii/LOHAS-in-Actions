package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateCommentRequest {

    @ApiModelProperty(value = "要修改的评论id")
    @JsonProperty("comment_id")
    private Integer commentId;

    @ApiModelProperty(value = "要修改的评论内容")
    private String content;

}
