package com.example.industry.entity.Activation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activation {
    String date;//统计日期
    float OP40;//OP40车床
    float OP50;//OP50车床
    float OP60;//OP60立加
    float OP70;//OP70立加
    float measuringMachine;//测量机
    float markingMachine;//打标机
    float PLC1;//总控PLC-1
    float PLC2;//总控PLC
    float workpieceOnline;//工件上线
    float workpieceOffline;//工件下线


}
