package com.example.industry.service.impl;

import com.example.industry.dao.DeviceMapper;
import com.example.industry.entity.Device.Device;
import com.example.industry.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 14:17
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<Device> listDevices() {
        return deviceMapper.listDevices();
    }

    @Override
    public Device getById(String id) {
        return deviceMapper.getById(id);
    }

    @Override
    public Device getByName(String name) {
        return deviceMapper.getByName(name);
    }
}
