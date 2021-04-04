package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.model.Shop;
import com.lohas.model.User;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class CommentItem {
    @ApiModelProperty(value = "公告id")
    @JsonProperty("announcementid")
    private Integer commentId;

    @ApiModelProperty(value = "评论用户id")
    @JsonProperty("userid")
    private Integer userId;

    @ApiModelProperty(value = "评论商店id")
    @JsonProperty("shopid")
    private Integer shopId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("commenttime")
    private Date commentTime;
}
