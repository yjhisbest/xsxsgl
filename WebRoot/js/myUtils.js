var myUtils = {
	/**
	 * 基础数据模块
	 */
		basedata:{
			/**
	 	 	* 基础数据模块的查询页面的删除功能的js处理 
		  	 */
			deleteObj:{
				/**
				 * 当页面上的复选框被选中以后，点击删除按钮要做的事情
				 */
				deleteFunction:function(config){
					$.deleteObj(config);
				}
			},
			/**
			 * 删除一个
			 */
			deleteOneEvent:{
				/**
				 * 当页面上的某一个元素的删除按钮被选中以后，点击删除按钮要做的事情
				 */
				deleteOneFunction:function(config){
					$.deleteOne(config);
				}
			},
			/**
			 * 修改的逻辑
			 */
			updateObj:{
				updateFunction:function(config){
						$.updateEvent(config);
				}
			},
			/**
			 * 分页逻辑
			 */
			dispage:{
				//点击首页，上一页，尾页的时候，要跳转到的action
				linkPage:function(){
					var currentPage = $(this).attr("param");
					var url = $("body").data("url");
					window.location.href = url+"?currentPage="+currentPage;
				},
				//点击转按钮
				skipPage:function(){
					var skipPage = $("input[id='pageNo']").val();
					var url = $("body").data("url");
					window.location.href = url+"?currentPage="+skipPage;
				}
			},
			/**
			 * 初始化事件
			 */
			initEvent:function(){
				$("input[flag='firstPage']").unbind("click");
				$("input[flag='firstPage']").bind("click",function(){
					myUtils.basedata.dispage.linkPage.call(this);
				});
				$("input[flag='prePage']").unbind("click");
				$("input[flag='prePage']").bind("click",function(){
					if($(this).attr("param")==0){
						alert("已经是第一页了");
					}else{
						myUtils.basedata.dispage.linkPage.call(this);
					}
					
				});
				$("input[flag='nextPage']").unbind("click");
				$("input[flag='nextPage']").bind("click",function(){
					var totalPages =$(this).attr("last");
					if($(this).attr("param")>totalPages){
						alert("已经是最后一页了");
					}else{
						myUtils.basedata.dispage.linkPage.call(this);
					}
				});
				$("input[flag='lastPage']").unbind("click");
				$("input[flag='lastPage']").bind("click",function(){
					myUtils.basedata.dispage.linkPage.call(this);
				});
				$("input[id='skip']").unbind("click");
				$("input[id='skip']").bind("click",function(){
					var totalPages = $("input[flag='nextPage']").attr("last");
					if(isNaN($("input[id='pageNo']").val())){
						alert("请输入数字");
					}
					else if(parseInt($("input[id='pageNo']").val())>parseInt(totalPages) || parseInt($("input[id='pageNo']").val())<=0){
						alert("要跳转的页面不在范围内");
					}else{
						myUtils.basedata.dispage.skipPage.call(this);
					}
				});
			}
		},
		privilege:{
			/**
			 * 弹出div框的操作
			 */
			divOpt: {
				showDiv:function(){
					var jsbh = $(this).attr("jsbh");
					var roletd = $(this).parent().siblings("td[rolename='rolename']");
					$.fn.GirdPanel.createtable({
						url:'roleJsonAction_showRoleFrame.action',
						fileds:$("#seek *[item]"),
						jsbh:jsbh,
						roletd:roletd
					});
					$("#seek").show();
				},
				//关闭div框
				closeDiv:function(){
					$.fn.GirdPanel.clearTr();
				},
				//提交确认角色
				sureSetRole:function(){
					$.fn.GirdPanel.submitRole({
						url:'roleJsonAction_setRole.action'
					});
					$.fn.GirdPanel.clearTr();
				}
			},
			//对div框进行操作
			divRoleFrame:function(){
				/**
			 	* 点击设置角色，弹出一个div框
			 	*/
				$(".setRole").unbind("click");
				$(".setRole").bind("click",function(){
					myUtils.privilege.divOpt.showDiv.call(this);
				});
				//关闭div框
				$(".seek_close").unbind("click");
				$(".seek_close").bind("click",function(){
					myUtils.privilege.divOpt.closeDiv();
				});
				//点击确认按钮
				$(".btns").unbind("click");
				$(".btns").bind("click",function(){
					myUtils.privilege.divOpt.sureSetRole();
				});
			}
		},
		//业务逻辑
		business:{
			//学生成绩信息
			learnMess: {
				//对学号处理
				dealXuehao: function(){
					if ($(this).val() != "") {
						$.post("learnMessageJsonAction_getXSMZ.action", {
							dealXH: $(this).val()
						}, function(data){
							if (data == "*bcz*") {
								alert("不存在该学生");
							}
							else {
								$("input[name='xsmz']").attr("value", data);
							}
						});
					}
					else {
						alert("学号不能为空");
					}
				},
				//对课程编号进行处理
				dealKCBH: function(){
					if ($(this).val() != "") {
						$.post("learnMessageJsonAction_getKCMC.action", {
							dealKCBH: $(this).val()
						}, function(data){
							if (data == "*bcz*") {
								alert("不存在该课程");
							}
							else {
								$("input[name='kcmc']").attr("value", data);
							}
						});
					}
					else {
						alert("课程编号不能为空");
					}
				},
				//计算成绩
				countCJ: function(){
					var cj = parseFloat($("input[name='pscj']").val()) * 0.4 + parseFloat($("input[name='kscj']").val()) * 0.6;
					$("input[name='cj']").attr("value", cj);
				},
				//初始化事件
				initEvent: function(){
					//对学号的处理
					$("input[name='xuehao']").unbind("blur");
					$("input[name='xuehao']").bind("blur", function(){
						myUtils.business.learnMess.dealXuehao.call(this);
					}),  //对课程编号的处理
					$("input[name='kcbh']").unbind("blur");
					$("input[name='kcbh']").bind("blur", function(){
						myUtils.business.learnMess.dealKCBH.call(this);
					}),  //对成绩的处理
					$("input[name='pscj']").unbind("blur");
					$("input[name='pscj']").bind("blur", function(){
						if (!isNaN($(this).val()) && $(this).val() != "") {
							if (parseFloat($(this).val()) >= 0 && parseFloat($(this).val()) <= 100) {
								myUtils.business.learnMess.countCJ();
							}
							else {
								alert('     输入的数字超出范围\r\n平时成绩的范围是0~100分');
								$("input[name='pscj']").attr("value", 0);
							}
						}
						else {
							alert("平时成绩必须是数字！！");
							$("input[name='kscj']").attr("value", 0);
						}
						
					});
					$("input[name='kscj']").unbind("blur");
					$("input[name='kscj']").bind("blur", function(){
						if (!isNaN($(this).val()) && $(this).val() != "") {
							if (parseFloat($(this).val()) >= 0 && parseFloat($(this).val()) <= 100) {
								myUtils.business.learnMess.countCJ();
							}
							else {
								alert('     输入的数字超出范围\r\n平时成绩的范围是0~100分');
								$("input[name='kscj']").attr("value", 0);
							}
						}
						else {
							alert("考试成绩必须是数字！！");
							$("input[name='kscj']").attr("value", 0);
						}
					});
				}
			},
			//关系逻辑处理
			relation:{	
				add:{
					tr:'',//方便删除
					//添加行
					addLine:function(){
						var $trClone = $("tr[id='base']:last-child").clone(true);
						$trClone.children("td").each(function(){
							/**
							 * xsyddzhibs[0].zymc
							 * xsyddzhibs[0].zymc-->xsyddzhibs， 0].zymc 通过split("[")
							 * 0].zymc-->0, .zymc 通过split("]")
							 */
							var $input = $(this).children("input");
							var oldNameValue = $input.attr("name");//原来的name属性的值
							var preNameValue = oldNameValue.split("[")[0];
							var middleNameValue = oldNameValue.split("[")[1].split("]")[0];
							var postNameValue = oldNameValue.split("[")[1].split("]")[1];
							middleNameValue = parseInt(middleNameValue)+1;
							var newNameValue = preNameValue+"["+middleNameValue+"]"+postNameValue;
							$input.attr("name",newNameValue);
							$input.attr("value","");
						});
						//添加克隆结点
						$("table[id='maintain-top'][size='size']").append($trClone);
						$("#rMenu").hide();
					},
					//删除行
					deleteLine:function(){
						if($("tr[id='base']").length==1){
							alert("已经只有一行了，请不要再删除它了");
						}else{
							myUtils.business.relation.add.tr.remove();
						}
						$("#rMenu").hide();
					},
					 //当鼠标移出右键菜单的时候，隐藏右键菜单
					hidden:function(){
						$("#rMenu").hover(function(){
							
						},function(){
							$("#rMenu").hide();
						});
					},
					 //* 显示右键菜单
					showMenu:function(e){
						$("#rMenu").css("left",e.clientX - 10);
						$("#rMenu").css("top",e.clientY - 25);
						$("#rMenu").show();
					},
					
					//对行的元素进行补充
					dealLineData: function(){
						var tipName = $("body").data("tipName");
						var mthis=$(this).parent().siblings("td[size='size']").children("input");
						if ($(mthis).val() != "") {
							var url = $("body").data("url");
							$.post(url+"?"+$("body").data("main")+"="+$(mthis).val(),null, function(data){
								if (data == "*bcz*") {
									alert("不存在该"+tipName);
								}
								else {
									var fields = $(mthis).parent().parent().children("td:not(:eq(0))");
									$.each(fields,function(){
										$(this).children("input").attr("value",data[$(this).attr("item")]);
									});
								}
							});
						}else{
							alert("请先填写"+tipName);
						}
					},
					//对添加元素的第一行作为主要方进行处理
					dealTopData:function(){
						var mythis = this;
						var url = $("body").data("topurl");
						var toptdName = $(mythis).parent().parent().children("td:first-child").val();//获取第一行的第一个td的名称，级作为主键额名称
						$.post(url+"?"+$(mythis).attr("id")+"="+$(mythis).val(),null, function(data){
							if (data == "*bcz*") {
								alert("不存在该"+toptdName);
							}
							else {
								var fields = $(mythis).parent().parent().children("td:nth-child(even):not(:eq(0))");
								$.each(fields,function(){
									$(this).children("input").attr("value",data[$(this).children("input").attr("id")]);
								});
							}
						});
					}
				},
				//初始化事件
				initEvent:function(){
					$("body").delegate("td[size='size']","contextmenu",function(e){
						myUtils.business.relation.add.showMenu(e);
						return false;//阻止浏览器自己的右键菜单弹出
					});
					myUtils.business.relation.add.hidden();
					//点击增加
					$("body").delegate("li[id='addLine']","click",function(){
						myUtils.business.relation.add.addLine();
					});
					//点击删除
					$("body").delegate("li[id='deleteLine']","click",function(){
						myUtils.business.relation.add.deleteLine();
					});
					$("body").delegate("tr[id='base'] td","click",function(){
						myUtils.business.relation.add.tr = $(this).parent();
					});
					$("body").delegate("#mainid","click",function(){
						myUtils.business.relation.add.dealLineData.call(this);
					});
					//查看头标志topbz是否存在和对其处理
					$("input[topbz='topbz']").unbind("blur");
					$("input[topbz='topbz']").bind("blur",function(){
						if($(this).val()!=null && $(this).val()!=""){
							myUtils.business.relation.add.dealTopData.call(this);
						}
					});
				}
			},
			//list页面的处理
			dealList:{
				//点击主表的解除关系处理的逻辑,释放所有的关系
				releaseRelationAll:function(config){
					var id = $(this).parent().parent().attr("id");
					$.post(config.url+"?"+config.mainId+"="+id,null,function(data){//mainId代表主表的类型的主键的名称
						if(data=="deleteOk"){
							alert("关系解除成功");
							document.forms[0].submit();
						}else{
							alert("操作出现错误了！！");
						}
					});
				},
				//点击子表的解除关系处理的逻辑,释放该子表元素与主表对应的关系
				releaseRelatioOne:function(config){
					var mainId = $(this).parent().siblings("td:first-child").text();
					var zhu = $
					$.post(config.url+"?"+config.mainId+"="+mainId+"&"+$("input:hidden").attr('name')+"="+$("input:hidden").val(),null,function(data){//mainId代表子表的类型的主键的名称，或者关键字
						if(data=="deleteOk"){
							alert("关系解除成功");
							document.forms[0].submit();
						}else{
							alert("操作出现错误了！！");
						}
					});
				},
				/**
				 * 用来解除该主表的元素与其对应的子表的元素的全部关系
				 */
				zhuGXTRClick:function(config){
					$("input[removegx='all']").unbind("click");
					$("input[removegx='all']").bind("click",function(){
						if (window.confirm("该操作将解除主表该元素和与他有关系的子表的元素关系,\r\n你确定真的要执行？")){
							myUtils.business.dealList.releaseRelationAll.call(this,config);
						}
					});
				},
				/**
				 * 用来解除该主表的元素与其对应的子表的元素的全部关系
				 */
				zhiGXTRClick:function(config){
					$("input[removegx='one']").unbind("click");
					$("input[removegx='one']").bind("click",function(){
						if (window.confirm("该操作将解除该元素和与他有对应的主表的元素关系,\r\n你确定真的要执行？")) {
							myUtils.business.dealList.releaseRelatioOne.call(this,config);
						}
					});
				},
				//让被选中的一行显示颜色
				checkzhuid:function(config){
					var arr = $("tr[field='item_zhub']");
					for(var a=0;a<arr.length;a++){
						if($(arr[a]).attr("id") === $("input:hidden[name='"+config.hiddenZhubid+"']").val()){
							$(arr[a]).css("backgroundColor","#D2D2D5");
						}
					}	
				},
				//当点击主表的某一行时的处理逻辑
				getZhiByZhuID:function(hiddenZhubid){
					var zhuid = $(this).parent().attr("id");
					/**
					 * 把当前点击的主表中的某一行的主表ID复制给<s:hidden name="query_zhib.id"></s:hidden>
					 * 当点击子表的分页的时候，把主表该行的id值传递给后台
					 */
					$("input[name='"+hiddenZhubid+"']").attr("value",zhuid);
					document.forms[0].submit();
				},
				/**
				 * 给主表的查询添加click事件
				 */
				zhubTRClick:function(config){
					$("tr[field='item_zhub'] td:first-child").unbind("click");
					$("tr[field='item_zhub'] td:first-child").bind("click",function(){
						myUtils.business.dealList.getZhiByZhuID.call(this,config.hiddenZhubid);
					});
				},
			},
			//关系部分的分页
			disPage:{
				fenye:{
					//点击首页，上一页，尾页的时候，要跳转到的action
					zhublinkPage:function(){
						var currentPage = $(this).attr("param");
						$("#zhub_pageNo").attr("value",currentPage);
						document.forms[0].submit();
					},
					zhiblinkPage:function(){
						var currentPage = $(this).attr("param");
						$("#zhib_pageNo").attr("value",currentPage);
						document.forms[0].submit();
					},
				},
				//初始化事件
				initEvent:function(){
					//主表
					$("input[flag='zhub_firstPage']").unbind("click");
					$("input[flag='zhub_firstPage']").bind("click",function(){
						myUtils.business.disPage.fenye.zhublinkPage.call(this);
					});
					$("input[flag='zhub_prePage']").unbind("click");
					$("input[flag='zhub_prePage']").bind("click",function(){
						if($(this).attr("param")==0){
							alert("已经是第一页了");
						}else{
							myUtils.business.disPage.fenye.zhublinkPage.call(this);
						}
						
					});
					$("input[flag='zhub_nextPage']").unbind("click");
					$("input[flag='zhub_nextPage']").bind("click",function(){
						var totalPages =$(this).attr("last");
						if($(this).attr("param")>totalPages){
							alert("已经是最后一页了");
						}else{
							myUtils.business.disPage.fenye.zhublinkPage.call(this);
						}
					});
					$("input[flag='zhub_lastPage']").unbind("click");
					$("input[flag='zhub_lastPage']").bind("click",function(){
						myUtils.business.disPage.fenye.zhublinkPage.call(this);
					});
					$("input[id='zhub_skip']").unbind("click");
					$("input[id='zhub_skip']").bind("click",function(){
						var totalPages = $("input[flag='zhub_nextPage']").attr("last");
						if(isNaN($("input[id='zhub_pageNo']").val())){
							alert("请输入数字");
						}
						else if(parseInt($("input[id='zhub_pageNo']").val())>parseInt(totalPages) || parseInt($("input[id='zhub_pageNo']").val())<=0){
							alert("要跳转的页面不在范围内");
						}else{
							myUtils.business.disPage.fenye.zhublinkPage.call(this);
						}
					});
					
					//子表
					$("input[flag='zhib_firstPage']").unbind("click");
					$("input[flag='zhib_firstPage']").bind("click",function(){
						myUtils.business.disPage.fenye.zhiblinkPage.call(this);
					});
					$("input[flag='zhib_prePage']").unbind("click");
					$("input[flag='zhib_prePage']").bind("click",function(){
						if($(this).attr("param")==0){
							alert("已经是第一页了");
						}else{
							myUtils.business.disPage.fenye.zhiblinkPage.call(this);
						}
						
					});
					$("input[flag='zhib_nextPage']").unbind("click");
					$("input[flag='zhib_nextPage']").bind("click",function(){
						var totalPages =$(this).attr("last");
						if($(this).attr("param")>totalPages){
							alert("已经是最后一页了");
						}else{
							myUtils.business.disPage.fenye.zhiblinkPage.call(this);
						}
					});
					$("input[flag='zhib_lastPage']").unbind("click");
					$("input[flag='zhib_lastPage']").bind("click",function(){
						myUtils.business.disPage.fenye.zhiblinkPage.call(this);
					});
					$("input[id='zhib_skip']").unbind("click");
					$("input[id='zhib_skip']").bind("click",function(){
						var totalPages = $("input[flag='zhib_nextPage']").attr("last");
						if(isNaN($("input[id='zhib_pageNo']").val())){
							alert("请输入数字");
						}
						else if(parseInt($("input[id='zhib_pageNo']").val())>parseInt(totalPages) || parseInt($("input[id='zhib_pageNo']").val())<=0){
							alert("要跳转的页面不在范围内");
						}else{
							myUtils.business.disPage.fenye.zhiblinkPage.call(this);
						}
					});
				}
			}
			
		}
};