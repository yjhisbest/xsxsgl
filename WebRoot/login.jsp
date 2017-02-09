<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生信息管理系统_用户登录</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow:hidden;
}
-->
</style>
<script type="text/JavaScript">

</script>
</head>

<body onLoad="MM_preloadimages/login('images/login/login_09_1.gif','images/login/login_10_1.gif')">
<s:form action="loginAction_authentication.action">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#02395f"><s:actionerror cssStyle="color:white;"/></td>
  </tr>
  <tr>
    <td height="607" align="center" background="images/login/login_02.gif"><table width="974" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="331" background="images/login/login_01.jpg">&nbsp;</td>
      </tr>
      <tr>
        <td height="116"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="393" height="116" background="images/login/login_05.gif">&nbsp;</td>
            <td width="174"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="81" background="images/login/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="24%"><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">用户</font></div></td>
                    <td width="76%" height="25"><input type="text" name="jsmc"  style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#14649f;"></td>
                  </tr>
                  <tr>
                    <td><div align="center"><font style="height:1;font-size:9pt; color:#bfdbeb;filter:glow(color=#1070a3,strength=1)">密码</font></div></td>
                    <td height="25"><input type="password" name="password"  style="width:125px; height:20px; background:#32a2e3; font-size:12px; border:solid 1px #0468a7; color:#14649f;"></td>
                  </tr>
                </table></td>
              </tr>
              <tr>
                <td height="35"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="35"><img src="images/login/login_08.gif" width="50" height="35"></td>
                    <td width="46"><input type="image" src="images/login/login_09.gif" name="Image1" width="46" height="35" border="0" id="Image1" onMouseOver="MM_swapImage('Image1','','images/login/login_09_1.gif',1)" onMouseOut="MM_swapImgRestore()"/></td>
                    <td width="45"><a href="#"><img src="images/login/login_10.gif" name="Image2" width="45" height="35" border="0" id="Image2" onMouseOver="MM_swapImage('Image2','','images/login/login_10_1.gif',1)" onMouseOut="MM_swapImgRestore()"></a></td>
                    <td width="33"><img src="images/login/login_11.gif" width="33" height="35"></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td width="407" background="images/login/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="160" background="images/login/login_12.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#02609c">&nbsp;</td>
  </tr>
</table>
</s:form>
</body>
</html>
