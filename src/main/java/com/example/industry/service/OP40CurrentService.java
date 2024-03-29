package com.example.industry.service;

import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.entity.Device.OP40Current;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OP40CurrentService {

    /**
     *  获取所有op40状态
     */
    List<OP40Current> listOP40Current();

    /**
     *  新增当前op40状态信息
     */
    boolean insertOP40Current(OP40Current op40Current);

    /**
     * 获取最新的一条记录
     */
    OP40Current getLatest();

    /**
     * 获取最大产量
     */
    Integer getOutput();

    /**
     * 获取最新10条记录
     */
    List<OP40Current> getLatest10();

    /**
     * 获取op40指定某一天的数据
     */
    List<OP40Current> getOP40ListByDate(String date);
}
