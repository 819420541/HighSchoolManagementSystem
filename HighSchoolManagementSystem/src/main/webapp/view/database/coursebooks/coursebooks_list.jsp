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
			<li><a href="#">基础数据</a></li>
			<li>教材管理</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		function query(condition){
			$("#keyword").attr("name",condition.value);
		}
	</script>
	
	<div class="row alert alert-info" style="margin:0px; padding:3px;" >
		<form action="${pageContext.request.contextPath}/database/coursebooks/list.action" 
				method="post" class="form-inline">
				
			<div class="col-sm-1" >条件:</div>
    		<div class="col-sm-3">
    			<select class="form-control input-sm" onchange="query(this)" name="condition">
		        	<option value="">请选择</option>
		        	<option value="coursebookid">教材编号</option>
		            <option value="coursebookname">教材名称</option>
		        </select>
			</div>
			
			<div class="col-sm-3">
		    	<input type="text"  id="keyword"  class="form-control input-sm"/>
		    </div>
			
			<input type="submit" class="btn btn-danger"  value="查询"/>
			<input type="button" class="btn btn-success" value="添加" 
					onClick="javascript:window.location='${pageContext.request.contextPath}/database/coursebooks/addLoad.action'"/>
		</form>
	</div>
	
	<div align="center">
		<div class="alert alert-warning" style="margin: 0px; padding: 5px; width: 80%;display:${empty info?'none':'block'} ">
			<button type="button" class="close" data-dismiss="alert">
				<span aria-hidden="true">&times;</span>	
			</button>
			<p align="center" style="color: red;">学校管理-${info}</p>
		</div>	
	</div>
	
	<div class="row" style="padding:15px; padding-top:0px; ">
		<table class="table table-condensed table-striped"></table>
	    <display:table class="table table-condensed table-striped" name="list" pagesize="10" 
	    		requestURI="${pageContext.request.contextPath }/database/coursebooks/list.action">
			<display:column property="coursebookid" 
					title="教材编号"></display:column>
			<display:column property="coursebookname" 
					title="教材名称"></display:column>
			<display:column property="coursebookcode" 
					title="教材代号"></display:column>
			<display:column property="coursebookdesc" 
					title="教材简介"></display:column>
			<display:column property="theoryperiod" 
					title="理论课时"></display:column>
			<display:column property="practiceperiod" 
					title="实践课时"></display:column>
			<display:column property="knowledge" 
					title="主要知识点"></display:column>
			<display:column property="suggestion" 
					title="相关建议"></display:column>
			<display:column href="${ pageContext.request.contextPath }/database/coursebooks/updateLoad.action" 
					paramId="coursebookid" paramProperty="coursebookid" value="修改" title="修改"></display:column>
			<display:column href="${ pageContext.request.contextPath }/database/coursebooks/delete.action" 
					paramId="coursebookid" paramProperty="coursebookid" value="删除" title="删除"></display:column>
	    </display:table>
	</div>

</body>
</html>
