package com.example.industry.dao;

import com.example.industry.entity.Output.output;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface OutputMapper {
    @Insert("INSERT INTO output(id,date,shift,device,yield) VALUES (#{id},#{date},#{shift},#{device},#{yield})")
    boolean insertoutput(output output);

    //按班次查询产量
    @Select("SELECT * from output where shift=#{shift}")
    List<output> getyieldShift(String shift);

    //按设备查询产量
    @Select("SELECT * from output where device=#{device}")
    List<output> getyieldDevice(String device);

    //按天次查询产量
    @Select("SELECT * from output where date=#{date}")
    List<output> getyieldDate(Date date);





}
