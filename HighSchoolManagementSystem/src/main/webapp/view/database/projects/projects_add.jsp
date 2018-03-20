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
			<li><a href="${pageContext.request.contextPath }/database/projects/list.action">
					项目管理</a></li>
			<li>添加项目信息</li>
		</ul>
	</div>
	
	<c:if test="${ allErrors!=null }">
		<br/>
		<c:forEach items="${ allErrors }" var="error">
			${ error.defaultMessage }
			<br/>
		</c:forEach>
	</c:if>

	<form action="${ pageContext.request.contextPath }/database/projects/add.action" 
			method="post" class="form-horizontal">
			
		<!-- 顶部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/database/projects/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	    
		<!-- 基本信息 -->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">基本信息</h5>
		
		<!-- begin 基本信息  row 01 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目编号</label>
					<div class="col-sm-9">
						<input type="text" name="projectid"  value="${ projects.projectid }" 
								class="form-control input-sm" placeholder="项目编号将会自动生成"
								readonly="readonly"/>
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目名称</label>
					<div class="col-sm-9">
						<input type="text" name="projectname" value="${ projects.projectname }" 
								class="form-control input-sm" placeholder="请输入项目名称"/>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 01 -->
	    
	    <!-- begin 基本信息  row 02 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">所需时间</label>
					<div class="col-sm-9">
						<input type="text" name="projectperiod"  value="${ projects.projectperiod }" 
								class="form-control input-sm" placeholder="请输入项目所需时间" />
					</div>
				</div>
			</div>
			
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">代码量</label>
					<div class="col-sm-9">
						<input type="text" name="codemeasure"  value="${ projects.codemeasure }" 
								class="form-control input-sm" placeholder="请输入项目的代码量" />
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 02 -->
	    
	    <!-- begin 基本信息  row 03 -->
		<div class="row">
			<div class="col-sm-5">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目难度</label>
					<div class="col-sm-9">
						<input type="text" name="projectlevel"  value="${ projects.projectlevel }" 
								class="form-control input-sm" placeholder="请输入项目难度" />
					</div>
				</div>
			</div>
		</div>
	    <!-- end   基本信息  row 03 -->
	    
	    <!-- 其它信息-->
		<h5 class="page-header alert-info" style="padding:10px; margin:0px; margin-bottom:5px;">其它信息</h5> 
		
		<!-- begin 其它信息  row 01 -->
	    <div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目简介</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="projectdesc">
							${ projects.projectdesc }
						</textarea>
					</div>
				</div>
			</div>
		</div>
	    <!-- end   其它信息  row 01 -->
	       
		<!-- begin 其它信息  row 02 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目重难点</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="difficulty">
							${ projects.difficulty }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 02 -->
		
		<!-- begin 其它信息  row 03 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目目的</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="target">
							${ projects.target }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 03 -->
		
		<!-- begin 其它信息  row 04 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目技术</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="technique">
							${ projects.technique }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 04 -->
		
		<!-- begin 其它信息  row 05 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目数据库</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="projectdatabase">
							${ projects.projectdatabase }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 05 -->
		
		<!-- begin 其它信息  row 06 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">编程环境</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="conditions">
							${ projects.conditions }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 06 -->
		
		<!-- begin 其它信息  row 07 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">项目特点</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="features">
							${ projects.features }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 07 -->
		
		<!-- begin 其它信息  row 08 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">技术难点</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="skilldifficulty">
							${ projects.skilldifficulty }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 08 -->
		
		<!-- begin 其它信息  row 09 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">技术重点</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="skillkeynote">
							${ projects.skillkeynote }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 09 -->
		
		<!-- begin 其它信息  row 10 -->
		<div class="row">
			<div class="col-sm-10">
				<div class="form-group">
					<label class="col-sm-3 control-label">相关建议</label>
					<div class="col-sm-9">
						<textarea class="form-control" name="suggestion">
							${ projects.suggestion }
						</textarea>
					</div>
				</div>
			</div>
		</div>
		<!--  end  其它信息  row 10 -->
		
		<!-- 底部按钮 -->
		<div class="row">
			<div class="col-sm-3 col-sm-offset-4">
				<input type="submit" class="btn btn-success" value="保存"/>
				<input type="reset"  class="btn btn-danger"  value="重置"/>
				<a href="${pageContext.request.contextPath }/database/projects/list.action" 
						class="btn btn-warning" >返回上一级</a>
			</div>
		</div>
	</form>
</body>
</html>
