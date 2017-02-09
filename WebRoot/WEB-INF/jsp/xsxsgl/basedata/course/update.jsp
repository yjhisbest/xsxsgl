<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html>
<head>
	<title>课程信息</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/images/title_arrow.gif"/> 课程信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="courseAction_update.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 课程信息 </div> 
        </div>
        <table id="userwrap">
			<tr class="user">
      		  <td class="right">
        		<table>
            		<tr>
            		<s:hidden name="kcbh"/>
                        <td class="one">课程名称</td>
                        <td class="two"><s:textfield name="kcmc" cssClass="inptxt"></s:textfield>
						</td>
                    </tr>
                    <tr>
                    	<td class="one">学时</td>
                        <td class="two"><s:textfield name="classHour" cssClass="inptxt"></s:textfield>
						</td>
                    	<td class="one">开课时间</td>
                        <td>
                        	<input name="kksj" type="text" class="tcal inptxt" readonly="readonly" value="<s:property value="kksj"/>"/>
						</td>
                    </tr>
                    <tr>
                    	<td class="one">学分</td>
                        <td class="two"><s:textfield name="credit" cssClass="inptxt"></s:textfield>
						</td>
                    	<td class="one">考查方式</td>
                        <td class="two"><s:textfield name="kaohe" cssClass="inptxt"></s:textfield>
						</td>
                    </tr>
                <tr>
                	<td colspan="3"></td>
                    <td class="btn"><input type="submit" value="修改"/><input type="reset" value="重置"/></td>
                </tr>
            </table>
        </td>
    </tr>
    </s:form>
</div>
</body>
</html>
