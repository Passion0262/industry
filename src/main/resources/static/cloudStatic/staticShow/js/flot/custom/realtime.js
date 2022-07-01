var $border_color = "#eee";
var $grid_color = "#eee";
var $default_black = "#666";

var data = [];
var dataset;
var totalPoints = 70;
var updateInterval = 1000;  //刷新间隔时间
var now = new Date().getTime();


function GetData() {
	data.shift();

	while (data.length < totalPoints) {     
		var y = Math.random() * 100;
		var temp = [now += updateInterval, y];
		data.push(temp);
	}
}

var options = {
	series: {
		lines: {
			show: true,
			lineWidth: 2,
			fill: true
		},
		points: {
			show: false,
			radius: 4,
			fill: true,
			fillColor: '#2a3039',
			lineWidth: 2
		},
	},
	xaxis: {
		mode: "time",
		tickSize: [5, "second"],
		tickFormatter: function (v, axis) {
			var date = new Date(v);
			if (date.getSeconds() % 5 == 0) {  //每隔5s显示时间
				var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
				var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
				var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
				return hours + ":" + (minutes-1) + ":" +seconds;
			} else {
				return "";
			}
		},
		axisLabel: "Time",
		axisLabelUseCanvas: true,
		axisLabelFontSizePixels: 12,
		axisLabelFontFamily: 'Verdana, Arial',
		axisLabelPadding: 10
	},
	yaxis: {
		min: 0,
		max: 100,        
		tickSize: 25,
		tickFormatter: function (v, axis) {
			if (v % 10 == 0) {
				return v + "%";
			} else {
				return "";
			}
		},
		axisLabel: "CPU loading",
		axisLabelUseCanvas: true,
		axisLabelFontSizePixels: 12,
		axisLabelPadding: 5
	},
	legend:{        
		show: true,
		position: 'ne'
	},

	tooltip: true,
	tooltipOpts: {
		content: '%s: %y'
	},

	colors: ['#3FC5AC', '#0084B4', '#d8e3ef', '#333333', '#CCCCCC'],

	grid: {
		hoverable: false,
		clickable: false,
		borderWidth: 0,
		tickColor: '#353c48',
		borderColor: '#353c48',
		verticalLines: true,
		horizontalLines: true,
	},
	shadowSize: 0,
};

$(document).ready(function () {
	GetData();
	dataset = [
		{ label: "进给倍率占比", data: data, color: '#6FB4CE' }
	];
	$.plot($("#flot-placeholder"), dataset, options);
	function update() {
		GetData();
		$.plot($("#flot-placeholder"), dataset, options)
		setTimeout(update, updateInterval);
	}
	update();
});
