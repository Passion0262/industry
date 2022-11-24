package com.example.industry.service;

import com.example.industry.entity.PLC.plc1;
import com.example.industry.entity.PLC.plc2;

import java.util.List;

public interface Plc2Service {
    /**
     * 显示所有信息
     */
    List<plc2> listAll();

    /**
     * 根据状态查询
     */
    List<plc2> getByStatus(String status);

    /**
     * 根据总控机种查询
     */
    List<plc2> getByType(String PLCType);

    /**
     * 新增当前plc2状态信息
     */
    boolean insertPlc2Current(plc2 plc2);

    /**
     * 获取plc2指定某一天的数据
     */
    List<plc2> getPlc2ListByDate(String date);

}
