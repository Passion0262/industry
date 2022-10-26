package com.example.industry.service;

import com.example.industry.entity.Device.MeasuringMachine;

public interface MeasuringMachineService {

    MeasuringMachine getmeasured(String acquisition_time);

    /**
     * 新增测量机信息
     */
    boolean insertMeasuringMachineCurrent(MeasuringMachine measuringMachine);
}
