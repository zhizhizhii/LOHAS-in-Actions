package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lohas.dao.inter.GreenPointInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

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
            list.add(greenPointItem);
        }
        //TODO: writing shit here
        Boolean[] checkList = new Boolean[]{false,false,false,false,false,false,false};
        Date today = new Date();
        for(GreenPointItem greenPointItem:list){
            Date date = greenPointItem.getDate();
            int days = (int) ((today.getTime() - date.getTime()) / (1000*3600*24));
            checkList[days]=true;
        }
        for(int i=0;i<7;i++) {
            if(!checkList[i]){
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(today);
                calendar.add(calendar.DATE,-1*i);
                Date date = new Date();
                date = calendar.getTime();
                GreenPointItem greenPointItem = new GreenPointItem(0,date);
                list.add(greenPointItem);
            }
        }
        Collections.sort(list);
        setGreenPointItemList(list);
        setTotalPoint(totalPoint);
    }
}
