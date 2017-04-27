/** Ajax通用方法 */
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
var cardate = {
	"optioncarmodel" : function() {
		$(document).on("click", ".addcarmodel", function() {
			if($("#model").val()==null||$("#model").val()==""){
				alert("请输入车辆类型！");
				return;
			}else if ($("#model").val().length<2||$("#model").val().length>10) {
				alert("车辆类型长度在2~10个汉字之间！");
				return;
			}else {
				var model = $("#model").val();
				ajax(proj+"/admin/Cardate_addCarModel", {model:model}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请输入必填项！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
		$(document).on("click", ".deletecartype", function() {
			var cmId = $(this).attr("data-id");
			var model = $(this).attr("data-model");
			if(confirm("确认操作？此操作不可逆！")){
				ajax(proj+"/admin/Cardate_deleteCarModel", {cmId:cmId,model:model}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请上传必要参数！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
		$(document).on("click", ".addcarlength", function() {
			if($(".length").val()==null||$(".length").val()==""){
				alert("请输入车长！");
				return;
			}else {
				var length = $(".length").val();
				ajax(proj+"/admin/Cardate_addCarLength", {length:length}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请输入必填项！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
		$(document).on("click", ".deletecarlength", function() {
			var clId = $(this).attr("data-id");
			var length = $(this).attr("data-length");
			if(confirm("确认操作？此操作不可逆！")){
				ajax(proj+"/admin/Cardate_deleteCarLength", {clId:clId,length:length}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请上传必要参数！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
		$(document).on("click", ".addcargotype", function() {
			if($(".cargoTypeName").val()==null||$(".cargoTypeName").val()==""){
				alert("请输入货物类型！");
				return;
			}else if ($(".cargoTypeName").val().length<2||$(".cargoTypeName").val().length>10) {
				alert("货物类型长度在2~10个汉字之间！");
				return;
			}else {
				var cargoTypeName = $(".cargoTypeName").val();
				ajax(proj+"/admin/Cardate_addCargoType", {cargoTypeName:cargoTypeName}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请输入必填项！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
		$(document).on("click", ".deletecargotype", function() {
			var cargoTypeId = $(this).attr("data-id");
			var cargoTypeName = $(this).attr("data-type");
			if(confirm("确认操作？此操作不可逆！")){
				ajax(proj+"/admin/Cardate_deleteCargoType", {cargoTypeId:cargoTypeId,cargoTypeName:cargoTypeName}, function(data) {
					if(data=="error"){
						alert("出现未知错误！");
					}else if (data=="no") {
						alert("请上传必要参数！");
					}else {
						location.href=proj+"/admin/Cardate";
					}
				});
			}
		});
	},
};