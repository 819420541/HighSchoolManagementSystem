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
			<li><a href="${pageContext.request.contextPath }/students/studyrecord/list.action">
					学历信息</a></li>
			<li>修改学历信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/students/studyrecord/update.action" 
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
					<label class="col-sm-3 control-label">学历编号</label>
					<div class="col-sm-9">
						<input type="text" name="studyrecordid"  value="${ studentstudyrecordInfo.studyrecordid }" 
								class="form-control input-sm" placeholder="联系编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">学生姓名</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="studentid">			
							<option>请选择学生</option>
							<c:forEach items="${ listOfStudentsbase }" var="Studentsbase">
								<option value="${Studentsbase.studentid}" 
										${studentstudyrecordInfo.studentid==Studentsbase.studentid?'selected':'' }>
									${Studentsbase.studentid} - ${Studentsbase.studentname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 1 -->
	    
		<!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">计算机基础</label>
					<div class="col-sm-9">
						<input type="text" name="computerlevel" value="${ studentstudyrecordInfo.computerlevel }" 
								class="form-control input-sm" placeholder="请输入计算机基础"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">英语基础</label>
					<div class="col-sm-9">
						<input type="text" name="englishlevel" value="${ studentstudyrecordInfo.englishlevel }" 
								class="form-control input-sm" placeholder="英语基础"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 2 -->
		
		<!-- begin 基本信息  row 3 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">毕业学校</label>
					<div class="col-sm-9">
						<input type="text" name="graduateschool" value="${ studentstudyrecordInfo.graduateschool }" 
								class="form-control input-sm" placeholder="请输入毕业学校"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">毕业日期</label>
					<div class="col-sm-9">
						<input type="text" name="gradutetime" value="${ studentstudyrecordInfo.gradutetime }" 
								class="form-control input-sm" placeholder="请输入毕业日期"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 3 -->
		
	    <!-- begin 基本信息  row 4 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">持有证书</label>
					<div class="col-sm-9">
						<input type="text" name="certificate" value="${ studentstudyrecordInfo.certificate }" 
								class="form-control input-sm" placeholder="请输入持有证书"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 4 -->
		
		<!-- begin 基本信息  row 5 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">工作单位</label>
					<div class="col-sm-9">
						<input type="text" name="jobcompany" value="${ studentstudyrecordInfo.jobcompany }" 
								class="form-control input-sm" placeholder="请输入工作单位"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">工作经历</label>
					<div class="col-sm-9">
						<input type="text" name="jobcourse" value="${ studentstudyrecordInfo.jobcourse }" 
								class="form-control input-sm" placeholder="请输入工作经历"/>
					</div>
				</div>
			</div>
		</div>
		<!-- end   基本信息  row 5 -->
	</form>
</body>
</html>
