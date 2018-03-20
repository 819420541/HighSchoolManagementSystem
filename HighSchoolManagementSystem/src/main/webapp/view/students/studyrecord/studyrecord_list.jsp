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
			<li><a href="#">学生信息</a></li>
			<li>学生管理</li>
			<li>学历记录</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
	</script>
	
	<div class="row alert alert-info" style="margin:0px; padding:3px;" >
		<form action="${pageContext.request.contextPath}/students/studyrecord/list.action" 
				method="post" class="form-inline">
				
			<div class="col-sm-1" >条件:</div>
    		<div class="col-sm-3">
    			<select class="form-control input-sm" onchange="query(this)" name="condition">
		        	<option value="">请选择</option>
		        	<option value="studentstudyrecord.studentid">学生编号</option>
		            <option value="studentname">学生姓名</option>
		        </select>
			</div>
			
			<div class="col-sm-3">
		    	<input type="text"  id="keyword"  class="form-control input-sm"/>
		    </div>
			
			<input type="submit" class="btn btn-danger"  value="查询"/>
			<input type="button" class="btn btn-success" value="添加" disabled
					onClick="javascript:window.location='${pageContext.request.contextPath}/students/studyrecord/addLoad.action'"/>
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-primary">
					<input type="checkbox"
							onClick="javascript:window.location='${pageContext.request.contextPath}/students/archives/list.action'"> 学生档案
				</label>
				<label class="btn btn-primary">
					<input type="checkbox"
							onClick="javascript:window.location='${pageContext.request.contextPath}/students/contact/list.action'"> 联系方式
				</label>
				<label class="btn btn-warning">
					<input type="checkbox" checked
							onClick="javascript:window.location='${pageContext.request.contextPath}/students/studyrecord/list.action'"> 学历记录
				</label>
			</div>
		</form>
	</div>
	
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>	
			</button>
			<p align="center" style="color: red;">学历管理-${info}</p>
		</div>	
	</div>
	
	<div class="row" style="padding:15px; padding-top:0px; ">
		<table class="table table-condensed table-striped"></table>
	    <display:table class="table table-condensed table-striped" name="list" pagesize="10" 
	    		requestURI="${pageContext.request.contextPath }/students/studyrecord/list.action">
	    	
	    	<display:column property="studentstudyrecord.studyrecordid"
	    			media="csv xml" 
					title="学历编号"></display:column>
			<display:column property="studentstudyrecord.studentid" 
					title="学生编号"></display:column>
			<display:column property="studentname" 
					title="学生姓名"></display:column>
			<display:column property="studentstudyrecord.computerlevel" 
					title="计算机基础"></display:column>
			<display:column property="studentstudyrecord.englishlevel" 
					title="英语基础"></display:column>
			<display:column property="studentstudyrecord.graduateschool" 
					title="毕业学校"></display:column>
			<display:column property="studentstudyrecord.gradutetime" 
					title="毕业时间"></display:column>
			<display:column property="studentstudyrecord.certificate" 
					title="持有证书"></display:column>
			<display:column property="studentstudyrecord.jobcompany" 
					title="工作单位"></display:column>
			<display:column property="studentstudyrecord.jobcourse" 
					title="工作经历"></display:column>
			<display:column href="${ pageContext.request.contextPath }/students/studyrecord/updateLoad.action" 
					paramId="studentstudyrecordid" paramProperty="studentstudyrecord.studyrecordid" value="修改" title="修改"></display:column>
			<display:column href="${ pageContext.request.contextPath }/students/studyrecord/delete.action"
					media="csv xml"
					paramId="studentstudyrecordid" paramProperty="studentstudyrecord.studyrecordid" value="删除" title="删除"></display:column>
	    </display:table>
	</div>

</body>
</html>
