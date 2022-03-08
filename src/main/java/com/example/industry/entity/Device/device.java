package com.example.industry.entity.Device;

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
public class Device {

    private String id;      //设备id

    private String pid;     //父节点id

    private String name;    //设备名称

    private String externalId;

    private String drivername;

    private boolean enable;

}
