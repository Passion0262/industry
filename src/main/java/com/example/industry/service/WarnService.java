package com.example.industry.service;

import com.example.industry.entity.Warn.warn;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-03 10:54
 */
public interface WarnService {
    /**
     * 获取所有报警信息
    * */
    List<warn> listwarn();
    /**
     *根据设备的名字查找报警信息
     * */
    List<warn> getDeviceName(String name);
    /**
     * 根据报警id查找报警信息
     * */
    warn getWarnId(int id);
}
