<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 	prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 	prefix="c"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>首页</title>
	<%@ include file="/view/public/common.jspf" %>
</head>

<body>
	<div style="padding:0px; margin:0px;">
		<ul class="breadcrumb" style=" margin:0px; " >
			<li>基础数据</li>
			<li><a href="${pageContext.request.contextPath }/database/coursebooks/list.action">
					教材管理</a></li>
			<li>添加教材信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/database/coursebooks/add.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/database/coursebooks/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">教材编号</label>
					<div class="col-sm-9">
						<input type="text" name="coursebookid"  value="${ coursebooks.coursebookid }" 
								class="form-control input-sm" placeholder="教材编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">教材名称</label>
					<div class="col-sm-9">
						<input type="text" name="coursebookname" value="${ coursebooks.coursebookname }" 
								class="form-control input-sm" placeholder="请输入教材名称"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 1 -->
	    
	    <!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">教材代号</label>
					<div class="col-sm-9">
						<input type="text" name="coursebookcode"  value="${ coursebooks.coursebookcode }" 
								class="form-control input-sm" placeholder="请输入教材代号" />
					</div>
				</div>
			</div>
			
		</div>
	    <!-- end   基本信息  row 2 -->
	    
	    <!-- begin 基本信息  row 3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">理论课时</label>
					<div class="col-sm-9">
						<input type="text" name="theoryperiod"  value="${ coursebooks.theoryperiod }" 
								class="form-control input-sm" placeholder="请输入教材理论课时"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">实践课时</label>
					<div class="col-sm-9">
						<input type="text" name="practiceperiod" value="${ coursebooks.practiceperiod }" 
								class="form-control input-sm" placeholder="请输入教材实践课时"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 3 -->
	    
	    <!-- 其它信息-->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">其它信息</h5> 
		
		<!-- begin 其它信息  row 1 -->
	    <div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">教材简介</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="coursebookdesc">
							${ coursebooks.coursebookdesc }
						</textarea>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   其它信息  row 1 -->
	       
		<!-- begin 其它信息  row 2 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">主要知识</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="knowledge">
							${ coursebooks.knowledge }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 2 -->
		
		<!-- begin 其它信息  row 3 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">相关建议</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="suggestion">
							${ coursebooks.suggestion }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 3 -->
		
		<!-- 底部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/database/coursebooks/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
