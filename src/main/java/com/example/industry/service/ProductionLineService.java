package com.example.industry.service;

import com.example.industry.entity.ProductionLine;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 14:15
 */
public interface ProductionLineService {

    /**
     *  获取所有生产线
     */
    List<ProductionLine> listLines();

    /**
     *  根据id查找生产线
     */
    ProductionLine getById(String id);

    /**
     *  根据name查找生产线
     */
    ProductionLine getByName(String name);

}
