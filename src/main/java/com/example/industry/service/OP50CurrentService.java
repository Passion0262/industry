package com.example.industry.service;



import com.example.industry.entity.Device.OP50Current;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-28 14:14
 */
public interface OP50CurrentService {
    /**
    * 获取op50的状态
    *
    * */
    List<OP50Current> listOP50Current();

    /**
     *  新增当前op50状态信息
     */
    boolean insertOP50Current(OP50Current op50Current);

}
