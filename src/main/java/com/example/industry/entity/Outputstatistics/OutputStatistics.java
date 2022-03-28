package com.example.industry.entity.Outputstatistics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputStatistics {
    private int id;//编号（产量统计）

    private String date;//统计日期

    private String deviceName;//设备名称

    private int output;//产量
}
