package com.example.industry.dao.device;

import com.example.industry.entity.Device.Device;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 10:52
 */
@Mapper
public interface DeviceMapper {

    @Select("SELECT * FROM device")
    List<Device> listDevices();

    @Select("SELECT * FROM device WHERE id = #{id}")
    Device getById(String id);

    @Select("SELECT * FROM device WHERE name = #{name}")
    Device getByName(String name);
}
