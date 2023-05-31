package com.example.industry.runner;

import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.PLC.plc1;
import com.example.industry.entity.PLC.plc2;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.Timeanalysis.TimeAnalysisByDate;
import com.example.industry.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Component
@EnableScheduling
public class timeAnalysisRunner {
    @Autowired
    OP40CurrentService op40CurrentService;

    @Autowired
    OP50CurrentService op50CurrentService;

    @Autowired
    OP60CurrentService op60CurrentService;

    @Autowired
    OP70CurrentService op70CurrentService;

    @Autowired
    MeasuringMachineService measuringMachineService;

    @Autowired
    Plc1Service plc1Service;

    @Autowired
    Plc2Service plc2Service;

    @Autowired
    TimeAnalysisService timeAnalysisService;

    //        每五秒执行一次
    //        设定定时器,每天凌晨更新前一天各设备状态用时占比
//    @Scheduled(cron = "0/5 * * * * ?")
    @Scheduled(cron = "0 0 1 * * ?")
    public void TaskJob() throws Exception {
        System.out.println("test second annotation style ...");
        //        设定定时器,每天凌晨更新前一天各设备状态用时占比
        //        读取设备信息进行用时分析并将结果存入数据库中
//        String date = "2022-03-28";
        LocalDate date = LocalDate.now().minusDays(1);
        System.out.println(date.toString());
        getTimeAnalysis(date.toString());

    }

    //统计日期date当天所有设备用时分析
    void getTimeAnalysis(String date) throws Exception {
        //        设定定时器,每天凌晨更新前一天各设备状态用时占比
        //        读取设备信息
        //        时间数据类型转换,并在末尾添加一条零点记录
        //        String date = "2022-03-28";

        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //        Date date2 = sdf.parse(date1);
        String[] device = {"OP40-车床", "OP50-车床", "OP60-立加", "OP70-立加", "测量机", "总控PLC-1", "总控PLC-2"};
        String date1 = date + " 00:00:00";
        String date2 = date + " 23:59:59";
        Timestamp DateEnd = Timestamp.valueOf(date1);
        Timestamp DateStart = Timestamp.valueOf(date2);

        List<OP40Current> op40data = op40CurrentService.getOP40ListByDate(date);
        List<OP50Current> op50data = op50CurrentService.getOP50ListByDate(date);
        List<OP60Current> op60data = op60CurrentService.getOP60ListByDate(date);
        List<OP70Current> op70data = op70CurrentService.getOP70ListByDate(date);
        List<MeasuringMachine> measuringMachineData = measuringMachineService.getMeasuringMachineListByDate(date);
        List<plc1> plc1Data = plc1Service.getPlc1ListByDate(date);
        List<plc2> plc2Data = plc2Service.getPlc2ListByDate(date);

//        添加一条零点数据用于计算时间戳
        device_data(DateEnd, op40data, op50data, op60data, op70data, measuringMachineData, plc1Data, plc2Data);

//        将设备数据提取为TimeAnalysisByDate类数据
        List<TimeAnalysisByDate> timeAnalysisByDate0 = new LinkedList<>();
        for (OP40Current o1 : op40data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getTime(), device[0], o1.getStatus());
            timeAnalysisByDate0.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate0, DateStart, date, device[0]);

