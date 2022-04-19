package com.example.industry.dao.device;

import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.entity.Device.OP40Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OP40CurrentMapper {

    @Select("SELECT * FROM op40_current")
    List<OP40Current> listOP40Current();

    @Insert("INSERT INTO op40_current(id,status,work_piece,output,rapid_feed_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{workPiece},#{output},#{rapidFeedRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(OP40Current op40Current);

    /**
     * 获取最新的一条记录
     */
    @Select("SELECT * FROM op40_current WHERE id = (SELECT MAX(id) FROM op40_current)")
    OP40Current getLatest();

    /**
     * 获取最新的10条记录
     */
    @Select("SELECT * FROM op40_current ORDER BY time DESC LIMIT 10")
    List<OP40Current> getLatest10();

}
