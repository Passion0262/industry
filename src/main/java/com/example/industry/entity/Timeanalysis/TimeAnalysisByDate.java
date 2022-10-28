package com.example.industry.entity.Timeanalysis;

import com.example.industry.entity.vo.TimeAnalysisVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeAnalysisByDate {
    private int id; //编号

    private Timestamp time;// 时间

    private String device;//设备

    private String Status;//设备状态

}
