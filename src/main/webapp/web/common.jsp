<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String port;
	if (request.getServerPort() == 80){port = "";} else {port = ":8080";}
	String path = request.getScheme() + "://" + request.getServerName() + port + "/SchoolGuider";
%>

	<div class="airlock">
		<input type="hidden" value=";jsessionid=<%=request.getSession().getId()%>" id="jsessionid"/>
		<header class="website-header" ng-init="mobile.expand=false" ng-class="{&#39;mobile-expand&#39;: mobile.expand}">
			<h1 style="width:15%"  class="website-logo">
				<div style="width:100%" class="caption" >
					<a href="<%=response.encodeUrl(path+"/")%>" ><img style="width:60%" src="<%=path %>/img/wendaan.svg"></a>
				</div>
			</h1>
			<a class="mobile-menu" ng-click="mobile.expand=!mobile.expand"></a>
			<nav>
				<ul class="website-menu">
					<li><a class="recommend"  data-href="<%=response.encodeUrl(path+"/user/questionList")%>" target="_blank">Recommend 专业推荐</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/majorList?pagenation.page=1")%>">Major 找专业</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1")%>">college 找大学</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/school-majorList?pagenation.page=1")%>" target="_blank">subject 选科查询</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/lessonList")%>" >training 培训</a></li>
				</ul>
				<ul class="website-registration">
					<c:if test="${sessionScope.USER_SESSION_KEY.userName == null}">
						<!---->  
						<li><a class="btn-link-lipstick mini" href="<%=response.encodeUrl(path+"/web/user-regist-one.jsp")%>" target="_blank" style="top:5px">注册</a></li> 
						<li><a class="btn-link-lipstick mini"  href="<%=response.encodeUrl(path+"/web/user-login.jsp")%>" style="top:5px">登录</a></li>
						<!-- <li><a class="btn-link-lipstick mini" style="top:5px" href="<%=response.encodeUrl(path+"/web/user-login.jsp")%>" target="_blank">登录</a></li> -->
					</c:if>
					<c:if test="${sessionScope.USER_SESSION_KEY.userName != null}">
						<li><a class="user" style="text-transform: capitalize" >${sessionScope.USER_SESSION_KEY.userName }</a></li>
						<li><a class="btn-link-lipstick mini" href="<%=response.encodeUrl(path+"/loginOut")%>">退出</a></li>
					</c:if>
				</ul>
			</nav>
		</header>
	</div>
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
	var proj = "<%=path %>";
	account.regist();
	account._login();
	
	$(document).on("click", ".user", function() {
		location.href = proj + "/user/userZoom";
	});
	
	$(document).on("click", ".recommend", function() {
		var target = $(".recommend").attr("data-href");
		var userId = ${sessionScope.USER_SESSION_KEY.userId} + "";
		if(userId == null) {
			userId = 0;
		}
		target += "?userId=" + userId;
		location.href = target;
	});
</script>
</html>
