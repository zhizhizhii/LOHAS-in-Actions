package com.lohas.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GreenPointItem {
    @ApiModelProperty(value = "每日分数")
    private Integer point;

    @ApiModelProperty(value = "日期")
    private Date date;
}
