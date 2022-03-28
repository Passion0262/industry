package com.example.industry.dao;

import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.*;

import  java.util.List;
@Mapper
public interface TimeAnalysisMapper {
    /**
     * 查询所有信息
     */
    @Select("SELECT * FROM time_analysis")
    List<TimeAnalysis> listAll();

    /**
     * 根据设备查询
     */
    @Select("SELECT * FROM time_analysis WHERE device=#{device}")
    List<TimeAnalysis> getByDevice(String device);

    /**
     * 根据日期查询
     */
    @Select("SELECT * FROM time_analysis WHERE date=#{date}")
    List<TimeAnalysis> getByDate(String date);
}
