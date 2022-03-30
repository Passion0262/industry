package com.example.industry.service;

import com.example.industry.entity.Activation.Activation;

public interface ActivationService {

    //按日期查询所有设备的稼动率
    Activation getallActivation(String date);
}
