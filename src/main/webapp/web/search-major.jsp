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
    <style type="text/css">
        @charset "UTF-8";
        [ng\:cloak], [ng-cloak], [data-ng-cloak], [x-ng-cloak], .ng-cloak, .x-ng-cloak, .ng-hide:not(.ng-hide-animate) {
            display: none !important;
        }
        ng\:form {
            display: block;
        }
        .li-online{
        	font-size: 1.4rem;
            float: left;
        }
        .li-online p{
        	font-size: 1.1rem;
            display: inline;
        }
        .li-online span{
            font-size: 1.75rem;
            color: #00afcc;
        }
    </style>
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 专业</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">
    <jsp:include page="../web/common.jsp"></jsp:include>

    <div class="div-max" style="margin:8% auto;">
        <div>
         		<div class="form-group form-group-sm" style="margin-top: 4%;  padding-bottom: 2%;">
                      <div class="col-sm-10" style="width: 40%" >
                      		<input type="hidden" class="condition" value="majorName" />
                          <input class="form-control value search_key" type="text"  id="formGroupInputSmall" placeholder="专业" value="${value}"/>
                      </div>
                      <button id="ok" type="button" class="btn-link-lipstick mini" style="float: left ;width:8%;" data-href="<%=response.encodeUrl(path+"/user/majorList")%>">找专业</button>
                 </div>
	        	<table class="table table-striped table-bordered table-hover" >
	        		<c:forEach begin="0"  end="${list.size()/5 }" varStatus="index">
	        			<tr>
	        				<c:forEach items="${list }" var="list" varStatus="flag" begin="${index.index*5 }" end="${index.index*5+4 }">
	        					<td style="text-align: center"><a class="all" data-id="${list.majorId }">${list.majorName }</a></td>
	        				</c:forEach>
	        			</tr>
	        		</c:forEach>
	        	</table>
		</div>
    </div>
	<!-- List DIV end -->
	
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
	HZFPagination.pagetoUrl = "/user/majorList";
	HZFPagination.pagetoParams = [".condition", ".value"];
	HZFPagination.init();
	HZFPagination.detailToList(".all", "/user/majorInSchool", "majorId=");
	
	//搜索框	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			$("#ok").click();
		}
	});
	
	//确认按钮
	$(document).on("click", "#ok", function() {
		var ok = $(this).attr("data-href");
		//选择框
		var con = $(".condition").val();
		var val = $(".value").val();
		if(val != null && val.length > 0) {
			ok += "?condition=" + con + "&value=" + val ;
		}
		location.href = ok;
	});
	
</script>
</html>
