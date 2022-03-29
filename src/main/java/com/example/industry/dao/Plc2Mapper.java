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
}
