package com.example.industry.runner;


import com.example.industry.entity.Device.DeviceStatus;
import com.example.industry.service.DeviceStatusService;
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

    @Autowired
    DeviceStatusService deviceStatusService;

    @Override
    public void run(String... args) throws Exception {
        log.info("这里处理项目加载一些系统参数、完成初始化、" +
                "预热本地缓存 from getDataRunner");
//        getData();
    }

    void getData() throws Exception{
        String url = "http://192.168.1.251:8099/WebApi/DataMonitor/GetDeviceAllVariable";
        //链接到目标地址
        Connection connect = Jsoup.connect(url);

        while (true) {
            //设置useragent,设置超时时间，并以get请求方式请求服务器
            Document document = connect
                    .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                    .timeout(30000)
                    .ignoreContentType(true)
                    .data("deviceid","f7607140-edb7-4f2b-a6b3-65c1e97c8fbe")
                    .post();
            Thread.sleep(10000);
            System.out.println(document.text());
            toSql(document.text());
        }
    }

    void toSql(String data) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(data);
        JsonNode node = rootNode.path("data");
        System.out.println(node);
        String value = node.path(0).path("value").textValue();
        System.out.println(value);
        String status = "";
        switch (value){
            case "1":
                status = "停机";
                break;
            case "2":
                status = "设定";
                break;
            case"3":
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
        DeviceStatus deviceStatus = new DeviceStatus(0,status,workPiece,output,rapidFeedRate,spindleSpeed,feedRate,feedSpeed,alarmNumber,alarmInfo,new Timestamp(new Date().getTime()));
        deviceStatusService.insertDeviceStatus(deviceStatus);
    }
}