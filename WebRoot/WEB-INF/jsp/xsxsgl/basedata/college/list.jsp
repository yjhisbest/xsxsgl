<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学院信息</title>
<script type="text/javascript">
	$(function(){
		//设置分页要跳转到的url
		$("body").data("url","collegeAction_showPageResult.action");
		//声明分页的事件
		myUtils.basedata.initEvent();
		//声明删除的事件
			//针对button
		myUtils.basedata.deleteObj.deleteFunction({
			id:'deleteSome',
			checkboxname:'ids',//复选框id名字
			controlCheckBox:'controlCheckBox',
			url:'collegeJsonAction_deleteColleges.action',
			successurl:'collegeAction_showPageResult.action'//删除成功后的跳转页面
		});
		myUtils.basedata.updateObj.updateFunction({
			url:"collegeAction_updateUI.action",
			id:"id"
		});
		myUtils.basedata.deleteOneEvent.deleteOneFunction({
			url:"collegeJsonAction_deleteOne.action",
			checkid:"deleteOne",
			id:"id",
			successurl:'collegeAction_showPageResult.action' //删除成功后的跳转页面
		});	
			
	})
</script>
</head>
<body>

<table id="userwrap">
	
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td class="btn" align="left"><input type="button" value="删除" id="deleteSome"/></td>
                </tr>
                <tr class="one" height="20">
                	<td><input type="checkbox" id="controlCheckBox"/></td>
                    <td width="300">学院</td>
                    <td width="300">院长</td>
					<td width="300">书记</td>
					<td width="500">操作</td>
                </tr>
               <s:iterator value="#colleges.rows">
	                <tr align="center">
					   <td><input type="checkbox" name="ids" value="${id}"/></td>
	                   <td><s:property value="xymc"/></td>
	                   <td><s:property value="yz"/></td>
					   <td><s:property value="sj"/></td>
					   <td class="btn" align="sj">
					   	<input type="submit" value="修改"/>
					    <input type="button" value="删除" id="deleteOne"/>
					   </td>
	                </tr>
				</s:iterator>
             </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="firstPage" value="首页"/>&nbsp;<input type="button" flag="prePage" param="${colleges.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${colleges.currentPage+1}" flag="nextPage" last="${colleges.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${colleges.totalPages}" flag="lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="colleges.currentPage" id="pageNo" type="text" value="${colleges.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" id="skip" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${colleges.totalRows}条记录，当前第 ${colleges.currentPage}/${colleges.totalPages}页</p>
        </td>
    </tr>
</table>
<div>
    <a href="collegeAction_addUI.action"><img src="${pageContext.request.contextPath}/images/createNew.png"/> </a>
</div>
</body>
</html>