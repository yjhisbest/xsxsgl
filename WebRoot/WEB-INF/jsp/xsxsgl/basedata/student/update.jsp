<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html>
<head>
	<title>学生信息</title>
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
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/images/title_arrow.gif"/> 学生信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id=MainArea>
    <s:form action="studentAction_update.action">
        <div class="ItemBlock_Title1"><!-- 信息说明 --><div class="ItemBlock_Title1">
        	<img border="0" width="4" height="7" src="${pageContext.request.contextPath}/css/blue/images/item_point.gif" /> 学生信息 </div> 
        </div>
        <table id="userwrap">
			<tr class="user">
      		  <td class="right">
        		<table>
            		<tr>
            		<s:hidden name="xuehao"></s:hidden>
            		<td class="one">姓名</td>
                        <td class="two"><s:textfield name="name" cssClass="inptxt"></s:textfield>
						</td>
                        <td class="one">密码</td>
                        <td class="two"><s:password name="password" cssClass="inptxt"></s:password>
						</td>
                    </tr>
                    <tr>
                    	<td class="one">政治面貌</td>
                        <td class="two"><s:textfield name="zzmm" cssClass="inptxt"></s:textfield>
						</td>
                    	<td class="one">性别</td>
                        <td class="two">
                        	<s:radio list="#{'1':'男','2':'女','3':'不详'}" name="sex"></s:radio>
						</td>
                    </tr>
                     <tr>
                     	<td class="one">出生日期</td>
                    	<td class="two">
                    	<input name="csrq" type="text" class="tcal inptxt" value="<s:property value="csrq"/>"/>
                    	</td>
                    	<td class="one">入学日期</td>
                    	<td class="two">
                    		<input name="rxrq" type="text" class="tcal inptxt" value="<s:property value="rxrq"/>"/>
                    	</td>
                    </tr>
                    <tr>
                    	<td class="one">联系电话</td>
                        <td class="two"><s:textfield name="cellphone" cssClass="inptxt"></s:textfield>
						</td>
                    	<td class="one">状态</td>
                        <td width="200px"><s:radio list="#{'1':'在读','2':'毕业','3':'停学','4':'退学'}" name="statue"></s:radio>
						</td>
                    	
                    </tr>
                     <tr>
						<td class="one">生源所在地</td>
                        <td class="two"><s:textfield name="syszd" cssClass="inptxt"></s:textfield>
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
