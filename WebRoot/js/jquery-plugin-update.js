/**
 * 1,这么写是一个闭包
 * 		闭包：
 * 			1，实现函数及变量的公有性和私有性
 * 			2，返回一个函数（对象），而这个对象可以是任意组织的
 * 2，保证插件的安全性
 * @param {Object} config
 */
(function(jQuery){
	$.updateEvent = function(config){
		$("input[value='修改']").unbind("click");
		$("input[value='修改']").bind("click",function(){
			/**
			 * 获取id
			 */
			var id = $(this).parent().siblings("td:first").children("input").attr("value");
			window.location.href = config.url+"?"+config.id+"="+id;
		});
	};
	
})(jQuery);
