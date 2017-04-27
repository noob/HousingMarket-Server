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
         .li-online {
          	font-size: 1.4rem;
              float: left;
          }
          .li-online p {
          	font-size: 1.1rem;
              display: inline;
          }
          .li-online span {
              font-size: 1.75rem;
              color: #00afcc;
          }
          .more-open {
               display: block;
           }
           .more-close {
               display: none;
           }
    </style>
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 专业适合排行</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">
		<style type="text/css">
		  #low_right
		    {
		      position: fixed;
		      width: 70px;
		      height: 40px;
		      bottom: 40px;
		      right: 20px;
		      text-align: center;
		      padding: 10px;
		      margin: 10px;
		    }
		</style>
</head>

<body ng-app="lyr.website" class="ng-scope"  style="">
    <jsp:include page="../web/common.jsp"></jsp:include>
	
    
    <div class="div-max" style="margin:6.5% auto;">
    	<!-- TOP 10 begin -->
    	
    	
    	<table class="table table-striped table-bordered table-hover" >
			<thead>
                <tr>
	                <th style="text-align: center ; width:65%">TOP 10</th>
					<th style="text-align: center">星级</th>
		         </tr>
	         </thead>
	         <tbody>
      				<c:forEach items="${list_major }" var="list" varStatus="index" end="9">
		         	<tr>
       					<td style="text-align: center"><a style="text-decoration:none;" class="majorName" data-value="${list.majorId }">${index.index + 1}.${list.majorName }</a></td>
       					<td style="text-align: center">
       						<c:if test="${list_score.get(index.index) >= four_five }"><img src="<%=path %>/img/five-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) >= three_four && list_score.get(index.index) < four_five }"><img src="<%=path %>/img/four-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) > lowest && list_score.get(index.index) < three_four}"><img src="<%=path %>/img/three-star.png"/></c:if>
       					</td>
        			</tr>
      				</c:forEach>
	         </tbody>
       	</table>
        <!-- TOP 10 end-->
        
        
        <table class="table table-striped table-bordered table-hover "  id="more">
			<thead>
                <tr>
	                <th style="text-align: center; width:65%">MORE</th>
					<th style="text-align: center">星级</th>
		         </tr>
	         </thead>
	         <tbody>
      				<c:forEach items="${list_major }" var="list" varStatus="index"  begin="10" end="${list_major.size() - 11 }">
		         	<tr>
       					<td style="text-align: center"><a style="text-decoration:none;" class="majorName" data-value="${list.majorId }">${index.index + 1}.${list.majorName }</a></td>
       					<td style="text-align: center">
       						<c:if test="${list_score.get(index.index) >= four_five }"><img src="<%=path %>/img/five-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) >= three_four && list_score.get(index.index) < four_five }"><img src="<%=path %>/img/four-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) > lowest && list_score.get(index.index) < three_four}"><img src="<%=path %>/img/three-star.png"/></c:if>
       					</td>
        			</tr>
      				</c:forEach>
	         </tbody>
       	</table>
        
        <!-- Last 10 begin -->
        <table class="table table-striped table-bordered table-hover" >
			<thead>
                <tr>
	                <th style="text-align: center; width:65%">LAST 10</th>
					<th style="text-align: center">星级</th>
		         </tr>
	         </thead>
	         <tbody>
      				<c:forEach items="${list_major }" var="list" varStatus="index" begin="${list_major.size() - 10}">
		         	<tr>
       					<td style="text-align: center"><a style="text-decoration:none;" class="majorName" data-value="${list.majorId }">${index.index + 1}.${list.majorName }</a></td>
       					<td style="text-align: center">
       						<c:if test="${list_score.get(index.index) >= four_five }"><img src="<%=path %>/img/five-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) >= three_four && list_score.get(index.index) < four_five }"><img src="<%=path %>/img/four-star.png"/></c:if>
                       		<c:if test="${list_score.get(index.index) > lowest && list_score.get(index.index) < three_four}"><img src="<%=path %>/img/three-star.png"/></c:if>
       					</td>
        			</tr>
      				</c:forEach>
	         </tbody>
       	</table>
        <!-- Last 10 end -->
        
        
    </div>
	<!-- List DIV end -->
	
	<!-- 悬浮 begin -->
	<div id="low_right" >
		    <div id="m1"  onclick="more_less(this)">
		    		<input type="hidden"  class="rankPower"  value="${USER_SESSION_KEY.rankPower }"/>
                   <a title="展开更多"><img style="width:50px" src="<%=path %>/img/more.png"/></a>
	        </div>
        	<div id="m2"  onclick="more_less(this)" class="more-close" >
                    <a><img style="width:50px" src="<%=path %>/img/less.png"/></a>
	        </div>
    </div>
    <!-- 悬浮 end -->
    
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
	account.regist();
	account._login();
	
	var proj = "<%=path %>";
	$("#more").hide();
	
	$(".search_key").bind("keypress", function(event) {
		if(event.keyCode == "13") {
			var search_value = $(this).val();
			var datahref = $(this).attr("href");
			datahref += "?search_value=" + search_value;
			location.href = datahref;
		}
	});
	
	var userId = ${USER_SESSION_KEY.userId } + "";
	$(document).on("click", "#m1", function() {
		ajax(proj +"/user/if_user_vip", {userId : userId}, function(data) {
			if(data == "success") {
				var m1 = document.getElementById("m1");
				m1.className = "more-close";
				var m2 = document.getElementById("m2");
				m2.className = "more-open";
				$("#more").show();
			} else {
				if(confirm("您不是会员VIP用户，不能查看更多专业匹配信息，是否前往购买？")) {
					location.href = proj + "/alipay/rank_power_form?userId=" + ${USER_SESSION_KEY.userId };
				}
			}
		});
		
		
		//if($(".rankPower").val() == 1){
			
		//} else {
			
		//}
	});
	
	$(document).on("click", "#m2", function() {
		var m1 = document.getElementById("m1");
        var m2 = document.getElementById("m2");
        m1.className = "more-open";
        m2.className = "more-close";
		$("#more").hide();
	});
	
	$(document).on("click", ".majorName", function() {
		var id = $(this).attr("data-value");
		location.href = proj + "/user/majorInSchool?pagenation.page=1&majorId=" + id;
	});
	
</script>
</html>
