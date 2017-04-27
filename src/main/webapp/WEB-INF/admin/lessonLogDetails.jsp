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
<title>培训订单详情 - 后台管理 </title>
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
						<h3>培训订单详情</h3> 
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 100%">
							<div class="panel-heading">
								<h4>用户信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									<dl>
									   <dt>用户编号</dt>
									   <dd>${lessonLog.userId}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>用户昵称</dt>
									   <dd>${lessonLog.userName}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>真实姓名</dt>
									   <dd>${lessonLog.realName}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>身份证号码</dt>
									   <dd>${lessonLog.idCard} </dd>
									   <br/><hr class="grey_hr"/>
									   <dt>联系方式</dt>
									   <dd>${lessonLog.userMobile}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>高中学校</dt>
									   <dd>${lessonLog.highSchoolName}</dd>
									   <br/><hr class="grey_hr"/>
									    <dt>性别</dt>
									   <dd><c:if test="${lessonLog.gender == 0}">女</c:if><c:if test="${lessonLog.gender == 1}">男</c:if></dd>
									   <br/><hr class="grey_hr"/>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 100%">
							<div class="panel-heading">
								<h4>培训订单信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									 <dl>
									 	<dt>订单编号</dt>
									   	<dd>${lessonLog.lessonLogId}</dd>
										<br/><hr class="grey_hr"/>
									 	<dt>商户订单号</dt>
									   	<dd>${lessonLog.outTradeNo}</dd>
										<br/><hr class="grey_hr"/>
									 	<dt>支付宝交易号</dt>
									   	<dd>${lessonLog.tradeNo}</dd>
										<br/><hr class="grey_hr"/>
									 	<dt>买家支付宝账号</dt>
									   	<dd>${lessonLog.buyerAlipayAccount}</dd>
										<br/><hr class="grey_hr"/>
										<dt>订单价格</dt>
										<dd>${lessonLog.realPrice}</dd>
										 <br/><hr class="grey_hr"/>
										<dt>培训编号</dt>
										<dd>${lessonLog.lessonId}</dd>
										 <br/><hr class="grey_hr"/>
										<dt>培训名称</dt>
										<dd>${lessonLog.lessonName}</dd>
										 <br/><hr class="grey_hr"/>
										<dt>培训开始时间</dt>
										<dd><fmt:formatDate pattern="yyyy-MM-dd" value="${lessonLog.lessonBeginDate}" /></dd>
										 <br/><hr class="grey_hr"/>
										<dt>记录创建时间</dt>
										<dd><fmt:formatDate pattern="yyyy-MM-dd" value="${lessonLog.createTime}" /></dd>
										 <br/><hr class="grey_hr"/>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<button style="margin-left: 15px" class="btn btn-dark back">  返回上一步</button>
				</div>
			</div>
		</div>
		<!--END PAGE CONTENT -->
		
	<div class="modal fade" id="formModal" tabindex="-1" >
		<div class="modal-dialog">
			<div class="modal-content" style="width: 400px;margin-left:100px">
				<div class="modal-header">
					<h4 class="modal-title" id="H2">修改专业</h4>
				</div>
				<div class="modal-body">
					<form id="schoolMajor_form"  method="post">
						<div class="form-group">
							<p>${schoolMajor.majorCode }  ${schoolMajor.majorName }</p>
							<input type="hidden" value="modify"  class="type" name="type"/>
							<input type="hidden" value="${schoolMajor.schoolMajorId }"  class="id" name="schoolMajorId"/>
							<input type="hidden" value="${schoolMajor.majorCode }"  class="mcode" name="majorCode"/>
							<input type="hidden" value="${schoolMajor.majorName }"  class="mname" name="majorName"/>
							<input type="hidden" value="${schoolMajor.schoolCode }"  class="sname" name="schoolCode"/>
							<input type="hidden" value="${schoolMajor.schoolName }"  class="sname" name="schoolName"/>
							<input class="form-control level" name="level" value="${schoolMajor.level }" placeholder="本科or专业   例如：本科"/><br/>
							<input class="form-control isKey" name="isKey"  value="${schoolMajor.isKey }"   placeholder="是否重点  例如：是"/><br/>
							<input class="form-control department" name="department" <c:if test="${schoolMajor.department == 1}">value="文科"</c:if><c:if test="${schoolMajor.department == 2}">value="理科"</c:if><c:if test="${schoolMajor.department == 0}">value="不限"</c:if> placeholder="文科or理科  例如：文科"/><br/>
							<input class="form-control subject1" name="subject1" placeholder="选考科目1（可选）"/><br/>
							<input class="form-control subject2" name="subject2" placeholder="选考科目2（可选）"/><br/>
							<input class="form-control subject3" name="subject3" placeholder="选考科目3（可选）"/><br/>
							<input type="hidden" value="" class="subject" name="subject"/>
							<input class="form-control tuition" name="tuition" value="${schoolMajor.tuition }" placeholder="学费/年"/><br/>
							<input class="form-control score" name="score" value="${schoolMajor.score }" placeholder="需求分数"/><br/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success confirm">确认</button>
					<button type="button" class="btn btn-default cancel" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
		
	<jsp:include page="../frame/super/footer.jsp"></jsp:include>
	<script src="<%=path %>/js/common.js"></script>
	<script type="text/javascript">
		var proj = "<%=path%>";
    	$(document).on("click", ".back", function() {
			location.href = history.go(-1);
		});
		
		$(document).on("click", ".modify", function() {
			var subj = new Array();
			if($(this).attr("data-subject").length > 0) {
				subj = $(this).attr("data-subject").split("，");
				for(var i=0; i<subj.length; i++) {
					var index = i+1;
					$(".subject" + index).val(subj[i]);
				}
				for(var j=3; j>subj.length; j--) {
					$(".subject" + j).val(null);
				}
			} else {
				$(".subject1").val(null);
				$(".subject2").val(null);
				$(".subject3").val(null);
				$(".subject").val(null);
			}
		});
		
		$(document).on("click", ".confirm", function() {
			var haveError = 0;
			var sub = "";
			if($(".level").val().trim() != "本科" && $(".level").val().trim() != "专科" && $(".level").val().trim() != "" && $(".level").val().trim() != null) {
				alert("请填写本科或专科！");
				haveError = 1;
			}
			if($(".isKey").val().trim() != "是" && $(".isKey").val().trim() != "否" && $(".isKey").val().trim() != "" && $(".isKey").val().trim() != null) {
				alert("是否重点选项填写错误！");
				haveError = 1;
			}
			if($(".department").val().trim() != "文科" && $(".department").val().trim() != "理科" && $(".department").val().trim() != "不限" && $(".department").val().trim() != "" && $(".department").val().trim() != null) {
				alert("文科or理科选项填写错误！");
				haveError = 1;
			}
			if(haveError == 1) {
				return;
			} else {
				if($(".isKey").val().trim() == "是") {
					$(".isKey").val(1);
				} else if($(".isKey").val().trim() == "否") {
					$(".isKey").val(0);
				}
				if($(".department").val().trim() == "文科") {
					$(".department").val(1);
				} else if($(".department").val().trim() == "理科") {
					$(".department").val(2);
				} else if($(".department").val().trim() == "不限" || $(".department").val().trim() == "" || $(".department").val().trim() == null) {
					$(".department").val(0);
				}
						//科目校验
				if($(".subject1").val().trim().length > 0) {
					sub = $(".subject1").val().trim();
				}
				if($(".subject2").val().trim().length > 0) {
					if(sub.length > 0) {
						sub += "，" + $(".subject2").val().trim();
					} else {
						sub = $(".subject2").val().trim();
					}
				}
				if($(".subject3").val().trim().length > 0) {
					if(sub.length > 0) {
						sub += "，" + $(".subject3").val().trim();
					} else {
						sub = $(".subject3").val().trim();
					}
				}
				$(".subject").val(sub);
				ajax(proj + "/admin/operateSchoolMajor" + $("#jsessionid").val(), $("#schoolMajor_form").serialize(), function(data) {
					if(data == "success") {
						location.href = location.href;
					} else {
						alert(data);
					}
				});
			}
		});
		
    </script>
</body>
</html>