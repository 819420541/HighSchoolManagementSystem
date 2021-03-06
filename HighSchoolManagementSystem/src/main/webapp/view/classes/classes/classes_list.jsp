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
			<li><a href="#">班级数据</a></li>
			<li>班级管理</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
	</script>
	
	<div class="row alert alert-info" style="margin:0px; padding:3px;" >
		<form action="${pageContext.request.contextPath}/classes/classes/list.action" 
				method="post" class="form-inline">
				
			<div class="col-sm-1" >条件:</div>
    		<div class="col-sm-3">
    			<select class="form-control input-sm" onchange="query(this)" name="condition">
		        	<option value="">请选择</option>
		        	<option value="classes.classid">班级编号</option>
		            <option value="classes.classname">班级名称</option>
		            <option value="classes.schoolid">学校编号</option>
		            <option value="schoolname">学校名称</option>
		        </select>
			</div>
			
			<div class="col-sm-3">
		    	<input type="text"  id="keyword"  class="form-control input-sm"/>
		    </div>
			
			<input type="submit" class="btn btn-danger"  value="查询"/>
			<input type="button" class="btn btn-success" value="添加" 
					onClick="javascript:window.location='${pageContext.request.contextPath}/classes/classes/addLoad.action'"/>
		</form>
	</div>
	
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>	
			</button>
			<p align="center" style="color: red;">班级管理-${info}</p>
		</div>	
	</div>
	
	<div class="row" style="padding:15px; padding-top:0px; ">
		<table class="table table-condensed table-striped"></table>
	    <display:table class="table table-condensed table-striped" name="list" pagesize="10" 
	    		requestURI="${pageContext.request.contextPath }/classes/classes/list.action">
			<display:column property="classes.classid" 
					title="班级编号"></display:column>
			<display:column property="classes.classname" 
					title="班级名称"></display:column>
			<display:column property="classes.enrollmentdate" 
					title="入学日期"></display:column>
			<display:column property="classes.graduatedate" 
					title="毕业日期"></display:column>
			<display:column property="classes.isgraduate" 
					title="是否毕业"></display:column>
			<display:column property="classes.schoolid" 
					title="学校编号"></display:column>
			<display:column property="schoolname" 
					title="学校名称"></display:column>
			<display:column property="classes.semesterid" 
					title="学期编号"></display:column>
			<display:column property="semestername" 
					title="学期名称"></display:column>
			<display:column property="classes.teacherofcharge" 
					title="班主任"></display:column>
			<display:column href="${ pageContext.request.contextPath }/classes/classes/updateLoad.action" 
					paramId="classid" paramProperty="classes.classid" value="修改" title="修改"></display:column>
			<display:column href="${ pageContext.request.contextPath }/classes/classes/delete.action" 
					paramId="classid" paramProperty="classes.classid" value="删除" title="删除"></display:column>
	    </display:table>
	</div>

</body>
</html>
