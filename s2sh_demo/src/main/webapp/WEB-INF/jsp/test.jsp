<%@page pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>
			iOS 日活跃用户走势
		</title>
		<script type="text/javascript" src="http://downloads.cnblogs.com/justinyoung/gchart/jquery.js"></script>
		<script type="text/javascript" src="http://downloads.cnblogs.com/justinyoung/gchart/jquery.gchart.js"></script>
		<script type="text/javascript">
			$(function () {
				//下载量
				var array1=[<%
								List activeUserCountList = (List)request.getAttribute("activeUserCountList");
								for(int i = activeUserCountList.size()-1 ;i >= 0;i--){									
									out.print(((Object[])activeUserCountList.get(i))[1]);
									if(i > 0){
										out.print(",");
									}
								}
							%>];
				//日期数组
				var array2=[<%
								for(int i = activeUserCountList.size()-1 ;i >= 0;i--){
									String s = ((Object[])activeUserCountList.get(i))[0].toString();
									out.print("'" + s.substring(5) + "'");
									if(i > 0){
										out.print(",");
									}
								}
							%>];
				$('#basicGChart').gchart({
					type: 'line',//图表类型
					title: 'iOS日活跃用户数走势图', //图表标题
					series: [
						$.gchart.series(array1,'red')//图表数据
					],
					axes: [//图表坐标轴
						$.gchart.axis('left', 0, 20,'blue'),
						$.gchart.axis('bottom',array2,'008000')
					],
					legend: 'top'});
			});
		</script>
		<style type="text/css">
			#basicGChart { width: 800px; height: 600px }
		</style>		
	</head>
	<body>
		<div style="text-align: center;">
			<div id="basicGChart"></div>
			<table border="1" cellpadding="5" cellspacing="0" style="width: 40%;margin: auto;">
				<thead>
					<tr>
						<th>日期</th>
						<th>活跃用户数</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${activeUserCountList}" var="item">
						<tr>
							<td>${item[0]}</td>
							<td>${item[1]}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</body>
</html>
