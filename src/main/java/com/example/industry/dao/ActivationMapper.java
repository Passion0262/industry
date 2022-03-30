package com.example.industry.dao;

import com.example.industry.entity.Activation.Activation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ActivationMapper {

    /**
     *按日期查询所有设备的稼动率
     */
    @Select("select * from activation where date=#{date}")
    Activation getallActivation(String date);


}
