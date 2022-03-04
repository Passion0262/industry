package com.example.industry.service;
import com.example.industry.entity.Cutter.cutter;
import java.util.List;
public interface cutterService {

    /**
     * 查询所有刀具信息
     */
    List<cutter> listCutter();

    /**
     * 根据id查找刀具
     */
    cutter getById(int cutterId);

    /**
     * 根据刀具型号查找刀具
     */
    List<cutter> getByType(String cutterType);

    /**
     * 根据刀具类型查找刀具
     */
    List<cutter> getByCategory(String cutterCategory);

    /**
     * 根据设备编号查找刀具
     */
    List<cutter> getByDeviceId(int deviceId);

    /**
     * 根据刀具刀位查找刀具
     */
    List<cutter> getByLocation(int cutterLocation);

    /**
     * 根据寿命状态查找刀具
     */
    List<cutter> getByLifeState(String lifeState);

}
