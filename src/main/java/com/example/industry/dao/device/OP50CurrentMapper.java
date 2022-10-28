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

    /**
     * 获取最新的10条记录
     */
    @Select("SELECT * FROM op50_current ORDER BY time DESC LIMIT 10")
    List<OP50Current> getLatest10();

    /**
     * 获取最新的一条记录
     */
    @Select("SELECT * FROM op50_current WHERE id = (SELECT MAX(id) FROM op50_current)")
    OP50Current getLatest();

    /**
     * 获取op50指定某一天的数据
     */
    @Select("SELECT * FROM op50_current WHERE DATE_FORMAT(time,'%Y-%m-%d') = #{date}")
    List<OP50Current> getOP50ListByDate(String date);
}
