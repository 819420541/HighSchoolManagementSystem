<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib  uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<%@ include file="/view/public/common.jspf" %>
</head>

<body>
	<div style="padding:0px; margin:0px;">
		<ul class="breadcrumb" style="margin:0px;" >
			<li><a href="#">考勤信息</a></li>
			<li>考勤管理</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
	</script>
	
	<div class="row alert alert-info" style="margin:0px; padding:3px;" >
		<form action="${pageContext.request.contextPath}/students/attendance/list.action" 
				method="post" class="form-inline">
				
			<div class="col-sm-1" >条件:</div>
    		<div class="col-sm-3">
    			<select class="form-control input-sm" onchange="query(this)" name="condition">
		        	<option value="">请选择</option>
		        	<option value="attendances.studentid">学生编号</option>
		            <option value="studentname">学生姓名</option>
		            <option value="attendances.classid">班级编号</option>
		            <option value="classname">班级名称</option>
		        </select>
			</div>
			
			<div class="col-sm-3">
		    	<input type="text"  id="keyword"  class="form-control input-sm"/>
		    </div>
			
			<input type="submit" class="btn btn-danger"  value="查询"/>
			<input type="button" class="btn btn-success" value="添加" 
					onClick="javascript:window.location='${pageContext.request.contextPath}/students/attendance/addLoad.action'"/>
		</form>
	</div>
	
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>	
			</button>
			<p align="center" style="color: red;">考勤管理-${info}</p>
		</div>	
	</div>
	
	<div class="row" style="padding:15px; padding-top:0px; ">
		<table class="table table-condensed table-striped"></table>
	    <display:table class="table table-condensed table-striped" name="list" pagesize="10" 
	    		requestURI="${pageContext.request.contextPath }/students/attendance/list.action">
	    	<display:column property="attendances.attendanceid" 
					title="考勤编号"></display:column>
			<display:column property="attendances.studentid" 
					title="学生编号"></display:column>
			<display:column property="studentname" 
					title="学生姓名"></display:column>
			<display:column property="attendances.semesterid" 
					title="学期编号"></display:column>
			<display:column property="semestername" 
					title="学期名称"></display:column>
			<display:column property="attendances.classid" 
					title="班级编号"></display:column>
			<display:column property="classname" 
					title="班级名称"></display:column>
			<display:column property="attendances.courseid" 
					title="课程编号"></display:column>
			<display:column property="coursename" 
					title="课程名称"></display:column>
			<display:column property="attendances.situation" 
					title="考勤情况"></display:column>
			<display:column property="attendances.attendancetime" 
					title="考勤时间"></display:column>
			<display:column property="attendances.attendancedesc" 
					title="考勤描述"></display:column>
			<display:column href="${ pageContext.request.contextPath }/students/attendance/updateLoad.action" 
					paramId="attendanceid" paramProperty="attendances.attendanceid" value="修改" title="修改"></display:column>
			<display:column href="${ pageContext.request.contextPath }/students/attendance/delete.action" 
					paramId="attendanceid" paramProperty="attendances.attendanceid" value="删除" title="删除"></display:column>
	    </display:table>
	</div>

</body>
</html>
