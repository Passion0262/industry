package com.example.industry.entity.PLC;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class plc1 {
    int id;//编号（此表为PLC_1历史参数）
    public Timestamp acquisitionTime;//采集时间
    String status;//状态
    String PLCType;//总控机种
    String fortyFeedingRequest;//40上料请求
    String fortyCuttingRequest;//40下料请求
    String fortyOnPosition;//40小车到位
    String fortyFeedingDone;//40上料完成
    String fortyCuttingDone;//40下料完成
    String fortyForward;//40料道正转
    String fortyReverse;//40料道反转
    String fiftyFeedingRequest;//50上料请求
    String fiftyCuttingRequest;//50下料请求
    String fiftyOnPosition;//50小车到位
    String fiftyFeedingDone;//50上料完成
    String fiftyCuttingDone;//50下料完成
    String fiftyForward;//50料道正转
    String fiftyReverse;//50料道反转
    String feedingLocation1XN;//上料位置1地址XN
    String feedingLocation2XN;//上料位置2地址XN
    String OP40LocationXN;//OP40位置XN
    String markingMachineLocationXN;//打标机地址XN
    String markingMachineLocationZS;//打标机地址ZS
    String OP50LocationZS;//OP50地址ZS
    String measuringMachineLocationZS;//测量机地址ZS
    String NGZSCode;//NGZS码
    String productionlineState;//产线状态
    String planNumber;//计划编号/订单
    String planAmount;//计划数量
    String productionNumber;//产品编号/机种
    String feedingLocation1ZS;//上料位置1地址ZS
    String feedingLocation2ZS;//上料位置2地址ZS
    String OP40LocationZS;//OP40位置ZS
    String measuringMachineLocationXN;//测量机地址XN
    String OP50LocationXN;//OP50地址XN
    String MarkingCode;//打标机

}
