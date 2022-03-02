package com.example.industry.dao;

import com.example.industry.entity.ProductionLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 10:52
 */
@Mapper
public interface ProductionLineMapper {

    @Select("SELECT * FROM production_line")
    List<ProductionLine> listLines();

    @Select("SELECT * FROM production_line WHERE id = #{id}")
    ProductionLine getById(String id);

    @Select("SELECT * FROM production_line WHERE name = #{name}")
    ProductionLine getByName(String name);
}
