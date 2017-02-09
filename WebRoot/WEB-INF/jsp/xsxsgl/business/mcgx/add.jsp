<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>addRelation</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("body").data("topurl","majorClassJsonAction_getMajor.action");//获取班级
		$("body").data("url","majorClassJsonAction_getClazz.action");//获取专业
		$("body").data("main","query_zhi.bjbh");//url的参数
		$("body").data("tipName","班级号");//url的参数
			myUtils.business.relation.initEvent();
	});

</script>
</head>
<body>
<s:form action="majorClassAction_saveRelation.action">
<table>
	<tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
              <tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">专业名称</td>
                    <td class="inp">
                    <s:textfield name="zymc" id="zymc" topbz="topbz"></s:textfield><!--topbz="topbz"头标志，用来查看该班级编号是否存在-->
                    </td>
					<td class="one" style="width:66px;">专业类别</td>
                    <td class="inp">
                    <s:textfield name="zylb" id="zylb" readonly="true"></s:textfield>
                    </td>
                    <td width="0"></td>
                    <td width="0">
                    <s:hidden name="mid" id="mid"/>
                    </td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td>
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="700" style="height:40px;" size="size">
                <tr class="two" align="center">
                    <td width="80">班级编号</td>
                    <td width="80">班级名称</td>
                    <td width="80">人数</td>
                </tr>
                <tr align="center" id="base">
                 <td style="border-collapse:collapse;  empty-cells:show;" item="bjbh" size="size"><input type="text" style="width:100%;" name="classes[0].bjbh"/></td>
                 <td style="border-collapse:collapse;  empty-cells:show;" item="bjmc"><input readonly="readonly" type="text" style="width:100%;" name="classes[0].bjmc" id="mainid"/></td>
                 <td style="border-collapse:collapse;  empty-cells:show;" item="number"><input readonly="readonly" type="text" style="width:100%;" name="classes[0].number" id="mainid"/></td>
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
