package com.example.industry.dao;

import com.example.industry.entity.Outputstatistics.OutputStatistics;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OutputStatisticsMapper {
    /**
     * 查询所有信息
     */
    @Select("SELECT * FROM output_statistics")
    List<OutputStatistics> listAll();

    /**
     * 根据日期查询
     */
    @Select("SELECT * FROM output_statistics WHERE date=#{date}")
    List<OutputStatistics> getByDate(String date);

    /**
     * 根据设备名称查询
     */
    @Select("SELECT * FROM output_statistics WHERE device_name=#{device_name}")
    List<OutputStatistics> getByDeviceName(String deviceName);
}
