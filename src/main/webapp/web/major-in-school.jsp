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
    <title>高校专业推荐系统 | 专业</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">
<jsp:include page="../web/common.jsp"></jsp:include>
    <div class="div-max" style="margin:6% auto;">
        <div style="margin-left:10%">
        	<div>
				<h3 style="margin-left:2%;padding-top: 1%">${school.schoolName }</h3>
			</div>
			<table class="table table-striped table-bordered table-hover" >
					<thead>
		                <tr>
			                <th style="text-align: center">专业名称</th>
			                <th style="text-align: center">专业或类名称</th>
							<th style="text-align: center">选考科目要求</th>
							<th style="text-align: center">层次</th>
							<th style="text-align: center">上一年分数线</th>
							<th style="text-align: center">参考学费/年</th>
							<th style="text-align: center">专业星级</th>
				         </tr>
			         </thead>
			         <tbody>
	       				<c:forEach items="${list }" var="list" varStatus="index">
				         	<tr>
		       					<td style="text-align: center">${list.majorName }</td>
		       					<td style="text-align: center">${list.cate }</td>
		       					<td style="text-align: center">
		       						<c:choose>
										<c:when test="${list.subject != null && list.subject.length() > 0}">${list.subject }</c:when>
										<c:otherwise>无</c:otherwise>
									</c:choose>
		       					</td>
		       					<td style="text-align: center">${list.level }</td>
		       					<td style="text-align: center">${list.score }</td>
		       					<td style="text-align: center">${list.tuition }</td>
		       					<td style="text-align: center">${list.recommend }</td>
		        			</tr>
	       				</c:forEach>
			         </tbody>
	        	</table>
			<c:if test="${list == null || list.size() <= 0}">
					<div class="div-body" style="width: 100%">
						<h2 style="text-align: center;">查询到0条信息</h2>
					</div>	
			</c:if>		
			<div class="div-body" style="width: 100%">
				<button style="margin: 15px; float:right" class="btn btn-dark back">  返回上一步</button>
			</div>	
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
	$(function () { formInit(); });
	account.regist();
	account._login();
	
	var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/user/majorList";
	HZFPagination.pagetoParams = [".subject1", ".subject2", ".subject3", ".department"];
	HZFPagination.init();
	
//搜索框	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});
	
	$(document).on("click", ".back", function() {
		location.href = history.go(-1);
	});
	
</script>
</html>
