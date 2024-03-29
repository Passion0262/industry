package com.example.industry.dao.device;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OP70CurrentMapper {

    @Select("SELECT * FROM op70_current")
    List<OP70Current> listOP70Current();

    @Insert("INSERT INTO op70_current(id,status,program_name,output,spindle_rate,spindle_speed,feed_rate,feed_speed,alarm_number,alarm_info,time) " +
            "VALUES (null,#{status},#{programName},#{output},#{spindleRate},#{spindleSpeed},#{feedRate},#{feedSpeed},#{alarmNumber},#{alarmInfo},CURRENT_TIMESTAMP)")
    boolean insertDeviceStatus(OP70Current op70Current);

    /**
     * 获取最新的10条记录
     */
    @Select("SELECT * FROM op70_current ORDER BY time DESC LIMIT 10")
    List<OP70Current> getLatest10();

    /**
     * 获取最新的一条记录
     */
    @Select("SELECT * FROM op70_current WHERE id = (SELECT MAX(id) FROM op70_current)")
    OP70Current getLatest();

    /**
     * 获取最大产量
     */
    @Select("SELECT MAX(output) FROM op70_current")
    Integer getOutput();

    /**
     * 获取op70指定某一天的数据
     */
    @Select("SELECT * FROM op70_current WHERE DATE_FORMAT(time,'%Y-%m-%d') = #{date}")
    List<OP70Current> getOP70ListByDate(String date);
}
