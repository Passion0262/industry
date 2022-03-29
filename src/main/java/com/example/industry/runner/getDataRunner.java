package com.example.industry.runner;


import com.example.industry.entity.Device.OP40Current;
import com.example.industry.entity.Device.OP50Current;
import com.example.industry.entity.Device.OP60Current;
import com.example.industry.entity.Device.OP70Current;
import com.example.industry.service.OP40CurrentService;
import com.example.industry.service.OP50CurrentService;
import com.example.industry.service.OP60CurrentService;
import com.example.industry.service.OP70CurrentService;
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
import java.util.Date;

@Component
@Slf4j
public class getDataRunner implements CommandLineRunner {
    public static final String OP40ID = "f7607140-edb7-4f2b-a6b3-65c1e97c8fbe";
    public static final String OP50ID = "8f12c017-c32f-4024-a3e1-5a35f986385a";
    public static final String OP60ID = "e8d89f4b-48ba-42b6-be37-e932b6904466";
    public static final String OP70ID = "b4fa2331-f058-4771-ac11-9f6125ccdca3";

    @Autowired
    OP40CurrentService op40CurrentService;

    @Autowired
    OP50CurrentService op50CurrentService;

    @Autowired
    OP60CurrentService op60CurrentService;

    @Autowired
    OP70CurrentService op70CurrentService;


    @Override
    public void run(String... args) throws Exception {
        log.info("这里处理项目加载一些系统参数、完成初始化、" +
                "预热本地缓存 from getDataRunner");
//        getData();
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
        log.info("op50: " +data);

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
}