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
    <title>高校专业推荐系统 | 答题</title>
    <link rel="stylesheet" href="<%=path%>/css/schoolguider/website.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path%>/css/schoolguider/page.css">
	<link rel="stylesheet" href="<%=path %>/css/schoolguider/jqueryui.min.css" />
    <link rel="stylesheet" href="<%=path %>/css/schoolguider/jquery-ui-slider-pips.min.css" />
    <link rel="stylesheet" href="<%=path %>/css/schoolguider/app.min.css" />
	<link rel="stylesheet" href="<%=path %>/css/schoolguider/zzsc.css"/>
</head>

<body ng-app="lyr.website" class="ng-scope"  style="overflow-y:scroll;">
    <jsp:include page="../web/common.jsp"></jsp:include>

		<div id="top" class="div-body" style="margin:0 auto; width: 85%;">
        	<div class="tabs-content">
            <div class="content active" id="steps-default-slider-result">
                <form id="msform" method="post">
                	<input type=hidden value="${sessionScope.USER_SESSION_KEY.userId}" name="userId" />
					<fieldset id="page1">
						请完成下列40道自测题<br/><br/>请尽量以统一的标准给自己以下方面打分，100分为满分，不要遗漏问题。<br/><br/>
                   		<c:forEach items="${requestScope.list1 }" var="list1" varStatus="index1">
                   			<p>${index1.index + 1 }.${list1.question }</p>
                        	<div class="steps-stacking-slider question${index1.index + 1}" ></div>
                        	<input type="hidden" class="input_question${index1.index + 1}" name="question${index1.index + 1}" value=""/>
                   		</c:forEach>
						<span>第1页/4页</span>
                        <!-- <input type="button" name="next" class="next action-button" value="下一页" /> -->
                        <a name="next" class="next action-button"  href="#top" style="width:12% ; text-decoration:none;">下一页</a>
                    </fieldset>

                    <fieldset id="page2">
                        <c:forEach items="${requestScope.list2 }" var="list2" varStatus="index2">
                   			<p>${index2.index + 11 }.${list2.question }</p>
                        	<div class="steps-stacking-slider question${index2.index + 11}" ></div>
                        	<input type="hidden" class="input_question${index2.index + 11}" name="question${index2.index + 11}"  value=""/>
                   		</c:forEach>
                        <!-- <input type="button" name="previous" class="previous action-button" value="上一页" /> -->
                        <a name="previous" class="previous action-button"  style="width:12% ; text-decoration:none;">上一页</a>
						<span>第2页/4页</span>
                        <!-- <input type="button" name="next" class="next action-button" value="下一页" /> -->
                        <a name="next" class="next action-button"  href="#top" style="width:12% ; text-decoration:none;">下一页</a>
                    </fieldset>

                    <fieldset id="page3">
                        <c:forEach items="${requestScope.list3 }" var="list3" varStatus="index3">
                   			<p>${index3.index + 21 }.${list3.question }</p>
                        	<div class="steps-stacking-slider question${index3.index + 21}"></div>
                        	<input type="hidden" class="input_question${index3.index + 21}" name="question${index3.index + 21}" value="" />
                   		</c:forEach>
                        <!-- <input type="button" name="previous" class="previous action-button" value="上一页" /> -->
                        <a name="previous" class="previous action-button"  style="width:12% ; text-decoration:none;">上一页</a>
                        第3页/4页
						<!-- <input type="button" name="next" class="next action-button" value="下一页" /> -->
                        <a name="next" class="next action-button"  href="#top" style="width:12% ; text-decoration:none;">下一页</a>
                    </fieldset>
                    <fieldset id="page4">
                        <c:forEach items="${list4 }" var="list4" varStatus="index4">
                   			<p>${index4.index + 31 }.${list4.question }</p>
                        	<div class="steps-stacking-slider question${index4.index + 31}" ></div>
                        	<input type="hidden" class="input_question${index4.index + 31}" name="question${index4.index + 31}" value="" />
                   		</c:forEach>
                        <!-- <input type="button" name="previous" class="previous action-button" value="上一页" /> -->
                        <a name="previous" class="previous action-button"  style="width:12% ; text-decoration:none;">上一页</a>
                        第4页/4页
						<button class="submit action-button up btn btn-success">提交</button>
                    </fieldset>

                </form>
            </div>
        </div>
    </div>
	
	
	
</body>
<script src="<%=path%>/js/schoolguider/vendors.min.3924f1bd79c3.js"></script>
<script src="<%=path%>/js/schoolguider/base.78759ea33cfe.js"></script>
<script src="<%=path%>/js/schoolguider/website.d6ab10c0b75c.js"></script>
<script src="<%=path%>/js/schoolguider/jquery.1.11.1.js"></script>
<script src="<%=path%>/js/bootstrap.js"></script>

<script src="<%=path%>/js/schoolguider/modernizr.min.js"></script>
<script src="<%=path%>/js/schoolguider/jquery-plus-ui.min.js"></script>
<script src="<%=path%>/js/schoolguider/jquery-ui-slider-pips.js"></script>
<script src="<%=path%>/js/schoolguider/examples.js"></script>
<script src="<%=path%>/js/schoolguider/jquery.easing.min.js" type="text/javascript"></script>
<script src="<%=path%>/js/schoolguider/zzsc.js" type="text/javascript"></script>

