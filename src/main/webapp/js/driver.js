function ajax(url, senddata, handler) {
	$.ajax({
		url : url,
		type : "post",
		data : senddata,
		timeout : 5000,
		dataType : "json",
		async : false,
		success : handler,
		error : function(msg) {
			alert("系统错误 ！" + msg);
		},
		complete : function(XMLHttpRequest, status) {
			if (status == 'timeout') {
				ajaxTimeoutTest.abort();
				alert("请求超时，请检查网络状态！");
			}
		}
	});
}
var num_entries = $.trim($("#num_entries").val())*1;
var driverName = $("#driverName").val();
var verifyStatus = $("#verifyStatus").val();
var driverStatus = $("#driverStatus").val();

var audit = {
		"initTDriver":function(){
			audit.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: audit.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			audit.pagenation_TDriver(page_index);
		},
		
		"pagenation_TDriver":function(page_index){
			location.href = proj + "/admin/Driver"+"?page="+(page_index+1)+"&driverName="+driverName+"&verifyStatus="+verifyStatus;
		},
		"init" : function() {
			$(document).on('click',".choose",function(){
				var driverName = $(".driverName").val();
				var verifyStatus = $(".verifyStatus").val();
				location.href = proj + "/admin/Driver"+"?driverName="+driverName+"&verifyStatus="+verifyStatus;
			});
			$(document).on('click',".agree",function(){
				var driverId = $(this).attr("data-id");
				var verifyStatus = $(this).attr("data-verifyStatus");
				if(confirm("确认操作？")){
					ajax(proj+"/admin/Driver_auditTDriver", {driverId:driverId,verifyStatus:verifyStatus}, function(data) {
						if(data=="no"){
							alert("请上传必要参数！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("审核通过！");
							location.href=location.href;
						}
					});
				}
			});
			$(document).on('click',".reject",function(){
				var driverId = $(this).attr("data-id");
				var verifyStatus = $(this).attr("data-verifyStatus");
				if(confirm("确认操作？")){
					ajax(proj+"/admin/Driver_auditTDriver", {driverId:driverId,verifyStatus:verifyStatus}, function(data) {
						if(data=="no"){
							alert("请上传必要参数！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("已驳回！");
							location.href=location.href;
						}
					});
				}
			});
			$(document).on('click',".disagree",function(){
				var driverId = $(this).attr("data-id");
				var verifyStatus = $(this).attr("data-verifyStatus");
				if(confirm("确认操作？")){
					ajax(proj+"/admin/Driver_deleteTDriver", {driverId:driverId,verifyStatus:verifyStatus}, function(data) {
						if(data=="no"){
							alert("请上传必要参数！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("已拒绝！");
							location.href=location.href;
						}
					});
				}
			});
			$(document).on('click',".details",function(){
				var driverId = $(this).attr("data-id");
				var type = 0;
				location.href = proj + "/admin/Driver_detailTDriver"+"?driverId="+driverId+"&type="+type;
			});
		},
		
};

var TDriver = {
		"initTDriver":function(){
			audit.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: audit.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			audit.pagenation_TDriver(page_index);
		},
		
		"pagenation_TDriver":function(page_index){
			location.href = proj + "/admin/Driver_dirverManager"+"?page="+(page_index+1)+"&driverName="+driverName+"&driverStatus="+driverStatus;
		},
		"optionTDriver" : function() {
			$(document).on('click',".choose",function(){
				var driverName = $(".driverName").val();
				var driverStatus = $(".driverStatus").val();
				location.href = proj + "/admin/Driver_dirverManager"+"?driverName="+driverName+"&driverStatus="+driverStatus;
			});
			$(document).on('click',".dongjie",function(){
				var driverId = $(this).attr("data-id");
				var driverStatus = $(this).attr("data-driverStatus");
				if(confirm("确认操作？")){
					ajax(proj+"/admin/Driver_optionTDriver", {driverId:driverId,driverStatus:driverStatus}, function(data) {
						if(data=="no"){
							alert("请上传必要参数！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("已冻结！");
							location.href=location.href;
						}
					});
				}
			});
			$(document).on('click',".jiedong",function(){
				var driverId = $(this).attr("data-id");
				var driverStatus = $(this).attr("data-driverStatus");
				if(confirm("确认操作？")){
					ajax(proj+"/admin/Driver_optionTDriver", {driverId:driverId,driverStatus:driverStatus}, function(data) {
						if(data=="no"){
							alert("请上传必要参数！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("已解冻！");
							location.href=location.href;
						}
					});
				}
			});
			$(document).on('click',".details",function(){
				var driverId = $(this).attr("data-id");
				var type = 1;
				location.href = proj + "/admin/Driver_detailTDriver"+"?driverId="+driverId+"&type="+type;
			});
			$(document).on('click',".jilu",function(){
				var driverId = $(this).attr("data-id");
				location.href = proj + "/admin/Driver_deliveryLog"+"?driverId="+driverId;
			});
		},
};
var driverId = $("#driverId").val();
var begin = $("#begin").val();
var end = $("#end").val();
var cargoStatus = $("#cargoStatus").val();
var name = $("#name").val();
var history_log = {
		"initlog":function(){
			history_log.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: history_log.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			history_log.pagenation_log(page_index);
		},
		
		"pagenation_log":function(page_index){
			location.href = proj + "/admin/Driver_deliveryLog"+"?page="+(page_index+1)+"&driverId="+driverId+"&begin="+begin+"&end="+end+"&cargoStatus="+cargoStatus;
		},
		
		"option" : function() {
			$(document).on('click',".choose",function(){
				var cargoStatus = $(".cargoStatus").val();
				var begin = $(".begin").val();
				var end = $(".end").val();
				location.href = proj + "/admin/Driver_deliveryLog"+"?driverId="+driverId+"&cargoStatus="+cargoStatus+"&begin="+begin+"&end="+end;
			});
			$(document).on('click',".details",function(){
				var cargoId = $(this).attr("data-id");
				location.href = proj + "/admin/User_cargoDetails"+"?cargoId="+cargoId;
			});
		}
		
};
var delivery_manager = {
		"initdelivery":function(){
			delivery_manager.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: delivery_manager.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			delivery_manager.pagenation_delivery(page_index);
		},
		
		"pagenation_delivery":function(page_index){
			location.href = proj + "/admin/Driver_deliveryLog"+"?page="+(page_index+1)+"&driverId="+driverId+"&begin="+begin+"&end="+end+"&cargoStatus="+cargoStatus;
		},
};