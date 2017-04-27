<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String port;
	if (request.getServerPort() == 80) {port = "";} else {port = ":8080";}
	String path = request.getScheme() + "://" + request.getServerName() + port + "/SchoolGuider";
%>

<!DOCTYPE html>
<html class="webkit win">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css">
        @charset "UTF-8";
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak, .ng-hide:not(.ng-hide-animate) {
            display: none !important;
        }
        ng\:form {
            display: block;
        }
    </style>
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 培训</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">

	<jsp:include page="../web/common.jsp"></jsp:include>
	
    <div class="div-max" style="margin:8% auto">
        <div >
				<table class="table table-striped table-bordered table-hover" >
					<thead>
		                <tr>
			                <th style="text-align: center">培训名称</th>
							<th style="text-align: center">培训时间</th>
							<th style="text-align: center">培训地点</th>
							<th style="text-align: center">周期</th>
							<th style="text-align: center">教师介绍</th>
							<th style="text-align: center">学费</th>
							<th style="text-align: center">提前报名价</th>
							<th style="text-align: center"> 操作</th>
				         </tr>
			         </thead>
			         <tbody>
	       				<c:forEach items="${list }" var="list" varStatus="index">
				         	<tr>
		       					<td style="text-align: center">${list.lessonTitle }</td>
		       					<td style="text-align: center"><fmt:formatDate pattern="yyyy-MM-dd" value="${list.lessonBeginDate}" /></td>
		       					<td style="text-align: center">${list.place }</td>
		       					<td style="text-align: center">${list.duration }</td>
		       					<td style="text-align: center">${list.teacherIntroduce }</td>
		       					<td style="text-align: center">${list.price }</td>
		       					<td style="text-align: center">${list.discountPrice } (<fmt:formatDate pattern="yyyy-MM-dd" value="${list.lessonDiscountEndDate}" />之前)</td>
		       					<td style="text-align: center">
		       						<button class="btn btn-primary enter" data-id="${list.lessonId }">报名</button>
		       					</td>
		        			</tr>
	       				</c:forEach>
			         </tbody>
	        	</table>
			<c:choose>
				<c:when test="${list != null}">
				</c:when>
				<c:otherwise><h1 style="text-align: center;">查询到0条信息</h1></c:otherwise>
			</c:choose>
		</div>
    </div>
	<!-- List DIV end -->
	
	
</body>
<script src="<%=path%>/js/schoolguider/vendors.min.3924f1bd79c3.js"></script>
<script src="<%=path%>/js/schoolguider/base.78759ea33cfe.js"></script>
<script src="<%=path%>/js/schoolguider/website.d6ab10c0b75c.js"></script>
<script src="<%=path%>/js/schoolguider/jquery.1.11.1.js"></script>
<script src="<%=path%>/js/bootstrap.js"></script>
<script src="<%=path%>/js/schoolguider/account.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
	
	var proj = "<%=path %>";
	HZFPagination.pageToJump(".detail", "/user/schoolDetails", "schoolId=");
	
	$(document).on("click", ".enter", function() {
		var lessonId = $(this).attr("data-id");
		var userId = ${sessionScope.USER_SESSION_KEY.userId } + "";
		if(userId != 0) { //已登录
			ajax(proj +"/user/if_user_info_complete", {userId : userId}, function(data) {
				if(data != "complete") {
					if (confirm("请前往个人中心完善信息")) {
						location.href = proj + "/user/userZoom";
					}
				} else if(data == "complete") {
					location.href = proj + "/alipay/form_page?lessonId=" + lessonId + "&userId=" + userId;
				} else {
					alert(data);
				}
			})
		} else {
			location.href = proj + "/user_login_ui";
		}
		
	});
	
	
</script>
</html>
