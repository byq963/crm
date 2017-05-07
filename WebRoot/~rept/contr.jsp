<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<!-- 引入jquery代码 -->
<script src="js/jquery/jquery-1.8.3.js" type="text/javascript"></script>
<!-- 引入highcharts主要代码 -->
<script src="js/Highcharts/highcharts.js" type="text/javascript"></script>
<!-- 添加主题样式js文件 -->
<script src="js/Highcharts/themes/grid.js" type="text/javascript"></script>
<!--添加导出模式 -->
<script src="js/Highcharts/modules/exporting.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function() {
		$("#statistics").click(function() {
			var Name = $("#custName").val();
			var Date = $("#ordeDate").val();
			$.ajax({
				url : 'custAction!statistics',
				type : 'POST',
				data : {
					custName : Name,
					ordeDate : Date
				},
				dataType : "json",
				success : function(data) {
				var arr=new Array();
				for(var i=0;i<data.length;i++){
					var temp=new Array();
					temp[0]=data[i].name;
					temp[1]=data[i].number;
					arr[i]=temp;
				}
                     createReport(arr);  
				}
			});
		});
		$("#exportExcel").click(function(){
			var Name = $("#custName").val();
			var Date = $("#ordeDate").val();
			$.ajax({
				url : 'custAction!exportExcel',
				type : 'POST',
				date : {
					custName : Name,
					ordeDate : Date
				},
				dateType : "json",
				success : function(data) {
				alert("导出数据成功");
				}
			});
		});
	});
	var chart;
	function createReport(arr){
		chart=new Highcharts.Chart({
			 //常规图表选项设置
                        chart: {
                            renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                            plotBackgroundColor: null,    //绘图区的背景颜色
                            plotBorderWidth: null,        //绘图区边框宽度
                            plotShadow: false            //绘图区是否显示阴影            
                        },
                        
                        //图表的主标题
                        title: {
                            text: '客户贡献分析'
                        },
                        //当鼠标经过时的提示设置
                        tooltip: {
                            pointFormat: '{series.name}: <b>{point.percentage}%</b>',
                            percentageDecimals: 1
                        },
                        //每种图表类型属性设置
                        plotOptions: {
                            //饼状图
                            pie: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    formatter: function() {
                                        //Highcharts.numberFormat(this.percentage,2)格式化数字，保留2位精度
                                        return '<b>'+ this.point.name +'</b>: '+Highcharts.numberFormat(this.percentage,2) +' %';
                                    }
                                }
                            }
                        },
                           //图表要展现的数据
                        series: [{
                            type: 'pie',
                            name: '所占比率',
                            data:arr
                        }]
		});
	}
	function query() {
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户贡献分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" id="statistics">统计图</button>
		<button class="common_button" id="exportExcel">Excel</button>
		<button class="common_button" onclick="query()">查询</button>
	</div>
	<form action="custAction!contribution" method="post" name="form1">
		<table class="query_form_table">
			<tr>
				<th>客户名称</th>
				<td><input name="custName" id="custName" />
				</td>
				<th>年份</th>
				<td><select name="ordeDate" id="ordeDate">
						<option value="我的天">全部</option>
						<option value="2005">2005</option>
						<option value="2006">2006</option>
						<option value="2007">2007</option>
						<option value="2008">2008</option>
						<option value="2009">2009</option>
						<option value="2010">2010</option>
						<option value="2011">2011</option>
						<option value="2012">2012</option>
						<option value="2013">2013</option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
				</select></td>
			</tr>
		</table>
		<br />
	</form>
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户名称</th>
			<th>订单金额（元）</th>
		</tr>
		<s:iterator value="mapContri" var="map1" status="status">
			<tr>
				<td class="list_data_number"><s:property value="#status.count" />
				</td>
				<td class="list_data_ltext">${map1.key}</td>
				<td class="list_data_number">${map1.value}</td>
			</tr>
		</s:iterator>
	</table>
	<div id="container" style="width: 800px; height: 400px; margin:0 auto">

	</div>

</body>
</html>