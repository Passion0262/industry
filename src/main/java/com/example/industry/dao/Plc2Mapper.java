package com.example.industry.dao;
import com.example.industry.entity.PLC.plc1;
import com.example.industry.entity.PLC.plc2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface Plc2Mapper
{
    /**
     * 查询所有信息
     */
    @Select("SELECT * FROM plc2")
    List<plc2> listAll();

    /**
     * 根据状态查询
     */
    @Select("SELECT * FROM plc2 WHERE status=#{status}")
    List<plc2> getByStatus(String status);

    /**
     * 根据总控机种查询
     */
    @Select("SELECT * FROM plc2 WHERE PLC_type=#{PLC_type}")
    List<plc2> getByType(String PLCType);

    /**
     * 新增plc记录
     */
    @Insert("INSERT INTO plc1(id,acquisition_time,status,plc_type,sixty_feeding_request,sixty_cutting_request,sixty_on_position,sixty_feeding_done,sixty_cutting_done,sixty_forward,sixty_reverse,"+
            "seventy_feeding_request,seventy_cutting_request,seventy_on_position,seventy_feeding_done,seventy_cutting_done,seventy_forward,seventy_reverse,op60_location_zs,"+
            "op70_location_zs,okzs_code,okzs_code1,ngzs_code,op60_location_xn,op70_location_xn,marking_code,productionline_state,plan_number,plan_amount,production_number," +
            "feeding_location1_zs,feeding_location2_zs,marking_machine_location_zs,measuring_machine_location_zs,measuring_machine_location_xn,feeding_location1_xn,feeding_location2_xn,marking_machine_location_xn) VALUES (null,CURRENT_TIMESTAMP,"+
            "#{status},#{PLCType},#{sixtyFeedingRequest},#{sixtyCuttingRequest},#{sixtyOnPosition},#{sixtyFeedingDone},#{sixtyCuttingDone},#{sixtyForward},#{sixtyReverse},#{seventyFeedingRequest},#{seventyCuttingRequest},"+
            "#{seventyOnPosition},#{seventyFeedingDone},#{seventyCuttingDone},#{seventyForward},#{seventyReverse},#{OP60LocationZS},#{OP70LocationZS},#{OKZSCode},#{OKZSCode1},#{NGZSCode},"+
            "#{OP60LocationXN},#{OP70LocationXN},#{MarkingCode},#{productionlineState},#{planNumber},#{planAmount},#{productionNumber},#{feedingLocation1ZS},#{feedingLocation2ZS},"+
            "#{markingMachineLocationZS},#{measuringMachineLocationZS},#{measuringMachineLocationXN},#{feedingLocation1XN},#{feedingLocation2XN}，#{markingMachineLocationXN})")
    boolean insertDeviceStatus(plc2 plc2);

}
