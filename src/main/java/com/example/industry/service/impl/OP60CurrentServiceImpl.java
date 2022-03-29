package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.dao.device.OP60CurrentMapper;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.service.OP40CurrentService;
import com.example.industry.service.OP60CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OP60CurrentServiceImpl implements OP60CurrentService{
    @Autowired
    OP60CurrentMapper op60CurrentMapper;

    @Override
    public List<OP60Current> listOP60Current() {
        return op60CurrentMapper.listOP60Current();
    }

    @Override
    public boolean insertOP60Current(OP60Current op60Current) {
        return op60CurrentMapper.insertDeviceStatus(op60Current);
    }
}