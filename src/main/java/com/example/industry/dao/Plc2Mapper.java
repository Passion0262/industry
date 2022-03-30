package com.example.industry.dao;
import com.example.industry.entity.PLC.plc2;
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


}
