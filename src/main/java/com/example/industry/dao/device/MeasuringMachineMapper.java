package com.example.industry.dao.device;

import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.Device.OP50Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MeasuringMachineMapper {
    /**
     *根据采集时间获取测量信息
     */
    @Select("SELECT * from measuring_machine where acquisition_time=#{acquisition_time}")
    MeasuringMachine getmeasured(String acquisition_time);

    /**
     * 新增信息
     */

    @Insert("INSERT INTO measuring_machine(id,acquisition_time,status,workpiece_code,workpiece_type,measured_value1,measured_value2,measured_value3,measured_value4,measured_results) " +
            "VALUES (null,CURRENT_TIMESTAMP,#{status},#{workpieceCode},#{workpieceType},#{measuredValue1},#{measuredValue2},#{measuredValue3},#{measuredValue4},#{measuredResults})")
    boolean insertDeviceStatus(MeasuringMachine measuringMachine);
}
