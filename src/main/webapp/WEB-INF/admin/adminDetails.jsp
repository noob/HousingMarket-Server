<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>管理员详情 - 后台管理 </title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<jsp:include page="../frame/super/header.jsp"></jsp:include>
<jsp:include page="../frame/super/menu.jsp"></jsp:include>

		<!--PAGE CONTENT -->
		<div id="content">
			<div class="inner">
				<div class="row">
					<div class="col-lg-12">
						<h3>管理员详情</h3>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default" style="hei ht: 700px">
							<div class="panel-heading">
								<h4>基本信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
								<dl>
								   <dt>头像</dt>
								   <dd><img src="${admin.adminImg}"  width="130px"  style="border:1px solid rgb(240,240,240); padding:5px;"/></dd>
								   <br/><br/><br/><br/><br/><br/>
								   <br/><hr class="grey_hr"/>
								   <dt>管理员编号</dt>
								   <dd>${admin.adminId}</dd>
								   <br/><hr class="grey_hr"/>
								   <dt>用户名</dt>
								   <dd>${admin.adminName}</dd>
								   <br/><hr class="grey_hr"/>
								   <dt>性别</dt>
								   <dd><c:choose><c:when test="${admin.gender==1 }">男</c:when><c:when test="${admin.gender==0 }">女</c:when><c:otherwise>未知</c:otherwise></c:choose></dd>
								   <br/><hr class="grey_hr"/>
								   <dt>个人简介</dt>
								   <dd>${user.individualResume}</dd>
								   <br/><hr class="grey_hr"/>
								   <dt>联系方式</dt>
								   <dd>${admin.mobile}</dd>
								   <br/><hr class="grey_hr"/>
								 <%--   <dt>邮箱</dt>
								   <dd>${user.email}</dd>
								   <br/><hr class="grey_hr"/> --%>
								   <dt>创建时间</dt>
								   <dd><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${admin.createTime}" /></dd>
								   <br/><hr class="grey_hr"/>
								   <dt>最后登录IP</dt>
								   <dd>${admin.lastIp}</dd>
								   <br/><hr class="grey_hr"/>
								    <dt>最后登录</dt>
								   <dd><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${admin.lastTime}" /></dd>
								   <br/><hr class="grey_hr"/>
								</dl>
								</div>

							</div>
						</div>
					</div>
					
					<button style="margin-left: 15px" class="btn btn-dark back">  返回上一步</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../frame/super/footer.jsp"></jsp:include>
	<script type="text/javascript">
    	$(document).on("click", ".back", function() {
			location.href = history.go(-1);
		});
    </script>
</body>
</html>