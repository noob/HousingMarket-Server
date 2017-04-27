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
var name = $("#name").val();
var type = $("#type").val();
var begin = $("#begin").val();
var end = $("#end").val();
var cargoStatus = $("#cargoStatus").val();
var isok = true;
var delivery = {
		
		"initdelivery":function(){
			delivery.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: delivery.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			delivery.pagenation_delivery(page_index);
		},
		
		"pagenation_delivery":function(page_index){
			location.href = proj + "/admin/Delivery_deliveryManager"+"?page="+(page_index+1)+"&name="+name+"&type="+type+"&begin="+begin+"&end="+end+"&cargoStatus="+cargoStatus;
		},
		
		"option" : function() {
			$(document).on("blur", ".ttime", function() {
				$(this).siblings(".error").remove();
				if (delivery.isEmpty(this)) {
					delivery.appendInfo(this, "请输入自动收货时间！");
					isok = false;
					return;
				}else if (delivery.isNum(this)) {
					delivery.appendInfo(this, "只能输入数字！");
					isok = false;
					return;
				}else {
					isok = true;
					return;
				}
			});
			$(document).on("click", ".confirm", function() {
				$(".ttime").trigger("blur");
				var set_time = $(".ttime").val();
				if(isok){
					if(confirm("确认设置？")){
						ajax($("#set_time").attr("action"), {set_time:set_time}, function(data) {
							if(data == "no"){
								alert("请输入必要参数！");
							}else if (data == "error") {
								alert("出现未知错误！");
							}else {
								alert("设置成功!");
								location.href = location.href;
							}
						});
					}
				}
			});
			$(document).on("click", ".choose", function() {
				var type = $(".type").val();
				var name = $(".name").val();
				var begin = $(".begin").val();
				var end = $(".end").val();
				location.href = proj + "/admin/Delivery_deliveryManager"+"?name="+name+"&type="+type+"&begin="+begin+"&end="+end+"&cargoStatus="+cargoStatus;
			});
			$(document).on("click", ".details", function() {
				var cargoId = $(this).attr("data-id");
				location.href = proj + "/admin/Delivery_detailsCargo"+"?cargoId="+cargoId;
			});
		} ,
		
		"isEmpty" : function(input) {
			if ($.trim($(input).val()).length > 0) {
				return false;
			} else {
				return true;
			}
		},
		"lengthCheck" : function(input, min, max) {
			if ($.trim($(input).val()).length >= min
					&& $.trim($(input).val()).length <= max) {
				return true;
			} else {
				return false;
			}
		},

		// 增加错误信息
		"appendInfo" : function(input, info) {
			$(input).css("border", "rgb(247,97,32) 1px solid");
			$(input)
					.after(
							"<span class='error J-unitive-tip unitive-tip' style='color:#393939'><i class='fa fa-times-circle fa-lg' style='color:#F76120;'></i>&nbsp;"
									+ info + "</span>");
		},
		
		"isEmail" : function(input) {
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			return myreg.test($(input).val());
		},
		
		// 返回原状态
		"toNormal" : function(input) {
			$(input).css("border", "rgb(170,170,170) 1px solid");
		},
		"isNum" : function(value) {
			return isNaN($(value).val());
		},

		"islength" : function(value) {
			var idlength = ($(value).val()).length;
			if (idlength != 18 && idlength != 15) {
				return false;
			} else {
				return true;
			}
		},

		"isform" : function(value) {

			var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;

			return regIdCard.test($(value).val());

		},

		"isIdcard18" : function(value) {
			idCard = $(value).val();
			if (idCard.length == 18) {
				var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
						5, 8, 4, 2);
				var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2);
				var idCardWiSum = 0;
				for ( var i = 0; i < 17; i++) {
					idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
				}
				var idCardMod = idCardWiSum % 11;
				var idCardLast = idCard.substring(17);
				if (idCardMod == 2) {
					if (idCardLast == "X" || idCardLast == "x") {
						return true;
					} else {
						return false;
					}
				} else {
					if (idCardLast == idCardY[idCardMod]) {
						return true;
					} else {
						return false;
					}
				}
			}

		}

};