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
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 搜索</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">
	<style type="text/css">
		.li-online{
			float: left;
		}
		.li-online p{
			display: inline;
		}
		.li-online span{
			font-size: 1.75rem;
			color: #00afcc;
		}
	</style>
</head>

<body ng-app="lyr.website" class="ng-scope">

    <jsp:include page="../web/common.jsp"></jsp:include>

    <div class="div-max" style="margin:6% auto">
    	<div class="div-body" style="width: 10%;height: 100%;">
            <div class="naniu" id="sp1" onclick="operate(this)">
                <a><span>> </span><p>大学</p></a>
            </div>
            <div class="naniu" id="sp2" onclick="operate(this)">
                <a><span>> </span><p>专业</p></a>
            </div>
        </div>
    	<div id="ps2" class="college-open" style="margin-left: 10%">
	    	<c:choose>
				<c:when test="${list_school != null && list_school.size() > 0}">
						<c:forEach items="${list_school }" var="list_school" varStatus="index_s">
					        <div class="div-body" style="background-color:whitesmoke; margin-left:5%; width: 85%;">
					            <ul>
					                <li style="margin-top: 1%; margin-bottom: 1%">
					                    <img class="li-inline" src="<%=path %>/img/index.jpg" style="width: 25%; height: auto; padding-left: 1%">
					                    <div class="li-inline" style="padding-left: 10%; width: 30%; padding-top: 1%">
					                        <h2><a href="" title="中国人民大学" target="_blank">${list_school.schoolName }</a></h2>
					                        <p>位置：${list_school.schoolRegion }</p>
					                        <p>学费：5000-6000元/年</p>
					                        <p class="operation_btn">
					                            <a class="btn btn-mini test_my_probability detail" data-id="${list_school.schoolId }"  target="_blank">详细</a>
					                        </p>
					                    </div>
					                    <div class="li-inline" style="width: 30%; padding-top: 1%;margin-left: 10%;">
					                        <h3>学校详情</h3>
					                        <cite>（RenminUniversityofChina）是一所以人文社会科学为主的综合性研究型全国重点大学，直属于教育部，由教育部与北京市共建。学校的前身是1937年诞生于抗日战争烽火中的陕北公..</cite>
					                    </div>
					                </li>
					            </ul>
					        </div>
				        </c:forEach>
					        <!-- List unit end -->
				</c:when>
				<c:otherwise><h1 style="text-align: center;">查询到0条信息</h1></c:otherwise>
			</c:choose>
		</div>
    	<div id="ps1" class="mojor-close" style="margin-left: 10%">
	    	<c:choose>
				<c:when test="${list_major != null && list_major.size() > 0}">
						<c:forEach items="${list_major }" var="list_major" varStatus="index_m">
					        <div class="div-body" style="background-color:whitesmoke; margin-left:5%; width: 85%;">
								<ul>
									<li style="margin-top: 1%; margin-bottom: 1%">
										<div class="li-online" style="padding-left: 10%; padding-top: 1%">
											<p><span>${list_major.majorName }</span></p>
											<p>所选文理: &nbsp<c:if test="${list_major.department == 0 || list_major.department == null || list_major.department <1}">不限</c:if><c:if test="${list_major.department == 1}">文科</c:if><c:if test="${list_major.department == 2}">理科</c:if></p>
										</div>
									</li>
								</ul>
							</div>
				        </c:forEach>
					        <!-- List unit end -->
				</c:when>
				<c:otherwise><h1 style="text-align: center;">查询到0条信息</h1></c:otherwise>
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
	HZFPagination.pageToJump(".detail", "/user/schoolDetails", "schoolId=");
	var proj = "<%=path %>";
	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});
	
    function operate(event) {
            if(event.id == "sp1") {
                var sp1 = document.getElementById("sp1");
                var sp2 = document.getElementById("sp2");
                var child1 = document.createElement("div");
                var child2 = document.createElement("div");
                sp1.className = "newdiv";
                sp2.className = "naniu";
                sp1.appendChild(child1);
                sp2.appendChild(child2);

                var ps1 = document.getElementById("ps1");
                var ps2 = document.getElementById("ps2");
                var child3 = document.createElement("ul");
                var child4 = document.createElement("div");
                ps1.className = "college-close";
                ps2.className = "mojor-open";
                ps1.appendChild(child3);
                ps2.appendChild(child4);
            }
            if(event.id == "sp2") {
                var sp1 = document.getElementById("sp1");
                var child1 = document.createElement("div");
                sp1.className = "naniu";
                sp1.appendChild(child1);
                var sp2 = document.getElementById("sp2");
                var child2 = document.createElement("div");
                sp2.className = "newdiv";
                sp2.appendChild(child2);

                var ps1 = document.getElementById("ps1");
                var ps2 = document.getElementById("ps2");
                var child3 = document.createElement("ul");
                var child4 = document.createElement("div");
                ps1.className = "college-open";
                ps2.className = "mojor-close";
                ps1.appendChild(child3);
                ps2.appendChild(child4);
            }
        }
        var g = $("#sp1");
		g.click();
	
</script>
</html>
