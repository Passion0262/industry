package com.example.industry.dao.device;


import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-28 14:19
 */
@Mapper
public interface OP50CurrentMapper {

    @Select("SELECT * FROM op50_current")
    List<OP50Current> listOP50Current();

    @Insert("INSERT INTO op50_current(id,status,work_piece,output,rapid_feed_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{workPiece},#{output},#{rapidFeedRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(OP50Current op50Current);

}