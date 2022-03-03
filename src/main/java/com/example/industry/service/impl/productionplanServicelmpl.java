package com.example.industry.service.impl;

import com.example.industry.dao.*;
import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.service.productionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class productionplanServicelmpl implements productionService{
    @Autowired
    productionplanMapper productionplanMapper;

    @Override
    public boolean insertproductionplan(productionplan Productionplan){return productionplanMapper.insertproductionplan(Productionplan);}

    @Override
    public boolean insertplan(productionplan Productionplan){return productionplanMapper.insertplan(Productionplan);}

    @Override
    public List<productionplan> getproplan(String planName, String modelType, Timestamp plannedstart, Timestamp plannedend, String state){return productionplanMapper.getproplan(planName,modelType,plannedstart,plannedend,state);}


}
