package com.example.industry.entity.Timeanalysis;

import com.example.industry.entity.vo.TimeAnalysisVO;
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

    public TimeAnalysisVO toVO(){
        TimeAnalysisVO vo = new TimeAnalysisVO();
        vo.setId(this.id);
        vo.setDate(this.date);
        vo.setDevice(this.device);
        vo.setStop(Double.parseDouble(this.stop.split("%")[0])/100);
        vo.setOperate(Double.parseDouble(this.operate.split("%")[0])/100);
        vo.setFree(Double.parseDouble(this.free.split("%")[0])/100);
        vo.setOffline(Double.parseDouble(this.offline.split("%")[0])/100);
        vo.setSetting(Double.parseDouble(this.setting.split("%")[0])/100);
        return vo;
    }
}
