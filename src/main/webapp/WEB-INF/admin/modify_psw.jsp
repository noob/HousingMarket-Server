<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
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
<title>高校专业推荐系统 | 修改密码</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<!-- GLOBAL STYLES -->
<!-- GLOBAL STYLES -->
<link rel="stylesheet" href="<%=path%>/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/css/main.css" />
<link rel="stylesheet" href="<%=path%>/css/theme.css" />
<link rel="stylesheet" href="<%=path%>/css/MoneAdmin.css" />
<link rel="stylesheet" href="<%=path%>/css/font-awesome.css" />
<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css" />
<!--END GLOBAL STYLES -->

<!-- PAGE LEVEL STYLES -->
<link href="<%=path%>/css/dataTables.bootstrap.css" rel="stylesheet" />
<!-- END PAGE LEVEL  STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 " >

     <!-- MAIN WRAPPER -->
    <div id="wrap">
		<jsp:include page="../frame/super/header.jsp"></jsp:include>
		<jsp:include page="../frame/super/menu.jsp"></jsp:include>

        <!--END MENU SECTION -->
		<!--PAGE CONTENT -->
			<div id="content">
				<div class="inner">
					<div class="row">
						<div class="col-lg-12">
							<h3> 修改密码  </h3>
						</div>
					</div>
					<hr />
					<div class="row">
						<div class="col-lg-12">
							<form id="modifypsw" style="margin-left: 10px;" action="<%=path %>/admin/modifyPsw" method="post">
								<div><p style="margin-left:15px ;">原密码：<input type="password" name="password" class="form-control search-input password"></p></div>
								<div><p style="margin-left:15px ;">新密码：<input type="password" name="newpassword" class="form-control search-input newpassword"></p></div>
								<div><p>确认密码：<input type="password" class="form-control search-input newpassword1"></p></div>
								<div><p style="margin-left:70px ;"><button id="modifyPSW" type="button" class="btn btn-success">确认</button><button id="test" type="reset" style="margin-left: 10px;" class="btn btn-primary">重置</button></p></div>
							</form>
						</div>
					</div>
                </div>
            </div>
    </div>
	<script src="<%=path%>/js/jquery-2.0.3.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	<script src="<%=path%>/js/account/account.js"></script>
	<script type="text/javascript">
		var proj="<%=path%>";
		account.accountPSW();
	</script>
</body>
</html>
