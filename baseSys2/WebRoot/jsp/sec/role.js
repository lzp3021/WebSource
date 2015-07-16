$(function() {
	$('#role #dg').datagrid({
		url : 'roleAction/findEasyPage',
		idField : 'roleId',
		toolbar :'#mm',
		fit : true,
		pagination : true,
		rownumbers : true,
		columns : [ [ {
			title : '角色名称',
			field : 'roleName',
			editor : 'textbox',
			width : 180
		}, {
			title : '角色编码',
			field : 'roleCode',
			editor : 'textbox',
			width : 60,
			align : 'left'
		}] ]
	});
})
