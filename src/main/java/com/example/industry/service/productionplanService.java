package com.example.industry.service;

import com.example.industry.entity.Productionplan.productionplan;

import java.sql.Timestamp;
import java.util.List;

public interface productionplanService {

    //新建生产计划
    boolean insertproductionplan(productionplan Productionplan);

    //新增记录
    boolean insertplan(productionplan Productionplan);

    //查询生产计划
    List<productionplan> getproplan(String planName, int modelType, Timestamp plannedstart, Timestamp plannedend, String state);

    //删除生茶计划
    boolean deleteplan(int planNumber);

}
