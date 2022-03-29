package com.example.industry.service;

import com.example.industry.entity.Device.OP40Current;
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

}
