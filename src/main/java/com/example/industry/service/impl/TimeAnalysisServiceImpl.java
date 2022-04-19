package com.example.industry.service.impl;

import com.example.industry.dao.TimeAnalysisMapper;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.vo.TimeAnalysisVO;
import com.example.industry.service.TimeAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeAnalysisServiceImpl implements TimeAnalysisService{

    @Autowired
    TimeAnalysisMapper timeAnalysisMapper;

    @Override
    public List<TimeAnalysis> listAll() {
        return timeAnalysisMapper.listAll();
    }

    @Override
    public List<TimeAnalysis> listByDevice(String deviceName) {
        return timeAnalysisMapper.listByDevice(deviceName);
    }

    @Override
    public List<TimeAnalysisVO> listByDate(String date){
        List<TimeAnalysisVO> voArrayList = new ArrayList<TimeAnalysisVO>();
        List<TimeAnalysis> list = timeAnalysisMapper.listByDate(date);
        for (TimeAnalysis timeAnalysis : list) {
            TimeAnalysisVO vo = timeAnalysis.toVO();
            voArrayList.add(vo);
        }
        return voArrayList;
    }

}
