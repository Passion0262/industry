package com.example.industry.entity.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class output {
    private int id;//编号
    private Date date; //日期
    private String shift;//班次
    private String device;//设备
    private int yield;//产量


}
