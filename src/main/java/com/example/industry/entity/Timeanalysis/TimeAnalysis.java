package com.example.industry.entity.Timeanalysis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeAnalysis {
    private int id; //编号（此表为用时分析）

    private String date;// 日期

    private String device;//设备

    private String stop;//停机

    private String operate;//运行

    private String free;//空闲

    private String offline;//离线

    private String setting;//设定
}
