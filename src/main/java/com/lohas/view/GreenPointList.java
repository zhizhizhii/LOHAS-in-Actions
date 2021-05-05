package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.dao.inter.GreenPointInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import sun.jvm.hotspot.debugger.Page;

import java.util.ArrayList;
import java.util.List;

@Data
public class GreenPointList {
    @ApiModelProperty(value = "每日分数")
    @JsonProperty("green_point_list")
    private List<GreenPointItem> greenPointItemList;

    @ApiModelProperty(value = "总分")
    @JsonProperty("total_point")
    private Integer totalPoint = 0;

    public GreenPointList(List<GreenPointInterface> greenPointInterfaceList, Integer totalPoint){
        List<GreenPointItem> list = new ArrayList<>();
        for(GreenPointInterface greenPointInterface:greenPointInterfaceList){
            GreenPointItem greenPointItem = new GreenPointItem(greenPointInterface.getPoint(),greenPointInterface.getOrder_date());
        }
        setGreenPointItemList(list);
        setTotalPoint(totalPoint);
    }
}
