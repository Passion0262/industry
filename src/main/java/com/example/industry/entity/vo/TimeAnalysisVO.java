package com.example.industry.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：shadow
 * @date ：Created in 2022/4/19 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeAnalysisVO {
    private int id; //编号

    private String date;// 日期

    private String device;//设备

    private Double stop;//停机

    private Double operate;//运行

    private Double free;//空闲

    private Double offline;//离线

    private Double setting;//设定
}