<script src="<%=path%>/js/schoolguider/account.js"></script>
<script src="<%=path %>/js/common.js"></script>
<script type="text/javascript">
	account.regist();
	account._login();
	
	var proj = "<%=path %>";
	
	//页面加载完成后设置所有slider为0
	$(document).ready(function() {
		
		for(var i = 1; i<=40; i++) {
			$(".question" + i).slider("value", 0);
			$(".question" + i).val(0);
		}
		var val = ${requestScope.answer1} + "";
		$(".question1").slider("value", val);
		$(".question1").val(val);
		var val = ${requestScope.answer2} + "";
		$(".question2").slider("value", val);
		$(".question2").val(val);
		var val = ${requestScope.answer3} + "";
		$(".question3").slider("value", val);
		$(".question3").val(val);
		var val = ${requestScope.answer4} + "";
		$(".question4").slider("value", val);
		$(".question4").val(val);
		var val = ${requestScope.answer5} + "";
		$(".question5").slider("value", val);
		$(".question5").val(val);
		var val = ${requestScope.answer6} + "";
		$(".question6").slider("value", val);
		$(".question6").val(val);
		var val = ${requestScope.answer7} + "";
		$(".question7").slider("value", val);
		$(".question7").val(val);
		var val = ${requestScope.answer8} + "";
		$(".question8").slider("value", val);
		$(".question8").val(val);
		var val = ${requestScope.answer9} + "";
		$(".question9").slider("value", val);
		$(".question9").val(val);
		var val = ${requestScope.answer10} + "";
		$(".question10").slider("value", val);
		$(".question10").val(val);
		var val = ${requestScope.answer11} + "";
		$(".question11").slider("value", val);
		$(".question11").val(val);
		var val = ${requestScope.answer12} + "";
		$(".question12").slider("value", val);
		$(".question12").val(val);
		var val = ${requestScope.answer13} + "";
		$(".question13").slider("value", val);
		$(".question13").val(val);
		var val = ${requestScope.answer14} + "";
		$(".question14").slider("value", val);
		$(".question14").val(val);
		var val = ${requestScope.answer15} + "";
		$(".question15").slider("value", val);
		$(".question15").val(val);
		var val = ${requestScope.answer16} + "";
		$(".question16").slider("value", val);
		$(".question16").val(val);
		var val = ${requestScope.answer17} + "";
		$(".question17").slider("value", val);
		$(".question17").val(val);
		var val = ${requestScope.answer18} + "";
		$(".question18").slider("value", val);
		$(".question18").val(val);
		var val = ${requestScope.answer19} + "";
		$(".question19").slider("value", val);
		$(".question19").val(val);
		var val = ${requestScope.answer20} + "";
		$(".question20").slider("value", val);
		$(".question20").val(val);
		var val = ${requestScope.answer21} + "";
		$(".question21").slider("value", val);
		$(".question21").val(val);
		var val = ${requestScope.answer22} + "";
		$(".question22").slider("value", val);
		$(".question22").val(val);
		var val = ${requestScope.answer23} + "";
		$(".question23").slider("value", val);
		$(".question23").val(val);
		var val = ${requestScope.answer24} + "";
		$(".question24").slider("value", val);
		$(".question24").val(val);
		var val = ${requestScope.answer25} + "";
		$(".question25").slider("value", val);
		$(".question25").val(val);
		var val = ${requestScope.answer26} + "";
		$(".question26").slider("value", val);
		$(".question26").val(val);
		var val = ${requestScope.answer27} + "";
		$(".question27").slider("value", val);
		$(".question27").val(val);
		var val = ${requestScope.answer28} + "";
		$(".question28").slider("value", val);
		$(".question28").val(val);
		var val = ${requestScope.answer29} + "";
		$(".question29").slider("value", val);
		$(".question29").val(val);
		var val = ${requestScope.answer30} + "";
		$(".question30").slider("value", val);
		$(".question30").val(val);
		var val = ${requestScope.answer31} + "";
		$(".question31").slider("value", val);
		$(".question31").val(val);
		var val = ${requestScope.answer32} + "";
		$(".question32").slider("value", val);
		$(".question32").val(val);
		var val = ${requestScope.answer33} + "";
		$(".question33").slider("value", val);
		$(".question33").val(val);
		var val = ${requestScope.answer34} + "";
		$(".question34").slider("value", val);
		$(".question34").val(val);
		var val = ${requestScope.answer35} + "";
		$(".question35").slider("value", val);
		$(".question35").val(val);
		var val = ${requestScope.answer36} + "";
		$(".question36").slider("value", val);
		$(".question36").val(val);
		var val = ${requestScope.answer37} + "";
		$(".question37").slider("value", val);
		$(".question37").val(val);
		var val = ${requestScope.answer38} + "";
		$(".question38").slider("value", val);
		$(".question38").val(val);
		var val = ${requestScope.answer39} + "";
		$(".question39").slider("value", val);
		$(".question39").val(val);
		var val = ${requestScope.answer40} + "";
		$(".question40").slider("value", val);
		$(".question40").val(val);
	});
	
	//提交表单
	$(".up").on("click", function() {
		var answer_array = new Array(40);
		var isFull = 1; // 1-40题全部填满 0-有漏题
		for(var i=1; i<=40; i++) {
			if($(".question" + i).val() != null && $(".question" + i).val() > 0) {
				$(".input_question" + i).val($(".question" + i).val());
				answer_array[i-1] = $(".question" + i).val();
			} else {
				$(".input_question" + i).val(0);
				answer_array[i-1] = 0;
			}
		}
		for(var j =0; j<40; j++) {
			if(answer_array[j] == 0) {
				isFull = 0;
			}
		}
		if (isFull == 0) {
			alert("您有题目遗漏，请检查！");
			return;
		}
		ajax(proj + "/user/answerAnalysis", $("#msform").serialize(), function(data) {
			if(data == "success") {
				location.href = proj + "/user/majorTOP";
			} else {
				alert(data);
			}
		});
	});
	
</script>
</html>
