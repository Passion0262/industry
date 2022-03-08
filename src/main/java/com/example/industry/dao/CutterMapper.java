package com.example.industry.dao;

import com.example.industry.entity.Cutter.cutter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import  java.util.List;
@Mapper
public interface CutterMapper {
    /**
    *查询所有刀具信息
    */
    @Select("SELECT * FROM cutter")
    List<cutter> listCutter();

    /**
     *根据刀具编号返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE cutter_id=#{cutter_id}")
    cutter getById(int cutterId);

    /**
     *根据刀具型号返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE cutter_type=#{cutter_type}")
    List<cutter> getByType(String cutterType);

    /**
     *根据刀具类型返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE cutter_category=#{cutter_category}")
    List<cutter> getByCategory(String cutterCategory);

    /**
     *根据设备编号返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE device_id=#{device_id}")
    List<cutter> getByDeviceId(int deviceId);

    /**
     *根据刀具刀位返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE cutter_location=#{cutter_location}")
    List<cutter> getByLocation(int cutterLocation);

    /**
     *根据寿命状态返回刀具信息
     */
    @Select("SELECT * FROM cutter WHERE life_state=#{life_state}")
    List<cutter> getByLifeState(String lifeState);

    /**
     * 新增刀具信息
     */
    @Insert("INSERT INTO cutter(cutter_id, cutter_category, cutter_type, device_id, device_name,cutter_location,cutter_state,cutter_length," +
            "cutter_diameter,wear_compensation_length,wear_compensation_diameter," +
            "life_state,counting_mode,initial_life,used_life,residual_life,alarm_value) VALUES (#{cutterId},#{cutterCategory},#{cutterType}," +
            "#{deviceId},#{deviceName},#{cutterLocation},#{cutterState},#{cutterLength},#{cutterDiameter},#{wearCompensationLength},#{wearCompensationDiameter}," +
            "#{lifeState},#{countingMode},#{initialLife},#{usedLife},#{residualLife},#{alarmValue})")
    boolean insertCutter(cutter cutter);

    /**
     * 根据刀具编号删除刀具
     */
    @Delete("DELETE from cutter where cutter_id=#{cutterId}")
    boolean deleteById(int cutterId);


}
