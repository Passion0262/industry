package com.example.industry.service.impl;

import com.example.industry.dao.DeviceMapper;
import com.example.industry.entity.Device.device;
import com.example.industry.service.deviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class deviceServiceImpl implements deviceService {

    @Autowired
    DeviceMapper deviceMpapper;


    @Override
    public List<device> listdevices() {
        return deviceMpapper.listdevices();
    }

    @Override
    public device getById(int device_id) {
        return deviceMpapper.getById(device_id);
    }
}
