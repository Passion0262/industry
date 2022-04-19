package com.example.industry.service.impl;

import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.dao.device.OP70CurrentMapper;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.service.OP50CurrentService;
import com.example.industry.service.OP70CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-28 14:11
 */
@Service

public class OP70CurrentServiceImpl implements OP70CurrentService{

    @Autowired
    OP70CurrentMapper op70CurrentMapper;

    @Override
    public List<OP70Current> listOP70Current() {
        return op70CurrentMapper.listOP70Current();
    }

    @Override
    public boolean insertOP70Current(OP70Current op70Current) {
        return op70CurrentMapper.insertDeviceStatus(op70Current);
    }

    @Override
    public List<OP70Current> getLatest10() {
        return op70CurrentMapper.getLatest10();
    }
}
