$(function() {
	//权限grid
	var dgRole = $('#roleUser #dgRole');
	var dgRoleId = 'roleId';
	var dgRoleToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			dgRole.edatagrid('addRow');
		}
	}];
	var dgRoleOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'roleAction/findEasyPage',
		saveUrl :'roleAction/saveRole',
		updateUrl :'roleAction/updateRole',
		autoSave:true,
		toolbar :dgRoleToolbar,
		onError :function(index,row){
			alert("发生错误，"+row.msg);
		},
		onSelect: function(index,row){
			dgUser.datagrid('load',{
				roleId: row.roleId
			});
		},
		columns : [ [  
		    {
				field : dgRoleId,
				hidden : true
			},{
				title : '角色编码',
				field : 'roleCode',
				width : 60,
				editor : 'textbox',
				align : 'left'
			},{
				title : '角色名称',
				field : 'roleName',
				editor : 'textbox',
				width : 180
			}
		] ]
	});
	dgRole.edatagrid(dgRoleOption);
	
	//用户grid
	var dgUser = $('#roleUser #dgUser');
	var dgUserId = 'userId';
	var dgUserToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			$('#winUser').window('open');
			dgOpenUser.datagrid('load');
		}
	},{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			var row = dgUser.datagrid("getSelected");
			if(row == null ){
				alert("请先选中要删除的数据！");
				return;
			}
			$.ajax({
				url : 'roleUserAction/deleteUser', // 后台处理程序
				type : 'post', // 数据发送方式
				dataType : 'text', // 返回数据格式
				data :{
					"roleId":dgRole.datagrid("getSelected").roleId,
					"userId":row.userId
				},// 要传递的数据
				success : function(result) {
					if (result=='fail') {
						alert("删除失败");
					}else{
						dgUser.datagrid("reload");
					} 
				},
				error : commerror
			});
		}
	}];
	var dgUserOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'roleUserAction/findUserByRoleId',
		toolbar :dgUserToolbar,
		pagination : false,
		columns : [ [ 
            {field:'userId',title:'用户ID',width:$(this).width()*0.2},
  			{field:'userCode',title:'用户证号',width:$(this).width()*0.2},
			{field:'password',title:'密码',width:$(this).width()*0.18},
			{field:'userName',title:'用户名',width:$(this).width()*0.3}
		] ]
	});
	dgUser.datagrid(dgUserOption);
	
	//弹出grid
	var dgOpenUser = $('#roleUser #dgOpenUser');
	var dgOpenUserToolbar = [{
		text:'确定',
		iconCls:'icon-add',
		handler:function(){
			var rows = dgOpenUser.datagrid('getChecked');
			var editRow = dgRole.edatagrid('getSelected');
			$.ajax({
				url : 'roleUserAction/saveRoleUser', // 后台处理程序
				type : 'post', // 数据发送方式
				dataType : 'text', // 返回数据格式
				data : {
					json : JSON.stringify(rows),
					roleId :editRow.roleId
				},
				success : function(result) {
					if (result=='fail') {
						alert("保存失败");
					}else{
						$.messager.alert('提示','保存成功!','info',function(){
							dgOpenUser.datagrid('clearSelections');
							dgUser.datagrid("reload");
						});
					} 
				},
				error : commerror
			});
			$('#winUser').window('close');
		}
	},{
		text:'取消',
		iconCls:'icon-remove',
		handler:function(){
			//dgOpenResource.datagrid('clearSelections');
			$('#winUser').window('close');
		}
	}];
	var dgOpenUserOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'userAction/findEasyPage',
		singleSelect:false,
		toolbar:dgOpenUserToolbar,
		columns : [ [ 
            {field:'userId',title:'用户ID',checkbox:true},
   			{field:'userCode',title:'用户证号',width:$(this).width()*0.2},
 			{field:'password',title:'密码',width:$(this).width()*0.18},
 			{field:'userName',title:'用户名',width:$(this).width()*0.3}
		] ]
	});
	dgOpenUser.datagrid(dgOpenUserOption);
})
