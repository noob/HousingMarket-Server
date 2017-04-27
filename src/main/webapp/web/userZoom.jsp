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
<style>
            .i-banner, .i-banner a {
                color: #000;
            }
            .i-banner {
                width: 100%;
                padding-top: 3%;
                padding-bottom: 2%;
                padding-left: 4%;
                border-bottom: 1px solid #eee;
                position: relative;
            }
            .i-banner-content {
                margin: 0 auto 12px;
                width: 990px;
            }
            .fn-clear {
                zoom: 1;
            }
            .i-banner, .i-banner a {
                color: #000;
            }
            .message-stat-none {
                color: #999;
            }
            .message-entrance {
                display: block;
                height: 38px;
                overflow: hidden;
                position: relative;
                transition: all 1.5s ease-in,all 1.3s ease-out;
            }
            .message-stat-none .message-clock-animate {
                -webkit-animation-name: none;
                animation-name: none;
            }
            .message-entrance .message-fore {
                display: block;
                color: #000;
                position: relative;
                top: -116px;
                text-align: center;
                font-size: 20px;
                line-height: 27px;
                font-family: Tahoma,Arail;
                zoom: 1;
            }
            .message-clock-animate {
                -webkit-animation: spaceboots 5s infinite;
                -moz-animation: spaceboots 5s infinite;
                -o-animation: spaceboots 5s infinite;
                -ms-animation: spaceboots 5s infinite;
                animation: spaceboots 5s infinite;
                display: block;
            }
            .message-clock-animate {
                -webkit-animation: spaceboots 5s infinite;
                -moz-animation: spaceboots 5s infinite;
                -o-animation: spaceboots 5s infinite;
                -ms-animation: spaceboots 5s infinite;
                animation: spaceboots 5s infinite;
                display: block;
            }
            .message-entrance .iconfont {
                cursor: pointer;
            }
            .iconfont {
                font-style: normal;
                font-weight: normal;
                cursor: default;
                -webkit-font-smoothing: antialiased;
            }
            .message-entrance .message-fore {
                display: block;
                color: #fff;
                position: relative;
                top: -116px;
                text-align: center;
                font-size: 20px;
                line-height: 27px;
                font-family: Tahoma,Arail;
                zoom: 1;
            }

            .i-banner-portrait {
                display: inline;
                float: left;
                width: 86px;
            }

            .i-banner-portrait a, .i-banner-portrait img {
                width: 80px;
                height: 80px;
            }

            .i-banner-portrait a, .i-banner-portrait img {
                width: 80px;
                height: 80px;
            }

            .i-banner-portrait a {
                -webkit-border-radius: 50%;
                -webkit-background-clip: padding-box;
                -moz-border-radius: 50%;
                -moz-background-clip: padding;
                border-radius: 50%;
                background-clip: padding-box;
                overflow: hidden;
                border: 2px solid #e1e1e1;
                display: block;
            }
            .i-banner, .i-banner a {
                color: #000;
            }
            .fn-left {
                font-size: 20px;
                display: inline;
                float: left;
            }
            .i-banner-main-hello {
                padding-top: 2%;
                padding-bottom: 2%;
            }
            .i-banner-main-detail {
                padding-top: 1%;
                position: relative;
            }
            .fn-clear {
                zoom: 1;
            }
            .i-banner-main:after {
                clear: both;
                content: "";
                display: block;
                font-size: 0;
                height: 0;
                visibility: hidden;
            }
            .i-banner-main {
                zoom: 1;
            }
            .li-inline{
                float: left;
            }
            .i-assets-header h3 {
                font-size: 24px;
            }
            .i-assets-balance-amount {
                line-height: 24px;
                margin-right: 20px;
            }
            .message-panel p, h3, h4, table, td, tr {
                margin: 0;
                padding: 0;
                border-spacing: 0;
            }
            .i-assets .amount {
                font-size: 26px;
                font-weight: 400;
                color: #666;
                margin-left: 2px;
            }
            strong, b {
                font-weight: bold;
            }
        </style>
</head>

