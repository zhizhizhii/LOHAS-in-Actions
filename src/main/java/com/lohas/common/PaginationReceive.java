package com.lohas.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class PaginationReceive {
    //send是指从前端发送过来的数据，receive是指前端收到的数据

    @ApiModelProperty(value = "总页数")
    @JsonProperty("totalpage")
    private Integer totalPage;

    @ApiModelProperty(value = "当前页号")
    @JsonProperty("pagenum")
    private Integer pageNum;

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
