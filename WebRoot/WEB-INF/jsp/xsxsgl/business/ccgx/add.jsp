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
		$("body").data("topurl","classCourseJsonAction_getClazz.action");//获取班级
		$("body").data("url","classCourseJsonAction_getCourse.action");//获取专业
		$("body").data("main","query_zhi.kcbh");//url的参数
		$("body").data("tipName","课程编号");
			myUtils.business.relation.initEvent();
	});

</script>
</head>
<body>
<s:form action="classCourseAction_saveRelation.action">
<table>
	<tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">班级编号</td>
                    <td class="inp">
                    <s:textfield name="bjbh" id="bjbh" topbz="topbz"></s:textfield><!--topbz="topbz"头标志，用来查看该班级编号是否存在-->
                    </td>
					<td class="one" style="width:66px;">班级名称</td>
                    <td class="inp">
                    <s:textfield name="bjmc" id="bjmc" readonly="true"></s:textfield>
                    </td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td>
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="1000" style="height:40px;" size="size">
                <tr class="two" align="center">
                    <td width="80">课程编号</td>
                    <td width="80">课程名称</td>
					<td width="80">教師名称</td>
					<td width="80">開課時間</td>
					<td width="80">學分</td>
                </tr>
                <tr align="center" id="base">
                 <td style="border-collapse:collapse;  empty-cells:show;" item="kcbh" size="size"><input type="text" style="width:100%;" name="courses[0].kcbh"/></td>
                 <td style="border-collapse:collapse;  empty-cells:show;" item="kcmc"><input readonly="readonly" type="text" style="width:100%;" name="courses[0].kcmc" id="mainid"/></td>
				 <td style="border-collapse:collapse;  empty-cells:show;" item="jsmc"><input readonly="readonly" type="text" style="width:100%;" name="courses[0].jsmc" id="mainid"/></td>
				 <td style="border-collapse:collapse;  empty-cells:show;" item="kksj"><input readonly="readonly" type="text" style="width:100%;" name="courses[0].kksj" id="mainid"/></td>
				 <td style="border-collapse:collapse;  empty-cells:show;" item="credit"><input readonly="readonly" type="text" style="width:100%;" name="courses[0].credit" id="mainid"/></td>
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

</body>
</html>
