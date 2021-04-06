package com.lohas.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeleteAnnouncementRequest {

    @ApiModelProperty(value = "要删除的公告id")
    @JsonProperty("announcement_id")
    private Integer announcementId;

}
