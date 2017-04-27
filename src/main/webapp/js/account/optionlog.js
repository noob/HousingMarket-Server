/**Ajax通用方法*/
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
var username = $("#username").val();
var begin = $("#begin").val();
var end = $("#end").val();
var option = {
		"initoption":function(){
			option.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: option.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			option.pagenation_option(page_index);
		},
		
		"pagenation_option":function(page_index){
			location.href = proj + "/admin/OptionLog"+"?page="+(page_index+1)+"&username="+username+"&begin="+begin+"&end="+end;
		},
		
		"option" : function() {
			$(document).on("click", ".looklog", function() {
				var begin = $(".begin").val();
				var end = $(".end").val();
				var username = $(".username").val();
				location.href = proj + "/admin/OptionLog"+"?username="+username+"&begin="+begin+"&end="+end;
			});
		}
};
