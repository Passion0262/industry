package com.example.industry.entity.Device;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class device {
    private int device_id;
    private String device_state;
    private String mode;
    private int feedrate;
    private int feedspeed;
    private int spindlerate;
    private int spindlespeed;
    private int producttion_line_id;
}

