<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生信息管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/JavaScript">
	$(function(){
		$(".four").click(function(){
			alert("请联系管理员");
		});
	});
</script>
<style type="text/css">
<!--
body {margin:0;}
.STYLE1 {
	font-size: 12px;
	color: #2b7dbb;
}
-->
</style>
<base target="_parent"/>
<script type="text/JavaScript">

</script>
</head>
<body>
<div id="topwrap">
	<div class="top">
		<div class="top_left"></div>
    </div>
    <div class="top_bottom">
    	<div class="top_bot_right">
        	<a href="${pageContext.request.contextPath }/loginAction_logout.action" class="one">注销</a><a  class="four">在线支持</a><a class="five">帮助</a>
        </div>
        <div class="top_bot_left">${sessionScope.teacher.jsmc }  您好!!</div>
    </div>
</div>
</body>
</html>