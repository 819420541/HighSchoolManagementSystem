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
			<li>考试数据</li>
			<li><a href="${pageContext.request.contextPath }/exams/achievements/list.action">
					成绩管理</a></li>
			<li>修改成绩信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/exams/achievements/update.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/exams/achievements/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">成绩编号</label>
					<div class="col-sm-9">
						<input type="text" name="achievementid"  value="${ achievementInfo.achievementid }" 
								class="form-control input-sm" placeholder="成绩编号将会自动生成"
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
					<label class="col-sm-3 control-label">考试安排名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name=examplanid >			
							<option>请选择考试安排</option>
							<c:forEach items="${listOfExamplans}" var="examplans">
								<option value="${examplans.examplanid}" 
										${examplans.examplanid==achievementInfo.examplanid?'selected':'' }>
									${examplans.examplanid} - ${examplans.examplanname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考试名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name=examid >			
							<option>请选择考试</option>
							<c:forEach items="${listOfExams}" var="exams">
								<option value="${exams.examid}" 
										${exams.examid==achievementInfo.examid?'selected':'' }>
									${exams.examid} - ${exams.examname}
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
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="studentid" >			
							<option>请选择学生</option>
							<c:forEach items="${listOfStudentsbase}" var="students">
								<option value="${students.studentid}" 
										${students.studentid==achievementInfo.studentid?'selected':'' }>
									${students.studentid} - ${students.studentname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考试成绩</label>
					<div class="col-sm-9">
						<input type="text" name="result" value="${ achievementInfo.result }" 
								class="form-control input-sm" placeholder="请输入考试成绩"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 3 -->
	    
	</form>
</body>
</html>
