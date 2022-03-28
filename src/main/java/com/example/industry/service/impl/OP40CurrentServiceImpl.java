package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.service.OP40CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OP40CurrentServiceImpl implements OP40CurrentService {

    @Autowired
    OP40CurrentMapper op40CurrentMapper;

    @Override
    public List<OP40Current> listOP40Current() {
        return op40CurrentMapper.listOP40Current();
    }

    @Override
    public boolean insertOP40Current(OP40Current op40Current) {
        return op40CurrentMapper.insertDeviceStatus(op40Current);
    }
}
