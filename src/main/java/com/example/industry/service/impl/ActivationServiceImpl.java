package com.example.industry.service.impl;

import com.example.industry.dao.ActivationMapper;
import com.example.industry.entity.Activation.Activation;
import com.example.industry.service.ActivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivationServiceImpl implements ActivationService {
    @Autowired
    ActivationMapper activationMapper;

    @Override
    public Activation getallActivation(String date){return activationMapper.getallActivation(date);}
}
