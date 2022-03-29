package com.example.industry.entity.PLC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class plc2 {
    int id;//编号（此表为PLC_2历史参数）
    String acquisitionTime;//采集时间
    String status;//状态
    String PLCType;//总控机种
    String sixtyFeedingRequest;//60上料请求
    String sixtyCuttingRequest;//60下料请求
    String sixtyOnPosition;//60小车到位
    String sixtyFeedingDone;//60上料完成
    String sixtyCuttingDone;//60下料完成
    String sixtyForward;//60料道正转
    String sixtyReverse;//60料道反转
    String seventyFeedingRequest;//70上料请求
    String seventyCuttingRequest;//70下料请求
    String seventyOnPosition;//70小车到位
    String seventyFeedingDone;//70上料完成
    String seventyCuttingDone;//70下料完成
    String seventyForward;//70料道正转
    String seventyReverse;//70料道反转
    String OP60LocationZS;//OP60位置ZS
    String OP70LocationZS;//OP70位置ZS
    String OKZSCode;//OKZS码
    String OKZSCode1;//OKZS码1
    String NGZSCode;//NGZS码
    String OP60LocationXN;//OP60地址XN
    String OP70LocationXN;//OP70地址XN
    String MarkingCode;//打标码
    String productionlineState;//产线状态
    String planNumber;//计划编号/订单
    String planAmount;//计划数量
    String productionNumber;//产品编号/机种
    String feedingLocation1ZS;//上料位置1地址ZS
    String feedingLocation2ZS;//上料位置2地址ZS
    String markingMachineLocationZS;//打标机地址ZS
    String measuringMachineLocationZS;//测量机地址ZS
    String measuringMachineLocationXN;//测量机地址XN
    String feedingLocation1XN;//上料位置1地址XN
    String feedingLocation2XN;//上料位置2地址XN
    String markingMachineLocationXN;//打标机地址XN
}
