package com.example.industry.entity.Warn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author ml
 * @create 2022-03-02 13:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class warn {
    private int productionId;      //报错编号递增
    private String deviceName;    // 设备的名称
    private String deviceStatus;   // 设备运行的状态
    private String deviceLocation;  // 设备的所处的公司名称或者地理位置
    private int warnId;        // 报错id编号
    private String warnInformation;   // 报错的详细信息
    private Timestamp warnTime;     // 报错的时间

}
