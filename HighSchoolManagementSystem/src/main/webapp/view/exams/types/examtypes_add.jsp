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
			<li><a href="${pageContext.request.contextPath }/exams/types/list.action">
					考试管理</a></li>
			<li>添加考试信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/exams/types/add.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/exams/types/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 1-->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考试类型编号</label>
					<div class="col-sm-9">
						<input type="text" name="examtypeid"  value="${ examtypesInfo.examtypeid }" 
								class="form-control input-sm" placeholder="考试类型编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考试类型名称</label>
					<div class="col-sm-9">
						<input type="text" name="examtypename" value="${ examtypesInfo.examtypename }" 
								class="form-control input-sm" placeholder="请输入考试类型名称"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 1 -->
	    
	    <!-- begin 基本信息  row 2 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">考试学校名称</label>
					<div class="col-sm-9">
						<select class="form-control input-sm" name="schoolid" >			
							<option>请选择学校</option>
							<c:forEach items="${listOfSchools}" var="schools">
								<option value="${schools.schoolid}" 
										${schools.schoolid==examtypesInfo.schoolid?'selected':'' }>
									${schools.schoolid} - ${schools.schoolname}
								</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 2 -->
	    
	    <!-- 描述信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">描述信息</h5>
		<!-- begin 描述信息  row 1 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">类型描述</label>
					<div class="col-sm-9">
						<textarea name="purpose" class="form-control">
							${ examtypesInfo.remark }
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
				<a href="${pageContext.request.contextPath }/exams/types/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
