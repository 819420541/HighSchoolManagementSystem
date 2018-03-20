<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
 <head>  
   <base href="<%=basePath%>">  
 </head>  
  <body>  
      <div  style="text-align:center">  
           jfreechart _图表<br><br>  
点击显示柱状图<a href="${pageContext.request.contextPath}/graph/achievements/getColumnChart">getColumnChart</a><br>
点击显示柱状图<a href="${pageContext.request.contextPath}/graph/achievements/graph.action">getColumnChart2</a><br>
点击显示饼状图<a href="getPieChart" >getPieChart</a><br>
点击显示仪表图<a href="getMeterChart" >getMeterChart</a><br>
点击显示多状图<a href="getMutilChart" >getMutiPieChart</a><br>
         <br><br>  

         <img src="${chartURL}"  width=600 height=400  border=0  color=gray >  
         <img src="${PieURL}"  width=600 height=400  border=0  color=gray>   
         <img src="${MeterURL}"  width=600 height=400  border=0  color=gray>   
         <img src="${MutilChart}"  width=1000 height=800  border=0  color=gray>   
      </div>  

  </body>  
</html>  