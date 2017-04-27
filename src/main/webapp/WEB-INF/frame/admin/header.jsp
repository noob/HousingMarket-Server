<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
%>
<link rel="stylesheet" href="<%=path%>/css/bootstrap.css" />
<link rel="stylesheet" href="<%=path%>/css/main.css" />
<link rel="stylesheet" href="<%=path%>/css/theme.css" />
<link rel="stylesheet" href="<%=path%>/css/MoneAdmin.css" />
<link rel="stylesheet" href="<%=path%>/css/font-awesome.css" />
<link rel="stylesheet" href="<%=path%>/css/pagination.css" />
<link href="<%=path%>/css/dataTables.bootstrap.css" rel="stylesheet" />
<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 ">
<!-- HEADER SECTION -->
<div id="top">
	<input type="hidden" value=";jsessionid=<%=request.getSession().getId()%>" id="jsessionid"/>
    <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px;">
       <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle">
           <i class="icon-align-justify"></i>
       </a>
       <!-- LOGO SECTION -->
       <header class="navbar-header">
               <h3 style="margin-top: 0px; margin-left: -50px;"> Management System </h3>
       </header>
       <!-- END LOGO SECTION -->
       <ul class="nav navbar-top-links navbar-right">
           <!--ADMIN SETTINGS SECTIONS -->
           <li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                   <i class="icon-user "></i>&nbsp; <span>${sessionScope.ADMIN_SESSION_KEY.adminName }</span>&nbsp;<i class="icon-chevron-down "></i>
               </a>
               <ul class="dropdown-menu dropdown-user">
                   <li><a href="<%=response.encodeUrl(path+"/loginOut")%>"><i class="icon-signout"></i> 注销 </a>
                   </li>
               </ul>
           </li>
           <!--END ADMIN SETTINGS -->
        </ul>
    </nav>

</div>
<!-- END HEADER SECTION -->