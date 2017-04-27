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
/**
 * 获取后缀
 * @param path
 * @returns
 */
function getFileName(path){
	var pos1 = path.lastIndexOf('/');
	var pos2 = path.lastIndexOf('\\');
	var pos  = Math.max(pos1, pos2);
	if( pos<0 )
	return path;
	else
	return path.substring(pos+1);
}

var isRegist = new Array(0, 0);
var islogin = new Array(0, 0);
var isPSW = new Array(0, 0 ,0);
var isAccount = new Array(0, 0 ,0 ,0 ,0);
var admin = false;
var versionError = new Array(0 ,0);
var versionNo = $(".versionNo1").val();
var account = {
		
		/**注册校验*/
		"regist" : function() {
			$("#error_text_name").css("display", "none");
			$("#error_text_password").css("display", "none");
			$(document).on("blur", ".regist_userName", function() {
				if(!account.isEmpty(this) && $(".regist_userName").val().trim().length >= 5 && $(".regist_userName").val().trim().length <= 11) {
					$("#error_text_name").css("display", "none");
					isRegist[0] = 1;
					return;
				} else {
					$("#error_text_name").show();
					isRegist[0] = 0;
					return;
				}
			});
			$(document).on("blur", ".regist_password", function() {
				if(!account.isEmpty(this) && $(".regist_password").val().trim().length >= 6 && $(".regist_password").val().trim().length <= 18) {
					$("#error_text_password").css("display", "none");
					isRegist[1] = 1;
					return;
				} else {
					$("#error_text_password").show();
					isRegist[1] = 0;
					return;
				}
			});
			$(document).on("click", ".regist", function() {
				$(".regist_userName").trigger("blur");
				$(".regist_password").trigger("blur");
				var flag = true;
				for(var i =0; i<=1; i++) {
					if(isRegist[i] == 0) {
						flag = flase;
					}
				}
	      		if(flag == true) {
	      			ajax(proj + "/regist", $("#regist_form").serialize(), function(data) {
	      				if(data == "success") {
	      					data = "注册成功！";
	      					$(".regist_userName").val("");
	      					$(".regist_password").val("");
	      				}
	      				$("#msg").html(data);
	      			});
	      		}
	      	});
		},
		
	/**登陆校验*/
	"login" : function() {
		$(document).on("blur", ".username", function() {
			$(this).siblings(".error").remove();
			if (account.isEmpty(this)) {
				account.appendInfo(this, "请输入用户名");
				islogin[0] = 0;
				return;
			}else if (!account.lengthCheck(this, 2, 18)) {
				account.appendInfo(this, "用户名长度在2~18个字符之间");
				islogin[0] = 0;
				return;
			}else {
				islogin[0] = 1;
				return;
			}
		});
		$(document).on("blur", ".password", function() {
			$(this).siblings(".error").remove();
			if (account.isEmpty(this)) {
				account.appendInfo(this, "请输入密码");
				islogin[1] = 0;
				return;
			}else if (!account.lengthCheck(this, 6, 18)) {
				account.appendInfo(this, "密码长度在6~18个字符之间");
				islogin[1] = 0;
				return;
			}else {
				islogin[1] = 1;
				return;
			}
		});
		$(document).on("click", ".login", function() {
			$(".username").trigger("blur");
			$(".password").trigger("blur");
			var flag = true;
			for ( var i = 0; i <= 1; i++) {
				if (islogin[i] == 0) {
					flag = false;
				}
			}
			if (flag == true) {
				ajax($("#login_form").attr("action"),  $("#login_form").serialize(), function(msg) {
					if(msg=="no"){
						alert("请输入用户名与密码！");
					}else if(msg=="fail"){
						account.appendInfo($(".password"), "帐户名或密码错误！");
					}else if (msg=="error") {
						alert("表单出现未知错误");
					}else if (msg=="super") {
						location.href = proj+ "/admin/superadmin";
					}else if (msg=="admin") {
						location.href = proj+ "/admin/admin";
					}else if(msg=="success"){
						location.href = proj+ "/user/user";
					}else{
						
					}
				});
			}
		});
	},
	
	/**修改密码校验*/
	"accountPSW" : function() {
		$(document).on("blur",".password",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请填输入原密码！");
				isPSW[0] = 0;
				return;
			}else {
				isPSW[0] = 1;
				account.toNormal(this);
			}
		});
		
		$(document).on("blur",".newpassword",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入新密码！");
				isPSW[1]=0;
				return;
			} else if (!account.lengthCheck(this, 6, 18)) {
				account.appendInfo(this, "密码长度在6~18位！");
				isPSW[1]=0;
				return;
			} else {
				isPSW[1] = 1;
				account.toNormal(this);
			}
		});
		
		$(document).on("blur",".newpassword1",function(){
			$(this).siblings(".error").remove();
			var psd=$(".newpassword").val();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入确认密码！");
				isPSW[2]=0;
				return;
			}else if (psd!==$(this).val()) {
				account.appendInfo(this, "两次密码不一致！");
				isPSW[2]=0;
				return;
			}else {
				isPSW[2] = 1;
				account.toNormal(this);
			}
			
		});
		
		$(document).on("click","#modifyPSW",function(){
			$(".password").trigger("blur");
			$(".newpassword").trigger("blur");
			$(".newpassword1").trigger("blur");
			
			var a = true;
			for( var i = 0; i <= 2; i++){
				if(isPSW[i] == 0){
					a = false;
				}
			}
			if(a){
				ajax($("#modifypsw").attr("action"),  $("#modifypsw").serialize(), function(data) {
					if(data=="no"){
						alert("请输入必要信息！");
					}else if (data=="fail") {
						account.appendInfo($(".password"), "原密码不正确，请重新输入！");
					}else if(data=="error"){
						alert("表单出现未知错误！");
					}else {
						alert("修改成功，请重新登陆！");
						location.href=proj+"/loginOut";
					}
				});
			}
		});
	},
	
	"modifyaccount" : function() {
		$(document).on("click","#back",function(){
			location.href=history.go(-1);
		});
		
		$(document).on("blur",".realname",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入真实姓名！");
				isAccount[0]=0;
				return;
			}else if (!account.lengthCheck(this, 2, 10)) {
				account.appendInfo(this, "真实姓名长度为2~10个汉字！");
				isAccount[0]=0;
				return;
			}else {
				isAccount[0] = 1;
				account.toNormal(this);
			}
		});
		$(document).on("blur",".idcard",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "身份证号码不能为空！");
				isAccount[1]=0;
				return;
			}else if (!account.islength(this)) {
				account.appendInfo(this, "身份证长度不正确！");
				isAccount[1]=0;
				return;
			}else if (!account.isform(this)) {
				account.appendInfo(this, "身份证格式不正确！");
				isAccount[1]=0;
				return;
			}else if (!account.isIdcard18(this)&&account.lengthCheck(this, 18, 18)) {
				account.appendInfo(this, "身份证号码错误 ！");
				isAccount[1]=0;
				return;
			}else {
				isAccount[1] = 1;
				account.toNormal(this);
			}
		});
		
		$(document).on("blur",".mobile",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入手机号码！");
				isAccount[2]=0;
				return;
			}else if (account.isNum(this)) {
				account.appendInfo(this, "手机号码只能由数字组成！");
				isAccount[2]=0;
				return;
			}else if (!account.lengthCheck(this, 11, 11)) {
				account.appendInfo(this, "手机号码长度为11位！");
				isAccount[2]=0;
				return;
			}else {
				isAccount[2] = 1;
				account.toNormal(this);
			}
		});
		$(document).on("blur",".email",function(){
			$(this).siblings(".error").remove();
			if(!account.isEmpty(this)&&!account.isEmail(this)){
				account.appendInfo(this, "邮箱格式不正确！");
				isAccount[3]=0;
				return;
			}else {
				isAccount[3] = 1;
				account.toNormal(this);
			}
		});
		$(document).on("blur",".position",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入家庭住址！");
				isAccount[4]=0;
				return;
			}else if (!account.lengthCheck(this, 2, 100)) {
				account.appendInfo(this, "长度在两个汉字以上！");
				isAccount[4]=0;
				return;
			}else {
				isAccount[4] = 1;
				account.toNormal(this);
			}
		});
		
		$(document).on("click",".modifyaccount",function(){
			$(".realname").trigger("blur");
			$(".idcard").trigger("blur");
			if ( $(".realname").length <= 0 ) { 
				isAccount[0] == 1;
			} 
			if($(".idcard").length <= 0){
				isAccount[1] == 1;
			}
			$(".mobile").trigger("blur");
			$(".email").trigger("blur");
			$(".position").trigger("blur");
			var a = true;
			for( var i = 2; i <= 4; i++){
				if(isAccount[i] == 0){
					a = false;
				}
			}
			if(a){
				$("#form_modifyaccount").ajaxFormUnbind();
				ajax($("#form_modifyaccount").attr("action").replace("imgUpload","modifyAccount"),  $("#form_modifyaccount").serialize(), function(data) {
					if(data=="error"){
						alert("表单出现未知错误！");
					}else {
						alert("编辑成功");
						location.href=location.href;
					}
				});
			}
		});
		
	},
	
	"adminrole" : function() {
		$(document).on("blur",".username",function(){
			$(this).siblings(".error").remove();
			if(account.isEmpty(this)){
				account.appendInfo(this, "请输入账户名！");
				return;
			}else {
				admin = true;
				account.toNormal(this);
			}
		});
		$(document).on("click",".addadmin",function(){
			$(".username").trigger("blur");
			if(admin==true){
				ajax($("#adminuser").attr("action"),$("#adminuser").serialize(), function(data) {
					if(data=="no"){
						alert("请输入账户名！");
					}else if (data=="double") {
						account.appendInfo($(".username"), "账户名已存在！");
					}else if (data=="error") {
						alert("出现未知错误！");
					}else {
						location.href=location.href;
					}
				});
			}
		});
		$(document).on("click",".delete",function(){
			var adminId = $(this).attr("data-id");
			var imageId = $(this).attr("data-img");
			if(confirm("确认操作，此操作不可逆！")){
				ajax(proj+"/admin/Role_deleteAdmin", {adminId:adminId,imageId:imageId}, function(data) {
					if(data=="no"){
						alert("表单提交错误！");
					}else if (data=="error") {
						alert("出现未知错误！");
					}else {
						alert("撤销成功！");
						location.href=location.href;
					}
				});
			}
		});
		$(document).on("click",".option_log",function(){
			var adminId = $(this).attr("data-id");
			location.href = proj+"/admin/OptionLog?adminId="+adminId;
		});
	},
	
	"version" : function() {
		$(document).on("blur", ".versionNo", function() {
			$(this).siblings(".error").remove();
			if (account.isEmpty(this)) {
				account.appendInfo(this, "请输入版本号！");
				versionError[0] = 0;
				return;
			}else if (account.isNum(this)) {
				account.appendInfo(this, "版本号只能输入整型数字！");
				versionError[0] = 0;
				return;
			}else if (account.isInteger(this)) {
				account.appendInfo(this, "版本号只能输入整型数字！");
				versionError[0] = 0;
				return;
			}else if(parseFloat(versionNo) > parseFloat($(this).val())){
					account.appendInfo(this, "版本号需大于等于之前版本！");
					versionError[0] = 0;
					return;
			}else {
				versionError[0] = 1;
			}
		});
		$(document).on("blur", ".apkName", function() {
			$(this).siblings(".error").remove();
			if (account.isEmpty(this)) {
				account.appendInfo(this, "请输入apk名称！");
				versionError[1] = 0;
				return;
			}else if(account.isChinese(this)){
				account.appendInfo(this, "请输入英文！");
				versionError[1] = 0;
				return;
			}else {
				versionError[1] = 1;
				return;
			}
		});
		
		$(document).on('click',".confirm",function(){
			$(".versionNo").trigger("blur");
			$(".apkName").trigger("blur");
			var a = true;
			for( var i = 0; i <= 1; i++){
				if(versionError[i] == 0){
					a = false;
				}
			}
			if(a){
				var name = $("#apk").val();
				var extend = name.substring(name.lastIndexOf(".")+1);
				if(name==null||name==""){
					alert("请选择上传的文件！");
				}else if (extend!="apk") {
					alert("请上传后缀为APK的文件！");
				}else{
					$(".fileName").val(getFileName(name));
						if(confirm("确认上传？")){
							$("#form_version").submit();
							alert("更新成功！");
						}
				}
			}
		});
		$(document).on('click',".back",function(){
			location.href = history.go(-1);
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
	"isInteger":function(value){
		var value = $(value).val();
		if(!isNaN(value)){
			return  !(value % 1 === 0);
		}else{
		   return false;
		}
	},
	"isChinese":function(value){
		if (escape($(value).val()).indexOf("%u") < 0) 
		{ 
			return false;
		} 
		return true;
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



