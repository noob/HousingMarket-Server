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
						<h3>专业详情</h3> 
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 650px">
							<div class="panel-heading">
								<h4>专业信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									<dl>
									   <dt>专业编号</dt>
									   <dd>${major.majorId}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>专业代码</dt>
									   <dd>${major.majorCode}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>专业名</dt>
									   <dd>${major.majorName}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>专业类别</dt>
									   <dd>${major.cate}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>须选考科目</dt>
									   <dd>${major.subject} </dd>
									   <br/><hr class="grey_hr"/>
									   <dt>专科本科</dt>
									   <dd>${major.level}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>是否重点</dt>
									   <dd><c:if test="${major.isKey == 0 }">否</c:if><c:if test="${major.isKey == 1 }">是</c:if></dd>
									   <br/><hr class="grey_hr"/>
									    <dt>文理需求</dt>
									   <dd><c:if test="${major.department == 0}">无</c:if><c:if test="${major.department == 1}">文科</c:if><c:if test="${major.department == 2}">理科</c:if></dd>
									   <br/><hr class="grey_hr"/>
									    <dt>学费/年</dt>
									   <dd>${major.tuition }</dd>
									   <br/><hr class="grey_hr"/>
									    <dt>分数需求</dt>
									   <dd>${major.score }</dd>
									   <br/><hr class="grey_hr"/>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 100%">
							<div class="panel-heading">
								<h4>学校信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									 <dl style="float:left;width:50%">
									 		<dt>学校代码</dt>
										   <dd>${major.schoolCode}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>哈哈哈ha</dt>
										   <dd></dd>
										   <br/><hr class="grey_hr"/>
										   <dt>给赞总数</dt>
										   <dd>${u.praiseCount}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>教程收藏数</dt>
										   <dd>${u.courseCollectCount}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>发布教学数</dt>
										   <dd>${u.teachingCount}</dd>
										   <br/><hr class="grey_hr"/>
									</dl>
									<dl style="float:left;width:50%">
											<dt>学校名称</dt>
										   <dd>${major.schoolName}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>被关注数</dt>
										   <dd>${u.getWatchCount}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>收赞总数</dt>
										   <dd>${u.getPraiseCount}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>乐趣收藏数</dt>
										   <dd>${u.lequCollectCount}</dd>
										   <br/><hr class="grey_hr"/>
										   <dt>发布乐趣数</dt>
										   <dd>${u.lequCount}</dd>
										   <br/><hr class="grey_hr"/>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<button style="margin-left: 15px"  class="btn btn-primary modifyMajor" data-toggle="modal" data-target="#formModal" >修改详情</button>
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
					<form id="major_form"  method="post">
						<div class="form-group">
							<input type="hidden" value="${major.majorId }"  class="id" name="majorId"/>
							<input type="hidden" value="${major.majorCode }"  class="mcode" name="majorCode"/>
							<input type="hidden" value="${major.majorName }"  class="mname" name="majorName"/>
							<input type="hidden" value="${major.schoolCode }"  class="scode" name="schoolCode"/>
							<input type="hidden" value="${major.schoolName }"  class="sname" name="schoolName"/>
							<span>专业类别</span> 
							<input class="form-control cate" name="cate" value="${major.cate }"/><br/>
							<span>本科or专科</span> 
							<input class="form-control level" name="level" value="${major.level }" placeholder="例如：本科"/><br/>
							<span>是否重点</span> 
							<input class="form-control isKey" name="isKey" <c:if test="${major.isKey == 0}">value="否"</c:if><c:if test="${major.isKey == 1}">value="是"</c:if> placeholder="例如：是"/><br/>
							<span>文科or理科</span> 
							<input class="form-control department" name="department" <c:if test="${major.department == 1}">value="文科"</c:if><c:if test="${major.department == 2}">value="理科"</c:if><c:if test="${major.department == 0}">value="不限"</c:if> placeholder="例如：文科"/><br/>
							<span>需选考科目(选填)</span>
							<input class="form-control course3" name="subject" placeholder="例如：物理，化学，生物" value="${major.subject }"/><br/>
							<span>学费/年</span>
							<input class="form-control tuition" name="tuition" value="${major.tuition }"/><br/>
							<span>需求分数</span>
							<input class="form-control score" name="score" value="${major.score }"/><br/>
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
		
		$(document).on("click", ".confirm", function() {
			var haveError = 0;
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
				} else if($(".department").val().trim() == "不限") {
					$(".department").val(0);
				}
				ajax(proj + "/admin/modifyMajor" + $("#jsessionid").val(), $("#major_form").serialize(), function(data) {
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