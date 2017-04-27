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
<link href="<%=path%>/css/bootstrap-fileupload.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path %>/plugins/datepicker/css/datepicker.css" />
<jsp:include page="../frame/super/header.jsp"></jsp:include>
<jsp:include page="../frame/super/menu.jsp"></jsp:include>

<!--PAGE CONTENT -->
<div id="content">
	<div class="inner">
		<div class="row">
			<div class="col-lg-12">
				<h3>学校管理</h3>
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
                   			<option id="schoolCode" value="schoolCode" <c:if test="${condition == 'schoolCode' }"> selected</c:if>>学校代码</option>
							<option id="schoolName" value="schoolName"  <c:if test="${condition == 'schoolName' }"> selected</c:if>>学校名字</option>
							<option id="schoolRegion" value="schoolRegion"  <c:if test="${condition == 'schoolRegion' }"> selected</c:if>>所属省份</option>
                   		</select>
                		<input style="width: 120px" class="form-control search-input value" value="${value}"/>
						&nbsp;&nbsp;
						<button class="btn btn-dark choose">筛选</button>
						&nbsp;&nbsp;<button class="btn btn-success addSchool" data-toggle="modal" data-target="#formModal">+添加学校</button>
						&nbsp;&nbsp;<button class="btn btn-success import" data-toggle="modal" data-target="#fileModal">+导入Excel</button>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							<table class="table table-striped table-bordered table-hover" id="dataTables-example">
								<thead>
									<tr>
										<th>编号</th>
										<th>学校代码</th>
										<th>学校名字</th>
										<th>所属地区</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.list }" var="list" varStatus="index">
										<tr>
											<td>${(requestScope.pagenation.page-1)*10+1+index.index}</td>
											<td>${list.schoolCode}</td>
											<td>${list.schoolName}</td>
											<td>${list.schoolRegion}</td>
											<td>
												<button class="btn btn-danger delete" data-id="${list.schoolId}">删除</button>
												<!-- 
												<button class="btn btn-info details" data-id="${list.schoolId}">详情</button>
												 -->
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
					<h4 class="modal-title" id="H2">添加学校</h4>
				</div>
				<div class="modal-body">
					<form id="school_form"  method="post">
						<div class="form-group">
							<input type="hidden" value=""  class="id" name="schoolId"/>
							<span>填写学校代码</span>
							<input class="form-control schoolCode" name="schoolCode"/><br/>
							<span>填写学校名字</span> 
							<input class="form-control schoolName" name="schoolName"/><br/>
							<span>填写学校所属省份</span> 
							<input class="form-control schoolRegion" name="schoolRegion"/><br/>
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
	
	<!-- 导入文件 -->
	       <div class="modal fade" id="fileModal" tabindex="-1" >
				<div class="modal-dialog">
					<div class="modal-content" style="width: 400px;margin-left:100px">
						<div class="modal-header">
							<h4 class="modal-title" >导入Excel</h4>
						</div>
						<div class="modal-body">
							<form id="upload_form"  method="post">
								<div class="form-group">
									 <div class="fileupload fileupload-new" data-provides="fileupload">
		                                <div class="fileupload-preview thumbnail" style="width: 200px; height: 150px; line-height: 150px;">
		                                		<img src="" id="file_img">
		                                </div>
		                                <div>
		                                    <span class="btn btn-file btn-success">
		                                    <span class="fileupload-new">选择</span>
		                                    <span class="fileupload-exists">更改</span>
		                                    <input type="file" id="file" name="file"  class="fileChoose" /></span>
		                                    <a class="btn btn-danger fileupload-exists" href="#" data-dismiss="fileupload">清除</a>
		                                </div>
		                            </div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-success sure">确认</button>
							<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
						</div>
					</div>
				</div>
			</div>
			<div class="mask"><br/>
				<img src="<%=path%>/img/loading.gif" /><br/><br/>
				<span>文件上传中，请稍后</span>
			</div>
	
</div>
<jsp:include page="../frame/super/footer.jsp"></jsp:include>
<script src="<%=path %>/plugins/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="<%=path %>/plugins/jasny/js/bootstrap-fileupload.js"></script>
<script src="<%=path %>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
	$(function () { formInit(); });
    var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/admin/schoolList";
	HZFPagination.pagetoParams = [".condition", ".value", "#selection"];
	HZFPagination.init();
	HZFPagination.screen(".choose");
	HZFPagination.pageToJump(".details", "/admin/schoolDetails", "schoolId=");
	$(document).on('click', ".delete", function() {
		var schoolId = $(this).attr("data-id");
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/deleteSchool" + $("#jsessionid").val(), {schoolId : schoolId}, function(data) {
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
	$(document).on('click', ".confirm", function() {
		var haveError = 0;
		if($(".schoolCode").val().trim().length == 0) {
			alert("学校代码不能为空！");
			haveError = 1;
		}
		if($(".schoolName").val().trim().length == 0) {
			alert("学校名字不能为空！");
			haveError = 1;
		}
		if(haveError == 1) {
			return;
		} else {
			ajax(proj + "/admin/addSchool" + $("#jsessionid").val(), $("#school_form").serialize(), function(data) {
				if(data == "success") {
					location.href = location.href;
				} else {
					alert(data);
				}
			});
		}
	});
	
	var inputs = new Array(".file");
    	 $(document).on('click',".sure",function(){
    	 	var haveError = 0;
    		for(var i=0; i < inputs.length; i++){
	    		if(inputs[i].indexOf("file") > 0){
					if(empty(".fileChoose")){
						if(empty(inputs[i])){
							alert("文件不能为空!");
		    				$(".fileChoose").focus();
		    				haveError = 1;
	    				} else{
		    				continue;
	    				}
					}
				} else 
	    			if(empty(inputs[i])){
	    				$(inputs[i]).focus();
	    				haveError = 1;
	    			}
    		}
    		if(haveError == 1){
    			return;
    		}
			ajaxFileUpload("<%=path %>/admin/importSchool"+ $("#jsessionid").val(), "#upload_form", function(data) {
					if(data=="no"){
						$(".mask").hide(50);
						alert("缺少必要参数");
					} else if (data=="error") {
						$(".mask").hide(50);
						alert("出现未知错误！");
					}  else {
						location.href=location.href;
					}
				});
			});
</script>
</body>
</html>
