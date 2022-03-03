package com.example.industry.dao;

import com.example.industry.entity.Cutter.cutter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
