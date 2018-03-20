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
		<ul class="breadcrumb" style="  margin:0px; " >
			<li><a href="#">学生管理</a></li>
			<li><a href="${pageContext.request.contextPath }/students/archives/list.action">
					学生信息</a></li>
			<li>查看联系信息</li>
		</ul>
	</div>

	<form action=" " class="form-horizontal">
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-5 col-sm-offset-4">
				<a href="${pageContext.request.contextPath }/students/contact/updateLoad.action?studentcontactid=${studentcontactInfo.studentcontactid}" 
						class="btn btn-success" >修改</a>
				<a href="${pageContext.request.contextPath }/students/archives/list.action" class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">联系编号</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentcontactInfo.studentcontactid}</p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<c:forEach items="${listOfStudentsbase}" var="Studentsbase">
							<c:if test="${Studentsbase.studentid==studentcontactInfo.studentid}">
								<p>${Studentsbase.studentname}</p>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 1 -->
	    
		<!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家庭住址</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentcontactInfo.homeaddress}</p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">家庭成员</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentcontactInfo.family}</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 2 -->
		
		<!-- begin 基本信息  row 3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">宅电</label>
					<div class="col-sm-9">
						<p class="form-control-static">${studentcontactInfo.phone}</p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">移动电话</label>
					<div class="col-sm-9">
						<p class="form-control-static">${ studentcontactInfo.mobilephone }</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 3 -->
		
	    <!-- begin 基本信息  row 4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">电子邮件</label>
					<div class="col-sm-9">
						<p class="form-control-static">${ studentcontactInfo.email }</p>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">其它方式</label>
					<div class="col-sm-9">
						<p class="form-control-static">${ studentcontactInfo.others }</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 4 -->
 
	</form>
</body>
</html>
