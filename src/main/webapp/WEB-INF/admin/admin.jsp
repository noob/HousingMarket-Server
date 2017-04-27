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
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->

 <!-- BEGIN HEAD -->
<head>
     <meta charset="UTF-8" />
    <title>高校专业推荐系统 | 管理员首页</title>
     <meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
     <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <!-- GLOBAL STYLES -->
    <!-- GLOBAL STYLES -->
    <link rel="stylesheet" href="<%=path %>/css/bootstrap.css" />
    <link rel="stylesheet" href="<%=path %>/css/main.css" />
    <link rel="stylesheet" href="<%=path %>/css/theme.css" />
    <link rel="stylesheet" href="<%=path %>/css/MoneAdmin.css" />
    <link rel="stylesheet" href="<%=path %>/css/font-awesome.css" />
    <!--END GLOBAL STYLES -->

    <!-- PAGE LEVEL STYLES -->
    <link href="<%=path %>/css/dataTables.bootstrap.css" rel="stylesheet" />
    <link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
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
		<jsp:include page="../frame/admin/header.jsp"></jsp:include>
		<jsp:include page="../frame/admin/menu.jsp"></jsp:include>
		
        <!--PAGE CONTENT -->
        <div id="content">
            <div class="inner">
                <div class="row">
                    <div class="col-lg-12">
                        <h3> 欢迎使用管理员 </h3>
                    </div>
                </div>
            </div>
        </div>
       <!--END PAGE CONTENT -->
    </div>
	<jsp:include page="../frame/admin/footer.jsp"></jsp:include>
    <script src="<%=path %>/js/common.js"></script>
   
</body>
</html>
