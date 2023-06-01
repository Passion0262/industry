package com.example.industry.service;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;

import java.util.List;

public interface OP70CurrentService {

    /**
     *  获取所有op70状态
     */
    List<OP70Current> listOP70Current();

    /**
     *  新增当前op70状态信息
     */
    boolean insertOP70Current(OP70Current op70Current);

    /**
     * 获取最新10条记录
     */
    List<OP70Current> getLatest10();

    /**
     *  获取op70最新的1条记录
     */
    OP70Current getLatest();

    /**
     * 获取最大产量
     */
    Integer getOutput();

    /**
     * 获取op70指定某一天的数据
     */
    List<OP70Current> getOP70ListByDate(String date);
}
