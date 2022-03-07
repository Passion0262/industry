package com.example.industry.entity.Productionplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productionplan {
    private String operation;  //操作
    private int planNumber;   //计划编号
    private String planName;  //计划名称
    private String state;      //状态
    private String devicegroup;//所属设备组
    private int planYield;    //计划产量
    private int qualifiedYield; //合格产量
    private int disqualifiedYield;//不合格产量
    private String planDetails;//计划明细
    private int modelType;//机种型号
    private Timestamp plannedstart;//计划开始时间
    private Timestamp plannedend;//计划结束时间
    private Timestamp actualstart;//实际开始时间
    private Timestamp actualend;//实际结束时间
}
