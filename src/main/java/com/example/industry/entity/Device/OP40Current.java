package com.example.industry.entity.Device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OP40Current {

    private int id;

    private String status;      //设备状态

    private String workPiece;   //工件号

    private int output;    //产量

    private int rapidFeedRate;      //快速进给倍率

    private int spindleSpeed;      //主轴转速

    private int feedRate;       //进给倍率

    private int feedSpeed;      //进给速度

    private int alarmNumber;        //当前告警编号

    private String alarmInfo;   //当前告警信息

    private Timestamp time;     //记录当前时间

}
