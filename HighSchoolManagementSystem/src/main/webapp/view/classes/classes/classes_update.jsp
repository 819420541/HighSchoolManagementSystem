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
			<li>班级数据</li>
			<li><a href="${pageContext.request.contextPath }/classes/classes/list.action">
					班级管理</a></li>
			<li>修改班级信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/classes/classes/update.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/classes/classes/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">班级编号</label>
					<div class="col-sm-9">
						<input type="text" name="classid"  value="${ classInfo.classid }" 
								class="form-control input-sm" placeholder="班级编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">班级名称</label>
					<div class="col-sm-9">
						<input type="text" name="classname" value="${ classInfo.classname }" 
								class="form-control input-sm" placeholder="请输入班级名称"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 1 -->
	    
	    <!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学校名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="schoolid" >			
							<option>请选择学校</option>
							<c:forEach items="${listOfSchools}" var="schools">
								<option value="${schools.schoolid}" 
										${schools.schoolid==classInfo.schoolid?'selected':'' }>
									${schools.schoolid} - ${schools.schoolname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">当前学期</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="semesterid" >			
							<option>请选择学期</option>
							<c:forEach items="${listOfSemesters}" var="semesters">
								<option value="${semesters.semesterid}" 
										${semesters.semesterid==classInfo.semesterid?'selected':'' }>
									${semesters.semesterid} - ${semesters.semestername}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 2 -->
	    
	    <!-- begin 基本信息  row 3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">入学日期</label>
					<div class="col-sm-9">
						<input type="text" name="enrollmentdate" onclick="WdatePicker()"
								value="<fmt:formatDate value="${classInfo.enrollmentdate}" 
										type="both" pattern="yyyy-MM-dd"/>" 
								class="form-control input-sm" 
								placeholder="请输入入学日期" />
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">毕业日期</label>
					<div class="col-sm-9">
						<input type="text" name="graduatedate" onclick="WdatePicker()"
								value="<fmt:formatDate value="${classInfo.graduatedate}" 
										type="both" pattern="yyyy-MM-dd"/>" 
								class="form-control input-sm" 
								placeholder="请输入毕业日期" />
					</div>
				</div>
			</div>		
		</div>
		<!-- end   基本信息  row 3 -->
	    
	    <!-- begin 基本信息  row 4 -->
	    <div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">班级主任</label>
					<div class="col-sm-9">
						<input type="text" name="teacherofcharge" value="${ classInfo.teacherofcharge }" 
								class="form-control input-sm" placeholder="请输入班级主任姓名"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">是否毕业</label>
					<div class="col-sm-9">
						<input type="radio" name="isgraduate" value="0"
								<c:if test="${classInfo.isgraduate== 'false'}">
								checked="checked"
								</c:if>
								>未毕业
						<input type="radio" name="isgraduate" value="1"
								<c:if test="${classInfo.isgraduate== 'true' }">
								checked="checked"
								</c:if>
								>已毕业
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 4 -->
		
		<!-- 底部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/classes/classes/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
