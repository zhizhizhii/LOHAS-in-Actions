package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateAnnouncementRequest {

    @ApiModelProperty(value = "要修改的公告id")
    @JsonProperty("announcement_id")
    private Integer announcementId;

    @ApiModelProperty(value = "要修改的公告标题")
    private String title;

    @ApiModelProperty(value = "要修改的公告内容")
    private String context;


}
