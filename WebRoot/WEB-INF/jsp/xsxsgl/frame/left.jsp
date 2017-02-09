<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/jquery-ztree-2.5.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/privilege.js"></script>
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style></head>

<body>
<table width="171" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top"><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0"  style="table-layout:fixed;">
      <tr>
        <td style="width:3px; background:#0a5c8e;">&nbsp;</td>
        <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
          <tr>
            <td height="5" style="line-height:5px; background:#0a5c8e;">&nbsp;</td>
          </tr>
          <tr>
            <td height="23" background="images/main_29.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="40%">&nbsp;</td>
                <td width="42%"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">方法管理</font></td>
                <td width="18%">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td bgcolor="#e5f4fd"><table width="171" height="100%" border="0" cellpadding="0" cellspacing="0">
              <tr bgcolor="#e5f4fd">
                <td valign="top">
					<div align="center">
						<ul id="tree" class="tree" style="width:230px; overflow:auto;"></ul>
					</div>
				</td>
              </tr>
            </td>
          </tr>
          <tr>
            <td height="9" style="line-height:9px; background:#0a5c8e;">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
