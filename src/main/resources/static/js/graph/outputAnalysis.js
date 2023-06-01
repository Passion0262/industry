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

            OP40 = result[0]
            OP50 = result[1]
            OP60 = result[2]
            OP70 = result[3]

            // date.push(result['outputAnalysisdate'][0])
            // date.push(result['outputAnalysisdate'][1])
            // date.push(result['outputAnalysisdate'][2])
            // date.push(result['outputAnalysisdate'][3])


        },
        error :function() {
            alert("获取后台数据失败！");
        }
    });

    // option = {
    //     title: {
    //         text: '设备产量计数分析'
    //     },
    //     tooltip: {
    //         trigger: 'axis',
    //         axisPointer: {
    //             type: 'shadow'
    //         }
    //     },
    //     legend: {},
    //     grid: {
    //         left: '3%',
    //         right: '4%',
    //         bottom: '3%',
    //         containLabel: true
    //     },
    //     yAxis: {
    //         type: 'value',
    //         boundaryGap: [1, 0.01]
    //     },
    //     xAxis: {
    //         type: 'category',
    //         data: date
    //     },
    //     series: [
    //         {
    //             name: 'OP40-车床',
    //             type: 'bar',
    //             data: 34
    //         },
    //         {
    //             name: 'OP50-车床',
    //             type: 'bar',
    //             data: 45
    //         },
    //         {
    //             name: 'OP60-立加',
    //             type: 'bar',
    //             data: 22
    //         },
    //         {
    //             name: 'OP70-立加',
    //             type: 'bar',
    //             data: 36
    //         }
    //     ]
    // };




    option = {
        title: {
            text: '设备产量计数'
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

        xAxis: {
            type: 'category',
            data: ["OP40", "OP50", "OP60", "OP70"]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [OP40, OP50, OP60, OP70],
            type: 'bar',
            label: {
                show: true,
                position: 'top'
            },
        }]};


    myChart.setOption(option);



    // var option = {
    //     title: {
    //         text: '柱状图数据图标分析工具',
    //
    //
    //         left:'center',
    //         textStyle:{
    //             color:'red',
    //             fontSize:35,
    //             textShadowColor:'break',
    //
    //             color:'#ffffff',//白色
    //
    //
    //         }
    //
    //
    //     },//标题
    //
    //     //backgroundColor:'#4F4F4F',//灰色背景
    //
    //
    //
    //     tooltip: {},
    //
    //     xAxis: {
    //
    //         splitLine: {
    //             show: true,
    //             lineStyle: {
    //                 color: ['grey'],
    //                 width: 0.5,
    //                 type: 'solid'
    //             },
    //         },
    //
    //
    //         axisLabel: {
    //             textStyle: {
    //                 color: '#ffffff',
    //                 fontSize:25,
    //
    //             },
    //         },
    //
    //
    //         axisTick:{
    //             show:false,
    //         },
    //         data: ['数据1', '数据2', '数据3', '数据4']
    //     },//
    //
    //     yAxis: {
    //
    //         /*name:'商品销量',
    //         type:'category',
    //         axisLine :{
    //             show:true,//显示y轴线
    //             symbol:['none','arrow'],//y轴箭头
    //             },*/
    //         splitLine: {
    //             show: true,
    //             lineStyle: {
    //                 color: ['grey'],
    //                 width: 0.5,
    //                 type: 'solid'
    //             },
    //         },
    //
    //         interval:10,//y轴数值距离
    //         axisLabel: {
    //             inside:false,
    //             textStyle: {
    //                 color: '#ffffff',
    //                 fontSize:12,
    //                 itemSize:'',
    //             },
    //         },
    //
    //
    //
    //     },
    //
    //
    //     series: [
    //         {
    //             //name: '二月销量',
    //             type: 'effectScatter',
    //             type:'bar',
    //             data: [80, 75, 68, 65],
    //             itemStyle: {
    //                 normal: {
    //                     //这里是重点
    //                     color: function(params) {
    //                         //注意，如果颜色太少的话，后面颜色不会自动循环，最好多定义几个颜色
    //                         var colorList = ['#0072E3','#FF359A', '#EAC100', '#82D900'];
    //                         return colorList[params.dataIndex]
    //                     }
    //                 }
    //             }
    //         },
    //
    //
    //         /*          {
    //                     name: '三月销量',
    //                     type: 'bar',
    //                     data: [50, 30, 20, 40, 60, 80]
    //                   }*/
    //
    //
    //
    //     ]
    // };
    //
    // // 使用刚指定的配置项和数据显示图表。
    // myChart.setOption(option);



}


