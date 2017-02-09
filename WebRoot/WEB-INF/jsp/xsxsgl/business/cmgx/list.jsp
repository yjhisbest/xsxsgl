<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/xsxsgl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/style_customer.css"/>
<script type="text/javascript" src="js/collegeDiv.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		myUtils.business.disPage.initEvent();
		myUtils.business.dealList.zhubTRClick({hiddenZhubid:"query_zhi.id"});
		myUtils.business.dealList.checkzhuid({hiddenZhubid:"query_zhi.id"});
		myUtils.business.dealList.zhuGXTRClick({
			url:"collegeMajorJsonAction_releaseAll.action",
			mainId:"id"
		});
		myUtils.business.dealList.zhiGXTRClick({
			url:"collegeMajorJsonAction_releaseOne.action",
			mainId:"query_zhi.zymc"
		});
	});
</script>
</head>
<body>
<table>
	<s:form action="collegeMajorAction_showCMGX.action">
	<tr>
    	<td>
            <div  style="overflow:auto;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">选择学院</td>
                    <td class="inp">
                    <s:textfield name="query_zhu.xymc" id="xymc" readonly="true"></s:textfield>
                    </td>
                	<td colspan="5"></td>
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
                    <td width="150">学院名</td>
                    <td width="150">院长</td>
                    <td width="150">院长</td>
                    <td width="150">操作</td>
                </tr>
                <!-- 
                	pageResult_zhub.rows  List<Xsddzhub>
                 -->
                <s:iterator value="#pageResult_zhub.rows" status="st">
                	<!-- 
                		field属性是用来确认是主表的tr
                	 -->
	                <tr field="item_zhub" id="${id}">
	                   <td style="border-collapse:collapse;  empty-cells:show;cursor: pointer;"><s:property value="xymc"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="yz"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="sj"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" class="btn" align="center"><input type="button" value="解除关系" class="setRole" removegx="all"/></td>
	                	<!-- removeGX='all'，用来在js校验中触发解除全部关系 -->
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
					<td width="150">专业名称</td>
					<td width="150">专业类别</td>
					<td width="150">操作</td>
                </tr>               
               <!-- 
               		创建一个隐藏域,保存点击的主表的id
                -->
                <s:hidden name="query_zhi.id"></s:hidden>
                <s:iterator value="#pageResult_zhib.rows" status="st1">
                <!-- 
                	当点击主表中的某一行的时候，加载子表中的内容，当对子表加载上一页或者下一页的时候，应该针对主表中的某一行加载
                	所以在子表分页的时候，应该传递一个参数：主表的id
                 -->
                <tr class="other">
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zymc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zylb"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" class="btn" align="center"><input type="button" value="解除关系" class="setRole" removegx="one"/></td>
                	<!-- removeGX='one'，用来在js校验中触发解除一个关系 -->
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
	              <td width="20" item="radio">选择</td>
	              <td width="60" item="xymc">学院</td>
				  <td width="60" item="yz">院长</td>
				  <td width="60" item="sj">书记</td>
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
