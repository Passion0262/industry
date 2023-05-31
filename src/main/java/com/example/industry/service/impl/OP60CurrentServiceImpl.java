package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.dao.device.OP60CurrentMapper;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.service.OP40CurrentService;
import com.example.industry.service.OP60CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class OP60CurrentServiceImpl implements OP60CurrentService{
    @Autowired
    OP60CurrentMapper op60CurrentMapper;

    @Override
    public List<OP60Current> listOP60Current() {
        return op60CurrentMapper.listOP60Current();
    }

    @Override
    public boolean insertOP60Current(OP60Current op60Current) {
       /* OP60Current lasted = getLatest();
        //如果要新增的记录和最新的一条相同，则不添加
        if (isSame(lasted,op60Current)){
            return false;
        }else {
            return op60CurrentMapper.insertDeviceStatus(op60Current);
        }*/
        return op60CurrentMapper.insertDeviceStatus(op60Current);
    }

    @Override
    public OP60Current getLatest() {
        return op60CurrentMapper.getLatest();
    }

    @Override
    public List<OP60Current> getLatest10() {
        return op60CurrentMapper.getLatest10();
    }

    @Override
    public List<OP60Current> getOP60ListByDate(String date) {
        return op60CurrentMapper.getOP60ListByDate(date);
    }

    boolean isSame(OP60Current o1, OP60Current o2){
        if (o1.getStatus().equals(o2.getStatus())
                && o1.getProgramName().equals(o2.getProgramName())
                && o1.getOutput() == o2.getOutput()
                && o1.getSpindleRate() == o2.getSpindleRate()
                && o1.getSpindleSpeed() == o2.getSpindleSpeed()
                && o1.getFeedRate() == o2.getFeedRate()
                && o1.getAlarmNumber() == o2.getAlarmNumber()
                && o1.getAlarmInfo().equals(o2.getAlarmInfo()) ){
            log.info("op40此条记录重复 : "+ o1);
            return true;
        }
        return false;
    }
}