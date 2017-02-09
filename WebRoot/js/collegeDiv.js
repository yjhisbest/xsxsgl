var collegeDiv={
	divOpt:{
		data:{
			arr: [],//数组，存放增加的tr
			fileds:''
		},
		
		showDiv:function(){
			$("#seek").show();
			collegeDiv.divOpt.createtable();
		},
		/**
		 * 创建表格
		 */
		createtable:function(){
			$.post("collegeMajorJsonAction_showCollegeDivFrame.action",null,function(data){
				collegeDiv.divOpt.createTR(data);
			});		
		},
		/**
		 * 创建tr
		 */
		createTR: function(data){
			$.each(data,function(){//循环行
				var row = this;//this代表{id:'',xymc:'',yz:'',sj:''}
				var $tr = $("<tr/>");
				var fileds = collegeDiv.divOpt.data.fileds;
				$.each(fileds,function(){//循环列
					var $td = collegeDiv.divOpt.creatTD(this, row);//this为fileds的每一个元素：每一列
					$tr.append($td);
				});
				$("#seek table").append($tr);
				collegeDiv.divOpt.data.arr.push($tr);
			});
		},
		/**
		 * 创建td
		 * field = <td width="500" item="name">角色名</td>
		 * row 代表{id:'',xymc:'',yz:'',sj:''}
		 * row[$(field).attr("item")]==row['xymc']
		 */
		creatTD: function(field, row){
		if($(field).attr("item")=="radio"){
				var $radio = $("<input/>").attr("type","radio").attr("id", row['id']).attr("name","forChoice");
				return $("<td/>").attr("item",$(field).attr("item")).append($radio);
			}else{
				return $("<td/>").attr("item",$(field).attr("item")).text(row[$(field).attr("item")]);
			}
		},
		//除掉刚刚生成的tr
		clearTr:function(){
			$.each(collegeDiv.divOpt.data.arr,function(){//循环列
				this.remove();
			});
			$('#seek').css("display","none");
		},
		//确认要选择的学校
		sureCollege:function(){
			var checkedRadio = $(":radio:checked");
			var id = checkedRadio.attr("id");
			var xymc = checkedRadio.parent().siblings("td[item='xymc']").text();
			$("#xymc").attr("value",xymc);
			$("input[name='id']:hidden").attr("value",id);
		}
	},
	//初始化事件
	initEvent:function(){
		$("#xymc").unbind("click");
		$("#xymc").bind("click",function(){
			collegeDiv.divOpt.data.fileds = $("#seek *[item]"),
			collegeDiv.divOpt.showDiv();
		});
		//点击关闭按钮
		$(".seek_close").unbind("click");
		$(".seek_close").bind("click",function(){
			collegeDiv.divOpt.clearTr();
		});
		//点击确认按钮
		$(".btns").unbind("click");
		$(".btns").bind("click",function(){
			collegeDiv.divOpt.sureCollege();
			collegeDiv.divOpt.clearTr();
		});
	}	
};
$().ready(function(){
	collegeDiv.initEvent();
});