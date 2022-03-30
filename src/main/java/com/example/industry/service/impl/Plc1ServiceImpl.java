package com.example.industry.service.impl;

import com.example.industry.dao.Plc1Mapper;
import com.example.industry.entity.PLC.plc1;
import com.example.industry.service.Plc1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Plc1ServiceImpl implements Plc1Service {
    @Autowired
    Plc1Mapper plc1Mapper;

    @Override
    public List<plc1> listAll(){
        return plc1Mapper.listAll();
    }

    @Override
    public List<plc1> getByStatus(String status){return plc1Mapper.getByStatus(status);}

    @Override
    public List<plc1> getByType(String PLCType){return plc1Mapper.getByType(PLCType);}

    @Override
    public List<plc1> getByPLState(String productionlineState){return plc1Mapper.getByPLState(productionlineState);
    }

    @Override
    public List<plc1> getByPNumber(String productionNumber){return plc1Mapper.getByPNumber(productionNumber);}
}
