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
var question = new Array(0, 0);
var question = {
		"initquestion":function(){
			question.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: question.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			question.pagenation_question(page_index);
		},
		
		"pagenation_question":function(page_index){
			location.href = proj + "/admin/Question"+"?page="+(page_index+1);
		},
		"optionquestion" : function() {
			
			$(document).on("blur",".question",function(){
				$(this).siblings(".error").remove();
				if(question.isEmpty(this)){
					question.appendInfo(this, "请输入问题！");
					question[0] = 0;
					return;
				}else {
					question[0] = 1;
					question.toNormal(this);
				}
			});
			$(document).on("blur",".answer",function(){
				$(this).siblings(".error").remove();
				if(question.isEmpty(this)){
					question.appendInfo(this, "请输入答案！");
					question[1] = 0;
					return;
				}else {
					question[1] = 1;
					question.toNormal(this);
				}
			});
			
			$(document).on("click", ".publish", function() {
				$(".cqId").val(null);
				$(".question").val(null);
				$(".answer").val(null);
			});
			
			$(document).on("click", ".edit", function() {
				var cqId = $(this).attr("data-id");
				var question = $(this).attr("data-qu");
				var answer = $(this).attr("data-an");
				$(".cqId").val(cqId);
				$(".question").val(question);
				$(".answer").val(answer);
				$("#typeuser").hide();
			});
			
			$(document).on("click", ".confirm", function() {
				var id = $(".cqId").val();
				$(".question").trigger("blur");
				$(".answer").trigger("blur");
				var flag = true;
				for ( var i = 0; i <= 1; i++) {
					if (question[i] == 0) {
						flag = false;
					}
				}
				if(flag){
					if(id!=null&&id!=""){
						ajax($("#addquestion").attr("action").replace("addQuestion","modifyQuestion"),  $("#addquestion").serialize(), function(data) {
							if(data=="no"){
								question.appendInfo($(".answer"), "请输入问题与答案！");
							}else if (data=="error") {
								alert("出现未知错误！");
							}else {
								alert("编辑成功");
								location.href=location.href;
							}
						});
					}else {
						ajax($("#addquestion").attr("action"),  $("#addquestion").serialize(), function(data) {
							if(data=="no"){
								question.appendInfo($(".answer"), "请输入问题与答案！");
							}else if (data=="error") {
								alert("出现未知错误！");
							}else {
								alert("添加成功！");
								location.href=location.href;
							}
						});
					}
					
				}
			});
			$(document).on("click", ".delete", function() {
				var cqId = $(this).attr("data-id");
				if(confirm("确认操作，此操作不可逆！")){
					ajax(proj+"/admin/Question_deleteQuestion", {cqId:cqId}, function(data) {
						if(data=="error"){
							alert("出现未知错误！");
						}else {
							alert("删除成功");
							location.href=location.href;
						}
					});
				}
			});
			
		},
		

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
		// 返回原状态
		"toNormal" : function(input) {
			$(input).css("border", "rgb(170,170,170) 1px solid");
		},
};

var advice = {
		"initadvice":function(){
			advice.initPagination($("#current_page").val());
		},
		"initPagination":function(current){
			 $("#Pagination").pagination(num_entries, {
		            callback: advice.pageClickCallback,
		            items_per_page:10,
		            num_edge_entries:2,// Show only one item per page
		            prev_text:"上一页",
		            next_text:"下一页",
		            current_page:current-1
		        });
		},
		"pageClickCallback":function(page_index, jq){
			advice.pagenation_advice(page_index);
		},
		
		"pagenation_advice":function(page_index){
			location.href = proj + "/admin/Advise"+"?page="+(page_index+1);
		},
		"optionadvice" : function() {
			$(document).on("click", ".details", function() {
				var linkman = $(this).attr("data-link");
				var contact = $(this).attr("data-con");
				var sendtime = $(this).attr("data-time");
				var content = $(this).attr("data-content");
				$(".linkman").val(linkman);
				$(".contact").val(contact);
				$(".sendtime").val(sendtime);
				$(".content").val(content);
			});
			$(document).on("click", ".delete", function() {
				var adviceId = $(this).attr("data-id");
				if(confirm("确认删除？此次操作不可逆？")){
					ajax(proj+"/admin/Advise_deleteAdvice", {adviceId:adviceId}, function(data) {
						if(data=="no"){
							alert("请选择操作项！");
						}else if (data=="error") {
							alert("出现未知错误！");
						}else {
							alert("删除成功！");
							location.href=location.href;
						}
					});
				}
			});
		},
};
