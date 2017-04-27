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
    <title>高校专业推荐系统 | 培训订单</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">

	<jsp:include page="../web/common.jsp"></jsp:include>
	
    <div class="div-max" style="margin:8% auto">
        <div >
        		<form  id="alipay_form" action="<%=path%>/alipay/submit_info" class="alipayform" method="POST">
        			<table class="table table-striped table-bordered">
        				<tbody>
        					<tr>
						         <td>培训名称</td>
						         <td>${lessonTitle }</td>
						      </tr>
						      <tr>
						         <td>教师</td>
						         <td>${teacherIntroduce }</td>
						      </tr>
						      <tr>
						         <td>培训地点</td>
						         <td>${place }</td>
						      </tr>
						      <tr>
						         <td>价格</td>
						         <td>${WIDtotal_fee }</td>
						      </tr>
						      <tr>
						         <td>培训内容</td>
						         <td>${lessonMsg }</td>
						      </tr>
						      <tr>
						         <td>培训条款</td>
						         <td>${lessonItem }</td>
						      </tr>
        				</tbody>
        			</table>
        			<input type="hidden" name="WIDout_trade_no" id="out_trade_no" value="${WIDout_trade_no }">
        			<input type="hidden" name="WIDsubject" value="${WIDsubject }">
        			<input type="hidden" name="WIDtotal_fee" value="${WIDtotal_fee }">
        			<input type="hidden" name="WIDbody" value="${WIDbody }">
        			<div class="checkbox" style="width:100%">
        				<label style="float:right; "><input type="checkbox"  id="checkbox" onclick="checkboxOnclick(this)">已确认条款</label>
        			</div>
        			</br>
        			</br>
        			<button id="pay_button" style="float:right; " type="submit" class="alisubmit btn btn-info pay"  disabled="disabled">确认支付</button>
        		</form>
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
	
	function checkboxOnclick(checkbox) {
		if(checkbox.checked) {
			$("#pay_button").attr("disabled", false);
		} else {
			$("#pay_button").attr("disabled", true);
		}
	}
	
	$(document).on("click", ".enter", function() {
		var lessonId = $(this).attr("data-id");
		var userId = ${sessionScope.USER_SESSION_KEY.userId } + "";
		if(userId != 0) { //已登录
			ajax(proj +"/user/if_user_info_complete", {userId : userId}, function(data) {
				if(data != "complete") {
					alert("请前往个人中心完善信息");
				} else if(data == "complete") {
					location.href = proj + "/alipay/submit_info?lessonId=" + lessonId + "&userId=" + userId;
					//暂时拟定个人信息完善 并 报名付款成功后
					/*
					ajax(proj + "/user/enter_record", {lessonId : lessonId, userId : userId }, function(msg) {
						if (msg == "success") {
							alert("success");
						}
					});
					*/
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
