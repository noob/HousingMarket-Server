<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String port;
if(request.getServerPort() == 80){port = "";}else{port = ":8080";}
String path = request.getScheme()+"://"+request.getServerName() +port+"/SchoolGuider";
%>
<script src="<%=path %>/js/jquery-1.9.0.min.js"></script>
<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="<%=path %>/js/jquery-ui.min.js"></script>
<script src="<%=path %>/plugins/uniform/jquery.uniform.min.js"></script>
<script src="<%=path %>/plugins/inputlimiter/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="<%=path %>/plugins/chosen/chosen.jquery.min.js"></script>
<script src="<%=path %>/plugins/colorpicker/js/bootstrap-colorpicker.js"></script>
<script src="<%=path %>/plugins/tagsinput/jquery.tagsinput.min.js"></script>
<script src="<%=path %>/plugins/validVal/js/jquery.validVal.min.js"></script>
<script src="<%=path %>/plugins/datepicker/js/bootstrap-datepicker.js"></script>
<script src="<%=path %>/plugins/timepicker/js/bootstrap-timepicker.min.js"></script>
<script src="<%=path %>/plugins/switch/static/js/bootstrap-switch.min.js"></script>
<script src="<%=path %>/plugins/jquery.dualListbox-1.3/jquery.dualListBox-1.3.min.js"></script>
<script src="<%=path %>/plugins/autosize/jquery.autosize.min.js"></script>
<script src="<%=path %>/js/formsInit.js"></script>