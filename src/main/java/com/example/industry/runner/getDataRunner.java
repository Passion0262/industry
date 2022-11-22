package com.example.industry.runner;


import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.entity.Device.MeasuringMachine;
import com.example.industry.entity.PLC.plc1;
import com.example.industry.entity.PLC.plc2;
import com.example.industry.service.OP40CurrentService;
import com.example.industry.service.OP50CurrentService;
import com.example.industry.service.OP60CurrentService;
import com.example.industry.service.OP70CurrentService;
import com.example.industry.service.MeasuringMachineService;
import com.example.industry.service.Plc1Service;
import com.example.industry.service.Plc2Service;
import com.example.industry.entity.Timeanalysis.TimeAnalysis;
import com.example.industry.entity.Timeanalysis.TimeAnalysisByDate;
import com.example.industry.service.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Component
@Slf4j
public class getDataRunner implements CommandLineRunner {
    public static final String OP40ID = "f7607140-edb7-4f2b-a6b3-65c1e97c8fbe";
    public static final String OP50ID = "8f12c017-c32f-4024-a3e1-5a35f986385a";
    public static final String OP60ID = "e8d89f4b-48ba-42b6-be37-e932b6904466";
    public static final String OP70ID = "b4fa2331-f058-4771-ac11-9f6125ccdca3";

    public static final String MeasuringMachineID = "0aab89b4-0eb0-44d6-a476-9bc22aa50dae";
    public static final String Plc1ID = "04265e86-37f7-4bef-b80c-5a6597598971";
    public static final String Plc2ID = "977546c6-5590-4327-8e41-d56c5195526b";
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


    @Override
    public void run(String... args) throws Exception {
        log.info("这里处理项目加载一些系统参数、完成初始化、" +
                "预热本地缓存 from getDataRunner");
        getData();
//        getTimeAnalysis("2022-03-28");
    }

    void getData() throws Exception {
        String url = "http://192.168.1.251:8099/WebApi/DataMonitor/GetDeviceAllVariable";
        //链接到目标地址
        Connection connect = Jsoup.connect(url);

        while (true) {

            getOP40(connect);

            getOP50(connect);

            Document document_op60 = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid", "e8d89f4b-48ba-42b6-be37-e932b6904466")
                    .post();
            Thread.sleep(10000);
            System.out.println(document_op60.text());
            getOP60(document_op60.text());

            Document document_op70 = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid", "b4fa2331-f058-4771-ac11-9f6125ccdca3")
                    .post();
            Thread.sleep(10000);
            System.out.println(document_op70.text());
            getOP70(document_op70.text());

            Document document_measuringMachine = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid", "0aab89b4-0eb0-44d6-a476-9bc22aa50dae")
                    .post();
            Thread.sleep(10000);
            System.out.println(document_measuringMachine.text());
            getMeasuringMachine(document_measuringMachine.text());

            Document document_plc1 = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid", "04265e86-37f7-4bef-b80c-5a6597598971")
                    .post();
            Thread.sleep(10000);
            System.out.println(document_plc1.text());
            getPlc1(document_plc1.text());

            Document document_plc2 = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid", "977546c6-5590-4327-8e41-d56c5195526b")
                    .post();
            Thread.sleep(10000);
            System.out.println(document_plc2.text());
            getPlc2(document_plc2.text());
        }
    }

