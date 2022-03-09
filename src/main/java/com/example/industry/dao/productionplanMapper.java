package com.example.industry.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.example.industry.entity.Productionplan.productionplan;
import org.apache.ibatis.annotations.Select;

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

    @Select("SELECT operation from productionplan where plan_number=#{planNumber}")
    String getplanoperation(int planNumber);

    @Select("SELECT plan_name from productionplan where plan_number=#{planNumber}")
    String getplanname(int planNumber);

    @Select("SELECT state from productionplan where plan_number=#{planNumber}")
    String getplanstate(int planNumber);

    @Select("SELECT devicegroup from productionplan where plan_number=#{planNumber}")
    String getplandevicegroup(int planNumber);

    @Select("SELECT plan_yield from productionplan where plan_number=#{planNumber}")
    int getplanyield(int planNumber);

    @Select("SELECT qualified_yield from productionplan where plan_number=#{planNumber}")
    int getqualifiedyield(int planNumber);

    @Select("SELECT disqualified_yield from productionplan where plan_number=#{planNumber}")
    int getdisqualifiedyield(int planNumber);



    @Select("SELECT plan_details from productionplan where plan_number=#{planNumber}")
    String getplandetails(int planNumner);

    @Select("SELECT model_type from productionplan where plan_number=#{planNumber}")
    int getplanmodeltype(int planNumner);

    @Select("SELECT plannedstart from productionplan where plan_number=#{planNumber}")
    Timestamp getplannedstart(int planNumner);

    @Select("SELECT plannedend from productionplan where plan_number=#{planNumber}")
    Timestamp getplannnedend(int planNumber);

    @Select("SELECT actualstart from productionplan where plan_number=#{planNumber}")
    Timestamp getactualstart(int planNumber);

    @Select("SELECT actualend from productionplan where plan_number=#{planNumber}")
    Timestamp getactualend(int planNumber);


}
