package com.example.industry.dao.device;

import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    /**
     * 获取测量机指定某一天的数据
     */
    @Select("SELECT * FROM measuring_machine WHERE DATE_FORMAT(acquisition_time,'%Y-%m-%d') = #{date}")
    List<MeasuringMachine> getMeasuringMachineListByDate(String date);

}
