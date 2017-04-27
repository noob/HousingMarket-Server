<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

 <!-- BEGIN HEAD -->
<head>
     <meta charset="UTF-8" />
    <title> 文件管理 - 后台管理 </title>
     <meta content="width=device-width, initial-scale=1.0" name="viewport" />
     <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <link rel="stylesheet" href="<%=path%>/css/pagination.css">
	<link rel="stylesheet" href="<%=path%>/plugins/datepicker/css/datepicker.css" />
	<link href="<%=path%>/css/bootstrap-fileupload.min.css" rel="stylesheet">
	<jsp:include page="../frame/super/header.jsp"></jsp:include>
	<jsp:include page="../frame/super/menu.jsp"></jsp:include>

        <!--PAGE CONTENT -->
        <div id="content">
            <div class="inner">
                <div class="row">
                    <div class="col-lg-12">
                        <h3> 文件管理 </h3>
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
							<option id="fileName" value="fileName"
								<c:if test="${condition == 'fileName' }"> selected</c:if>>文件名字</option>
							<option id="fileType" value="fileType"
								<c:if test="${condition == 'fileType' }"> selected</c:if>>文件类型</option>
							<option id="fileRemark" value="fileRemark"
								<c:if test="${condition == 'fileRemark' }"> selected</c:if>>描述关键字</option>
						</select> 
						<input style="width: 120px" class="form-control search-input value" value="${value}" /> <br />
						<br />
						<div style="text-align:center">
							<span style="margin-top: 5px;float: left;vertical-align:middle">创建时间：</span>
							<div style="width:240px;float:left"
								class="input-group input-append date" id="dp3"
								data-date="${begin}" data-date-format="yyyy-mm-dd">
								<input class="form-control begin" type="text" value="${begin}"
									readonly=""> <span class="input-group-addon add-on"><i
									class="icon-calendar"></i></span>
								&nbsp;&nbsp;&nbsp;到&nbsp;&nbsp;&nbsp;
							</div>
							<div style="width:200px;float:left"
								class="input-group input-append date" id="dp4"
								data-date="${end}" data-date-format="yyyy-mm-dd">
								<input class="form-control end" type="text" value="${end}"
									readonly=""> <span class="input-group-addon add-on"><i
									class="icon-calendar"></i></span>
							</div>
						</div>
						&nbsp;&nbsp;
						<button class="btn btn-dark choose">筛选</button>
						&nbsp;&nbsp;
						<button class="btn btn-success addMajor" data-toggle="modal"
							data-target="#formModal">+上传文件</button>
					</div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>编号</th>
											<th>文件名字</th>
 											<th>文件类型</th>
											<th>上传时间</th>
											<th>描述</th>
											<th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.list }" var="list" varStatus="index">
											<tr>
												<td>${(requestScope.pagenation.page-1)*10+1+index.index}</td>
												<td>${list.fileName}</td>
												<td>${list.fileType}</td>
												<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.createTime}" /></td>
												<td>${list.fileRemark}</td>
												<td>
													<button class="btn btn-danger delete" data-id="${list.fileId}">删除</button>
													<!-- 
													<button class="btn btn-info download" data-id="${list.fileId}">下载</button>
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
						<h4 class="modal-title" id="H2">上传文件</h4>
					</div>
					<div class="modal-body">
						<form id="upload_form"  method="post">
							<div class="form-group">
								 <div class="fileupload fileupload-new" data-provides="fileupload">
	                            	<input type="hidden" name="fileName" value=""  class="file">
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
						<button type="button" class="btn btn-success confirm">确认</button>
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
     <script>
        $(function () { formInit(); });
        
    	var proj = "<%=path %>";
    	HZFPagination.pagetoUrl = "/admin/fileList";
		HZFPagination.pagetoParams = [".condition", ".value", ".begin", ".end", "#selection" ];
		HZFPagination.init();
		HZFPagination.screen(".choose");
    	var inputs = new Array(".file");
    	 $(document).on('click',".confirm",function(){
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
			ajaxFileUpload("<%=path %>/admin/uploadFile"+ $("#jsessionid").val(), "#upload_form", function(data) {
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
		
  	    $(document).on('click',".delete",function(){
			var fileId = $(this).attr("data-id");
			if(confirm("确认操作？")){
				ajax(proj+"/admin/deleteFile"+$("#jsessionid").val(), {fileId:fileId}, function(data) {
					if(data=="no"){
						alert("删除失败！");
					}else if (data=="error") {
						alert("出现未知错误！");
					}else {
						location.href=location.href;
					}
				});
			}
		});
		
    </script>
</body>
</html>
