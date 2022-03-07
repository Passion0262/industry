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

    @Override
    public String getplanoperation(int planNumber){return productionplanMapper.getplanoperation(planNumber);}

    @Override
    public String getplanname(int planNumber){return productionplanMapper.getplanname(planNumber);}

    @Override
    public String getplanstate(int planNumber){return productionplanMapper.getplanstate(planNumber);}

    @Override
    public String getplandevicegroup(int planNumber){return productionplanMapper.getplandevicegroup(planNumber);}

    @Override
    public int getplanyield(int planNumber){return productionplanMapper.getplanyield(planNumber);}

    @Override
    public int getqualifiedyield(int planNumber){return productionplanMapper.getqualifiedyield(planNumber);}

    @Override
    public int getdisqualifiedyield(int planNumber){return productionplanMapper.getdisqualifiedyield(planNumber);}


    @Override
    public String getplandetails(int planNumber){return productionplanMapper.getplandetails(planNumber);}

    @Override
    public int getplanmodeltype(int planNumber){return productionplanMapper.getplanmodeltype(planNumber);}

    @Override
    public Timestamp getplannedstart(int planNumber){return productionplanMapper.getplannedstart(planNumber);}

    @Override
    public Timestamp getplannedend(int planNumber){return productionplanMapper.getplannnedend(planNumber);}

    @Override
    public Timestamp getactualstart(int planNumber){return productionplanMapper.getactualstart(planNumber);}

    @Override
    public Timestamp getactualend(int planNumber){return productionplanMapper.getactualend(planNumber);}



}
