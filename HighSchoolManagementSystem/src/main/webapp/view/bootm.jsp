<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>

</head>
	
<%@ include file="/view/public/common.jspf" %>

<body>

<div style="padding:0px; margin:0px;">
 <ul class="breadcrumb" style=" padding:0px; padding-left:20px;" >
  <li ><a href="#">首页</a></li>
  <li>工作台</li>
</ul>
</div>

<div class="row " style="padding:1px; margin:0px;"  >
	<div class="col-sm-8">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>招生线索来源图
          </div>
              <div class="panel-body">
               <img src="${pageContext.request.contextPath}/resource/img/招生.png" width="100%" />
              </div>
        </div>
    </div>
 	<div class="col-sm-4">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>关键试图
          </div>
   <table class="table table-bordered">
	<tr>
    	<th>视图</th>
        <th>模块</th>
        <th>数量</th>
    </tr>
    
    	<tr>
    	<td>正式学员</td>
        <td>学员</td>
        <td>1523</td>
    </tr><tr>
    	<td>正式学员</td>
        <td>学员</td>
        <td>1523</td>
    </tr><tr>
    	<td>正式学员</td>
        <td>学员</td>
        <td>1523</td>
    </tr>
	</table>  
        </div>
    </div>

	<div class="col-sm-6">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>招生线索来源图
          </div>
              <div class="panel-body">
               <img src="${pageContext.request.contextPath}/resource/img/02.png" width="100%" />
              </div>
        </div>
    </div>
	<div class="col-sm-6">
        <div class="panel panel-default" >
          <div class="panel-heading" style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>招生线索来源图
          </div>
              <div class="panel-body">
               <img src="${pageContext.request.contextPath}/resource/img/02.png" width="100%" />
              </div>
        </div>
    </div>
 	<div class="col-sm-4">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>今日联系
          </div>
   <table class="table table-bordered" >
	<tr >
    	<th>联系人</th>
        <th>电话好吗</th>
     
    </tr>
    <tr>
    	<td>张三</td>
        <td>1522355214</td>
    </tr>
	</table>  
        </div>
    </div>
 	<div class="col-sm-4">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>今日联系
          </div>
   <table class="table table-bordered" >
	<tr >
    	<th>联系人</th>
        <th>电话好吗</th>
     
    </tr>
    <tr>
    	<td>张三</td>
        <td>1522355214</td>
    </tr>
	</table>  
        </div>
    </div>
     	<div class="col-sm-4">
            <div class="panel panel-default">
          <div class="panel-heading"  style=" padding:3px;height:30px;"  >
            <span class="glyphicon glyphicon-refresh"></span>公告
          </div>
		  <div class="panel-body">公告</div>	
        </div>
    </div>
</div>



</body>
</html>
