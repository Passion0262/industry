package com.example.industry.service;
import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.PLC.plc1;

import java.util.List;

public interface Plc1Service {
    /**
     * 显示所有信息
     */
    List<plc1> listAll();

    /**
     * 根据状态查询
     */
    List<plc1> getByStatus(String status);

    /**
     * 根据总控机种查询
     */
    List<plc1> getByType(String PLCType);

    /**
     * 根据产线状态查询
     */
    List<plc1> getByPLState(String productionlineState);

    /**
     * 根据产品编号/机种查询
     */
    List<plc1> getByPNumber(String productionNumber);

    /**
     * 新增当前plc1状态信息
     */
    boolean insertPlc1Current(plc1 plc1);

    /**
     * 获取plc1指定某一天的数据
     */
    List<plc1> getPlc1ListByDate(String date);

}
