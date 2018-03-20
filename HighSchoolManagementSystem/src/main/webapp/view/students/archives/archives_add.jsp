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
			<li>学生数据</li>
			<li><a href="${pageContext.request.contextPath }/students/archives/list.action">
					学生管理</a></li>
			<li>添加学生信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/students/archives/add.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/students/archives/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生编号</label>
					<div class="col-sm-9">
						<input type="text" name="studentid"  value="${ studentsbaseInfo.studentid }" 
								class="form-control input-sm" placeholder="学生编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			
		</div>
	    <!-- end   基本信息  row 1 -->
	    
	    <!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<input type="text" name="studentname" value="${ studentsbaseInfo.studentname }" 
								class="form-control input-sm" placeholder="请输入学生姓名"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">姓名拼音</label>
					<div class="col-sm-9">
						<input type="text" name="namespell" value="${ studentsbaseInfo.namespell }" 
								class="form-control input-sm" placeholder="请输入姓名拼音"/>
					</div>
				</div>
			</div>
			
		</div>
	    <!-- end   基本信息  row 2 -->
	    
	    <!-- begin 基本信息  row 3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学校名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="schoolid" >			
							<option>请选择学校</option>
							<c:forEach items="${ listOfSchools }" var="schools">
								<option value="${schools.schoolid}" 
										${studentsbaseInfo.schoolid==schools.schoolid?'selected':'' }>
									${schools.schoolid} - ${schools.schoolname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">班级名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="classid" >			
							<option>请选择班级</option>
							<c:forEach items="${ listOfClasses }" var="classes">
								<option value="${classes.classid}" 
										${studentsbaseInfo.classid==classes.classid?'selected':'' }>
									${classes.classid} - ${classes.classname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 3 -->
		
		<!-- begin 基本信息  row 4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">出生日期</label>
					<div class="col-sm-9">
						<input type="text" name="birthday" onclick="WdatePicker()"
								value="<fmt:formatDate value="${studentsbaseInfo.birthday }" 
										type="both" pattern="yyyy-MM-dd"/>" 
								class="form-control input-sm" 
								placeholder="请输入出生日期" />
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">身份证号</label>
					<div class="col-sm-9">
						<input type="text" name="identitycard" value="${ studentsbaseInfo.identitycard }" 
								class="form-control input-sm" placeholder="请输入身份证号"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 4 -->
		
		<!-- begin 基本信息  row 5 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生性别</label>
					<div class="col-sm-9">
						<input type="text" name="sex" value="${ studentsbaseInfo.sex }" 
								class="form-control input-sm" placeholder="请输入学生性别"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">民族</label>
					<div class="col-sm-9">
						<input type="text" name="nation" value="${ studentsbaseInfo.nation }" 
								class="form-control input-sm" placeholder="请输入民族"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 5 -->
		
		<!-- begin 基本信息  row 6 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学历</label>
					<div class="col-sm-9">
						<input type="text" name="education" value="${ studentsbaseInfo.education }" 
								class="form-control input-sm" placeholder="请输入学生学历"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 6 -->
		
		<!-- begin 基本信息  row 7 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">住址</label>
					<div class="col-sm-9">
						<input type="text" name="dwellingplace" value="${ studentsbaseInfo.dwellingplace }" 
								class="form-control input-sm" placeholder="请输入住学生址"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">籍贯</label>
					<div class="col-sm-9">
						<input type="text" name="nativeplace" value="${ studentsbaseInfo.nativeplace }" 
								class="form-control input-sm" placeholder="请输入学生 籍贯"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 7 -->
		
		<!-- 底部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/students/archives/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
