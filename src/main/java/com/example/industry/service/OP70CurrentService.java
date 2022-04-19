package com.example.industry.service;

import com.example.industry.entity.Device.OP40Current;
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

}
