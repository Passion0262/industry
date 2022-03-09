package com.example.industry.service;

import com.example.industry.entity.Productionplan.productionplan;

import java.sql.Timestamp;
import java.util.List;

public interface productionplanService {

    //新建生产计划
    boolean insertproductionplan(productionplan Productionplan);

    //新增记录
    boolean insertplan(productionplan Productionplan);

    //查询所有生产计划
    List<productionplan> getall();

    //查询生产计划
    List<productionplan> getproplan(String planName, int modelType, Timestamp plannedstart, Timestamp plannedend, String state);

    //删除生产计划
    boolean deleteplan(int planNumber);

    //获取生产计划操作
    String getplanoperation(int planNumber);

    //获取生产计划名称
    String getplanname(int planNumber);

    //获取生产计划状态
    String getplanstate(int planNumber);

    //获取生产计划所属设备组
    String getplandevicegroup(int planNumber);

    //获取计划产量
    int getplanyield(int planNumber);

    //获取合格产量
    int getqualifiedyield(int planNumber);

    //获取不合格产量
    int getdisqualifiedyield(int planNumber);

    //获取计划明细
    String getplandetails(int planNumber);

    //获取机种型号
    int getplanmodeltype(int planNumber);

    //获取计划开始时间
    Timestamp getplannedstart(int planNumber);

    //获取计划结束时间
    Timestamp getplannedend(int planNumber);

    //获取实际开始时间
    Timestamp getactualstart(int planNumber);

    //获取实际结束时间
    Timestamp getactualend(int planNumber);

}