    void getOP40(Connection connect) throws Exception {
        //设置useragent,设置超时时间，并以get请求方式请求服务器
        Document document_op40 = connect
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .timeout(30000)
                .ignoreContentType(true)
                .data("deviceid", getDataRunner.OP40ID)
                .post();
        Thread.sleep(10000);
        String data = document_op40.text();
        log.info(data);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "停机";
                break;
            case "2":
                status = "设定";
                break;
            case "3":
                status = "空闲";
                break;
            case "5":
                status = "运行";
                break;
            default:
                break;
        }
        String workPiece = node.path(1).path("value").textValue();
        int output = Integer.parseInt(node.path(2).path("value").textValue());
        int rapidFeedRate = Integer.parseInt(node.path(3).path("value").textValue());
        int spindleSpeed = Integer.parseInt(node.path(4).path("value").textValue());
        int feedRate = Integer.parseInt(node.path(5).path("value").textValue());
        int feedSpeed = Integer.parseInt(node.path(6).path("value").textValue());
        int alarmNumber = Integer.parseInt(node.path(7).path("value").textValue());
        String alarmInfo = node.path(8).path("value").textValue();
        OP40Current op40Current = new OP40Current(888, status, workPiece, output, rapidFeedRate, spindleSpeed, feedRate, feedSpeed, alarmNumber, alarmInfo, new Timestamp(new Date().getTime()));
        op40CurrentService.insertOP40Current(op40Current);
    }

    void getOP50(Connection connect) throws Exception {
        Document document_op50 = connect
                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .timeout(30000)
                .ignoreContentType(true)
                .data("deviceid", getDataRunner.OP50ID)
                .post();
        Thread.sleep(10000);
        String data = document_op50.text();
        log.info("op50: " + data);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "停机";
                break;
            case "2":
                status = "设定";
                break;
            case "3":
                status = "空闲";
                break;
            case "5":
                status = "运行";
                break;
            default:
                break;
        }
        String workPiece = node.path(1).path("value").textValue();
        int output = Integer.parseInt(node.path(2).path("value").textValue());
        int rapidFeedRate = Integer.parseInt(node.path(3).path("value").textValue());
        int spindleSpeed = Integer.parseInt(node.path(4).path("value").textValue());
        int feedRate = Integer.parseInt(node.path(5).path("value").textValue());
        int feedSpeed = Integer.parseInt(node.path(6).path("value").textValue());
        int alarmNumber = Integer.parseInt(node.path(7).path("value").textValue());
        String alarmInfo = node.path(8).path("value").textValue();
        OP50Current op50Current = new OP50Current(80, status, workPiece, output, rapidFeedRate, spindleSpeed, feedRate, feedSpeed, alarmNumber, alarmInfo, new Timestamp(new Date().getTime()));
        op50CurrentService.insertOP50Current(op50Current);

    }

    void getOP60(String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "停机";
                break;
            case "2":
                status = "设定";
                break;
            case "3":
                status = "空闲";
                break;
            case "5":
                status = "运行";
                break;
            default:
                break;
        }
        String programName = node.path(1).path("value").textValue();
        int output = Integer.parseInt(node.path(2).path("value").textValue());
        int spindleRate = Integer.parseInt(node.path(3).path("value").textValue());
        int spindleSpeed = Integer.parseInt(node.path(4).path("value").textValue());
        int feedRate = Integer.parseInt(node.path(5).path("value").textValue());
        int feedSpeed = Integer.parseInt(node.path(6).path("value").textValue());
        int alarmNumber = Integer.parseInt(node.path(7).path("value").textValue());
        String alarmInfo = node.path(8).path("value").textValue();
        OP60Current op60Current = new OP60Current(80, status, programName, output, spindleRate, spindleSpeed, feedRate, feedSpeed, alarmNumber, alarmInfo, new Timestamp(new Date().getTime()));
        op60CurrentService.insertOP60Current(op60Current);

    }

    void getOP70(String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "停机";
                break;
            case "2":
                status = "设定";
                break;
            case "3":
                status = "空闲";
                break;
            case "5":
                status = "运行";
                break;


            default:
                break;
        }
        String programName = node.path(1).path("value").textValue();
        int output = Integer.parseInt(node.path(2).path("value").textValue());
        int spindleRate = Integer.parseInt(node.path(3).path("value").textValue());
        int spindleSpeed = Integer.parseInt(node.path(4).path("value").textValue());
        int feedRate = Integer.parseInt(node.path(5).path("value").textValue());
        int feedSpeed = Integer.parseInt(node.path(6).path("value").textValue());
        int alarmNumber = Integer.parseInt(node.path(7).path("value").textValue());
        String alarmInfo = node.path(8).path("value").textValue();
        OP70Current op70Current = new OP70Current(80, status, programName, output, spindleRate, spindleSpeed, feedRate, feedSpeed, alarmNumber, alarmInfo, new Timestamp(new Date().getTime()));
        op70CurrentService.insertOP70Current(op70Current);
    }

    void getMeasuringMachine(String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "Stop";
                break;
            case "2":
                status = "Run";
                break;
            case "3":
                status = "Free";
                break;
            case "5":
                status = "Offline";
                break;
            default:
                break;
        }
        String workpieceCode = node.path(1).path("value").textValue();
        String workpieceType = node.path(2).path("value").textValue();
        String measuredValue1 = node.path(3).path("value").textValue();
        String measuredValue2 = node.path(4).path("value").textValue();
        String measuredValue3 = node.path(5).path("value").textValue();
        String measuredValue4 = node.path(6).path("value").textValue();
        String measuredResults = node.path(7).path("value").textValue();

        MeasuringMachine measuringMachine = new MeasuringMachine(0,new Timestamp(new Date().getTime()),status,workpieceCode,workpieceType,measuredValue1,measuredValue2,measuredValue3,measuredValue4,measuredResults);
        measuringMachineService.insertMeasuringMachineCurrent(measuringMachine);
    }

    void getPlc1(String data) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value){
            case "1":
                status = "Stop";
                break;
            case "2":
                status = "Run";
                break;
            case "3":
                status = "Offline";
                break;
            case "5":
                status = "Debug";
                break;
            default:
                break;
        }
        String PLCType = node.path(1).path("value").textValue();
        String fortyFeedingRequest = node.path(2).path("value").textValue();
        String fortyCuttingRequest = node.path(3).path("value").textValue();
        String fortyOnPosition = node.path(4).path("value").textValue();
        String fortyFeedingDone = node.path(5).path("value").textValue();
        String fortyCuttingDone = node.path(6).path("value").textValue();
        String fortyForward = node.path(7).path("value").textValue();
        String fortyReverse= node.path(8).path("value").textValue();
        String fiftyFeedingRequest = node.path(9).path("value").textValue();
        String fiftyCuttingRequest = node.path(10).path("value").textValue();
        String fiftyOnPosition = node.path(11).path("value").textValue();
        String fiftyFeedingDone = node.path(12).path("value").textValue();
        String fiftyCuttingDone = node.path(13).path("value").textValue();
        String fiftyForward = node.path(14).path("value").textValue();
        String fiftyReverse = node.path(15).path("value").textValue();
        String feedingLocation1XN = node.path(16).path("value").textValue();
        String feedingLocation2XN = node.path(17).path("value").textValue();
        String OP40LocationXN = node.path(18).path("value").textValue();
        String markingMachineLocationXN = node.path(19).path("value").textValue();
        String markingMachineLocationZS = node.path(20).path("value").textValue();
        String OP50LocationZS = node.path(21).path("value").textValue();
        String measuringMachineLocationZS = node.path(22).path("value").textValue();
        String NGZSCode = node.path(23).path("value").textValue();
        String productionlineState = node.path(24).path("value").textValue();
        String planNumber = node.path(25).path("value").textValue();
        String planAmount = node.path(26).path("value").textValue();
        String productionNumber = node.path(27).path("value").textValue();
        String feedingLocation1ZS = node.path(32).path("value").textValue();
        String feedingLocation2ZS = node.path(33).path("value").textValue();
        String OP40LocationZS = node.path(34).path("value").textValue();
        String measuringMachineLocationXN = node.path(35).path("value").textValue();
        String OP50LocationXN = node.path(36).path("value").textValue();
        String MarkingCode = node.path(37).path("value").textValue();

        plc1 plc1 = new plc1(6948,new Timestamp(new Date().getTime()),status,PLCType,fortyFeedingRequest,fortyCuttingRequest,fortyOnPosition,
                fortyFeedingDone,fortyCuttingDone,fortyForward,fortyReverse,fiftyFeedingRequest,fiftyCuttingRequest,fiftyOnPosition,fiftyFeedingDone,
                fiftyCuttingDone,fiftyForward,fiftyReverse,feedingLocation1XN,feedingLocation2XN,OP40LocationXN,markingMachineLocationXN,
                markingMachineLocationZS,OP50LocationZS,measuringMachineLocationZS,NGZSCode,productionlineState,planNumber,planAmount,productionNumber,
                feedingLocation1ZS,feedingLocation2ZS,OP40LocationZS,measuringMachineLocationXN,OP50LocationXN,MarkingCode);
        plc1Service.insertPlc1Current(plc1);

    }

    void getPlc2(String data) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value) {
            case "1":
                status = "Stop";
                break;
            case "2":
                status = "Run";
                break;
            case "3":
                status = "Offline";
                break;
            case "5":
                status = "Debug";
                break;
            default:
                break;
        }
        String PLCType = node.path(1).path("value").textValue();
        String sixtyFeedingRequest = node.path(2).path("value").textValue();
        String sixtyCuttingRequest = node.path(3).path("value").textValue();
        String sixtyOnPosition = node.path(4).path("value").textValue();
        String sixtyFeedingDone = node.path(5).path("value").textValue();
        String sixtyCuttingDone = node.path(6).path("value").textValue();
        String sixtyForward = node.path(7).path("value").textValue();
        String sixtyReverse = node.path(8).path("value").textValue();
        String seventyFeedingRequest = node.path(9).path("value").textValue();
        String seventyCuttingRequest = node.path(10).path("value").textValue();
        String seventyOnPosition = node.path(11).path("value").textValue();
        String seventyFeedingDone = node.path(12).path("value").textValue();
        String seventyCuttingDone = node.path(13).path("value").textValue();
        String seventyForward = node.path(14).path("value").textValue();
        String seventyReverse = node.path(15).path("value").textValue();
        String OP60LocationZS = node.path(16).path("value").textValue();
        String OP70LocationZS = node.path(17).path("value").textValue();
        String OKZSCode = node.path(18).path("value").textValue();
        String OKZSCode1 = node.path(19).path("value").textValue();
        String NGZSCode = node.path(20).path("value").textValue();
        String OP60LocationXN = node.path(21).path("value").textValue();
        String OP70LocationXN = node.path(22).path("value").textValue();
        String MarkingCode = node.path(23).path("value").textValue();
        String productionlineState = node.path(24).path("value").textValue();
        String planNumber = node.path(25).path("value").textValue();
        String planAmount = node.path(26).path("value").textValue();
        String productionNumber = node.path(27).path("value").textValue();
        String feedingLocation1ZS = node.path(32).path("value").textValue();
        String feedingLocation2ZS = node.path(33).path("value").textValue();
        String markingMachineLocationZS = node.path(34).path("value").textValue();
        String measuringMachineLocationZS = node.path(35).path("value").textValue();
        String measuringMachineLocationXN = node.path(36).path("value").textValue();
        String feedingLocation1XN = node.path(37).path("value").textValue();
        String feedingLocation2XN = node.path(38).path("value").textValue();
        String markingMachineLocationXN = node.path(39).path("value").textValue();
        plc2 plc2 =(new plc2(0,new Timestamp(new Date().getTime()),status,PLCType,sixtyFeedingRequest,sixtyCuttingRequest,sixtyOnPosition,
        sixtyFeedingDone,sixtyCuttingDone,sixtyForward,sixtyReverse,seventyFeedingRequest,seventyCuttingRequest,seventyOnPosition,seventyFeedingDone,
                seventyCuttingDone,seventyForward,seventyReverse,OP60LocationZS,OP70LocationZS,OKZSCode,OKZSCode1,NGZSCode,OP60LocationXN,OP70LocationXN,
                MarkingCode,productionlineState,planNumber,planAmount,productionNumber,feedingLocation1ZS,feedingLocation2ZS,markingMachineLocationZS,measuringMachineLocationZS,
                measuringMachineLocationXN,feedingLocation1XN,feedingLocation2XN,markingMachineLocationXN));
        plc2Service.insertPlc2Current(plc2);
    }

