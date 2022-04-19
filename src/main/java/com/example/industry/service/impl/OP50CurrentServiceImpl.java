package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.service.OP50CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-28 14:11
 */
@Service
public class OP50CurrentServiceImpl implements OP50CurrentService {

    @Autowired
    OP50CurrentMapper op50CurrentMapper;

    @Override
    public List<OP50Current> listOP50Current() {
        return op50CurrentMapper.listOP50Current();
    }

    @Override
    public boolean insertOP50Current(OP50Current op50Current) {
        return  op50CurrentMapper.insertDeviceStatus(op50Current);
    }

    @Override
    public List<OP50Current> getLatest10() {
        return op50CurrentMapper.getLatest10();
    }
}
