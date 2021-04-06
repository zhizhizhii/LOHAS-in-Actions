package com.lohas.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class PaginationSend {
    //send是指从前端发送过来的数据，receive是指前端收到的数据

    @ApiModelProperty(value = "当前页号")
    @JsonProperty("page_num")
    private Integer pageNum;

    @ApiModelProperty(value = "页面大小")
    @JsonProperty("page_size")
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
