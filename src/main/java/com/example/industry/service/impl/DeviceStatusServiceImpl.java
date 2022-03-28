package com.example.industry.service.impl;

import com.example.industry.dao.DeviceStatusMapper;
import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.service.DeviceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceStatusServiceImpl implements DeviceStatusService {

    @Autowired
    DeviceStatusMapper deviceStatusMapper;

    @Override
    public List<DeviceStatus> listDeviceStatus() {
        return deviceStatusMapper.listDeviceStatus();
    }

    @Override
    public boolean insertDeviceStatus(DeviceStatus deviceStatus) {
        return deviceStatusMapper.insertDeviceStatus(deviceStatus);
    }


}
