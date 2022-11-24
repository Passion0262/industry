package com.example.industry.service.impl;

import com.example.industry.dao.Plc2Mapper;
import com.example.industry.entity.PLC.plc1;
import com.example.industry.entity.PLC.plc2;
import com.example.industry.service.Plc2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Plc2ServiceImpl implements Plc2Service {
    @Autowired
    Plc2Mapper plc2Mapper;

    @Override
    public List<plc2> listAll(){
        return plc2Mapper.listAll();
    }

    @Override
    public List<plc2> getByStatus(String status){return plc2Mapper.getByStatus(status);}

    @Override
    public List<plc2> getByType(String PLCType){return plc2Mapper.getByType(PLCType);}

    @Override
    public List<plc2> getPlc2ListByDate(String date) {
        return plc2Mapper.getPlc2ListByDate(date);
    }


    @Override
    public boolean insertPlc2Current(plc2 plc2){return plc2Mapper.insertDeviceStatus(plc2);}
    }