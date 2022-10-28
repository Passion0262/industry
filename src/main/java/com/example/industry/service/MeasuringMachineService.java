package com.example.industry.service;

import com.example.industry.entity.Device.MeasuringMachine;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MeasuringMachineService {

    MeasuringMachine getmeasured(String acquisition_time);

    /**
     * 新增测量机信息
     */
    boolean insertMeasuringMachineCurrent(MeasuringMachine measuringMachine);

    /**
     * 获取测量机指定某一天的数据
     */
    List<MeasuringMachine> getMeasuringMachineListByDate(String date);

}
