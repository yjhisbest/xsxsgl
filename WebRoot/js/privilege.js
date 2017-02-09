var privilege = {
	setting:{
		isSimpleData: true,
		treeNodeKey: "id",
		treeNodeParentKey: "pid",
		showLine: true,
		root: {
			isRoot: true,
			nodes: []
		}
	},
	loadMenuitemTree:function(){
		$.post("roleJsonAction_getMenuitemTree.action",null,function(data){
			$("#tree").zTree(privilege.setting,data);
		});
	}
};
$().ready(function(){
	privilege.loadMenuitemTree();
});