<body ng-app="lyr.website" class="ng-scope">
	<jsp:include page="../web/common.jsp"></jsp:include>
	
	<div class="" >
            <div class="i-banner" style="margin-top: 12%; max-height:1280px;">
                <div class="i-banner-content fn-clear">
               <!-- 
                    <div class="i-banner-portrait">
                        <a class="userInfo-portrait">
                            <img src="${sessionScope.USER_SESSION_KEY.userImg }" id="J-portrait-user" alt="头像"></a>
                    </div>
                     -->
                    <div class="li-inline" style="padding-left: 5%; width: 30%; padding-top: 1%">
	                        <div class="i-banner-main-hello fn-clear">
	                            <p class="userName fn-left">你好, ${sessionScope.USER_SESSION_KEY.userName }</p>
	                        </div>
	                        <div class="i-banner-main-detail fn-clear">
	                            <div class="fn-left fn-mr-5" style="margin-top: 5%">
	                                账户名：${sessionScope.USER_SESSION_KEY.mobile }
	                            </div>
	                        </div>
                    </div>
                    
                    <div class="li-inline" style="width: 60%; padding-left:5%; padding-top: 6%;padding-bottom: 2%">
                        <div class="i-assets-content">
                            <div class="i-assets-body fn-clear" style="padding-left: 5%;">
                                <a class="btn-link-lipstick mini recommend"  style="text-decoration:none; width: 15%;margin-left: 10%" href="">推荐记录</a>
                            </div>
                        </div>
                    </div>
                    
					<div class="li-inline" style="width: 90%; padding-top: 2%;border-bottom: 1px solid #eee;"></div>
                    <div class="li-inline" style="width: 68%; padding-top: 2%;">
                        <h3><b>完善信息</b></h3>
                        <form class="form-horizontal info_form" style="margin-top: 4%;margin-left: 10%">
                        	<input type="hidden" name="userId" value="${sessionScope.USER_SESSION_KEY.userId }"/>
                            <div class="form-group form-group-sm">
                                <label class="col-sm-2 control-label"for="formGroupInputSmall">真实姓名</label>
                                <div class="col-sm-10">
                                    <input class="form-control realName"  type="text"  name="realName"  placeholder="真实姓名">
                                </div>
                            </div>
                            <div class="form-group form-group-sm" style="margin-top: 4%">
                                <label class="col-sm-2 control-label"for="formGroupInputSmall">身份证</label>
                                <div class="col-sm-10">
                                    <input class="form-control idCard"  type="text"  id="formGroupInputSmall"  name="idCard"  placeholder="身份证">
                                </div>
                            </div>
                            <div class="form-group form-group-sm" style="margin-top: 4%">
                                <label class="col-sm-2 control-label"for="formGroupInputSmall">高中学校</label>
                                <div class="col-sm-10">
                                    <input class="form-control high_school" name="highSchool" type="text" placeholder="高中就读学校">
                                </div>
                            </div>
                            <a class="btn-link-lipstick mini complete_info" style="width: 12%; margin-top: 4%; float:right; text-decoration:none;" href="">提交</a>
                        </form>
                    </div>
                    
                    <div class="li-inline" style="width: 90%; padding-top: 2%;border-bottom: 1px solid #eee;"></div>
                    <div class="li-inline" style="width: 68%; padding-top: 2%;">
                        <h3><b>修改密码</b></h3>
                        <form class="form-horizontal password_form" style="margin-top: 4%;margin-left: 10%">
                        	<input type="hidden" name="userId" value="${sessionScope.USER_SESSION_KEY.userId }"/>
                            <div class="form-group form-group-sm">
                                <label class="col-sm-2 control-label" for="formGroupInputSmall">旧密码</label>
                                <div class="col-sm-10">
                                    <input class="form-control old_password"  name="old_password" type="text" placeholder="旧密码">
                                </div>
                            </div>
                            <div class="form-group form-group-sm" style="margin-top: 4%">
                                <label class="col-sm-2 control-label"for="formGroupInputSmall">新密码</label>
                                <div class="col-sm-10">
                                    <input class="form-control new_password" name="new_password"  type="text"id="formGroupInputSmall"placeholder="新密码">
                                </div>
                            </div>
                            <div class="form-group form-group-sm" style="margin-top: 4%">
                                <label class="col-sm-2 control-label"for="formGroupInputSmall">重复新密码</label>
                                <div class="col-sm-10">
                                    <input class="form-control  confirm_password " type="text" placeholder="重复新密码">
                                </div>
                            </div>
                            <a class="btn-link-lipstick mini modify" style="width: 12%; margin-top: 4%; float:right; text-decoration:none;" href="">确认修改</a>
                        </form>
                    </div>
                    <div class="i-banner-main fn-clear" style="padding-left: 2%;">
                    </div>
                </div>
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
	
	var userId = ${sessionScope.USER_SESSION_KEY.userId };
	$(document).on("click", ".recommend", function() {
		ajax(proj + "/user/recommendRecord", {userId : userId}, function(data) {
			if (data == "success") {
				location.href = proj + "/user/majorTOP";
			} else {
				alert("无推荐记录");
			}
		});
	});
	
	$(document).on("click", ".complete_info", function() {
		if ($(".realName").val().trim().length == 0 || $(".idCard").val().trim().length == 0 || $(".high_school").val().trim().length == 0) {
			alert("信息不能为空");
			return;
		}
		ajax(proj + "/user/complete_info", $(".info_form").serialize(), function(data) {
			if (data == "success") {
				alert("信息完善成功");
			} else {
				alert("未知错误,请再试一次");
			}
		});
		
	});
	
	$(document).on("click", ".modify", function() {
		if ($(".old_password").val().trim().length == 0 || $(".new_password").val().trim().length == 0 || $(".confirm_password").val().trim().length == 0) {
			alert("密码不能为空");
			return;
		}
		if ($(".new_password").val().trim() != $(".confirm_password").val().trim()) {
			alert("两次密码输入不同");
			return;
		}
		ajax(proj + "/user/modify_password", $(".password_form").serialize(), function(data) {
			if (data == "success") {
				alert("修改成功请重新登录");
				location.href = proj + "/loginOut";
			} else {
				alert("未知错误,请再试一次");
			}
		});
	});
	
</script>
</html>
