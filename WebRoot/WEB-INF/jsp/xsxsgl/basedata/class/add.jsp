<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html>
<head>
	<title>班级信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/tcal.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/tcal.js"></script>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/images/title_arrow.gif"/> 班级信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="classAction_add.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 班级信息 </div> 
        </div>
        <table id="userwrap">
			<tr class="user">
      		  <td class="right">
        		<table>
            		<tr>
                    	<td class="one">班级编号</td>
                        <td class="two"><s:textfield name="bjbh" cssClass="inptxt"></s:textfield>
                    </tr>
                    <tr>
                    	<td class="one">班级名称</td>
                        <td class="two"><s:textfield name="bjmc" cssClass="inptxt"></s:textfield>
						</td>
                    </tr>
                <tr>
                	<td colspan="3"></td>
                    <td class="btn"><input type="submit" value="添加"/><input type="reset" value="重置"/></td>
                </tr>
            </table>
        </td>
    </tr>
    </s:form>
</div>
</body>
</html>
