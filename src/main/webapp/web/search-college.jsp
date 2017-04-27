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
    </style>
    <meta charset="utf-8">
    <title>高校专业推荐系统 | 大学</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/pagination.css">

</head>

<body ng-app="lyr.website" class="ng-scope">

	<jsp:include page="../web/common.jsp"></jsp:include>
	
    <div class="div-max" style="margin:8% auto">
    <!--  
        <div class="div-body" style="width: 10%;height: 100%;">
            <dl class="div-body-left">
            	<dd>
            	
					<ul>
						<input type="hidden"  class="condition" value="schoolRegion"/>
						<h5 class="value" value="${value }">按省份</h5>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=北京")%>" title="北京">北京</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=天津")%>" title="天津">天津</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=河北")%>" title="河北">河北</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=山西")%>" title="山西">山西</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=内蒙古")%>" title="内蒙古">内蒙古</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=辽宁")%>" title="辽宁">辽宁</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=吉林")%>" title="吉林">吉林</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=黑龙江")%>" title="黑龙江">黑龙江</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=上海")%>" title="上海">上海</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=江苏")%>" title="江苏">江苏</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=浙江")%>" title="浙江">浙江</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=安徽")%>" title="安徽">安徽</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=福建")%>" title="福建">福建</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=江西")%>" title="江西">江西</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=山东")%>" title="山东">山东</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=河南")%>" title="河南">河南</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=湖北")%>" title="湖北">湖北</a></li>
						<li><a class="region" href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=湖南")%>" title="湖南">湖南</a></li>
						<li><a class="region"  href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=广东")%>" title="广东">广东</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=广西")%>" title="广西">广西</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=海南")%>" title="海南">海南</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=重庆")%>" title="重庆">重庆</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=四川")%>" title="四川">四川</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=贵州")%>" title="贵州">贵州</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=云南")%>" title="云南">云南</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=西藏")%>" title="西藏">西藏</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=陕西")%>" title="陕西">陕西</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=甘肃")%>" title="甘肃">甘肃</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=青海")%>" title="青海">青海</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=宁夏")%>" title="宁夏">宁夏</a></li>
						<li><a class="region"href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1&condition=schoolRegion&value=新疆")%>" title="新疆">新疆</a></li>
					</ul>
					
				</dd>
            </dl>
        </div>
        -->
        <div >
        	<div class="form-group form-group-sm" style="margin-top: 4%;  padding-bottom: 2%;">
                   <select style="width:10%; line-height: 16px; float:left; background-image:url(<%=path%>/img/black.png);" class="form-control search-input condition" value="${condition }"> 
			                <!-- <option value="" <c:if test="${condition == null }"> selected</c:if>>-请选择-</option> -->
			                <option id="schoolName" value="schoolName" <c:if test="${condition == 'schoolName' }"> selected</c:if>>学校名字</option>
							<option id="schoolRegion" value="schoolRegion"  <c:if test="${condition == 'schoolRegion' }"> selected</c:if>>学校省份</option>
			             </select>
                    <div class="col-sm-10" style="width: 40%" >
                        <!--  <input type="hidden" class="condition"  value="schoolName" />-->
			        	
                        <input  class="form-control value search_key" type="text"  id="formGroupInputSmall" placeholder="大学" value="${value }" />
                    </div>
                    <button id="ok" type="button" class="btn-link-lipstick mini" style="float: left ;width:8%;" data-href="<%=response.encodeUrl(path+"/user/schoolList?pagenation.page=1")%>">找大学</button>
               </div>
	        <c:if test="${pagenation.total > 0}">
				<table class="table table-striped table-bordered table-hover" >
					<thead>
		                <tr>
			                <th style="text-align: center">大学名称</th>
							<th style="text-align: center">省份</th>
							<th style="text-align: center">查看</th>
				         </tr>
			         </thead>
			         <tbody>
	       				<c:forEach items="${list }" var="list" varStatus="index">
				         	<tr>
		       					<td style="text-align: center">${list.schoolName }</td>
		       					<td style="text-align: center">${list.schoolRegion }</td>
		       					<td style="text-align: center">
		       						<button class="btn btn-primary detail" data-id="${list.schoolId }">招生专业</button>
		       					</td>
		        			</tr>
	       				</c:forEach>
			         </tbody>
	        	</table>
	        </c:if>
			<c:choose>
				<c:when test="${pagenation.total > 0}">
					<div class="div-body" style=" width: 100%">
						<div id="Pagination" class="pagination" style="float:right; position:relative; "></div>
						<input type="hidden" value="${pagenation.total}" id="num_entries" /> 
						<input type="hidden" value="${pagenation.page}" id="current_page" />
					</div>
				</c:when>
				<c:otherwise><h1 style="text-align: center;">查询到0条信息</h1></c:otherwise>
			</c:choose>
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
	account.regist();
	account._login();
	
	var proj = "<%=path %>";
	HZFPagination.pagetoUrl = "/user/schoolList";
	HZFPagination.pagetoParams = [".condition", ".value"];
	HZFPagination.init();
	HZFPagination.pageToJump(".detail", "/user/schoolDetails", "schoolId=");
	
	var v = "${requestScope.value }";
	if(v != null && v.length > 0) {
		$(".value").val(v);
	}
	$(document).on("click", ".region", function() {
		$(".value").val($(this).attr("title"));
	});
	
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
			ok += "&condition=" + con + "&value=" + val ;
		}
		location.href = ok;
	});
	
	
</script>
</html>
