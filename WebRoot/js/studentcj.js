var studentcj= {
	//div操作
	divOpt:{
		// 显示被隐藏的div
		showDiv:function(){
			$("div:hidden").show();
		}
	},
	data:{
		render : 'canvasDiv',
		data: '',
		title : '',
		showpercent:false,
		decimalsnum:2,
		width : 700,
		height : 350,
		coordinate:{
			background_color:'#fefefe',
			scale:[{
				 position:'left',	
				 start_scale:0,
				 end_scale:50,
			 scale_space:10,
				 listeners:{
					parseText:function(t,x,y){
						return {text:t}
					}
				}
			}]
		}	
	},
	divOpt:{
		showDiv:function(){
			$("div[id='canvasDiv']:hidden").show();
			studentcj.divOpt.getStudentData();
		},
		getStudentData:function(){
			var xuehao = $("input[name='query_zhi.xuehao']").val();
			$.post("studentLearnMessJsonAction_getLearnMessData.action?query_zhi.xuehao="+xuehao,null,
			function(data){
				studentcj.data.data = eval("("+ data +")");
				studentcj.data.title = '学号为 '+$("input:hidden[name='query_zhi.xuehao']").val()+' 的学生成绩柱形图';
				new iChart.Column2D(studentcj.data).draw();;
			});
		}
	},
	init: {
		//初始化事件
		initEvent: function(){
			if($("input[name='query_zhi.xuehao']:hidden").val()!="" && $("input[name='query_zhi.xuehao']:hidden").val()!=null){
				studentcj.divOpt.showDiv();
			}
				
		}
	}
}