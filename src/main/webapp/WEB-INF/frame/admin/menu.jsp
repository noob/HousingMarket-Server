<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
%>
<!-- HEADER SECTION -->
<div id="left" >
      <ul id="menu" class="collapse">
      	<c:set var="selection" value="${param.selection }"></c:set>
      	 <input type="hidden" id="selection" value="${selection }"/>
      	 <li class='panel <c:if test="${selection == 0 || selection ==null}">active</c:if>'>
              <a href="<%=response.encodeUrl(path+"/admin/superadmin?selection=0")%>" >
                  <i class="icon-home"></i> 首页 
              </a>                   
          </li>
          <li class='panel <c:if test="${selection == 11 || selection == 12}">active</c:if>'>
              <a class="accordion-toggle collapsed"   href="#" data-parent="#menu" data-toggle="collapse"  data-target="#user_manage">
                  <i class="icon-user"></i> 用户管理
                  <span class="pull-right">
	                  	<c:choose><c:when test="${selection == 11 || selection == 12}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                  </span>
              </a>
              <ul <c:choose><c:when test="${selection == 11 || selection == 12}">class="in" id="user_manage"</c:when><c:otherwise>class="collapse" id="user_manage"</c:otherwise></c:choose>>
                  <li <c:if test="${selection == 12}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/userList?pagenation.page=1&selection=12")%>" ><i class="icon-angle-right"></i> 所有用户 </a></li>
              </ul>
          </li>
          <li class="panel   <c:if test="${selection ==21 || selection == 22 || selection ==23}">active</c:if>">
              <a class="accordion-toggle collapsed"  href="#" data-parent="#menu" data-toggle="collapse"  data-target="#schoolmajor">
                  <i class="icon-tasks"></i> 学校与专业
                  <span class="pull-right">
	                  	<c:choose><c:when test="${selection  == 21 || selection == 22 || selection == 23}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                  </span>
              </a>
              <ul <c:choose><c:when test="${selection  == 21 || selection == 22 || selection == 23}">class="in" id="schoolmajor"</c:when><c:otherwise>class="collapse" id="schoolmajor"</c:otherwise></c:choose>>
                  <li  <c:if test="${selection == 21}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/schoolList?pagenation.page=1&selection=21")%>"><i class="icon-angle-right"></i> 所有学校</a></li>
                  <li  <c:if test="${selection == 22}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/majorList?pagenation.page=1&selection=22")%>"><i class="icon-angle-right"></i> 所有专业</a></li>
                  <li  <c:if test="${selection == 23}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/school-majorList?pagenation.page=1&selection=23")%>"><i class="icon-angle-right"></i> 学校-专业</a></li>
              </ul>
          </li>
          <li class="panel   <c:if test="${selection ==31 || selection == 32 || selection == 33}">active</c:if>">
              <a class="accordion-toggle collapsed"  href="#" data-parent="#menu" data-toggle="collapse"  data-target="#question">
                  <i class="icon-tasks"></i> 题目管理
                  <span class="pull-right">
	                  	<c:choose><c:when test="${selection  == 31 || selection == 32 || selection == 33}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                  </span>
              </a>
              <ul <c:choose><c:when test="${selection  == 31 || selection == 32 || selection == 33}">class="in" id="question"</c:when><c:otherwise>class="collapse" id="question"</c:otherwise></c:choose>>
                  <li  <c:if test="${selection == 31}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/questionList?pagenation.page=1&selection=31")%>"><i class="icon-angle-right"></i> 所有题目</a></li>
                  <li  <c:if test="${selection == 32}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/weightList?pagenation.page=1&selection=32")%>"><i class="icon-angle-right"></i> 权重管理</a></li>
                  <li  <c:if test="${selection == 33}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/starList?selection=33")%>"><i class="icon-angle-right"></i> 星级管理</a></li>
              </ul>
          </li>
           <li class="panel   <c:if test="${selection ==41}">active</c:if>">
             <a class="accordion-toggle collapsed"  href="#" data-parent="#menu" data-toggle="collapse"  data-target="#filemanage">
                  <i class="icon-tasks"></i> 文件管理
                  <span class="pull-right">
	                  	<c:choose><c:when test="${selection ==41}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                  </span>
              </a>
              <ul <c:choose><c:when test="${selection ==41}">class="in" id="filemanage"</c:when><c:otherwise>class="collapse" id="filemanage"</c:otherwise></c:choose>>
                  <li  <c:if test="${selection == 41}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/fileList?pagenation.page=1&selection=41")%>"><i class="icon-angle-right"></i> 所有文件</a></li>
              </ul>
          </li>
          <li class="panel   <c:if test="${selection ==51}">active</c:if>">
             <a class="accordion-toggle collapsed"  href="#" data-parent="#menu" data-toggle="collapse"  data-target="#lessonmanage">
                  <i class="icon-tasks"></i> 培训管理
                  <span class="pull-right">
	                  	<c:choose><c:when test="${selection ==51}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                  </span>
              </a>
              <ul <c:choose><c:when test="${selection ==51}">class="in" id="lessonmanage"</c:when><c:otherwise>class="collapse" id="lessonmanage"</c:otherwise></c:choose>>
                  <li  <c:if test="${selection == 51}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/lessonList?pagenation.page=1&selection=51")%>"><i class="icon-angle-right"></i> 培训订单</a></li>
              </ul>
          </li>
<!--    
          <li class="panel <c:if test="${selection ==80}">active</c:if>"><a href="<%=path %>/admin/TVersion?selection=80"><i class="icon-android"></i> 版本更新</a></li>
       	<li class="panel <c:if test="${selection ==91 || selection ==92  || selection ==93}">active</c:if>">
             <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#notification">
                 <i class="icon-envelope"></i> 通知中心
                 <span class="pull-right">
                 		<c:choose><c:when test="${selection ==91 || selection ==92  || selection ==93}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                 </span>
             </a>
             <ul <c:choose><c:when test="${selection ==91 || selection ==92 || selection ==93}">class="in" id="notification"</c:when><c:otherwise>class="collapse" id="notification"</c:otherwise></c:choose>>
                 <li <c:if test="${selection == 91}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/Advise?selection=91") %>"><i class="icon-angle-right"></i> 建议与反馈 </a></li>
                 <li <c:if test="${selection == 92}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/Notification_informs?selection=92")%>"><i class="icon-angle-right"></i> 举报管理  </a></li>
                 <li <c:if test="${selection == 93}" >class="active"</c:if>><a href="<%=response.encodeUrl(path+"/admin/Notification?selection=93")%>"><i class="icon-angle-right"></i> 通知管理  </a></li>
             </ul>
         </li>
 -->
		<li class="panel <c:if test="${selection ==100}">active</c:if>">
              <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#blank-nav">
                  <i class="icon-cog"></i> 账户管理
                 <span class="pull-right">
                 		<c:choose><c:when test="${selection ==100}"><i class="icon-angle-down"></i></c:when><c:otherwise><i class="icon-angle-left"></i></c:otherwise></c:choose>
                 </span>
              </a>
              <ul <c:choose><c:when test="${selection ==100}">class="in" id="blank-nav"</c:when><c:otherwise>class="collapse" id="blank-nav"</c:otherwise></c:choose>>
                  <li <c:if test="${selection == 100}" >class="active"</c:if>><a href="<%=path %>/admin/modifyPswUI?selection=100"><i class="icon-angle-right"></i> 修改密码  </a></li>
              </ul>
          </li>
      </ul>

  </div>
<!-- END HEADER SECTION -->