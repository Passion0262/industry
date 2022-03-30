package com.example.industry.dao;
import com.example.industry.entity.PLC.plc1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

}
