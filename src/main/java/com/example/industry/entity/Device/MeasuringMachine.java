package com.example.industry.entity.Device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasuringMachine {
    private int id;
    private Timestamp acquisitionTime; //采集时间
    private String status; //状态
    private String workpieceCode; //工件码
    private String workpieceType; //工件型号
    private String measuredValue1; //测量值1
    private String measuredValue2; //测量值2
    private String measuredValue3; //测量值3
    private String measuredValue4; //测量值4
    private String measuredResults; //测量结果
}
