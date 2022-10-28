package com.example.industry.service;



import com.example.industry.entity.Device.OP40Current;
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

    /**
     *  获取op50最新的10条记录
     */
    List<OP50Current> getLatest10();

    /**
     *  获取op50最新的1条记录
     */
    OP50Current getLatest();

    /**
     * 获取op50指定某一天的数据
     */
    List<OP50Current> getOP50ListByDate(String date);

}
