<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>班级信息</title>
<script type="text/javascript">
	$(function(){
		//设置分页要跳转到的url
		$("body").data("url","learnMessageAction_showPageResult.action");
		//声明分页的事件
		myUtils.basedata.initEvent();
		//声明删除的事件
			//针对button
		myUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',//复选框id名字
			controlCheckBox:'controlCheckBox',
			url:'learnMessageJsonAction_deleteLearnMessages.action',
			successurl:'learnMessageAction_showPageResult.action' //删除成功后的跳转页面
		});
		myUtils.basedata.updateObj.updateFunction({
			url:"learnMessageAction_updateUI.action",
			id:"lid"
		});
		myUtils.basedata.deleteOneEvent.deleteOneFunction({
			url:"learnMessageJsonAction_deleteOne.action",
			checkid:"deleteOne",
			id:"lid",
			successurl:'learnMessageAction_showPageResult.action' //删除成功后的跳转页面
		});	
			
	})
</script>
</head>
<body>
<s:form action="learnMessageAction_showPageResult.action">
	<div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">学号</td>
                    <td class="inp">
                   	 	<s:textfield name="baseQuery.xuehao"></s:textfield>
                    </td>
                    <td class="one" style="width:66px;">课程编号</td>
                    <td class="inp">
                    	<s:textfield name="baseQuery.kcbh"></s:textfield>
                    </td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">教师编号</td>
                    <td class="inp">
                   	 	<s:textfield name="baseQuery.jsbh"></s:textfield>
                    </td>
					<td></td>
                    <td height="40" align="center"><input type="submit" value="   查 询   " class="btn"/></td>
                </tr>
            </table>
           </div>
<table id="userwrap">
	<tr learnMessage="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="1200" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="250">学号</td>
                    <td width="250">学生名字</td>
					<td width="250">课程编号</td>
					<td width="250">课程名称</td>
                    <td width="250">成绩</td>
					<td width="250">考试成绩</td>
					<td width="250">平时成绩</td>
                    <td width="250">教师名称</td>
					<td width="250">教师编号</td>
					<td width="500">操作</td>
                </tr>
               <s:iterator value="#learnMessages.rows">
	                <tr align="center">
					   <td><input type="checkbox" name="ids" value="${lid}"/></td>
	                   <td><s:property value="xuehao"/></td>
	                   <td><s:property value="xsmz"/></td>
					   <td><s:property value="kcbh"/></td>
					   <td><s:property value="kcmc"/></td>
	                   <td><s:property value="cj"/></td>
					   <td><s:property value="kscj"/></td>
					   <td><s:property value="pscj"/></td>
	                   <td><s:property value="jsmc"/></td>
					   <td><s:property value="jsbh"/></td>
					   <td class="btn" align="center">
					   	<input type="button" value="修改"/>
					    <input type="button" value="删除" id="deleteOne"/>
					   </td>
	                </tr>
				</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;<input type="button" flag="prePage" param="${learnMessagees.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${learnMessages.currentPage+1}" flag="nextPage" last="${learnMessages.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${learnMessages.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="learnMessages.currentPage" id="pageNo" type="text" value="${learnMessages.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" id="skip" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${learnMessages.totalRows}条记录，当前第 ${learnMessages.currentPage}/${learnMessages.totalPages}页</p>
        </td>
    </tr>
</table>
</s:form>
<div>
    <a href="learnMessageAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png"/> </a>
</div>
</body>
</html>