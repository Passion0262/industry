package com.example.industry.service;

import com.example.industry.entity.Device.DeviceStatus;

import java.util.List;

public interface DeviceStatusService {

    /**
     *  获取所有设备状态
     */
    List<DeviceStatus> listDeviceStatus();

    /**
     *  新增当前设备状态信息
     */
    boolean insertDeviceStatus(DeviceStatus deviceStatus);

}
