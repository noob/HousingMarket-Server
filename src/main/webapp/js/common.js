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


$(document).on('click',".cancel",function(){
	$("form")[0].reset();
});

function empty(value){
	if($(value).val() == undefined || $(value).val().length == 0){
		return true;
	} else {
		return false;
	}
}

function blurWarning(value){
	$(document).on("blur", value, function() {
		if(empty(value)){
			if(!$(value).parent().parent().hasClass("has-error"))
				$(value).parent().parent().addClass("has-error");
		} else {
			$(value).parent().parent().removeClass("has-error");
		};
	});
}

function ajaxFileUpload(url, fileId, handler) {
	$(fileId).ajaxFormUnbind();
	$(fileId).ajaxForm({
		url : url, // 请求的url
		type : "post", // 请求方式
		dataType : "json", // 响应的数据类型
		async :true, // 异步
		success : handler,
		error : function(msg){
			$(".mask").hide(50);
			alert("不要超过 10M！");
		}
	});
	$(fileId).attr("enctype", "multipart/form-data");
	$(fileId).submit();
	$(".mask").show(50); 
}

menu();
function menu(){
	$(document).on("click",".panel",function(){
		if($(this).parent().attr("class").indexOf("collapse") == -1)
			return;
		$(".panel").each(function(){
			if($(this).attr("class").indexOf("active") > 0){
				$(this).removeClass("active");
				$(this).find("i:eq(1)").removeClass("icon-angle-down").addClass("icon-angle-left");
			}
		});
		$(this).addClass("active");
		$(this).find("i:eq(1)").removeClass("icon-angle-left").addClass("icon-angle-down");
	});
}

var num_entries = $.trim($("#num_entries").val())*1;

var HZFPagination = {
		"pagetoUrl": "",
		"pagetoParams":[],
		"init":function(){
			HZFPagination.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: HZFPagination.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			HZFPagination.pagenationClick(page_index);
		},
		"pagenationClick":function(page_index){
			location.href = proj + HZFPagination.pagetoUrl+$("#jsessionid").val()+"?pagenation.page="+(page_index+1)+HZFPagination.getScreenValues(HZFPagination.pagetoParams);
		},
		"getScreenValues":function(array){
			var x;
			var values = "";
			for (x in array){
				if(array[x].indexOf("checkbox") > 0){
					if($(array[x]).is(':checked')){
						values += "&"+array[x].replace(/./,"").replace(/-checkbox/,"")+"="+$(array[x]).val();
					} else {
						continue;
					}
				} else {
					values += "&"+array[x].replace(/./,"")+"="+$(array[x]).val();
				}
			}
			return values;
		},
		"screen" : function(id) {
			$(document).on('click',id,function(){
				location.href = proj + HZFPagination.pagetoUrl+$("#jsessionid").val()+"?pagenation.page=1"+HZFPagination.getScreenValues(HZFPagination.pagetoParams);
			});
		},
		//页面跳转 如详情只需要id
		"pageToJump" : function(id, url, prefix) {
			$(document).on('click', id, function(){
				location.href = proj+url +$("#jsessionid").val()+"?"+prefix+$(this).attr("data-id")+"&selection="+$("#selection").val();
			});
		},
		"detailToList" : function(id, url, prefix) {
			$(document).on('click', id, function(){
				location.href = proj+url +$("#jsessionid").val()+"?pagenation.page=1&"+prefix+$(this).attr("data-id")+"&selection="+$("#selection").val();
			});
		},
		//需要2个元素如 id , code
		"twoParamsPageToJump" : function(id, url, prefix1, prefix2) {
			$(document).on('click', id, function(){
				location.href = proj+url +$("#jsessionid").val()+"?"+prefix1+$(this).attr("data-id")+"&"+prefix2+$(this).attr("data-code")+"&selection="+$("#selection").val();
			});
		},
		//springmvc 风格页面跳转
		"SpringMVCpageToJump" : function(id, url) {
			$(document).on('click', id, function(){
				location.href = proj+url + $(this).attr("data-id") +$("#jsessionid").val()+"?"+"&selection="+$("#selection").val();
			});
		}
};

var file_control =  {
		"init":function(){
			$(document).on('change',"#file_upload",function(){
				if($.trim($("#file_upload").val()) == ""){
					return;
				}
				$(".loading").show();
				$(".photo").hide();
				$("#form_modifyaccount").ajaxFormUnbind();
				$("#form_modifyaccount").ajaxForm({
					url : $("#form_modifyaccount").attr("action"), // 请求的url
					type : "post", // 请求方式
					dataType : "json", // 响应的数据类型
					async :true, // 异步
					success : function(data){
						$("#img").attr("src","/ccdjAdmin/images/"+data);
						data = data.substr(data.indexOf("temp/")+15);
						$("#pic_name").val(data);
						$(".loading").hide();
						$(".photo").show();
					},
					error : function(msg){
						alert("error:"+msg);
						$(".loading").hide();
						$(".photo").show();
					}
				});
				$("#form_modifyaccount").attr("enctype", "multipart/form-data");
				$("#form_modifyaccount").submit();
			});
			$(document).on('click',".photo",function(){
				$("#file_upload").trigger("click");
			});
			
		}

};
