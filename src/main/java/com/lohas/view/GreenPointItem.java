package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreenPointItem implements Comparable<GreenPointItem>{
    @ApiModelProperty(value = "每日分数")
    private Integer point;

    @ApiModelProperty(value = "日期")
    private Date date;

    public GreenPointItem(Integer point, String order_date){
        this.point=point;
        Date date = new Date();
        String[ ] dateDivide = order_date.split("-");
        int year = Integer.parseInt(dateDivide[0].trim());
        int month = Integer.parseInt(dateDivide[1].trim());
        int day = Integer.parseInt(dateDivide[2].trim());
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,day);
        date=calendar.getTime();
        this.date=date;
    }

    @Override
    public int compareTo(GreenPointItem greenPointItem){
        return this.date.compareTo(greenPointItem.getDate());
    }
}
