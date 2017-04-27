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
<title>学校管理 - 后台管理</title>
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
				<h3>星级管理</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
				<div class="col-lg-12" style="margin-top: 15px;">
						&nbsp;&nbsp;
						<button class="btn btn-success modify" data-toggle="modal" data-target="#formModal"
							data-three_four="${three_four }" data-four_five="${four_five }"  data-lowest="${lowest }">+修改星级标准</button>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>星级</th>
										<th>最低分</th>
										<th>最高分</th>
									</tr>
								</thead>
								<tbody>
								
									<c:forEach items="${requestScope.list }" var="list" varStatus="index">
										<tr>
											<td><img class="radius" src="<%=path + '/' %>${list.starImg}" /></td>
											<td>${list.scoreMin}</td>
											<td>${list.scoreMax}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
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
					<h4 class="modal-title" id="H2">修改星级</h4>
				</div>
				<div class="modal-body">
					<form id="star_form"  method="post">
						<div class="form-group">
							<span>3星标准线</span> 
							<input class="form-control lowest" name="lowest"/><br/>
							<span>3星与4星标准线</span> 
							<input class="form-control three_four" name="three_four"/><br/>
							<span>4星与5星标准线</span> 
							<input class="form-control four_five" name="four_five"/><br/>
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
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
    var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/admin/starList";
	HZFPagination.pagetoParams = ["#selection"];
	HZFPagination.init();
	
	$(document).on('click', ".modify", function() {
		var lowest = $(this).attr("data-lowest");
		var three_four = $(this).attr("data-three_four");
		var four_five = $(this).attr("data-four_five");
		$(".lowest").val(lowest);
		$(".three_four").val(three_four);
		$(".four_five").val(four_five);
	});
	
	$(document).on('click', ".confirm", function() {
		var haveError = 0;
		if(isNaN($(".lowest").val().trim())  || isNaN($(".three_four").val().trim()) || isNaN($(".four_five").val().trim())) {
			alert("分数必须为数字！");
			haveError = 1;
		}
		if($(".lowest").val().trim().length == 0 || $(".three_four").val().trim().length == 0 || $(".four_five").val().trim().length == 0) {
			alert("标准线不能为空！");
			haveError = 1;
		}
		if(haveError == 1) {
			return;
		} else {
			ajax(proj + "/admin/modifyStar" + $("#jsessionid").val(), $("#star_form").serialize(), function(data) {
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
