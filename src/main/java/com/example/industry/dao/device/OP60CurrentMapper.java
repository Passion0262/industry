package com.example.industry.dao.device;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OP60CurrentMapper {

    @Select("SELECT * FROM op60_current")
    List<OP60Current> listOP60Current();

    @Insert("INSERT INTO op60_current(id,status,program_name,output,spindle_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{programName},#{output},#{spindleRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(OP60Current op60Current);

    /**
     * 获取最新的10条记录
     */
    @Select("SELECT * FROM op60_current ORDER BY time DESC LIMIT 10")
    List<OP60Current> getLatest10();

    /**
     * 获取最新的一条记录
     */
    @Select("SELECT * FROM op60_current WHERE id = (SELECT MAX(id) FROM op60_current)")
    OP60Current getLatest();

    /**
     * 获取op60指定某一天的数据
     */
    @Select("SELECT * FROM op60_current WHERE DATE_FORMAT(time,'%Y-%m-%d') = #{date}")
    List<OP60Current> getOP60ListByDate(String date);
}
