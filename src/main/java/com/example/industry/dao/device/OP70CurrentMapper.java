package com.example.industry.dao.device;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP70Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OP70CurrentMapper {

    @Select("SELECT * FROM op70_current")
    List<OP70Current> listOP70Current();

    @Insert("INSERT INTO op70_current(id,status,work_piece,output,rapid_feed_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{workPiece},#{output},#{rapidFeedRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(OP70Current op70Current);

}
