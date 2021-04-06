package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CommentforUserItem {
    @ApiModelProperty(value = "评论id")
    @JsonProperty("commentid")
    private Integer commentId;

    @ApiModelProperty(value = "商店id")
    @JsonProperty("shopid")
    private Integer shopId;

    @ApiModelProperty(value = "商店名称")
    @JsonProperty("shopname")
    private String shopName;

    @ApiModelProperty(value = "商户头像")
    private String avatar;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    @JsonProperty("commenttime")
    private Date commentTime;
}
