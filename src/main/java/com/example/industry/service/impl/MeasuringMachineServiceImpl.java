package com.example.industry.service.impl;

import com.example.industry.dao.device.MeasuringMachineMapper;
import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.service.MeasuringMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasuringMachineServiceImpl implements MeasuringMachineService{
    @Autowired
    MeasuringMachineMapper measuringMachineMapper;

    @Override
    public MeasuringMachine getmeasured(String acquisition_time){return measuringMachineMapper.getmeasured(acquisition_time);}

    @Override
    public boolean insertMeasuringMachineCurrent(MeasuringMachine measuringMachine){return measuringMachineMapper.insertDeviceStatus(measuringMachine);}


    @Override
    public List<MeasuringMachine> getMeasuringMachineListByDate(String date) {
        return measuringMachineMapper.getMeasuringMachineListByDate(date);
    }

}




