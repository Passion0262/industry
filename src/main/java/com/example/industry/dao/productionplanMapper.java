package com.example.industry.dao;

import org.apache.ibatis.annotations.*;
import com.example.industry.entity.Productionplan.productionplan;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface productionplanMapper {

    //新建生产计划
    @Insert("INSERT INTO productionplan(plan_name,model_type,plan_yield,devicegroup,plannedstart,plannedend) VALUES (#{planName},#{modelType},#{planYield},#{devicegroup},#{plannedstart},#{plannedend})")
    boolean insertproductionplan(productionplan Productionplan);

    //新增记录
    @Insert("INSERT INTO productionplan(operation,plan_number,plan_name,state,devicegroup,plan_yield,qualified_yield,disqualified_yield,plan_details,model_type,plannedstart,plannedend,actualstart,actualend) VALUES (#{operation},#{planNumber},#{planName},#{state},#{devicegroup},#{planYield},#{qualifiedYield},#{disqualifiedYield},#{planDetails},#{modelType},#{plannedstart},#{plannedend},#{actualstart},#{actualend})")
    boolean insertplan(productionplan Productionplan);

    //查询所有生产计划
    @Select("SELECT * from productionplan")
    List<productionplan> getall();

    //查询生产计划
    @Select("SELECT * from productionplan where plan_name=#{planName} AND model_type=#{modelType} AND plannedstart=#{plannedstart} AND plannedend=#{plannedend} AND state=#{state}")
    List<productionplan> getproplan(String planName, int modelType, Timestamp plannedstart, Timestamp plannedend, String state);

    //删除生产计划
    @Delete("DELETE from productionplan where plan_number=#{planNumber} ")
    boolean deleteplan(int planNumber);

    //查询某一时间段内的生产计划
    @Select("SELECT * from productionplan where plannedstart BETWEEN #{plannedstart1} AND #{plannedstart2}")
    List<productionplan> getplans(Timestamp plannedstart1, Timestamp plannedstart2);







}
