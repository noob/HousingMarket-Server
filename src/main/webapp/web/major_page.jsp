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
        .li-online{
        	font-size: 1.4rem;
            float: left;
        }
        .li-online p{
        	font-size: 1.1rem;
            display: inline;
        }
        .li-online span{
            font-size: 1.75rem;
            color: #00afcc;
        }
    </style>
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 专业</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">

    <jsp:include page="../web/common.jsp"></jsp:include>

    <div class="div-max" style="margin:6% auto;">
        <div>
        	<table class="table table-striped table-bordered table-hover" >
        		<c:forEach begin="0"  end="${list.size()/5 }" varStatus="index">
        			<tr>
        				<c:forEach items="${list }" var="list" varStatus="flag" begin="${index.index*5 }" end="${index.index*5+4 }">
        					<td style="text-align: center">${list.majorName }</td>
        				</c:forEach>
        			</tr>
        		</c:forEach>
        	</table>
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
									<input type="text" placeholder="请输入账户名" class="form-control userName" name="userName" title="请输入账户名" />
									<div style="color:red; margin-top: 6px; height:15px;">
										<span id="login_error_text_name">&nbsp;&nbsp;用户名应为5-11个字符</span>
									</div>
								</div>
								<br />
								<div>
									<input type="password" placeholder="请输入密码" class="form-control password" name="password" title="请输入密码" />
									<div style="color:red; margin-top: 6px; height:15px;">
										<span id="login_error_text_password">&nbsp;&nbsp;密码应为6-18个字符</span>
									</div>
								</div>
								<div style="color:red; margin-top: 6px; height:15px;">
									<span id="msg" style="line-height:20px; text-align:center; display:block"></span>
								</div>
								<br />
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary login">登录</button>
							<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
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
										<input class="form-control regist_userName" name="regist_userName" placeholder="用户名" />
										<div style="color:red; margin-top: 6px; height:15px;">
											<span id="error_text_name">&nbsp;&nbsp;用户名应为5-11个字符</span>
										</div>
									</div>
									<br />
									<div>
										<input class="form-control regist_password" name="regist_password" placeholder="密码" />
										<div style="color:red; margin-top: 6px; height:15px;">
											<span id="error_text_password">&nbsp;&nbsp;密码应为6-18个字符</span>
										</div>
									</div>
									<div style="color:red; margin-top: 6px; height:15px;">
										<span id="msg" style="line-height:20px; text-align:center; display:block"></span>
									</div>
								</div>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary regist">注册</button>
							<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
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
<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
	$(function () { formInit(); });
	account.regist();
	account._login();
	
	var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/user/majorList";
	HZFPagination.pagetoParams = [".condition", ".value", ".subject1", ".subject2", ".subject3", ".department"];
	HZFPagination.init();
	HZFPagination.detailToList(".all", "/user/majorInSchool", "majorId=");
	
	//回显checkbox
	var sub = "${requestScope.subject }";
	$(".subject").val(sub);
	$("input[name='course']").each(function() {
		if(sub.indexOf($(this).val()) != -1) {
			$(this).attr("checked", true);
		}
	});
	choicetest('course',3);
	
	//回显文科理科
	var dep = "${requestScope.department}";
	if(dep == 1) {
		$("#wenke").attr("checked", true);
		$(".department").val(1);
	} else if(dep == 2) {
		$("#like").attr("checked", true);
		$(".department").val(2);
	} else {
		$("#buxian").attr("checked", true);
		$(".department").val("");
	}

	//搜索框	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});
	
	//确认按钮
	$(document).on("click", "#ok", function() {
		var ok = $(this).attr("data-href");
		//选择框
		var con = $(".condition").val();
		var val = $(".value").val();
		if(val != null && val.length > 0) {
			ok += "&condition=" + con + "&value=" + val ;
		}
		//多选按钮
		var str = "";
		var array = new Array();
		$("input[name='course']:checked").each(function() {
			str += $(this).val() + ",";
		});
		array = str.split(",");
		if(array[0] != null && array[0].length > 0) {
			ok += "&subject1=" + array[0];
		}
		if(array[1] != null && array[1].length > 0) {
			ok += "&subject2=" + array[1];
		}
		if(array[2] != null && array[2].length > 0) {
			ok += "&subject3=" + array[2];
		}
		//单选按钮
		var rad = $("input:radio[name=dep]:checked").val();
		ok+="&department=" + rad;
		location.href = ok;
	});
	
	//复选框 最多3选
    function choicetest(name,num) {
        var choicearr = document.getElementsByName(name);
        var a=0;
        for(var i=0; i<choicearr.length; i++) {
            if(choicearr[i].checked){
                a = a + 1;
            }
        }
        if(a == num){
            for(var i=0; i<choicearr.length; i++) {
            	 if(!choicearr[i].checked) {
            	 	choicearr[i].disabled = 'disabled';
            	 }
            }
        }else{
            for(var i=0; i<choicearr.length; i++) {
            	choicearr[i].removeAttribute('disabled');
            }
        }
    }
	
</script>
</html>
