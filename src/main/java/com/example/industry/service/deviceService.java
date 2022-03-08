package com.example.industry.service;

import com.example.industry.entity.Device.Device;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 14:15
 */
public interface DeviceService {

    /**
     *  获取所有设备
     */
    List<Device> listDevices();

    /**
     *  根据id查找设备
     */
    Device getById(String id);

    /**
     *  根据name查找设备
     */
    Device getByName(String name);

}
