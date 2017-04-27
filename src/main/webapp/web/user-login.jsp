<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<title>问达 | 登录</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
     <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <!-- GLOBAL STYLES -->
     <!-- PAGE LEVEL STYLES -->
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="<%=path%>/css/login.css"/>
    <link rel="stylesheet" href="<%=path %>/css/button.css"/>
    <link rel="stylesheet" href="<%=path%>/css/magic.css"/>
    <link rel="stylesheet" href="<%=path %>/css/font-awesome.min.css" />
     <!-- END PAGE LEVEL STYLES -->
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->
</head>
		<!-- END HEAD -->


<body>

	<!-- PAGE CONTENT  -->
	<div class="container">
		<div class="text-center">
			<!-- <h2 style="font-family: '微软雅黑';color: #0E4776;">问达</h2> -->
			<a href="<%=response.encodeUrl(path+"/")%>" ><img style="width: 12%" src="<%=path %>/img/wendaan.svg"></a>
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form id="login_form"  action="<%=path%>/login" class="form-signin" method="post">
					<input type="hidden" class="verifyCode" name="verifyCode" value=""/>
					<div style="color:red; margin: 6px; height:15px;">
						<span id="msg" style="line-height:20px; text-align:center; display:block"></span>
					</div>
					<div>
						<input type="text" placeholder="请输入手机号" class="form-control userName" name="userName" title="请输入用户名" />
						<div style="color:red; margin-top: 6px; height:15px;">
							<span id="login_error_text_name">&nbsp;&nbsp;请输入手机号 </span>
						</div>
					</div>
					<div style="width: 100%;">
						<div style="width: 100%;">
							<input type="password" placeholder="请输入密码" class="form-control password" name="password" />
						</div>
					</div>
					<div style="color:red; width:100%; margin-top: 6px; height:15px;">
						<span style="width:100%" id="login_error_text_password">&nbsp;&nbsp;请输入密码</span>
					</div>
					<div style="width: 100%;">
						<button style="margin-top: 20px;width: 100%;" class="btn text-muted text-center btn-info login" type="button" title="点击登录">登录</button>
					</div>
					<!-- 
					<div>
						 &nbsp;&nbsp;
						<button style="margin-top: 20px;" class="button button-circle button-royal button-small regist"  data-toggle="modal" data-target="#formModal"><i class="fa fa-plus"></i></button>
					</div>
					-->
					<div style="width: 100%; margin-top:5px; text-align: center;">
						<a style="margin-right: 15%; text-decoration:none;" href="<%=response.encodeUrl(path+"/web/user-regist-one.jsp")%>">注册</a>
						<a style="margin-left: 15%; text-decoration:none;" class="accountBack"  href="<%=response.encodeUrl(path+"/accountBack_ui_one")%>">找回密码</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--END PAGE CONTENT -->

	 <!-- PAGE LEVEL SCRIPTS -->
      <script src="<%=path %>/js/jquery-2.0.3.min.js"></script>
      <script src="<%=path %>/js/bootstrap.js"></script>
      <script src="<%=path %>/js/schoolguider/account.js"></script>
      <script type="text/javascript">
      	$(function () { formInit(); });
      	var proj = '<%=path%>';
      	account._login();
      	
		$(document).on("click", ".accountBack", function() {
			location.href = proj + "/accountBack_ui";
		});
      	
      	var countdown=60;
      	function settime(obj) {
      		var mobile = $(".userName").val();
      		if(countdown == 60) {
      			ajax(proj  + "/getCode", {mobile:mobile}, function(data) {
					$(".verifyCode").val(data);
      			});
      		}
		    if (countdown == 0) { 
		        obj.removeAttribute("disabled");    
		        obj.value="获取验证码"; 
		        countdown = 60; 
		        return;
		    } else { 
		        obj.setAttribute("disabled", true); 
		        obj.value="重新发送(" + countdown + ")"; 
		        countdown--; 
		    }
			setTimeout(function() {settime(obj);},1000);
		}
		
      </script>
      <!--END PAGE LEVEL SCRIPTS -->

</body>
</html>
