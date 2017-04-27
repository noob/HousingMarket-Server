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
<title>题目管理 - 后台管理</title>
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
				<h3>题目管理</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="col-lg-12" style="margin-top: 15px;">
						查询条件：
						<select style="width:120px" class="form-control search-input condition" value="${condition }"> 
                   			<option value="" <c:if test="${condition == null }"> selected</c:if>>-请选择-</option>
                   			<option id="question" value="question" <c:if test="${condition == 'question'}"> selected</c:if>>问题内容</option>
                   		</select>
                		<input style="width: 120px" class="form-control search-input value" value="${value}"/>
						&nbsp;&nbsp;<button class="btn btn-dark choose">筛选</button>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>编号</th>
										<th>问题</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="list" varStatus="index">
										<tr>
											<td>${(pagenation.page-1)*10+1+index.index}</td>
											<td>${list.question}</td>
											<td>
												<button class="btn btn-info modify" data-id="${list.questionId}" data-q="${list.question }" data-toggle="modal" data-target="#formModal"> 修改 </button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div id="Pagination" class="pagination" style="float:right; position:relative; "></div>
						<input type="hidden" value="${pagenation.total}" id="num_entries" />
						<input type="hidden" value="${pagenation.page}" id="current_page" />
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
					<h4 class="modal-title" id="H2">修改问题</h4>
				</div>
				<div class="modal-body">
					<form id="question_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="id" name="questionId"/>
							<span>问题内容</span>
							<input class="form-control question" name="question"/><br/>
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
	HZFPagination.pagetoUrl = "/admin/questionList";
	HZFPagination.pagetoParams = [".condition", ".value", "#selection" ];
	HZFPagination.init();
	HZFPagination.screen(".choose");
	HZFPagination.pageToJump(".details", "/admin/schoolDetails", "questionId=");
	
	$(document).on("click", ".modify", function() {
		$(".id").val($(this).attr("data-id"));
		$(".question").val($(this).attr("data-q"));
	});
	
	$(document).on('click', ".confirm", function() {
		var haveError = 0;
		if($(".question").val().trim().length == 0) {
			alert("问题不能为空！");
			haveError = 1;
		}
		if(haveError == 1) {
			return;
		} else {
			ajax(proj + "/admin/modifyQuestion" + $("#jsessionid").val(), $("#question_form").serialize(), function(data) {
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
