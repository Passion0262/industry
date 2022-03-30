package com.example.industry.entity.Alarmstatistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlarmStatistics {
    private int id;
    private String date;//统计日期
    private String device;//设备名称
    private String alarmId;//报警编号
    private int times;//出现次数
    private String proportion;//占比
    private String alarmInfo;//报警信息
}
