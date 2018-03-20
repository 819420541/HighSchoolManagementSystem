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
			<li>考勤数据</li>
			<li><a href="${pageContext.request.contextPath }/students/attendance/list.action">
					考勤管理</a></li>
			<li>添加考勤信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/students/attendance/add.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/students/attendance/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考勤编号</label>
					<div class="col-sm-9">
						<input type="text" name="attendanceid"  value="${ attendanceInfo.attendanceid }" 
								class="form-control input-sm" placeholder="考勤编号将会自动生成"
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
						<select class="form-control input-sm" name="studentid" >			
							<option>请选择学生</option>
							<c:forEach items="${ listOfStudentsbase }" var="students">
								<option value="${students.studentid}" 
										${attendanceInfo.studentid==students.studentid?'selected':'' }>
									${students.studentid} - ${students.studentname}
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
										${attendanceInfo.classid==classes.classid?'selected':'' }>
									${classes.classid} - ${classes.classname}
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
					<label class="col-sm-3 control-label">学期名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="semesterid" >			
							<option>请选择学期</option>
							<c:forEach items="${ listOfSemesters }" var="semester">
								<option value="${semester.semesterid}" 
										${attendanceInfo.semesterid==semester.semesterid?'selected':'' }>
									${semester.semesterid} - ${semester.semestername}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">课程名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="courseid" >			
							<option>请选择课程</option>
							<c:forEach items="${ listOfCourses }" var="course">
								<option value="${course.courseid}" 
										${attendanceInfo.courseid==course.courseid?'selected':'' }>
									${course.courseid} - ${course.coursename}
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
					<label class="col-sm-3 control-label">考勤情况</label>
					<div class="col-sm-9">
						<input type="text" name="situation" value="${ attendanceInfo.situation }" 
								class="form-control input-sm" placeholder="请输入考勤情况"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考勤日期</label>
					<div class="col-sm-9">
						<input type="text" name="attendancetime" onclick="WdatePicker()"
								value="<fmt:formatDate value="${attendanceInfo.attendancetime }" 
										type="both" pattern="yyyy-MM-dd"/>" 
								class="form-control input-sm" 
								placeholder="请输入考勤日期" />
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 4 -->
		
		
		<!-- 描述信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
		<!-- begin 描述信息  row 1 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">考勤描述</label>
					<div class="col-sm-9">
						<textarea name="studentDesc" class="form-control">
							${ attendanceInfo.attendancedesc }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!-- end   描述信息  row 1 -->
		
		<!-- 底部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/students/attendance/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
