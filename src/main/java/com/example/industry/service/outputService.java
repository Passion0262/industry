package com.example.industry.service;

import com.example.industry.entity.Output.output;
import java.util.Date;
import java.util.List;

public interface outputService {
    //新增记录
    boolean insertoutput(output output);

    //按班次查询产量
    List<output> getyieldShift(String shift);

    //按设备查询产量
    List<output> getyieldDevice(String Device);

    //按日期查询产量
    List<output> getyieldDate(Date date);

}
