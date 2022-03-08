package com.example.industry.service.impl;
import com.example.industry.dao.CutterMapper;
import com.example.industry.entity.Cutter.cutter;
import com.example.industry.service.cutterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class cutterServicelmpl implements cutterService {

    @Autowired
    CutterMapper cutterMappper;

    @Override
    public List<cutter> listCutter() {
        return cutterMappper.listCutter();
    }

    @Override
    public cutter getById(int cutterId) {return cutterMappper.getById(cutterId);}

    @Override
    public List<cutter> getByType(String cutterType) {return cutterMappper.getByType(cutterType);}

    @Override
    public List<cutter> getByCategory(String cutterCategory) {return cutterMappper.getByType(cutterCategory);}

    @Override
    public List<cutter> getByDeviceId(int deviceId) {return cutterMappper.getByDeviceId(deviceId);}

    @Override
    public List<cutter> getByLocation(int cutterLocation) {return cutterMappper.getByLocation(cutterLocation);}

    @Override
    public List<cutter> getByLifeState(String lifeState) {return cutterMappper.getByLifeState(lifeState);}

    @Override
    public boolean insertCutter(cutter cutter){return cutterMappper.insertCutter(cutter);}
}
