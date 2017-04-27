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
	<title>问达 | 找回密码</title>
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
			<div id="regist" class="tab-pane active">
				<form id="account_back_form"  action="<%=path%>/login" class="form-signin" method="post">
					<div style="color:red; margin: 6px; height:15px;">
						<span id="msg" style="line-height:20px; text-align:center; display:block"></span>
					</div>
					<div>
						<input type="password" placeholder="请输入新密码" class="form-control password" name="password" />
						<div style="color:red; margin-top: 6px; height:15px;">
							<span id="regist_error_text_password">&nbsp;&nbsp;密码长度在6~11之间 </span>
						</div>
					</div>
					<div>
						<input type="password" placeholder="请确认新密码" class="form-control password2" name="password2" />
						<div style="color:red; margin-top: 6px; height:15px;">
							<span id="regist_error_text_password2">&nbsp;&nbsp;两次密码不同 </span>
						</div>
					</div>
					<div style="width: 100%;">
						<button style="margin-top: 20px;width: 100%;" class="btn text-muted text-center btn-info modify" type="button" > 确认修改 </button>
					</div>
					<!-- 
					<div>
						 &nbsp;&nbsp;
						<button style="margin-top: 20px;" class="button button-circle button-royal button-small regist"  data-toggle="modal" data-target="#formModal"><i class="fa fa-plus"></i></button>
					</div>
					-->
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
      	function toHome() {
			location.href = proj + "/user_login_ui";
		}
      	account.accountBack_three();
		
      </script>
      <!--END PAGE LEVEL SCRIPTS -->

</body>
</html>
