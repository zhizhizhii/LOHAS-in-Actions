package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.Shop;
import com.lohas.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommentItem {

    @ApiModelProperty(value = "评论id")
    @JsonProperty("comment_id")
    private Integer commentId;

    @ApiModelProperty(value = "评论用户id")
    @JsonProperty("user_id")
    private Integer userId;

    @ApiModelProperty(value = "评论用户名")
    @JsonProperty("username")
    private String userName;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("comment_time")
    private Date commentTime;
}
