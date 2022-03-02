package com.example.industry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：shadow
 * @date ：Created in 2022/3/2 10:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionLine {

    private String id;      //生产线id

    private String pid;     //父节点id

    private String name;    //生产线名称

    private String externalId;

    private String drivername;

    private boolean enable;

}
