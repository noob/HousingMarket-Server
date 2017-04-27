<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title>专业详情 - 后台管理 </title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<jsp:include page="../frame/super/header.jsp"></jsp:include>
<jsp:include page="../frame/super/menu.jsp"></jsp:include>

		<!--PAGE CONTENT -->
		<div id="content">
			<div class="inner">
				<div class="row">
					<div class="col-lg-12">
						<h3>权重详情</h3> 
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-9">
						<div class="panel panel-default" style="height: 100%">
							<div class="panel-heading">
								<h4>信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									<form id="weight_form"  method="post">
										<div class="form-group">
											<input type="hidden" value="${majorQuestion.majorCode}"  class="majorCode" name="majorCode"/>
											<input type="hidden" value="${majorQuestion.majorName }"  class="majorName" name="majorName"/>
											<input type="hidden" value="${majorQuestion.majorQuestionId }"  class="majorQuestionId" name="majorQuestionId"/>
												<div style="margin-left: 11px">
													 <dl style="float:left; width:100%;">
													 	<c:forEach items="${question }" var="question" varStatus="index_question">
													 	   <dt style="width:80%">${index_question.index + 1} . ${question.question }</dt>
														   <dd><input value=""  class="form-control weight${index_question.index+1}" name="weight${index_question.index+1}"  style="width:65px; "/></dd>
														   <br/><br/><hr class="grey_hr"/>
													 	</c:forEach>
													</dl>
												</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<button style="margin-left: 15px"  class="btn btn-primary modify">确认修改</button>
					<button style="margin-left: 15px" class="btn btn-dark back">  返回上一步</button>
				</div>
			</div>
		</div>
		<!--END PAGE CONTENT -->
		
	<jsp:include page="../frame/super/footer.jsp"></jsp:include>
	<script src="<%=path %>/js/common.js"></script>
	<script type="text/javascript">
		var proj = "<%=path%>";
    	$(document).on("click", ".back", function() {
			location.href = history.go(-1);
		});
		
		$(document).ready(function() {
			var weight1 = "${majorQuestion.weight1}";
			$(".weight1").val(weight1);
			var weight2 = "${majorQuestion.weight2}";
			$(".weight2").val(weight2);
			var weight3 = "${majorQuestion.weight3}";
			$(".weight3").val(weight3);
			var weight4 = "${majorQuestion.weight4}";
			$(".weight4").val(weight4);
			var weight5 = "${majorQuestion.weight5}";
			$(".weight5").val(weight5);
			var weight6 = "${majorQuestion.weight6}";
			$(".weight6").val(weight6);
			var weight7 = "${majorQuestion.weight7}";
			$(".weight7").val(weight7);
			var weight8 = "${majorQuestion.weight8}";
			$(".weight8").val(weight8);
			var weight9 = "${majorQuestion.weight9}";
			$(".weight9").val(weight9);
			var weight10 = "${majorQuestion.weight10}";
			$(".weight10").val(weight10);
			var weight11 = "${majorQuestion.weight11}";
			$(".weight11").val(weight11);
			var weight12 = "${majorQuestion.weight12}";
			$(".weight12").val(weight12);
			var weight13 = "${majorQuestion.weight13}";
			$(".weight13").val(weight13);
			var weight14 = "${majorQuestion.weight14}";
			$(".weight14").val(weight14);
			var weight15 = "${majorQuestion.weight15}";
			$(".weight15").val(weight15);
			var weight16 = "${majorQuestion.weight16}";
			$(".weight16").val(weight16);
			var weight17 = "${majorQuestion.weight17}";
			$(".weight17").val(weight17);
			var weight18 = "${majorQuestion.weight18}";
			$(".weight18").val(weight18);
			var weight19 = "${majorQuestion.weight19}";
			$(".weight19").val(weight19);
			var weight20 = "${majorQuestion.weight20}";
			$(".weight20").val(weight20);
			var weight21 = "${majorQuestion.weight21}";
			$(".weight21").val(weight21);
			var weight22 = "${majorQuestion.weight22}";
			$(".weight22").val(weight22);
			var weight23 = "${majorQuestion.weight23}";
			$(".weight23").val(weight23);
			var weight24 = "${majorQuestion.weight24}";
			$(".weight24").val(weight24);
			var weight25 = "${majorQuestion.weight25}";
			$(".weight25").val(weight25);
			var weight26 = "${majorQuestion.weight26}";
			$(".weight26").val(weight26);
			var weight27 = "${majorQuestion.weight27}";
			$(".weight27").val(weight27);
			var weight28 = "${majorQuestion.weight28}";
			$(".weight28").val(weight28);
			var weight29 = "${majorQuestion.weight29}";
			$(".weight29").val(weight29);
			var weight30 = "${majorQuestion.weight30}";
			$(".weight30").val(weight30);
			var weight31 = "${majorQuestion.weight31}";
			$(".weight31").val(weight31);
			var weight32 = "${majorQuestion.weight32}";
			$(".weight32").val(weight32);
			var weight33 = "${majorQuestion.weight33}";
			$(".weight33").val(weight33);
			var weight34 = "${majorQuestion.weight34}";
			$(".weight34").val(weight34);
			var weight35 = "${majorQuestion.weight35}";
			$(".weight35").val(weight35);
			var weight36 = "${majorQuestion.weight36}";
			$(".weight36").val(weight36);
			var weight37 = "${majorQuestion.weight37}";
			$(".weight37").val(weight37);
			var weight38 = "${majorQuestion.weight38}";
			$(".weight38").val(weight38);
			var weight39 = "${majorQuestion.weight39}";
			$(".weight39").val(weight39);
			var weight40 = "${majorQuestion.weight40}";
			$(".weight40").val(weight40);
		});
		
		$(document).on("click", ".modify", function() {
			var haveError = 0;
			for(var i=1; i<=10; i++) {
				if(isNaN($(".weight" + i).val())) {
					haveError = 1;
				}
			}
			if(haveError == 1) {
				alert("权重输入错误");
				return;
			} else {
				if(confirm("确认修改吗？")) {
					ajax(proj + "/admin/modifyWeight" + $("#jsessionid").val(), $("#weight_form").serialize(), function(data) {
						if(data == "success") {
							location.href = location.href;
						} else {
							alert(data);
						}
					});
				}
			}
		});
		
    </script>
</body>
</html>