package com.example.industry.service.impl;

import com.example.industry.dao.ProductionLineMapper;
import com.example.industry.entity.ProductionLine;
import com.example.industry.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 14:17
 */
@Service
public class ProductionLineServiceImpl implements ProductionLineService {
    @Autowired
    ProductionLineMapper productionLineMapper;

    @Override
    public List<ProductionLine> listLines() {
        return productionLineMapper.listLines();
    }

    @Override
    public ProductionLine getById(String id) {
        return productionLineMapper.getById(id);
    }

    @Override
    public ProductionLine getByName(String name) {
        return productionLineMapper.getByName(name);
    }
}
