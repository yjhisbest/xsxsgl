//动态填充表格
(function($){
	$.fn.GirdPanel = {
		/**
		 * 默认的参数
		 */
		defaultConfig:{
			url:'',
			fileds:'',	//代表表格中有的所有列
			jsbh:'',
			roletd:'',
			arr: []
		},
		/**
		 * 创建表格
		 */
		createtable:function(config){
			//把config里的内容赋值给默认的参数	
			$.extend($.fn.GirdPanel.defaultConfig,config);
			$.post($.fn.GirdPanel.defaultConfig.url,null,function(data){
				$.fn.GirdPanel.createTR(data);
			});		
		},
		/**
		 * 创建tr
		 */
		createTR: function(data){
			$.each(data,function(){//循环行
				var row = this;//this代表{rid:'',name:'',description:''}
				var $tr = $("<tr/>");
				var fileds = $.fn.GirdPanel.defaultConfig.fileds;
				$.each(fileds,function(){//循环列
					var $td = $.fn.GirdPanel.creatTD(this, row);//this为fileds的每一个元素：每一列
					$tr.append($td);
				});
				$("#seek table").append($tr);
				$.fn.GirdPanel.defaultConfig.arr.push($tr);
			});
		},
		/**
		 * 创建td
		 * field = <td width="500" item="name">角色名</td>
		 * row 代表{rid:'',name:'',description:''}
		 * row[$(field).attr("item")]==row['name']
		 */
		creatTD: function(field, row){
		if($(field).attr("item")=="radio"){
				var $radio = $("<input/>").attr("type","radio").attr("rid", row['rid']).attr("name","rid");
				return $("<td/>").attr("item",$(field).attr("item")).append($radio);
			}else{
				return $("<td/>").attr("item",$(field).attr("item")).text(row[$(field).attr("item")]);
			}
		},
		//除掉刚刚生成的tr
		clearTr:function(){
			$.each($.fn.GirdPanel.defaultConfig.arr,function(){//循环列
				this.remove();
			});
			$('#seek').css("display","none");
		},
		//提交角色
		submitRole:function(config){
			var checkedRadio = $(":radio:checked");
			var rid = checkedRadio.attr("rid");
			var jsbh = $.fn.GirdPanel.defaultConfig.jsbh;
			var name = checkedRadio.parent().siblings("td[item='name']").text();
			$.post(config.url,{
				rid:rid,
				jsbh:jsbh
				},function(data){
				alert("设置角色成功");
				$.fn.GirdPanel.defaultConfig.roletd.text(name);
			});
		}
	};
})($);
