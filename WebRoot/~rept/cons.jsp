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
		$("#statisticsCons").click(function() {
			var date = $("#constitute").val();
			$.ajax({
				url : 'custAction!statisticsCons',
				type : 'POST',
				data : {
					constitute : date
				},
				dataType : "json",
				success : function(data) {
					var arr = new Array();
					var brr = new Array();
					for ( var i = 0; i < data.length; i++) {
						arr[i] = data[i].name;
						brr[i] = data[i].number;
					}
					createReport(arr, brr);
				}

			});

		});
		$("#exportExcel").click(function(){
			var date = $("#constitute").val();
			$.ajax({
				url : 'custAction!exportConsExcel',
				type : 'POST',
				data : {
					constitute : date
				},
				dateType : "json",
				success : function(data) {
					alert("导出数据成功");
				}
			});
		});
	});
	var chart;
	function createReport(arr,brr){
		chart=new Highcharts.Chart({
			 			//常规图表选项设置
                        chart: {
                            renderTo: 'container',        //在哪个区域呈现，对应HTML中的一个元素ID
                            plotBackgroundColor: null,    //绘图区的背景颜色
                            plotBorderWidth: null,        //绘图区边框宽度
                            plotShadow: false            //绘图区是否显示阴影            
                        },
                        xAxis:{
                        	categories:arr,
                        	title:{text:'客户构成'}
                        },
                        yAxis:{
                        	min:0,
                        	title:{text:'数量(个)'}
                        },
                        //图表的主标题
                        title: {
                            text: '客户构成分析'
                        },
                       
                        //每种图表类型属性设置
                        plotOptions: {
                            bar: {
                                allowPointSelect: true,
                                cursor: 'pointer',
                                dataLabels: {
                                    enabled: true,
                                    color: '#000000',
                                    connectorColor: '#000000',
                                    formatter: function() {
                                        return '客户数:'+Highcharts.numberFormat(this.y,1);
                                    }
                                }
                            }
                        },
                           //图表要展现的数据
                        series: [{
                            type: 'bar',
                            name: '客户数量',
                            data:brr
                        }]
		});
	}
	function query() {
		form1.submit();
	}
</script>
</head>
<body>

	<div class="page_title">客户构成分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" id="statisticsCons">统计图</button>
		<button class="common_button" id="exportExcel">Excel</button>
		<button class="common_button" onclick="query()">查询</button>
	</div>
	<form action="custAction!constitute" method="post" name="form1">
		<table class="query_form_table">
			<tr>
				<th>报表方式</th>
				<td><select name="constitute" id="constitute">
						<option value="0">按等级</option>
						<option value="1">按信用度</option>
						<option value="2">按满意度</option>
				</select>
				</td>

				<th>&nbsp;</th>
				<td>&nbsp;</td>
			</tr>
		</table>
		<br />
	</form>
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>等级</th>
			<th>客户数量</th>
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