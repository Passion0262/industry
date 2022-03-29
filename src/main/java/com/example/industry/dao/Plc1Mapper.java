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
}
