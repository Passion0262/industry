package com.example.industry.entity.Cutter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cutter {
  private int cutterId;

  private int deviceId;

  private String cutterType;

  private String deviceName;

  private int cutterLocation;

  private String cutterState;

  private float cutterLength;

  private float cutterDiameter;

  private float wearCompensationLength;

  private float wearCompensationDiameter;

  private String lifeState;

  private String countingMode;

  private int initialLife;

  private int usedLife;

  private int residualLife;

  private int alarmValue;


}
