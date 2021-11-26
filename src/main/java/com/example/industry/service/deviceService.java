package com.example.industry.service;
import com.example.industry.entity.Device.device;
import java.util.List;

public interface deviceService {

    /**
     * 显示所有设备信息
     * @return 返回所有设备列表
     */
    List<device> listdevices();

    /**
     * 根据id返回device记录
     * @param device_id device表id
     * @return device实体类
     */
    device getById(int device_id);

    //boolean isExist(String username,String password);
}
