package com.example.industry.dao;

import com.example.industry.entity.Device.device;
import org.apache.ibatis.annotations.*;
import  java.util.List;

@Mapper
public interface DeviceMapper {
    @Select("SELECT * FROM device")
    List<device> listdevices();

    @Select("SELECT * FROM device WHERE device.deviceid = #{deviceID}")
    device getById(int device_id);

}
