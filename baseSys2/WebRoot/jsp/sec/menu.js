$(function() {
	var toolbar = [{
		text:'增加根节点',
		iconCls:'icon-add',
		handler:function(){
			$("#menu #form").form('clear');
			$('#menu #form').form('load', {
				parentId : 0,
				parentMenuName : 'Root'
			});
//			$('#menu #isValid').combobox('select',true);
		}
	},{
		text:'增加子节点',
		iconCls:'icon-add',
		handler:function(){
			var row = $('#menu #tg').treegrid("getSelected");
			if(row == null){
				alert("请先选中要删除的数据！");
				return;
			}
			$("#menu #form").form('clear');
			$('#menu #form').form('load', {
				parentId : row.menuId,
				parentMenuName : row.menuName
			});
//			$('#resource #isValid').combobox('select',true);
		}
	}]
	$('#menu #tg').treegrid({
		url : 'menuAction/menuTree',
		idField : 'menuId',
		fit : true,
		treeField : 'menuName',
		toolbar :toolbar,
		onClickRow : function(row){
			edit(row);
		},
		columns : [ [ {
			title : '菜单ID',
			field : 'menuId',
			hidden : true,
		}, {
			title : '父菜单ID',
			field : 'parentId',
			hidden : true,
		}, {
			title : '菜单名称',
			field : 'menuName',
			editor : 'textbox',
			width : 180
		}, {
			title : '菜单编码',
			field : 'menuCode',
			editor : 'textbox',
			width : 60,
			align : 'left'
		}, {
			title : '菜单链接',
			field : 'menuUrl',
			editor : 'textbox',
			width : 200
		} ] ]
	});
})
// 新增
function append() {
	$('#menu #form').form('reset');
	$('#button').val('append');
	var tg = $("#menu #tg").treegrid('getSelected');
	if (tg == null) {
		$.messager.alert('提示', '请选择一行信息', 'warning');
		return;
	}
	$('#menuform').form('load', {
		parentId : tg.menuId,
	});
	$('#menu_dialog').dialog('open');
}
// 编辑
function edit(row) {
	var parent = $('#menu #tg').treegrid('getParent',row.id);
	if(parent != null){
		row = $.mergeJsonO(row,{
			'parentMenuName':parent.menuName
		});
	}else{
		row = $.mergeJsonO(row,{
			'parentMenuName':'Root'
		});
	}
	$('#menu #form').form('load',row);
}
function save() {
	$.ajax({
		type : 'post',
		url : 'menuAction/menuSave',
		data : $("#menu #form").serialize(),
		dataType : 'text',
		success : function(result) {
			if (result == 'success') {
				$.messager.alert('提示', '保存成功', 'info');
				$('#menu #tg').treegrid('reload');
			} else {
				$.messager.alert('ERROR', '保存失败', 'error');
			}
		},
	});
}