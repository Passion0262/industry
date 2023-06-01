package com.example.industry.service.impl;

import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.dao.device.OP50CurrentMapper;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.service.OP50CurrentService;
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
public class OP50CurrentServiceImpl implements OP50CurrentService {

    @Autowired
    OP50CurrentMapper op50CurrentMapper;

    @Override
    public List<OP50Current> listOP50Current() {
        return op50CurrentMapper.listOP50Current();
    }

    @Override
    public boolean insertOP50Current(OP50Current op50Current) {
    /*    OP50Current lasted = getLatest();
        //如果要新增的记录和最新的一条相同，则不添加
        if (isSame(lasted,op50Current)){
            return false;
        }else {
            return op50CurrentMapper.insertDeviceStatus(op50Current);
        }*/
        return op50CurrentMapper.insertDeviceStatus(op50Current);
    }

    @Override
    public OP50Current getLatest() {
        return op50CurrentMapper.getLatest();
    }

    @Override
    public Integer getOutput(){return op50CurrentMapper.getOutput();}

    @Override
    public List<OP50Current> getLatest10() {
        return op50CurrentMapper.getLatest10();
    }

    @Override
    public List<OP50Current> getOP50ListByDate(String date) {
        return op50CurrentMapper.getOP50ListByDate(date);
    }

    boolean isSame(OP50Current o1,OP50Current o2){
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
