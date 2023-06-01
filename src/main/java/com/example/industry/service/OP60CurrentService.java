package com.example.industry.service;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;

import java.util.List;

public interface OP60CurrentService {

    /**
     *  获取所有op60状态
     */
    List<OP60Current> listOP60Current();

    /**
     *  新增当前op60状态信息
     */
    boolean insertOP60Current(OP60Current op60Current);

    /**
     * 获取最新10条记录
     */
    List<OP60Current> getLatest10();

    /**
     *  获取op60最新的1条记录
     */
    OP60Current getLatest();

    /**
     * 获取最大产量
     */
    Integer getOutput();

    /**
     * 获取op60指定某一天的数据
     */
    List<OP60Current> getOP60ListByDate(String date);

}
