package com.example.industry.service.impl;

import com.example.industry.dao.OutputMapper;
import com.example.industry.entity.Output.output;
import com.example.industry.service.outputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class outputServiceImpl implements outputService {
    @Autowired
    OutputMapper outputMapper;

    @Override
    public boolean insertoutput(output output){return outputMapper.insertoutput(output);}

    @Override
    public List<output> getyieldShift(String shift){return outputMapper.getyieldShift(shift);}

    @Override
    public List<output> getyieldDevice(String device){return outputMapper.getyieldDevice(device);}

    @Override
    public List<output> getyieldDate(Date date){return outputMapper.getyieldDate(date);}



}
