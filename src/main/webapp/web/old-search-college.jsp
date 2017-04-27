<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String port;
	if (request.getServerPort() == 80) {port = "";} else {port = ":8080";}
	String path = request.getScheme() + "://" + request.getServerName() + port + "/SchoolGuider";
%>

<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="webkit win">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta name="author" content="">
<style type="text/css">
@charset "UTF-8";
[ng\:cloak],[ng-cloak],[data-ng-cloak],[x-ng-cloak],.ng-cloak,.x-ng-cloak,.ng-hide:not(.ng-hide-animate){display:none !important;}
ng\:form {display: block;}
.li-inline {
	float: left;
}
.div-body {
	font-size: 1.25rem;
	float: left;
}
</style>
<meta charset="utf-8">
<title>SG | 查大学</title>
<link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
<link rel="stylesheet" href="<%=path %>/css/pagination.css">
</head>

<body ng-app="lyr.website" class="ng-scope">
	<div class="airlock">
		<input type="hidden" value=";jsessionid=<%=request.getSession().getId()%>" id="jsessionid"/>
		<header class="website-header" ng-init="mobile.expand=false" ng-class="{&#39;mobile-expand&#39;: mobile.expand}">
			<h1 class="website-logo">
				<div class="caption">
					choose in the <a href="<%=response.encodeUrl(path+"/")%>">SG System</a>
				</div>
			</h1>
			<a class="mobile-menu" ng-click="mobile.expand=!mobile.expand"></a>
			<nav>
				<ul class="website-menu">
					<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1")%>">College 找大学</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/majorList")%>">Major 找专业</a></li>
					<li><a href="#major-recommend">Recommend 专业推荐</a></li>
					<li class="search">
						<a class="search-icon">查找专业/大学</a>
						<form class="ng-pristine ng-valid">
							<input type="text" class="addsearch ng-pristine ng-untouched ng-valid" placeholder="查找专业/大学" data-addsearch-field="true" autocomplete="off" style="cursor: auto;">
						</form>
					</li>
				</ul>
				<ul class="website-registration">
					<c:if test="${sessionScope.USER_SESSION_KEY.userName == null}">
						<li><a class="btn-link-lipstick mini" data-toggle="modal" data-target="#registFormModal">注册</a></li>
						<li><a data-toggle="modal" data-target="#loginFormModal" href="">登录</a></li>
					</c:if>
					<c:if test="${sessionScope.USER_SESSION_KEY.userName != null}">
						<li><a>${sessionScope.USER_SESSION_KEY.userName }</a></li>
						<li><a class="btn-link-lipstick mini" href="<%=response.encodeUrl(path+"/loginOut")%>">退出</a></li>
					</c:if>
				</ul>
			</nav>
		</header>
	</div>

	<div class="div-max" style="margin-top: 8%; margin-left: 10%">
		<div class="div-body" style="background-color:whitesmoke; width: 10%; height:150%;">
			<dl>
				<dd>
					<ul style="margin-left: 4%">
						<h3>按省份</h3>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=北京")%>">北京</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=天津")%>" title="天津">天津</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=河北")%>" title="河北">河北</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=山西")%>" title="山西">山西</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=内蒙古")%>" title="内蒙古">内蒙古</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=辽宁")%>" title="辽宁">辽宁</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=吉林")%>" title="吉林">吉林</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=黑龙江")%>" title="黑龙江">黑龙江</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=上海")%>" title="上海">上海</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=江苏")%>" title="江苏">江苏</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=浙江")%>" title="浙江">浙江</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=安徽")%>" title="安徽">安徽</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=福建")%>" title="福建">福建</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=江西")%>" title="江西">江西</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=山东")%>" title="山东">山东</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=河南")%>" title="河南">河南</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=湖北")%>" title="湖北">湖北</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=湖南")%>" title="湖南">湖南</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=广东")%>" title="广东">广东</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=广西")%>" title="广西">广西</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=海南")%>" title="海南">海南</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=重庆")%>" title="重庆">重庆</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=四川")%>" title="四川">四川</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=贵州")%>" title="贵州">贵州</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=云南")%>" title="云南">云南</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=西藏")%>" title="西藏">西藏</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=陕西")%>" title="陕西">陕西</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=甘肃")%>" title="甘肃">甘肃</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=青海")%>" title="青海">青海</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=宁夏")%>" title="宁夏">宁夏</a></li>
						<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=新疆")%>" title="新疆">新疆</a></li>
					</ul>
				</dd>
			</dl>
		</div>
		<!-- List DIV begin -->
		<div style="margin-left: 10%">
			<!-- List unit begin -->
			<!-- 
			<div class="div-body" style="background-color:whitesmoke; margin-left:5%; width: 80%">
				<ul>
					<li style="margin-top: 1%; margin-bottom: 1%; padding-left: 5%;">
						<img class="li-inline" src="<%=path %>/img/index.jpg" style="width: 25%; height: 14%; padding-top: 3.5%">
						<div class="li-inline" style="padding-left: 5%; width: 30%; padding-top: 1%">
							<h3>
								<a href="" title="中国人民大学" target="_blank">中国人民大学1</a>
							</h3>
							<p>平均分：600</p>
							<p>学费：5000-6000元/年</p>
							<p class="operation_btn">
								<a class="btn btn-mini test_my_probability"  href="" title="" target="_blank">详细</a>
							</p>
						</div>
						<div class="li-inline" style="width: 30%; padding-top: 3.5%">
							<cite>（RenminUniversityofChina）是一所以人文社会科学为主的综合性研究型全国重点大学，直属于教育部，由教育部与北京市共建。学校的前身是1937年诞生于抗日战争烽火中的陕北公..</cite>
						</div>
					</li>
				</ul>
			</div>
			 -->
			<c:forEach items="${requestScope.list }" var="list" varStatus="index">
				<div class="div-body" style="background-color:whitesmoke; margin-left:5%; width: 80%">
					<ul>
						<li style="margin-top: 1%; margin-bottom: 1%; padding-left: 5%;">
							<img class="li-inline" src="<%=path %>/img/index.jpg" style="width: 25%; height: 14%; padding-top: 3.5%">
							<div class="li-inline" style="padding-left: 5%; width: 30%; padding-top: 1%">
								<h3>
									<a href=""  target="_blank">${list.schoolName }</a>
								</h3>
								<p>平均分：600</p>
								<p>学费：5000-6000元/年</p>
								<p class="operation_btn">
									<a class="btn btn-mini test_my_probability"  href="" title="" target="_blank">详细</a>
								</p>
							</div>
							<div class="li-inline" style="width: 30%; padding-top: 3.5%">
								<cite>（RenminUniversityofChina）是一所以人文社会科学为主的综合性研究型全国重点大学，直属于教育部，由教育部与北京市共建。学校的前身是1937年诞生于抗日战争烽火中的陕北公..</cite>
							</div>
						</li>
					</ul>
				</div>
			</c:forEach>
			
			<!-- List unit end -->
			<div class="div-body" style="background-color:whitesmoke; margin-left:5%; width: 80%">
				<div id="Pagination" class="pagination" style="float:right; position:relative; "></div>
				<input type="hidden" value="${pagenation.total}" id="num_entries" /> 
				<input type="hidden" value="${pagenation.page}" id="current_page" />
			</div>
		</div>
		<!-- List DIV end -->
		
		
	</div>
	
	
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
	HZFPagination.pagetoUrl = "/user/schoolList";
	HZFPagination.init();
	
</script>
</html>
