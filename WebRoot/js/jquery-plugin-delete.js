(function($){
	//批量删除
	$.deleteObj = function(config){
		/**
		 * config.id代表删除按钮的id的值
		 */
		$("input[type='button'][id='"+config.id+"']").unbind("click");
		$("input[type='button'][id='"+config.id+"']").bind("click",function(){
			if($("input[name='"+config.checkboxname+"']:checked").length==0){
				alert("你还没有选择要删除的数据");
			}else{
				if (window.confirm("你确定真的要删除吗？")) {
					var checkedNodes = $("input[name='"+config.checkboxname+"']:checked");
					//"1,2,3,4"
					var checkedStr = "";
					for(var i=0;i<checkedNodes.length;i++){
						if(i==checkedNodes.length-1){
							/**
							 * checkedNodes[i]代表某一个checkbox元素，是dom对象
							 * $(checkedNodes[i])是jQuery对象
							 */
							checkedStr = checkedStr + $(checkedNodes[i]).attr("value");
						}else{
							checkedStr = checkedStr + $(checkedNodes[i]).attr("value") + ",";
						}
					}
					$.post(config.url+"?checkedStr="+checkedStr, function(data){
						if(data=="deleteOK"){
							alert("删除成功");
							window.location.href = config.successurl;
						}else{
							alert(data);
						}
				});
				}
			}
			
		});
		/**
		 * 触发最上面的checkbox事件
		 * 	如果该checkbox被选中，下面的所有的checkbox被选中
		 * 	如果该checkbox没有被选中，下面的所有的checkbox不被选中
		 */
		$("#"+config.controlCheckBox).unbind("click");
		$("#"+config.controlCheckBox).bind("click",function(){
			if($(this).attr("checked")){
				$("input[name='"+config.checkboxname+"']").attr("checked",true);
			}else{
				$("input[name='"+config.checkboxname+"']").attr("checked",false);
			}
		});
		/**
		 * 表格中的checkbox事件
		 */
		$("input[name='"+config.checkboxname+"']").unbind("click");
		$("input[name='"+config.checkboxname+"']").bind("click",function(){
			if($("input[name='"+config.checkboxname+"']:not(:checked)").length==0){
				$("#"+config.controlCheckBox).attr("checked",true);
			}else{
				$("#"+config.controlCheckBox).attr("checked",false);
			}
		});
	},
	/**
	 * 删除一个的时候
	 */
	$.deleteOne = function(config){
		$("input[value='删除'][id='"+config.checkid+"']").unbind("click");
		$("input[value='删除'][id='"+config.checkid+"']").bind("click",function(){
			if (window.confirm("你确定真的要删除吗？")) {
				/**
				 * 获取id
				 */
				var id = $(this).parent().siblings("td:first").children("input").attr("value");
				$.post(config.url+"?"+config.id+"="+id, function(data){
						if(data=="deleteOK"){
							alert("删除成功");
							window.location.href = config.successurl;
						}else{
							alert(data);
						}
				});
				
			}
		});
	}
	
}($));
