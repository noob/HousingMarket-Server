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
	String path = request.getScheme() + "://" + request.getServerName()
			+ port + "/SchoolGuider";
%>

<!DOCTYPE html>
<html class="webkit win">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
@charset "UTF-8";

[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not
	(.ng-hide-animate ) {
	display: none !important;
}

ng\:form {
	display: block;
}

.li-online {
	font-size: 1.4rem;
	float: left;
}

.li-online p {
	font-size: 1.1rem;
	display: inline;
}

.li-online span {
	font-size: 1.75rem;
	color: #00afcc;
}
</style>
<meta charset="utf-8">
<title>高校专业推荐系统 | 大学</title>
<link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
<link rel="stylesheet"
	href="<%=path%>/css/schoolguider/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
<link rel="stylesheet" href="<%=path%>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">
	<jsp:include page="../web/common.jsp"></jsp:include>

	<div class="div-max" style="margin:8% auto">

		<div class="div-body" style="width: 10%;height: 100%;">
			<dl class="div-body-left">
				<dd>
					<h5 style="margin-left: 2%">查询条件:</h5>
					<select style="width:120px; background-image:url(<%=path%>/img/black.png);" class="form-control search-input condition" value="${condition }">
						<option value="" <c:if test="${condition == null }"> selected</c:if>>-请选择-</option>
						<option id="schoolCode" value="schoolCode" <c:if test="${condition == 'schoolCode' }"> selected</c:if>>学校代码</option>
						<option id="schoolName" value="schoolName" <c:if test="${condition == 'schoolName' }"> selected</c:if>>学校名字</option>
						<option id="schoolRegion" value="schoolRegion" <c:if test="${condition == 'schoolRegion' }"> selected</c:if>>所属省份</option>
					</select> 
					<input style="width: 120px; margin-top:5px;" placeholder="请输入" class="form-control search-input value" value="${value}" />
				</dd>
				<dd onclick="choicetest('course',3)">
					<ul>
						<input type="hidden" class="subject1" value="${subject1 }" />
						<input type="hidden" class="subject2" value="${subject2 }" />
						<input type="hidden" class="subject3" value="${subject3 }" />
						<h5 class="subject" value="${subject }">选考科目</h5>
						<li><input type="checkbox" name="course" title="物理"
							value="物理">物理</input></li>
						<li><input type="checkbox" name="course" title="化学"
							value="化学">化学</input></li>
						<li><input type="checkbox" name="course" title="生物"
							value="生物">生物</input></li>
						<li><input type="checkbox" name="course" title="地理"
							value="地理">地理</input></li>
						<li><input type="checkbox" name="course" title="历史"
							value="历史">历史</input></li>
						<li><input type="checkbox" name="course" title="思想政治"
							value="思想政治">思想政治</input></li>
						<li><input type="checkbox" name="course" title="技术"
							value="技术">技术</input></li>
					</ul>
				</dd>
				<dd>
					<button id="ok" style="margin-top: 5px; " class="btn btn-dark choose" data-href="<%=response.encodeUrl(path+"/user/majorInSchool?pagenation.page=1")%>">筛选</button>
				</dd>
			</dl>
		</div>

		<div style="margin-left:13%">
			<div>
				<input type="hidden" class="majorId" value="${major.majorId }" />
				<h3 style="margin-left:2%;padding-top: 1%">${major.majorName}</h3>
			</div>
			
			<c:if test="${pagenation.total > 0}">
				<table class="table table-striped table-bordered table-hover" >
					<thead>
		                <tr>
			                <th style="text-align: center">大学名称</th>
			                <th style="text-align: center">所属省份</th>
			                <th style="text-align: center">专业或类名称</th>
							<th style="text-align: center">选考科目要求</th>
							<th style="text-align: center">层次</th>
							<th style="text-align: center">专业星级</th>
				         </tr>
			         </thead>
			         <tbody>
	       				<c:forEach items="${list }" var="list" varStatus="index">
				         	<tr>
		       					<td style="text-align: center">${list.schoolName }</td>
		       					<td style="text-align: center">${list.schoolRegion }</td>
		       					<td style="text-align: center">${list.cate }</td>
		       					<td style="text-align: center">
		       						<c:choose>
										<c:when test="${list.subject != null && list.subject.length() > 0}">${list.subject }</c:when>
										<c:otherwise>无</c:otherwise>
									</c:choose>
		       					</td>
		       					<td style="text-align: center">${list.level }</td>
		       					<td style="text-align: center">${list.recommend }</td>
		        			</tr>
	       				</c:forEach>
			         </tbody>
	        	</table>
	        </c:if>
			<button  class="btn btn-dark back"> 返回上一步</button>
			<c:choose>
				<c:when test="${pagenation.total > 0}">
					<div style="float:right; width: 70%">
						<div id="Pagination" class="pagination" style="float:right; position:relative; "></div>
						<input type="hidden" value="${pagenation.total}" id="num_entries" />
						<input type="hidden" value="${pagenation.page}" id="current_page" />
					</div>
				</c:when>
				<c:otherwise>
					<div class="div-body" style="margin-left:5%; width: 85%">
						<h2 style="text-align: center;">没有大学开设此专业</h2>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- List DIV end -->

	<!-- Login from begin -->
	<div class="modal fade" id="loginFormModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">登录</h4>
				</div>
				<div class="modal-body">
					<form id="login_form" class="form-signin" method="post">
						<div>
							<input type="text" placeholder="请输入账户名"
								class="form-control userName" name="userName" title="请输入账户名" />
							<div style="color:red; margin-top: 6px; height:15px;">
								<span id="login_error_text_name">&nbsp;&nbsp;用户名应为5-11个字符</span>
							</div>
						</div>
						<br />
						<div>
							<input type="password" placeholder="请输入密码"
								class="form-control password" name="password" title="请输入密码" />
							<div style="color:red; margin-top: 6px; height:15px;">
								<span id="login_error_text_password">&nbsp;&nbsp;密码应为6-18个字符</span>
							</div>
						</div>
						<div style="color:red; margin-top: 6px; height:15px;">
							<span id="msg"
								style="line-height:20px; text-align:center; display:block"></span>
						</div>
						<br />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary login">登录</button>
					<button type="button" class="btn btn-default cancel"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Login from end -->
	<!-- Regist from begin -->
	<div class="modal fade" id="registFormModal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">注册</h4>
				</div>
				<div class="modal-body">
					<form id="regist_form" method="post">
						<div class="form-group">
							<div>
								<input class="form-control regist_userName"
									name="regist_userName" placeholder="用户名" />
								<div style="color:red; margin-top: 6px; height:15px;">
									<span id="error_text_name">&nbsp;&nbsp;用户名应为5-11个字符</span>
								</div>
							</div>
							<br />
							<div>
								<input class="form-control regist_password"
									name="regist_password" placeholder="密码" />
								<div style="color:red; margin-top: 6px; height:15px;">
									<span id="error_text_password">&nbsp;&nbsp;密码应为6-18个字符</span>
								</div>
							</div>
							<div style="color:red; margin-top: 6px; height:15px;">
								<span id="msg"
									style="line-height:20px; text-align:center; display:block"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary regist">注册</button>
					<button type="button" class="btn btn-default cancel"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Regist from begin -->


</body>
<script src="<%=path%>/js/schoolguider/vendors.min.3924f1bd79c3.js"></script>
<script src="<%=path%>/js/schoolguider/base.78759ea33cfe.js"></script>
<script src="<%=path%>/js/schoolguider/website.d6ab10c0b75c.js"></script>
<script src="<%=path%>/js/schoolguider/jquery.1.11.1.js"></script>
<script src="<%=path%>/js/bootstrap.js"></script>
<script src="<%=path%>/js/schoolguider/account.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.pagination.js"></script>
<script src="<%=path%>/js/common.js"></script>
<script type="text/javascript">
	$(function () { formInit(); });
	account.regist();
	account._login();
	
	$(document).on("click", ".back", function() {
			location.href = history.go(-1);
		});
	
	var proj = "<%=path%>";
	HZFPagination.pagetoUrl = "/user/majorInSchool";
	HZFPagination.pagetoParams = [ ".condition", ".value", ".majorId", ".subject1", ".subject2", ".subject3"];
	HZFPagination.init();
	HZFPagination.pageToJump(".detail", "/user/schoolDetails", "schoolId=");

	$(".search_key").bind("keypress", function(event) {
		if (event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});

	//复选框 最多3选
	function choicetest(name, num) {
		var choicearr = document.getElementsByName(name);
		var a = 0;
		for ( var i = 0; i < choicearr.length; i++) {
			if (choicearr[i].checked) {
				a = a + 1;
			}
		}
		if (a == num) {
			for ( var i = 0; i < choicearr.length; i++) {
				if (!choicearr[i].checked) {
					choicearr[i].disabled = 'disabled';
				}
			}
		} else {
			for ( var i = 0; i < choicearr.length; i++) {
				choicearr[i].removeAttribute('disabled');
			}
		}
	}

	//回显checkbox
	var sub = "${requestScope.subject }";
	$(".subject").val(sub);
	$("input[name='course']").each(function() {
		if (sub.indexOf($(this).val()) != -1) {
			$(this).attr("checked", true);
		}
	});
	choicetest('course', 3);

	//确认按钮
	$(document).on("click", "#ok", function() {
		var flag = 0;
		var choice = document.getElementsByName("course");
		var a = 0;
		for ( var i = 0; i < choice.length; i++) {
			if (choice[i].checked) {
				a = a + 1;
			}
		}
		if (a == 1 || a ==2) {
			flag = 1;
			alert("请选择满3项科目");
			return;
		}
	
		var ok = $(this).attr("data-href");
		//选择框
		var con = $(".condition").val();
		var val = $(".value").val();
		if (val != null && val.length > 0) {
			ok += "&condition=" + con + "&value=" + val;
		}
		//多选按钮
		var str = "";
		var array = new Array();
		$("input[name='course']:checked").each(function() {
			str += $(this).val() + ",";
		});
		array = str.split(",");
		if (array[0] != null && array[0].length > 0) {
			ok += "&subject1=" + array[0];
		}
		if (array[1] != null && array[1].length > 0) {
			ok += "&subject2=" + array[1];
		}
		if (array[2] != null && array[2].length > 0) {
			ok += "&subject3=" + array[2];
		}
		ok += "&majorId=" + $(".majorId").val();
		if (array[0] != null && array[0].length > 0) {
			var identity = ${sessionScope.USER_SESSION_KEY.mobile } + "";
			if (identity == 0) {
				location.href = proj + "/user_login_ui";
			} else {
				location.href = ok;
			}
		} else {
			location.href = ok;
		}
	});
</script>
</html>