//    //统计日期date当天所有设备用时分析
//    void getTimeAnalysis(String date) throws Exception {
//        //        设定定时器,每天凌晨更新前一天各设备状态用时占比
//        //        读取设备信息
//        //        时间数据类型转换,并在末尾添加一条零点记录
//        //        String date = "2022-03-28";
//
//        //        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        //        Date date2 = sdf.parse(date1);
//        String[] device = {"OP40-车床","OP50-车床","OP60-立加","OP70-立加","测量机","总控PLC-1","总控PLC-2"};
//        String date1 = date + " 23:59:59";
//        String date2 = date + " 00:00:00";
//        Timestamp DateEnd = Timestamp.valueOf(date1);
//        Timestamp DateStart = Timestamp.valueOf(date2);
//
//        List<OP40Current> op40data = op40CurrentService.getOP40ListByDate(date);
//        List<OP50Current> op50data = op50CurrentService.getOP50ListByDate(date);
//        List<OP60Current> op60data = op60CurrentService.getOP60ListByDate(date);
//        List<OP70Current> op70data = op70CurrentService.getOP70ListByDate(date);
////        List<MeasuringMachine> measuringMachinesData = measuringMachineService.getMeasuringMachineListByDate(date);
////        List<PLC1> PLC1data = plc1Service.getPLC1ListByDate(date);
////        List<PLC2> PLC2data = plc2Service.getPLC2ListByDate(date);
//
////      若查询的日期无设备数据，默认离线
//        OP40Current op40temp;
//        if (op40data.size()==0){op40temp = new OP40Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, DateEnd);
//        }else{op40temp = op40data.get(op40data.size() - 1);op40temp.setId(op40temp.getId()+1);op40temp.setTime(DateEnd);}
//        op40data.add(op40temp);
//        OP50Current op50temp;
//        if (op50data.size()==0){op50temp = new OP50Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, DateEnd);
//        }else{op50temp = op50data.get(op50data.size() - 1);op50temp.setId(op50temp.getId()+1);op50temp.setTime(DateEnd);}
//        op50data.add(op50temp);
//        OP60Current op60temp;
//        if (op60data.size()==0){op60temp = new OP60Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, DateEnd);
//        }else{op60temp = op60data.get(op60data.size() - 1);op60temp.setId(op60temp.getId()+1);op60temp.setTime(DateEnd);}
//        op60data.add(op60temp);
//        OP70Current op70temp;
//        if (op70data.size()==0){op70temp = new OP70Current(1, "离线", null, 0, 0, 0, 0, 0, 0, null, DateEnd);
//        }else{op70temp = op70data.get(op70data.size() - 1);op70temp.setId(op70temp.getId()+1);op70temp.setTime(DateEnd);}
//        op70data.add(op70temp);
//
////        System.out.println(op60temp);
////        System.out.println(op70temp);
//
//        List<TimeAnalysisByDate> timeAnalysisByDate1 = new LinkedList<>();
//        for( OP40Current o1 : op40data){
//            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(),o1.getTime(),device[0],o1.getStatus());
//            timeAnalysisByDate1.add(timeAnalysisByDateTemp);
//        }
//        getDeviceTimeAnalysis(timeAnalysisByDate1,DateStart,date,device[0]);
//
//        List<TimeAnalysisByDate> timeAnalysisByDate2 = new LinkedList<>();
//        for( OP50Current o1 : op50data){
//            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(),o1.getTime(),device[0],o1.getStatus());
//            timeAnalysisByDate2.add(timeAnalysisByDateTemp);
//        }
//        getDeviceTimeAnalysis(timeAnalysisByDate2,DateStart,date,device[1]);
//
//        List<TimeAnalysisByDate> timeAnalysisByDate3 = new LinkedList<>();
//        for( OP60Current o1 : op60data){
//            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(),o1.getTime(),device[0],o1.getStatus());
//            timeAnalysisByDate3.add(timeAnalysisByDateTemp);
//        }
//        getDeviceTimeAnalysis(timeAnalysisByDate3,DateStart,date,device[2]);
//
//        List<TimeAnalysisByDate> timeAnalysisByDate4 = new LinkedList<>();
//        for( OP70Current o1 : op70data){
//            TimeAnalysisByDate timeAnalysisByDateTemp = new TimeAnalysisByDate(o1.getId(),o1.getTime(),device[0],o1.getStatus());
//            timeAnalysisByDate4.add(timeAnalysisByDateTemp);
//        }
//        getDeviceTimeAnalysis(timeAnalysisByDate4,DateStart,date,device[3]);
//
//    }
//
//    //计算时间戳差值
//    public static int getTimeDifference(Timestamp formatTime1, Timestamp formatTime2) {
//        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
//        long t1 = formatTime1.getTime();
//        long t2 = formatTime2.getTime();
////        int hours=(int) ((t1 - t2)/(1000*60*60));
////        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
////        int second=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);
////        return ""+hours+"小时"+minutes+"分"+second+"秒";
//        return (int) (t1 - t2)/1000;
//    }
//    //计算百分比
//    public String percent(int x, int y) {
//        String percent = "";
//        double xx = x * 100.0;
//        double yy = y * 100.0;
//        double zz = xx / yy;
//        DecimalFormat df = new DecimalFormat("##.00%");
//        if(Math.abs(zz)<0.000000000001){
//            percent = "0.00%";
//        } else {
//            percent = df.format(zz);
//        }
//        return percent;
//    }
//
//    //统计具体某个设备的状态用时分布
//    void getDeviceTimeAnalysis(List<TimeAnalysisByDate> timeAnalysisByDate,Timestamp DateStart,String date,String device){
//        int stopTime = 0;
//        int operateTime = 0;
//        int freeTime = 0;
//        int offlineTime = 0;
//        int settingTime = 0;
//
//        for (TimeAnalysisByDate v1 : timeAnalysisByDate){
//            if("设定".equals(v1.getStatus())){
//                settingTime += getTimeDifference(v1.getTime(),DateStart);
//                DateStart = v1.getTime();
//            }else if ("运行".equals(v1.getStatus())){
//                operateTime += getTimeDifference(v1.getTime(),DateStart);
//                DateStart = v1.getTime();
//            }else if ("停机".equals(v1.getStatus())){
//                stopTime += getTimeDifference(v1.getTime(),DateStart);
//                DateStart = v1.getTime();
//            }else if ("空闲".equals(v1.getStatus())){
//                freeTime += getTimeDifference(v1.getTime(),DateStart);
//                DateStart = v1.getTime();
//            }else {
//                //其他状态均视为离线
//                offlineTime += getTimeDifference(v1.getTime(),DateStart);
//                DateStart = v1.getTime();
//            }
//        }
//
//        String stop = percent(stopTime,86400);
//        String operate = percent(operateTime,86400);
//        String free = percent(freeTime,86400);
//        String offline = percent(offlineTime,86400);
//        String setting = percent(settingTime,86400);
//        String[] res = {stop,operate,free,offline,setting};
//        TimeAnalysis timeAnalysis1 = new TimeAnalysis(88,date,device,stop,operate,free,offline,setting);
//        System.out.println(timeAnalysis1);
//        timeAnalysisService.insertStatusAnalysis(timeAnalysis1);
////        return ;
//    }
}