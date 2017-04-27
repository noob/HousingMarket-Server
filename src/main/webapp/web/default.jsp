<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String port;
	if (request.getServerPort() == 80){port = "";} else {port = ":8080";}
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
<meta charset="utf-8">
<title>问达 | 首页</title>
<link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
<link rel="stylesheet" href="<%=path %>/css/pagination.css">
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<style>
    .li-inline{
        float: left;
    }
    .fangkuai{
        width: 15%;
        background-color: #50B3E5;
        margin-left: 5%;
        border-radius: 8px;
    }
    .fangkuai p{
        text-align:center;
        width: 100%;
        padding-top: 10%;
    }
    .fangkuai img{
        width: 26%;
    }
</style>
</head>

<body ng-app="lyr.website" class="ng-scope">
	
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
				<!-- -->
				<ul class="website-menu">
					<li><a class="recommend"  data-href="<%=response.encodeUrl(path+"/user/questionList")%>" >Recommend 专业推荐</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/majorList?pagenation.page=1")%>">Major 找专业</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1")%>">college 找大学</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/school-majorList?pagenation.page=1")%>" >subject 选科查询</a></li>
					<li><a href="<%=response.encodeUrl(path+"/user/lessonList")%>" >training 培训</a></li>
				</ul>
				<ul class="website-registration">
					<c:if test="${sessionScope.USER_SESSION_KEY.userName == null}">
						<li><a class="btn-link-lipstick mini" href="<%=response.encodeUrl(path+"/user_regist_ui_one")%>" target="_blank" style="top:5px">注册</a></li> 
						<li><a class="btn-link-lipstick mini"  href="<%=response.encodeUrl(path+"/user_login_ui")%>"  style="top:5px">登录</a></li>
					</c:if>
					<c:if test="${sessionScope.USER_SESSION_KEY.userName != null}">
						<li><a class="user"  style="text-transform: capitalize" >${sessionScope.USER_SESSION_KEY.userName }</a></li>
						<li><a class="btn-link-lipstick mini" href="<%=response.encodeUrl(path+"/loginOut")%>">退出</a></li>
					</c:if>
				</ul>
			</nav>
		</header>
		<section class="content">
			<header class="banner medium bleed gutter-bottom home" >
					<div style="z-index: 99; padding-top: 18%; width: 100%">
						<p style="text-align:center; width: 100%;padding-bottom: 10%"><img style="width: 26%" src="<%=path %>/img/wendaan.png"></p>
						<div class="li-inline fangkuai btn-link-lipstick recommend"  data-href="<%=response.encodeUrl(path+"/user/questionList")%>">
		                    <p><img style="padding-top: 10%" src="<%=path %>/img/recommend.svg"></p>
		                    <p style="font-size:18px;" class="mini " >专业推荐</p>
		                </div>
		                <div class="li-inline fangkuai btn-link-lipstick choose_major" data-href="<%=response.encodeUrl(path+"/user/majorList?pagenation.page=1")%>">
		                    <p><img style="padding-top: 10%" src="<%=path %>/img/search_college.svg"></p>    
		                    <p style="font-size:18px;" class=" mini" >找专业</p>
		                </div>
		                <div class="li-inline fangkuai btn-link-lipstick choose_college" data-href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1")%>">
		                    <p><img style="padding-top: 10%" src="<%=path %>/img/college.svg"></p>
		                    <p style="font-size:18px;" class=" mini" >找大学</p>
		                </div>
		                <div class="li-inline fangkuai btn-link-lipstick choose_subject" data-href="<%=response.encodeUrl(path+"/user/school-majorList?pagenation.page=1")%>" >
		                    <p><img style="padding-top: 10%" src="<%=path %>/img/subject.svg"></p>
		                    <p style="font-size:18px;" class=" mini" >选科查询</p>
		                </div>
		                <div class="li-inline fangkuai btn-link-lipstick enter" data-href="<%=response.encodeUrl(path+"/user/lessonList")%>">
		                    <p><img style="padding-top: 10%" src="<%=path %>/img/enter.svg"></p>    
		                    <p style="font-size:18px;" class=" mini" >培训报名</p>
		                </div>'
		            </div>
			</header>
			
		</section>
		<style>
				.footer p{
					text-align: center;
				}
			</style>
			<div id="footer" class="footer" style="margin-top:20px">
				<br/><br/>
				<!--
				<p class="ft-copy">Copyright ©2016 Corporation, All Rights Reserved</p>
				<p>宁波思库网络科技有限公司　<a href="">版权所有</a>　<a href="" target="_blank">浙ICP备16020911号</a></p>
				 -->
				 <p class="ft-copy">Copyright ©2016 , All Rights Reserved</p>
				<p>东风神起团队　<a href="">版权所有</a></p>
			</div>
	</div>
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
	var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/user/schoolList";
	HZFPagination.init();
	
	$(document).on("click", ".user", function() {
		location.href = proj + "/user/userZoom";
	});
	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("data-href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});
	
	$(document).on("click", ".search-btn", function() {
		var search_value = $(".search_input").val();
		var datahref = $(".search_input").attr("data-href");
		datahref += "?search_value=" + search_value;
		location.href = datahref;
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
	
	$(document).on("click", ".choose_major", function() {
		var target = $(".choose_major").attr("data-href");
		location.href = target;
	});
	
	$(document).on("click", ".choose_college", function() {
		var target = $(".choose_college").attr("data-href");
		location.href = target;
	});
	
	$(document).on("click", ".choose_subject", function() {
		var target = $(".choose_subject").attr("data-href");
		location.href = target;
	});
	
	$(document).on("click", ".enter", function() {
		var target = $(".enter").attr("data-href");
		location.href = target;
	});
	
</script>
</html>
