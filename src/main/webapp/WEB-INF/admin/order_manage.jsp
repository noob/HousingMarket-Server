<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String port;
	if (request.getServerPort() == 80) {
		port = "";
	} else {
		port = ":8080";
	}
	String path = request.getScheme() + "://" + request.getServerName() + port + "/SchoolGuider";
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
<title>培训订单管理 - 后台管理</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<link rel="stylesheet" href="<%=path %>/css/pagination.css">
<link rel="stylesheet" href="<%=path %>/plugins/datepicker/css/datepicker.css" />
<jsp:include page="../frame/super/header.jsp"></jsp:include>
<jsp:include page="../frame/super/menu.jsp"></jsp:include>

<!--PAGE CONTENT -->
<div id="content">
	<div class="inner">
		<div class="row">
			<div class="col-lg-12">
				<h3>培训订单管理</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="col-lg-12" style="margin-top: 15px;">
						联系方式：
						<input style="width: 120px" class="form-control search-input mobile" value="${mobile}" />
						&nbsp;&nbsp;
						培训标题：
						<input style="width: 120px" class="form-control search-input lessonName" value="${lessonName}" />
						<br /> 
						<br />
						<div style="text-align:center">
							<span style="margin-top: 5px;float: left;vertical-align:middle">创建时间：</span>
							<div style="width:240px;float:left" class="input-group input-append date" id="dp3" data-date="${begin}" data-date-format="yyyy-mm-dd">
								<input class="form-control begin" type="text" value="${begin}" readonly=""> <span class="input-group-addon add-on"><i class="icon-calendar"></i></span>
								&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;
							</div>
							<div style="width:200px;float:left" class="input-group input-append date" id="dp4" data-date="${end}" data-date-format="yyyy-mm-dd">
								<input class="form-control end" type="text" value="${end}" readonly=""> <span class="input-group-addon add-on"><i class="icon-calendar"></i></span>
							</div>
						</div>
						&nbsp;&nbsp;
						<button class="btn btn-dark choose">筛选</button>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>编号</th>
										<th>培训标题</th>
										<th>订单价格</th>
										<th>创建时间</th>
										<th>开课日期</th>
										<th>用户名</th>
										<th>真实姓名</th>
										<th>联系方式</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="list" varStatus="index">
										<tr>
											<td>${(pagenation.page-1)*10+1+index.index}</td>
											<td>${list.lessonName}</td>
											<td>${list.realPrice}</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.createTime}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.lessonBeginDate}" /></td>
											<td>${list.userName }</td>
											<td>${list.realName }</td>
											<td>${list.userMobile }</td>
											<td>
												<button class='btn btn-danger delete' data-id="${list.lessonLogId}">删除</button>
												<button class='btn btn-info details' data-id="${list.lessonLogId}">详情</button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div id="Pagination" class="pagination" style="float:right; position:relative; "></div>
						<input type="hidden" value="${requestScope.pagenation.total}" id="num_entries" />
						<input type="hidden" value="${requestScope.pagenation.page}" id="current_page" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--END PAGE CONTENT -->
	
</div>
<jsp:include page="../frame/super/footer.jsp"></jsp:include>
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
	$(function () { formInit(); });
    var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/admin/orderList";
	HZFPagination.pagetoParams = [".mobile", ".lessonName", ".begin", ".end", "#selection"];
	HZFPagination.init();
	HZFPagination.screen(".choose");
	HZFPagination.pageToJump(".details", "/admin/lessonLogDetails", "lessonLogId=");
	
	$(document).on('click', ".delete", function() {
		var lessonLogId = $(this).attr("data-id");
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/deleteOrder" + $("#jsessionid").val(), {lessonLogId : lessonLogId}, function(data) {
				if (data == "no") {
					alert("请上传必要参数！");
				} else if (data == "error") {
					alert("出现未知错误！");
				} else {
					location.href = location.href;
				}
			});
		}
	});
	
</script>
</body>
</html>