        List<TimeAnalysisByDate> timeAnalysisByDate1 = new LinkedList<>();
        for (OP50Current o1 : op50data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getTime(), device[1], o1.getStatus());
            timeAnalysisByDate1.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate1, DateStart, date, device[1]);

        List<TimeAnalysisByDate> timeAnalysisByDate2 = new LinkedList<>();
        for (OP60Current o1 : op60data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getTime(), device[2], o1.getStatus());
            timeAnalysisByDate2.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate2, DateStart, date, device[2]);

        List<TimeAnalysisByDate> timeAnalysisByDate3 = new LinkedList<>();
        for (OP70Current o1 : op70data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getTime(), device[3], o1.getStatus());
            timeAnalysisByDate3.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate3, DateStart, date, device[3]);

        List<TimeAnalysisByDate> timeAnalysisByDate4 = new LinkedList<>();
        for (MeasuringMachine o1 : measuringMachineData) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getAcquisitionTime(), device[4], o1.getStatus());
            timeAnalysisByDate4.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate4, DateStart, date, device[4]);

        List<TimeAnalysisByDate> timeAnalysisByDate5 = new LinkedList<>();
        for (plc1 o1 : plc1Data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getAcquisitionTime(), device[5], o1.getStatus());
            timeAnalysisByDate5.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate5, DateStart, date, device[5]);

        List<TimeAnalysisByDate> timeAnalysisByDate6 = new LinkedList<>();
        for (plc2 o1 : plc2Data) {
            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(), o1.getAcquisitionTime(), device[0], o1.getStatus());
            timeAnalysisByDate0.add(timeAnalysisByDateTemp);
        }
        getDeviceTimeAnalysis(timeAnalysisByDate6, DateStart, date, device[6]);

    }

    static void device_data(Timestamp dateEnd, List<OP40Current> op40data, List<OP50Current> op50data, List<OP60Current> op60data, List<OP70Current> op70data, List<MeasuringMachine> measuringMachineData, List<plc1> plc1Data, List<plc2> plc2Data) {
        //      若查询的日期无设备数据，默认离线
        OP40Current op40temp;
        if (op40data.size() == 0) {
            op40temp = new OP40Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, dateEnd);
        } else {
            op40temp = op40data.get(op40data.size() - 1);
            op40temp.setId(op40temp.getId() + 1);
            op40temp.setTime(dateEnd);
        }
        op40data.add(op40temp);

        OP50Current op50temp;
        if (op50data.size() == 0) {
            op50temp = new OP50Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, dateEnd);
        } else {
            op50temp = op50data.get(op50data.size() - 1);
            op50temp.setId(op50temp.getId() + 1);
            op50temp.setTime(dateEnd);
        }
        op50data.add(op50temp);

        OP60Current op60temp;
        if (op60data.size() == 0) {
            op60temp = new OP60Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, dateEnd);
        } else {
            op60temp = op60data.get(op60data.size() - 1);
            op60temp.setId(op60temp.getId() + 1);
            op60temp.setTime(dateEnd);
        }
        op60data.add(op60temp);

        OP70Current op70temp;
        if (op70data.size() == 0) {
            op70temp = new OP70Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, dateEnd);
        } else {
            op70temp = op70data.get(op70data.size() - 1);
            op70temp.setId(op70temp.getId() + 1);
            op70temp.setTime(dateEnd);
        }
        op70data.add(op70temp);

        MeasuringMachine measuringMachineTemp;
        if (measuringMachineData.size() == 0) {
            measuringMachineTemp = new MeasuringMachine(1, dateEnd, "offline", null, null, null, null, null, null, null);
        } else {
            measuringMachineTemp = measuringMachineData.get(op70data.size() - 1);
            measuringMachineTemp.setId(measuringMachineTemp.getId() + 1);
            measuringMachineTemp.setAcquisitionTime(dateEnd);
        }
        measuringMachineData.add(measuringMachineTemp);

        plc1 plc1temp;
        if (plc1Data.size() == 0) {
            plc1temp = new plc1(1, dateEnd, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        } else {
            plc1temp = plc1Data.get(plc1Data.size() - 1);
            plc1temp.setId(plc1temp.getId() + 1);
            plc1temp.setAcquisitionTime(dateEnd);
        }
        plc1Data.add(plc1temp);

        plc2 plc2temp;
        if (plc2Data.size() == 0) {
            plc2temp = new plc2(1, dateEnd, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
        } else {
            plc2temp = plc2Data.get(plc2Data.size() - 1);
            plc2temp.setId(plc2temp.getId() + 1);
            plc2temp.setAcquisitionTime(dateEnd);
        }
        plc2Data.add(plc2temp);
    }

    //计算时间戳差值
    public static int getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
        long t1 = formatTime1.getTime();
        long t2 = formatTime2.getTime();
//        int hours=(int) ((t1 - t2)/(1000*60*60));
//        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
//        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
//        return ""+hours+"小时"+minutes+"分"+second+"秒";
        return (int) (t1 - t2) / 1000;
    }

    //计算百分比
    public String percent(int x, int y) {
        String percent = "";
        double xx = x * 100.0;
        double yy = y * 100.0;
        double zz = xx / yy;
        DecimalFormat df = new DecimalFormat("##.00%");
        if (Math.abs(zz) < 0.000000000001) {
            percent = "0.00%";
        } else {
            percent = df.format(zz);
        }
        return percent;
    }

    //统计具体某个设备的状态用时分布
    void getDeviceTimeAnalysis(List<TimeAnalysisByDate> timeAnalysisByDate, Timestamp DateStart, String date, String device) {
        int stopTime = 0;
        int operateTime = 0;
        int freeTime = 0;
        int offlineTime = 0;
        int settingTime = 0;

        for (TimeAnalysisByDate v1 : timeAnalysisByDate) {
            if ("设定".equals(v1.getStatus())) {
                settingTime += getTimeDifference(v1.getTime(), DateStart);
                DateStart = v1.getTime();
            } else if ("运行".equals(v1.getStatus())) {
                operateTime += getTimeDifference(v1.getTime(), DateStart);
                DateStart = v1.getTime();
            } else if ("停机".equals(v1.getStatus())) {
                stopTime += getTimeDifference(v1.getTime(), DateStart);
                DateStart = v1.getTime();
            } else if ("空闲".equals(v1.getStatus())) {
                freeTime += getTimeDifference(v1.getTime(), DateStart);
                DateStart = v1.getTime();
            } else {
                //其他状态均视为离线
                offlineTime += getTimeDifference(v1.getTime(), DateStart);
                DateStart = v1.getTime();
            }
        }

        String stop = percent(stopTime, 86400);
        String operate = percent(operateTime, 86400);
        String free = percent(freeTime, 86400);
        String offline = percent(offlineTime, 86400);
        String setting = percent(settingTime, 86400);
        String[] res = {stop, operate, free, offline, setting};
        TimeAnalysis timeAnalysis1 = new TimeAnalysis(88, date, device, stop, operate, free, offline, setting);
        System.out.println(timeAnalysis1);
        timeAnalysisService.insertStatusAnalysis(timeAnalysis1);
//        return ;
    }
}
