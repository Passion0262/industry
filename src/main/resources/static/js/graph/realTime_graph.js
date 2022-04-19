$('#OP40').ready(setInterval(OP40,1000)); //当对应标签加载好时会每隔1秒调用graph方法
$('#OP50').ready(setInterval(OP50,1000)); //当对应标签加载好时会每隔1秒调用graph方法
$('#OP60').ready(setInterval(OP60,1000)); //当对应标签加载好时会每隔1秒调用graph方法
$('#OP70').ready(setInterval(OP70,1000)); //当对应标签加载好时会每隔1秒调用graph方法

function OP40(){
    var chartDom = document.getElementById('OP40');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var time = [];
    var output = [];
    var rapid_feed_rate = [];
    var spindle_speed = [];
    var feed_rate = [];
    var feed_speed = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OP40",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                time.push(result[i].time.substring(11, 19));
                output.push(Math.cbrt(result[i].output));
                rapid_feed_rate.push(Math.cbrt(result[i].rapidFeedRate));
                spindle_speed.push(Math.cbrt(result[i].spindleSpeed));
                feed_rate.push(Math.cbrt(result[i].feedRate));
                feed_speed.push(Math.cbrt(result[i].feedSpeed));
            }
        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: 'OP40数据'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function(params, ticket, callback) {
                // console.log(params[0])
                let str = params[0].axisValue + "<br />";
                params.forEach((item) => {
                    str +=
                        '<div class="clearfix"><span class="fl" style="display:inline-block;margin-top:6px;margin-right:5px;border-radius:50%;width:10px;height:10px;left:5px;background-color:'+item.color+'"></span><span class="fl">' + item.seriesName + '</span> : <span class="fr">' + (item.data == null? "-": (item.data*item.data*item.data).toFixed(0)) + '</span></div>';
                });
                return str;
            }
        },
        legend: {
            data: ['output', 'rapid_feed_rate', 'spindle_speed', 'feed_rate', 'feed_speed']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: time
        },
        yAxis: {
            type: 'value',
            scale: 'true',
            axisLabel: {
                formatter:function(value){
                    return value*value*value
                }
            }
        },
        series: [
            {
                name: 'spindle_speed',
                type: 'line',
                data: spindle_speed,
                smooth: true
            },
            {
                name: 'rapid_feed_rate',
                type: 'line',
                data: rapid_feed_rate,
                smooth: true
            },
            {
                name: 'feed_speed',
                type: 'line',
                data: feed_speed,
                smooth: true
            },
            {
                name: 'feed_rate',
                type: 'line',
                data: feed_rate,
                smooth: true
            },
            {
                name: 'output',
                type: 'line',
                data: output,
                smooth: true
            }
        ]
    };


    myChart.setOption(option);
}

function OP50(){
    var chartDom = document.getElementById('OP50');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var time = [];
    var output = [];
    var rapid_feed_rate = [];
    var spindle_speed = [];
    var feed_rate = [];
    var feed_speed = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OP50",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                time.push(result[i].time.substring(11, 19));
                output.push(Math.cbrt(result[i].output));
                rapid_feed_rate.push(Math.cbrt(result[i].rapidFeedRate));
                spindle_speed.push(Math.cbrt(result[i].spindleSpeed));
                feed_rate.push(Math.cbrt(result[i].feedRate));
                feed_speed.push(Math.cbrt(result[i].feedSpeed));
            }
        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: 'OP50数据'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function(params, ticket, callback) {
                // console.log(params[0])
                let str = params[0].axisValue + "<br />";
                params.forEach((item) => {
                    str +=
                        '<div class="clearfix"><span class="fl" style="display:inline-block;margin-top:6px;margin-right:5px;border-radius:50%;width:10px;height:10px;left:5px;background-color:'+item.color+'"></span><span class="fl">' + item.seriesName + '</span> : <span class="fr">' + (item.data == null? "-": (item.data*item.data*item.data).toFixed(0)) + '</span></div>';
                });
                return str;
            }
        },
        legend: {
            data: ['output', 'rapid_feed_rate', 'spindle_speed', 'feed_rate', 'feed_speed']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: time
        },
        yAxis: {
            type: 'value',
            scale: 'true',
            axisLabel: {
                formatter:function(value){
                    return value*value*value
                }
            }
        },
        series: [
            {
                name: 'spindle_speed',
                type: 'line',
                data: spindle_speed,
                smooth: true
            },
            {
                name: 'rapid_feed_rate',
                type: 'line',
                data: rapid_feed_rate,
                smooth: true
            },
            {
                name: 'feed_speed',
                type: 'line',
                data: feed_speed,
                smooth: true
            },
            {
                name: 'feed_rate',
                type: 'line',
                data: feed_rate,
                smooth: true
            },
            {
                name: 'output',
                type: 'line',
                data: output,
                smooth: true
            }
        ]
    };


    myChart.setOption(option);
}

