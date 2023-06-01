package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.service.OP40CurrentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OP40CurrentServiceImpl implements OP40CurrentService {

    @Autowired
    OP40CurrentMapper op40CurrentMapper;

    @Override
    public List<OP40Current> listOP40Current() {
        return op40CurrentMapper.listOP40Current();
    }

    @Override
    public boolean insertOP40Current(OP40Current op40Current) {
        /*OP40Current lasted = getLatest();
        //如果要新增的记录和最新的一条相同，则不添加
        if (isSame(lasted,op40Current)){
            return false;
        }else {
            return op40CurrentMapper.insertDeviceStatus(op40Current);
        }*/
        return op40CurrentMapper.insertDeviceStatus(op40Current);
    }

    @Override
    public OP40Current getLatest() {
        return op40CurrentMapper.getLatest();
    }

    @Override
    public Integer getOutput(){return op40CurrentMapper.getOutput();}

    @Override
    public List<OP40Current> getLatest10() {
        return op40CurrentMapper.getLatest10();
    }

    @Override
    public List<OP40Current> getOP40ListByDate(String date) {
        return op40CurrentMapper.getOP40ListByDate(date);
    }

    boolean isSame(OP40Current o1,OP40Current o2){
        if (o1.getStatus().equals(o2.getStatus())
                && o1.getWorkPiece().equals(o2.getWorkPiece())
                && o1.getOutput() == o2.getOutput()
                && o1.getRapidFeedRate() == o2.getRapidFeedRate()
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
