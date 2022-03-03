package com.example.industry.dao;

import com.example.industry.entity.Warn.warn;
import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 * @author ml
 * @create 2022-03-02 13:56
 */
@Mapper
public interface WarnMapper {
    @Select("SELECT * FROM warn")
    List<warn> listwarn();

    @Select("SELECT * FROM warn WHERE device_name = #{name}")
    List<warn> getDeviceName(String name);

    @Select("SELECT * FROM warn WHERE warn_id = #{id}")
    warn getWarnId(int id);
}
