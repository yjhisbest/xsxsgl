<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<script type="text/javascript" src="js/studentcj.js"></script>
<script type="text/javascript" src="js/ichart.1.2.min.js"></script>
<link rel="stylesheet" href="css/demo.css" type="text/css"/>
<script type="text/javascript">
	$(document).ready(function(){
		myUtils.business.disPage.initEvent();
		myUtils.business.dealList.zhubTRClick({hiddenZhubid:"query_zhi.xuehao"});
		myUtils.business.dealList.checkzhuid({hiddenZhubid:"query_zhi.xuehao"});
		studentcj.init.initEvent();
	});
</script>
</head>
<body>
<table>
	<s:form action="studentLearnMessAction_showStuentLearnMess.action">
	<tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">学号</td>
                    <td class="inp">
                   	 	<s:textfield name="query_zhu.xuehao"></s:textfield>
                    </td>
                    <td class="one" style="width:66px;">性别</td>
                    <td>
                    	<s:radio list="#{'1':'男','2':'女','3':'不详'}" name="query_zhu.sex"></s:radio>
                    </td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">学生姓名</td>
                    <td class="inp">
                   	 	<s:textfield name="query_zhu.name"></s:textfield>
                    </td>
					<td></td>
                    <td height="40" align="center"><input type="submit" value="   查 询   " class="btn"/></td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
	<tr>
    	<td >
            <div   style=" height:230px; width:950px;">
            <table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="950"  style="font-size:12px;text-align: center;">
                <tr class="one">
                    <td width="150">学号</td>
                    <td width="150">姓名</td>
                    <td width="150">性别</td>
                    <td width="150">在校状态</td>
                    <td width="150">政治面貌</td>
                </tr>
                <!-- 
                	pageResult_zhub.rows  List<Xsddzhub>
                 -->
                <s:iterator value="#pageResult_zhub.rows" status="st">
                	<!-- 
                		field属性是用来确认是主表的tr
                	 -->
	                <tr field="item_zhub" id="${xuehao}">
	                   <td style="border-collapse:collapse;  empty-cells:show;cursor: pointer;"><s:property value="xuehao"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="name"/></td>
	                   <td>
					   	<s:if test="sex==1">男</s:if>
						<s:if test="sex==2">女</s:if>
						<s:if test="sex==3">不详</s:if>
					   </td>
	                   <td>
					   	<s:if test="statue==1">在读</s:if>
						<s:if test="statue==2">毕业</s:if>
						<s:if test="statue==3">停学</s:if>
						<s:if test="statue==4">退学</s:if>
						</td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zzmm"/></td>
	                </tr>
                </s:iterator>
                <tr>
                   <td style="border:0"></td>
                </tr>
              </table>
               <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="zhub_firstPage" value="首页"/>&nbsp;<input type="button" flag="zhub_prePage" param="${pageResult_zhub.currentPage-1}" value="上一页" />&nbsp;
		<input type="button" param="${pageResult_zhub.currentPage+1}" flag="zhub_nextPage" last="${pageResult_zhub.totalPages}" value="下一页"/>&nbsp;<input type="button" param="${pageResult_zhub.totalPages}" flag="zhub_lastPage" value="尾页"/>&nbsp;
		<span>转到第<input name="query_zhu.currentPage" id="zhub_pageNo" type="text" value="${pageResult_zhub.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;
		<input type="button" value="转" id="zhub_skip" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhub.totalRows}条记录，当前第 ${pageResult_zhub.currentPage}/${pageResult_zhub.totalPages}页</p>
           </div>
		</td>
    </tr>
    
    <tr>
    	<td >
            <div  style="height:213px; width:950px;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;text-align: center;" width="950">
                <tr class="two" align="center">
					<td width="150">学号</td>
					<td width="150">学生名字</td>
					<td width="150">课程</td>
					<td width="150">教师</td>
					<td width="150">平时成绩</td>
					<td width="150">考试成绩</td>
					<td width="150">成绩</td>
                </tr>               
               <!-- 
               		创建一个隐藏域,保存点击的主表的xuehao
                -->
                <s:hidden name="query_zhi.xuehao"/>
                <s:iterator value="#pageResult_zhib.rows" status="st1">
                <!-- 
                	当点击主表中的某一行的时候，加载子表中的内容，当对子表加载上一页或者下一页的时候，应该针对主表中的某一行加载
                	所以在子表分页的时候，应该传递一个参数：主表的id
                 -->
                <tr class="other">
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="xuehao"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="xsmz"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kcmc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="jsmc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="pscj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kscj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="cj"/></td>
                </tr>
                </s:iterator>
                
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
            </table>
            <p style="width:900px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="zhib_firstPage" value="首页"/>&nbsp;<input type="button" flag="zhib_prePage" param="${pageResult_zhib.currentPage-1}" value="上一页" />&nbsp;
		<input type="button" flag="zhib_nextPage" param="${pageResult_zhib.currentPage+1}" last="${pageResult_zhib.totalPages}" value="下一页"/>&nbsp;
		<input type="button" flag="zhib_lastPage" param="${pageResult_zhib.totalPages}" value="尾页"/>&nbsp;
		<span>转到第<input name="query_zhi.currentPage" id="zhib_pageNo" type="text" value="${pageResult_zhib.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;
		<input type="button" value="转" id="zhib_skip" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhib.totalRows}条记录，当前第 ${pageResult_zhib.currentPage}/${pageResult_zhib.totalPages}页</p>
           </div>
    	</td>
    </tr>    
</s:form>
</table>
<div id='canvasDiv' style="display: none;"></div>
</body>
</html>
