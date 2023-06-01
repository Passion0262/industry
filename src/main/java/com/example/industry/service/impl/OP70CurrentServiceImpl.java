package com.example.industry.service.impl;

import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.dao.device.OP70CurrentMapper;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.service.OP50CurrentService;
import com.example.industry.service.OP70CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author ml
 * @create 2022-03-28 14:11
 */
@Slf4j
@Service

public class OP70CurrentServiceImpl implements OP70CurrentService{

    @Autowired
    OP70CurrentMapper op70CurrentMapper;

    @Override
    public List<OP70Current> listOP70Current() {
        return op70CurrentMapper.listOP70Current();
    }

    @Override
    public boolean insertOP70Current(OP70Current op70Current) {
        /*OP70Current lasted = getLatest();
        //如果要新增的记录和最新的一条相同，则不添加
        if (isSame(lasted,op70Current)){
            return false;
        }else {
        return op70CurrentMapper.insertDeviceStatus(op70Current);
             }*/
        return op70CurrentMapper.insertDeviceStatus(op70Current);
    }

    @Override
    public OP70Current getLatest() {
        return op70CurrentMapper.getLatest();
    }

    @Override
    public Integer getOutput(){return op70CurrentMapper.getOutput();}

    @Override
    public List<OP70Current> getLatest10() {
        return op70CurrentMapper.getLatest10();
    }

    @Override
    public List<OP70Current> getOP70ListByDate(String date) {
        return op70CurrentMapper.getOP70ListByDate(date);
    }

    boolean isSame(OP70Current o1, OP70Current o2){
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
