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
<title>用户管理 - 后台管理</title>
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
				<h3>用户管理</h3>
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
                   			<option id="mobile" value="mobile" <c:if test="${condition == mobile }"> selected</c:if>>联系电话</option>
							<option id="idCard" value="idCard"  <c:if test="${condition == idCard }"> selected</c:if>>身份证号</option>
                   		</select>
                		<input style="width: 120px" class="form-control search-input value" value="${value}"/>
						&nbsp;
						用户状态： 
						<select style="width:120px"class="form-control search-input userStatus" value="${userStatus }">
							<option value="" <c:if test="%{userStatus == null }"> selected</c:if>>全部</option>
							<option value="1" <c:if test="%{userStatus == '1' }"> selected</c:if>>正常使用</option>
							<option value="0" <c:if test="%{userStatus == '0' }"> selected</c:if>>已冻结</option>
						</select> 
						&nbsp;
						性别：
                		<select style="width:120px" class="form-control search-input gender" value="${gender }">
                			<option value="" <c:if test='value == null'> selected</c:if>>-请选择-</option>
               				<option value="1" <c:if test='value == "1"'> selected</c:if>>男</option>
							<option value="0"  <c:if test='value == "0"'> selected</c:if>>女</option>
               			</select>
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
										<th>昵称</th>
										<th>性别</th>
										<th>联系电话</th>
										<th>用户等级</th>
										<th>创建时间</th>
										<th>最后登录</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.list }" var="list" varStatus="index">
										<tr>
											<!-- <td>${index.index + ((pagenation.page-1) * 10) + 1}</td> -->
											<td>${(requestScope.pagenation.page-1)*10+1+index.index}</td>
											<td>${list.userName}</td>
											<td>
												<c:if test="${list.gender==1}">男</c:if>
												<c:if test="${list.gender==0}">女</c:if>
												<c:if test="${list.gender==null}">未知</c:if>
											</td>
											<td>${list.mobile}</td>
											<td>
												<c:if test="${list.rankPower==1}">VIP</c:if>
											</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${list.createTime}" /></td>
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${list.lastTime}" /></td>
											<td>
											<!-- 
												<button class='btn <c:if test="${list.userStatus==1}">btn-danger</c:if><c:if test="${list.userStatus==0}">btn-success</c:if> dongjie' data-id="${list.userId}" data-userStatus="${list.userStatus}">
													<c:if test="${list.userStatus==1}">冻结</c:if><c:if test="${list.userStatus==0}">解冻</c:if>
												</button>
												 -->
												<button class="btn btn-primary details" data-id="${list.userId}">详情</button>
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
<script>
       $(function () { formInit(); });
</script>
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
    var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/admin/userList";
	HZFPagination.pagetoParams = [".condition", ".value", ".userStatus", ".gender", ".begin", ".end", "#selection" ];
	HZFPagination.init();
	HZFPagination.screen(".choose");
	HZFPagination.pageToJump(".details", "/admin/userDetails", "userId=");
	$(document).on('click', ".dongjie", function() {
		var userId = $(this).attr("data-id");
		var userStatus = $(this).attr("data-userStatus");
		if (userStatus == 1) {
			userStatus = 0;
		} else {
			userStatus = 1;
		}
		if (confirm("确认操作？")) {
			ajax(proj + "/admin/optionUser" + $("#jsessionid").val(), {userId : userId, userStatus : userStatus}, function(data) {
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
