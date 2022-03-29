package com.example.industry.service.impl;

import com.example.industry.dao.Plc2Mapper;
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
}