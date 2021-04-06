package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeleteCommentRequest {

    @ApiModelProperty(value = "要删除的评论id")
    @JsonProperty("comment_id")
    private Integer commentId;

}
