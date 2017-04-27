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
<title>学校详情 - 后台管理 </title>
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
						<h3>学校详情</h3>
					</div>
				</div>
				<hr />
				<div class="row">
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 450px">
							<div class="panel-heading">
								<h4>基本信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									<dl>
									   <dt>学校编号</dt>
									   <dd>${school.schoolId}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>学校代码</dt>
									   <dd>${school.schoolCode}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>学校名字</dt>
									   <dd>${school.schoolName}</dd>
									   <br/><hr class="grey_hr"/>
									   <dt>所属省份</dt>
									   <dd>${school.schoolRegion}</dd>
									   <br/><hr class="grey_hr"/>
									</dl>
								</div>

							</div>
						</div>
					</div>
					
					<div class="col-lg-6">
						<div class="panel panel-default" style="height: 100%">
							<div class="panel-heading">
								<h4>业务信息</h4>
							</div>
							<div class="panel-body">
								<div style="margin-left: 11px">
									 <dl style="float:left;width:50%">
									 		<dt>总积分</dt>
										   <dd>${u.uPoint}</dd>
										   <br/><hr class="grey_hr"/>
										 	<dt>关注数</dt>
										   <dd>${u.watchCount}</dd>
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
											<dt>分享总数</dt>
										   <dd>${u.shareCount}</dd>
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
					<button style="margin-left: 15px" class="btn btn-primary school" data-id="${school.schoolCode }">  查询所有专业</button>
					<button style="margin-left: 15px" class="btn btn-dark back">  返回上一步</button>
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="../frame/super/footer.jsp"></jsp:include>
	<script>
       $(function () { formInit(); });
	</script>
	<script type="text/javascript" src="<%=path %>/js/jquery.pagination.js"></script>
	<script src="<%=path %>/js/common.js"></script>
	<script type="text/javascript">
		var proj = "<%=path %>";
		HZFPagination.detailToList(".school", "/admin/majorList", "schoolCode=");
		
    	$(document).on("click", ".back", function() {
			location.href = history.go(-1);
		});
    </script>
</body>
</html>