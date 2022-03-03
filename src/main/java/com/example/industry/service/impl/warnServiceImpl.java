package com.example.industry.service.impl;

import com.example.industry.dao.WarnMapper;
import com.example.industry.entity.Warn.warn;
import com.example.industry.service.WarnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.WatchService;
import java.util.List;

/**
 * @author ml
 * @create 2022-03-03 10:50
 */
@Service
public class warnServiceImpl implements WarnService {
    @Autowired
    WarnMapper warnMapper;

    @Override
    public List<warn> listwarn() {
        return warnMapper.listwarn();
    }

    @Override
    public List<warn> getDeviceName(String name) {
        return warnMapper.getDeviceName(name);
    }

    @Override
    public warn getWarnId(int id) {
        return warnMapper.getWarnId(id);
    }
}