function OP60(){
    var chartDom = document.getElementById('OP60');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var time = [];
    var output = [];
    var spindle_rate = [];
    var spindle_speed = [];
    var feed_rate = [];
    var feed_speed = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OP60",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                time.push(result[i].time.substring(11, 19));
                output.push(Math.cbrt(result[i].output));
                spindle_rate.push(Math.cbrt(result[i].spindleRate));
                spindle_speed.push(Math.cbrt(result[i].spindleSpeed));
                feed_rate.push(Math.cbrt(result[i].feedRate));
                feed_speed.push(Math.cbrt(result[i].feedSpeed));
            }
        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: 'OP60数据'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function(params, ticket, callback) {
                // console.log(params[0])
                let str = params[0].axisValue + "<br />";
                params.forEach((item) => {
                    str +=
                        '<div class="clearfix"><span class="fl" style="display:inline-block;margin-top:6px;margin-right:5px;border-radius:50%;width:10px;height:10px;left:5px;background-color:'+item.color+'"></span><span class="fl">' + item.seriesName + '</span> : <span class="fr">' + (item.data == null? "-": (item.data*item.data*item.data).toFixed(0)) + '</span></div>';
                });
                return str;
            }
        },
        legend: {
            data: ['output', 'spindle_rate', 'spindle_speed', 'feed_rate', 'feed_speed']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: time
        },
        yAxis: {
            type: 'value',
            scale: 'true',
            axisLabel: {
                formatter:function(value){
                    return value*value*value
                }
            }
        },
        series: [
            {
                name: 'spindle_speed',
                type: 'line',
                data: spindle_speed,
                smooth: true
            },
            {
                name: 'spindle_rate',
                type: 'line',
                data: spindle_rate,
                smooth: true
            },
            {
                name: 'feed_speed',
                type: 'line',
                data: feed_speed,
                smooth: true
            },
            {
                name: 'feed_rate',
                type: 'line',
                data: feed_rate,
                smooth: true
            },
            {
                name: 'output',
                type: 'line',
                data: output,
                smooth: true
            }
        ]
    };


    myChart.setOption(option);
}

function OP70(){
    var chartDom = document.getElementById('OP70');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var time = [];
    var output = [];
    var spindle_rate = [];
    var spindle_speed = [];
    var feed_rate = [];
    var feed_speed = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OP70",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                time.push(result[i].time.substring(11, 19));
                output.push(Math.cbrt(result[i].output));
                spindle_rate.push(Math.cbrt(result[i].spindleRate));
                spindle_speed.push(Math.cbrt(result[i].spindleSpeed));
                feed_rate.push(Math.cbrt(result[i].feedRate));
                feed_speed.push(Math.cbrt(result[i].feedSpeed));
            }
        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: 'OP70数据'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function(params, ticket, callback) {
                // console.log(params[0])
                let str = params[0].axisValue + "<br />";
                params.forEach((item) => {
                    str +=
                        '<div class="clearfix"><span class="fl" style="display:inline-block;margin-top:6px;margin-right:5px;border-radius:50%;width:10px;height:10px;left:5px;background-color:'+item.color+'"></span><span class="fl">' + item.seriesName + '</span> : <span class="fr">' + (item.data == null? "-": (item.data*item.data*item.data).toFixed(0)) + '</span></div>';
                });
                return str;
            }
        },
        legend: {
            data: ['output', 'spindle_rate', 'spindle_speed', 'feed_rate', 'feed_speed']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: time
        },
        yAxis: {
            type: 'value',
            scale: 'true',
            axisLabel: {
                formatter:function(value){
                    return value*value*value
                }
            }
        },
        series: [
            {
                name: 'spindle_speed',
                type: 'line',
                data: spindle_speed,
                smooth: true
            },
            {
                name: 'spindle_rate',
                type: 'line',
                data: spindle_rate,
                smooth: true
            },
            {
                name: 'feed_speed',
                type: 'line',
                data: feed_speed,
                smooth: true
            },
            {
                name: 'feed_rate',
                type: 'line',
                data: feed_rate,
                smooth: true
            },
            {
                name: 'output',
                type: 'line',
                data: output,
                smooth: true
            }
        ]
    };


    myChart.setOption(option);
}
