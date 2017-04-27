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
<title>子管理员管理 - 后台管理</title>
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
				<h3>子管理管理</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="col-lg-12" style="margin-top: 15px;">
						联系电话：
						<input style="width: 120px" class="form-control search-input mobile" value="${mobile}" />
						&nbsp;
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
						&nbsp;&nbsp;
						<button class="btn btn-success addAdmin" data-toggle="modal" data-target="#formModal">+添加子管理员</button>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>编号</th>
										<th>账号</th>
										<th>联系电话</th>
										<th>创建时间</th>
										<th>最后登录时间</th>
										<th>最后登录IP</th>
										<th>权限</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="list" varStatus="index">
										<tr>
											<td>${(pagenation.page-1)*10+1+index.index}</td>
											<td>${list.adminName}</td>
											<td>${list.mobile}</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.createTime}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${list.lastTime}" /></td>
											<td>${list.lastIp }</td>
											<td>${list.power }</td>
											<td>
												<button class='btn btn-danger delete' data-id="${list.adminId}">删除</button>
												<button class="btn btn-primary details" data-id="${list.adminId}">详情</button>
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
	
	<div class="modal fade" id="formModal" tabindex="-1" >
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">添加子管理员</h4>
				</div>
				<div class="modal-body">
					<form id="admin_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="id" name="adminId"/>
							<span>子管理员账号 (6~11位数字,字母)</span>
							<input class="form-control adminName" name="adminName"/>
							<br/>
							<span>子管理员权限 (请填写2或3，2-中级，3-低级)</span><br/>
							<input class="form-control power" name="power"/>
							<br/>
							<br/>
							<span>*子管理员默认密码为123123</span> 
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success confirm">确认</button>
					<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
</div>
<jsp:include page="../frame/super/footer.jsp"></jsp:include>
<script>
       $(function () { formInit(); });
</script>
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
    var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/admin/adminList";
	HZFPagination.pagetoParams = [".mobile", ".begin", ".end", "#selection"];
	HZFPagination.init();
	HZFPagination.screen(".choose");
	HZFPagination.pageToJump(".details", "/admin/adminDetails", "adminId=");
	$(document).on('click', ".delete", function() {
		var adminId = $(this).attr("data-id");
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/deleteAdmin" + $("#jsessionid").val(), {adminId : adminId}, function(data) {
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
	
	$(document).on("click", ".confirm", function() {
		var haveError = 0;
		if($(".adminName").val().trim().length == 0 || $(".adminName").val().trim().length < 6 || $(".adminName").val().trim().length > 11) {
			alert("请正确填写管理员账号！");
			haveError = 1;
		}
		if($(".power").val().trim() != "2" && $(".power").val().trim() != "3") {
			alert("请正确填写管理员权限！");
			haveError = 1;
		}		
		if(haveError == 1) {
			return;
		} else {
			ajax(proj + "/admin/addAdmin" + $("#jsessionid").val(), $("#admin_form").serialize(), function(data) {
				if(data == "success") {
					location.href = location.href;				
				} else {
					alert(data);
				}
			});
		}
	});
	
</script>
</body>
</html>
