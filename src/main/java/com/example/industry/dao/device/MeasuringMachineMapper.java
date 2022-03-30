package com.example.industry.dao.device;

import com.example.industry.entity.Device.MeasuringMachine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MeasuringMachineMapper {
    /**
     *根据采集时间获取测量信息
     */
    @Select("SELECT * from measuring_machine where acquisition_time=#{acquisition_time}")
    MeasuringMachine getmeasured(String acquisition_time);
}
