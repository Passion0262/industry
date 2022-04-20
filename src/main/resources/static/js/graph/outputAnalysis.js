$('#outputAnalysis').ready(outputAnalysis);

function outputAnalysis(){
    var chartDom = document.getElementById('outputAnalysis');
    var myChart = echarts.init(chartDom);
    var option;


    // 创建变量接收数据
    var date = [];
    var OP40 = [];
    var OP50 = [];
    var OP60 = [];
    var OP70 = [];

    //AJAX接收数据主体
    $.ajax({
        type:"GET",
        url:"/OutputAnalysis",
        dataType:"json",
        async:false,
        cache:false,
        success:function (result) {
            for (var i = 0; i < result.length; i++){
                if (i%5==1){
                    date.push(result[i].date)
                }
                if (result[i].deviceName=="OP40-车床"){
                    OP40.push(result[i].output)
                }
                if (result[i].deviceName=="OP50-车床"){
                    OP50.push(result[i].output)
                }
                if (result[i].deviceName=="OP60-立加"){
                    OP60.push(result[i].output)
                }
                if (result[i].deviceName=="OP70-立加"){
                    OP70.push(result[i].output)
                }
            }
        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    option = {
        title: {
            text: '设备产量计数分析'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {},
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        xAxis: {
            type: 'category',
            data: date
        },
        series: [
            {
                name: 'OP40-车床',
                type: 'bar',
                data: OP40
            },
            {
                name: 'OP50-车床',
                type: 'bar',
                data: OP50
            },
            {
                name: 'OP60-立加',
                type: 'bar',
                data: OP60
            },
            {
                name: 'OP70-立加',
                type: 'bar',
                data: OP70
            }
        ]
    };

    myChart.setOption(option);
}


