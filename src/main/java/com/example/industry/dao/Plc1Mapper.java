package com.example.industry.dao;
import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.PLC.plc1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
@Mapper
public interface Plc1Mapper
{
    /**
     * 查询所有信息
     */
    @Select("SELECT * FROM plc1")
    List<plc1> listAll();

    /**
     * 根据状态查询
     */
    @Select("SELECT * FROM plc1 WHERE status=#{status}")
    List<plc1> getByStatus(String status);

    /**
     * 根据总控机种查询
     */
    @Select("SELECT * FROM plc1 WHERE PLC_type=#{PLC_type}")
    List<plc1> getByType(String PLCType);

    /**
     * 根据产线状态查询
     */
    @Select("SELECT * FROM plc1 WHERE productionline_state=#{productionline_state}")
    List<plc1> getByPLState(String productionlineState);

    /**
     * 根据产品编号/机种查询
     */
    @Select("SELECT * FROM plc1 WHERE production_number=#{production_number}")
    List<plc1> getByPNumber(String productionNumber);


    /**
     * 获取plc1指定某一天的数据
     */
    @Select("SELECT * FROM plc1 WHERE DATE_FORMAT(acquisition_time,'%Y-%m-%d') = #{date}")
    List<plc1> getPlc1ListByDate(String date);

    /**
     * 新增plc记录
     */
    @Insert("INSERT INTO plc1(id,acquisition_time,status,plc_type,forty_feeding_request,forty_cutting_request,forty_on_position,forty_feeding_done,forty_cutting_done,forty_forward,forty_reverse,"+
    "fifty_feeding_request,fifty_cutting_request,fifty_on_position,fifty_feeding_done,fifty_cutting_done,fifty_forward,fifty_reverse,feeding_location1_xn,"+
    "feeding_location2_xn,op40_location_xn,marking_machine_location_xn,marking_machine_location_zs,op50_location_zs,measuring_machine_location_zs,ngzs_code,productionline_state,"+
    "plan_number,plan_amount,production_number,feeding_location1_zs,feeding_location2_zs,op40_location_zs,measuring_machine_location_xn,op50_location_xn,marking_code) VALUES (null,CURRENT_TIMESTAMP,"+
    "#{status},#{PLCType},#{fortyFeedingRequest},#{fortyCuttingRequest},#{fortyOnPosition},#{fortyFeedingDone},#{fortyCuttingDone},#{fortyForward},#{fortyReverse},#{fiftyFeedingRequest},#{fiftyCuttingRequest},"+"#{fiftyOnPosition},#{fiftyFeedingDone},#{fiftyCuttingDone},#{fiftyForward},#{fiftyReverse},#{feedingLocation1XN},#{feedingLocation2XN},#{OP40LocationXN},#{markingMachineLocationXN},#{markingMachineLocationZS},"+
    "#{OP50LocationZS},#{measuringMachineLocationZS},#{NGZSCode},#{productionlineState},#{planNumber},#{planAmount},#{productionNumber},#{feedingLocation1ZS},#{feedingLocation2ZS},"+
    "#{OP40LocationZS},#{measuringMachineLocationXN},#{OP50LocationXN},#{MarkingCode})")
    boolean insertDeviceStatus(plc1 plc1);
}
