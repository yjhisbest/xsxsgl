<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>addRelation</title>
<script type="text/javascript" src="js/collegeDiv.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("body").data("url","collegeMajorJsonAction_getMajor.action");//获取专业
		$("body").data("main","query_zhi.zymc");//url的参数
		$("body").data("tipName","专业");
			myUtils.business.relation.initEvent();
	});

</script>
</head>
<body>
<s:form action="collegeMajorAction_saveRelation.action">
<table>
	<tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">选择学院</td>
                    <td class="inp">
                    <s:textfield name="xymc" id="xymc" readonly="true"></s:textfield>
                    <s:hidden name="id"/>
                    </td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td>
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="600" style="height:40px;" size="size">
                <tr class="two" align="center">
                    <td width="80">专业名称</td>
                    <td width="80">专业类别</td>
                </tr>
                <tr align="center" id="base">
                 <td style="border-collapse:collapse;  empty-cells:show;" item="zymc" size="size"><input type="text" style="width:100%;" name="majors[0].zymc"/></td>
                 <td style="border-collapse:collapse;  empty-cells:show;" item="zylb"><input readonly="readonly" type="text" style="width:100%;" name="majors[0].zylb" id="mainid"/></td>
                </tr>
             </table>
         </td>
     </tr>
     <tr>
       <td class="btn" height="30" align="right" style="padding-right"><input type="submit" value="建立关系"></td>
     </tr>
</table>
</s:form>

<div class="addnodes" id="rMenu" style="position:absolute;display:none;overflow:hidden">
       <ul>
         <li id="addLine" style="background-color:#FFFFFF; border:1px solid #8ab2e6;cursor:pointer; width: 60px;padding: 5px 0 5px 17px">增加</li>
         <li id="deleteLine" style="background-color:#FFFFFF; border:1px solid #8ab2e6;cursor:pointer; width: 60px;padding: 5px 0 5px 17px ">删除</li>
       </ul>
</div>
<!-- 学院选择div款 -->
 <div id="seek">
    <div class="seek_con_top">
	     <h5>学院信息</h5>
	     <span class="seek_close"></span>
	</div>
	<div class="seek_con">
	     <div style="overflow:scroll; overflow-x:hidden; height:275px;border:1px solid #898989;width:800px">
	          <table cellpadding="0" cellspacing="0" id="maintain-top" align="center"  width="800" style=" font-size:12px; height:50px;text-align: center;">
	            <tr>
	              <td width="50" item="radio">选择</td>
	              <td width="150" item="xymc">学院</td>
				  <td width="150" item="yz">院长</td>
				  <td width="150" item="sj">书记</td>
				</tr>
	           </table>
	       </div>
	       <div class="btns">
                <button class="btn">确定</button>
           </div>
	  </div>
</div>

</body>
</html>
