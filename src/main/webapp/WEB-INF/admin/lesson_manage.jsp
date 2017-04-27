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
<title>课程管理 - 后台管理</title>
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
				<h3>课程管理</h3>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="col-lg-12" style="margin-top: 15px;">
					<button style="margin-left:1%" class="btn btn-success add" data-toggle="modal" data-target="#formModal">+新增课程</button>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>培训标题</th>
										<th>教师介绍</th>
										<th>地点</th>
										<th>开班时间</th>
										<th>周期</th>
										<th>价格</th>
										<th>优惠价</th>
										<th>优惠截止日期</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list }" var="list" varStatus="index">
										<tr>
											<td>${list.lessonTitle}</td>
											<td>${list.teacherIntroduce}</td>
											<td>${list.place}</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.lessonBeginDate}" /></td>
											<td>${list.duration }</td>
											<td>${list.price }</td>
											<td>${list.discountPrice }</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.lessonDiscountEndDate}" /></td>
											<td>
												<button class='btn btn-danger delete' data-id="${list.lessonId}">删除</button>
												<button class="btn btn-primary modify" data-id="${list.lessonId}" data-toggle="modal" data-target="#formModal"
													data-lessonTitle="${list.lessonTitle}"  data-teacherIntroduce="${list.teacherIntroduce}"  data-place="${list.place }" 
													data-lessonBeginDate="${list.lessonBeginDate }" data-duration="${list.duration }" data-price="${list.price }" 
													data-lessonDiscountEndDate="${list.lessonDiscountEndDate }" data-discountPrice="${list.discountPrice }">修改</button>
												<button class='btn btn-success content'  data-toggle="modal" data-target="#formModal_content" 
													data-id="${list.lessonId}"  data-lessonMsg="${list.lessonMsg}">培训内容</button>
												<button class='btn btn-info item'   data-toggle="modal" data-target="#formModal_item" 
													data-id="${list.lessonId}"  data-lessonItem="${list.lessonItem}">培训条款</button>
											</td>
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
					<h4 class="modal-title" id="H2">修改培训</h4>
				</div>
				<div class="modal-body">
					<form id="lesson_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="lessonId" name="id"/>
							<span>培训标题</span><br/>
							<input class="form-control lessonTitle" name="lessonTitle"/>
							<br/>
							<span>教师介绍</span><br/>
							<input class="form-control teacherIntroduce" name="teacherIntroduce"/>
							<br/>
							<span>培训地点</span><br/>
							<input class="form-control place" name="place"/>
							<br/>
							<span>开班时间</span><br/>
							<div style="width:200px;" class="input-group input-append date" id="dp3"  data-date="" data-date-format="yyyy-mm-dd">
								<input class="form-control simple_lessonBeginDate" type="text"  value="" readonly=""/> <span class="input-group-addon add-on"><i class="icon-calendar"></i></span>
								<input class="complete_lessonBeginDate" type="hidden" name="lessonBeginDate"/>
							</div>
							<br/>
							<span>培训周期</span><br/>
							<input class="form-control duration" name="duration"/>
							<br/>
							<span>原价</span><br/>
							<input class="form-control price" name="price"/>
							<br/>
							<span>优惠价</span><br/>
							<input class="form-control discountPrice" name="discountPrice"/>
							<br/>
							<span>优惠截止日期</span><br/>
							<div style="width:200px;" class="input-group input-append date" id="dp4"  data-date="" data-date-format="yyyy-mm-dd">
								<input class="form-control simple_lessonDiscountEndDate" type="text"  value="" readonly=""/> <span class="input-group-addon add-on"><i class="icon-calendar"></i></span>
								<input class="complete_lessonDiscountEndDate" type="hidden" name="lessonDiscountEndDate"/>
							</div>
							<br/>
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
	
	<div class="modal fade" id="formModal_content" tabindex="-1" >
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">修改培训内容</h4>
				</div>
				<div class="modal-body">
					<form id="lessonMsg_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="lessonId" name="lessonId"/>
							<span>培训内容</span>
							<textarea class="form-control content_area" name="lessonMsg" rows="10"></textarea>
							<br/>
							<br/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success confirm_content">确认</button>
					<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="formModal_item" tabindex="-1" >
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">修改培训条款</h4>
				</div>
				<div class="modal-body">
					<form id="lessonItem_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="lessonId" name="lessonId"/>
							<span>培训条款</span>
							<textarea class="form-control item_area" name="lessonItem" rows="10"></textarea>
							<br/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success confirm_item">确认</button>
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
	
	$(document).on('click', ".delete", function() {
		var lessonId = $(this).attr("data-id");
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/deleteLesson" + $("#jsessionid").val(), {lessonId : lessonId}, function(data) {
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
	
	$(document).on("click", ".modify", function() {
		$(".lessonId").val($(this).attr("data-id"));
		$(".lessonTitle").val($(this).attr("data-lessonTitle"));
		$(".place").val($(this).attr("data-place"));
		$(".price").val($(this).attr("data-price"));
		$(".discountPrice").val($(this).attr("data-discountPrice"));
		$(".duration").val($(this).attr("data-duration"));
		$(".teacherIntroduce").val($(this).attr("data-teacherIntroduce"));
		$(".simple_lessonBeginDate").val($(this).attr("data-lessonBeginDate").substring(0, 10));
		$(".complete_lessonBeginDate").val($(this).attr("data-lessonBeginDate"));
		$(".simple_lessonDiscountEndDate").val($(this).attr("data-lessonDiscountEndDate").substring(0, 10));
		$(".complete_lessonDiscountEndDate").val($(this).attr("data-lessonDiscountEndDate"));
		
	});
	
	$(document).on("click", ".content", function() {
		$(".lessonId").val($(this).attr("data-id"));
		$(".content_area").val($(this).attr("data-lessonMsg"));
	});
	
	$(document).on("click", ".item", function() {
		$(".lessonId").val($(this).attr("data-id"));
		$(".item_area").val($(this).attr("data-lessonItem"));
	});
	
	$(document).on("click", ".confirm", function() {
		var haveError = 0;
		if($(".lessonTitle").val().trim().length == 0) {
			alert("请正确填写培训标题！");
			haveError = 1;
		}
		if($(".teacherIntroduce").val().trim() == 0) {
			alert("请正确填写教师介绍！");
			haveError = 1;
		}		
		if($(".place").val().trim() == 0) {
			alert("请正确填写培训地点！");
			haveError = 1;
		}	
		if($(".complete_lessonBeginDate").val().trim() == 0) {
			alert("请正确填写开课时间！");
			haveError = 1;
		} else {
			$(".complete_lessonBeginDate").val($(".simple_lessonBeginDate").val() + " 00:00:00.0");
		}
		if($(".complete_lessonDiscountEndDate").val().trim() == 0) {
			alert("请正确填写优惠截止时间！");
			haveError = 1;
		} else {
			$(".complete_lessonDiscountEndDate").val($(".simple_lessonDiscountEndDate").val() + " 00:00:00.0");
		}
		if($(".duration").val().trim() == 0) {
			alert("请正确填写培训周期！");
			haveError = 1;
		}
		if($(".price").val().trim() == 0) {
			alert("请正确填写原价！");
			haveError = 1;
		}
		if($(".discountPrice").val().trim() == 0) {
			alert("请正确填写优惠价！");
			haveError = 1;
		}
		if(haveError == 1) {
			return;
		} else {
			ajax(proj + "/admin/modifyLesson" + $("#jsessionid").val(), $("#lesson_form").serialize(), function(data) {
				if(data == "success") {
					location.href = location.href;
				} else {
					alert(data);
				}
			});
		}
	});
	
	$(document).on("click", ".confirm_content", function() {
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/modifyLessonMsg" + $("#jsessionid").val(), $("#lessonMsg_form").serialize(), function(data) {
				if(data == "success") {
					location.href = location.href;
				} else {
					alert(data);
				}
			});
		}
	});
	
	$(document).on("click", ".confirm_item", function() {
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/modifyLessonItem" + $("#jsessionid").val(), $("#lessonItem_form").serialize(), function(data) {
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
