package com.example.industry.service.impl;

import com.example.industry.dao.TimeAnalysisMapper;
import com.example.industry.dao.device.OP40CurrentMapper;
import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.Warn.warn;
import com.example.industry.entity.vo.TimeAnalysisVO;
import com.example.industry.service.TimeAnalysisService;
import com.example.industry.service.OP40CurrentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TimeAnalysisServiceImpl implements TimeAnalysisService{

    @Autowired
    TimeAnalysisMapper timeAnalysisMapper;
    OP40CurrentMapper op40CurrentMapper;

    @Override
    public List<TimeAnalysis> listAll() {
        return timeAnalysisMapper.listAll();
    }

    @Override
    public List<TimeAnalysis> listByDevice(String deviceName) {
        return timeAnalysisMapper.listByDevice(deviceName);
    }

    @Override
    public List<TimeAnalysis> listByDate(String date){
        return timeAnalysisMapper.listByDate(date);
    }

    @Override
    public List<TimeAnalysis> listByDateRange(String start_date, String end_date){return timeAnalysisMapper.listByDateRange(start_date, end_date);}

//    @Override
//    public List<OP40Current> getOP40ListByDate(String date) {
//        return op40CurrentMapper.getOP40ListByDate(date);
//    }

    @Override
    public boolean insertStatusAnalysis(TimeAnalysis timeAnalysis){
        return timeAnalysisMapper.insertStatusAnalysis(timeAnalysis);
    }

    @Override
    public TimeAnalysis getLatest() {return timeAnalysisMapper.getLatest();}

}
