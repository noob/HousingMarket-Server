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
    <title>高校专业推荐系统 | 订单</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">

	<jsp:include page="../web/common.jsp"></jsp:include>
	
    <div class="div-max" style="margin:8% auto">
        <div >
        		<form  id="alipay_form" action="<%=path%>/alipay/submit_info_2" class="alipayform" method="POST">
        			<table class="table table-striped table-bordered">
        				<tbody>
        					<tr>
						         <td>名称</td>
						         <td>${WIDsubject }</td>
						      </tr>
						      <tr>
						         <td>详细内容</td>
						         <td>查看更多专业推荐排行</td>
						      </tr>
						      <tr>
						         <td>价格</td>
						         <td>${WIDtotal_fee } 元</td>
						      </tr>
        				</tbody>
        			</table>
        			<input type="hidden" name="WIDout_trade_no" id="out_trade_no" value="${WIDout_trade_no }">
        			<input type="hidden" name="WIDsubject" value="${WIDsubject }">
        			<input type="hidden" name="WIDtotal_fee" value="${WIDtotal_fee }">
        			<input type="hidden" name="WIDbody" value="${WIDbody }">
        			<!-- <input type="hidden" name="msessionId" value="${msessionId }"> -->
        			<input style="float:right" type="submit" class="alisubmit btn btn-info pay" value="确认支付">
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
	
	
	
</script>
</html>
