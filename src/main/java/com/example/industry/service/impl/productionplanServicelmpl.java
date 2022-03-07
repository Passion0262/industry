package com.example.industry.service.impl;

import com.example.industry.dao.*;
import com.example.industry.entity.Productionplan.productionplan;
import com.example.industry.service.productionplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class productionplanServicelmpl implements productionplanService {
    @Autowired
    productionplanMapper productionplanMapper;

    @Override
    public boolean insertproductionplan(productionplan Productionplan){return productionplanMapper.insertproductionplan(Productionplan);}

    @Override
    public boolean insertplan(productionplan Productionplan){return productionplanMapper.insertplan(Productionplan);}

    @Override
    public List<productionplan> getproplan(String planName, int modelType, Timestamp plannedstart, Timestamp plannedend, String state){return productionplanMapper.getproplan(planName,modelType,plannedstart,plannedend,state);}

    @Override
    public boolean deleteplan(int planNumber){return productionplanMapper.deleteplan(planNumber);}


}
