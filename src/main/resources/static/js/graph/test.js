$('#graph').ready(setInterval(graph, 1000)); //当对应标签加载好时会每隔1秒调用graph方法

function graph(){
    var chartDom = document.getElementById('graph');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var time = [];
    var output = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OP40",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {

            for (var i = 0; i < result.length; i++){
                time.push(result[i].time);
                output.push(result[i].output);
            }

        },
        error :function(errorMsg) {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: 'OP40产出'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: 'output'
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
            type: 'value'
        },
        series: [
            // {
            //     name: 'Email',
            //     type: 'line',
            //     stack: 'Total',
            //     data: [120, 132, 101, 134, 90, 230, 210],
            //     smooth: true
            // },
            // {
            //     name: 'Union Ads',
            //     type: 'line',
            //     stack: 'Total',
            //     data: [220, 182, 191, 234, 290, 330, 310],
            //     smooth: true
            // },
            // {
            //     name: 'Video Ads',
            //     type: 'line',
            //     stack: 'Total',
            //     data: [150, 232, 201, 154, 190, 330, 410],
            //     smooth: true
            // },
            // {
            //     name: 'Direct',
            //     type: 'line',
            //     stack: 'Total',
            //     data: [320, 332, 301, 334, 390, 330, 320],
            //     smooth: true
            // },
            {
                name: 'Search Engine',
                type: 'line',
                stack: 'Total',
                data: output,
                smooth: true
            }
        ]
    };


    myChart.setOption(option);
}
