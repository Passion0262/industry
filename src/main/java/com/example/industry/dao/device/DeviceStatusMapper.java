package com.example.industry.dao.device;

import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.entity.Output.output;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeviceStatusMapper {

    @Select("SELECT * FROM device_status")
    List<DeviceStatus> listDeviceStatus();

    @Insert("INSERT INTO device_status(id,status,work_piece,output,rapid_feed_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{workPiece},#{output},#{rapidFeedRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(DeviceStatus deviceStatus);

}
