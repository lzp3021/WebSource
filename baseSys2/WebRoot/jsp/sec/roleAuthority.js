$(function() {
	//权限grid
	var dgRole = $('#roleAuthority #dgRole');
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
			dgAuthority.datagrid('load',{
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
	
	//资源grid
	var dgAuthority = $('#roleAuthority #dgAuthority');
	var dgAuthorityId = 'authorityId';
	var dgAuthorityToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			$('#winAuthority').window('open');
		}
	},{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			var row = dgAuthority.datagrid("getSelected");
			if(row == null ){
				alert("请先选中要删除的数据！");
				return;
			}
			$.ajax({
				url : 'roleAuthorityAction/deleteAuthority', // 后台处理程序
				type : 'post', // 数据发送方式
				dataType : 'text', // 返回数据格式
				data :{
					"roleId":dgRole.datagrid("getSelected").roleId,
					"authorityId":row.authorityId
				},// 要传递的数据
				success : function(result) {
					if (result=='fail') {
						alert("删除失败");
					}else{
						dgAuthority.datagrid("reload");
					} 
				},
				error : commerror
			});
		}
	}];
	var dgAuthorityOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'roleAuthorityAction/findAuthorityByRoleId',
		toolbar :dgAuthorityToolbar,
		pagination : false,
		columns : [ [  {
			field : dgAuthorityId,
			hidden : true
		},{
			title : '权限编码',
			field : 'authorityCode',
			width : 60,
			align : 'left'
		},{
			title : '权限名称',
			field : 'authorityName',
			width : 180
		}
		] ]
	});
	dgAuthority.datagrid(dgAuthorityOption);
	
	//弹出grid
	var dgOpenAuthority = $('#roleAuthority #dgOpenAuthority');
	var dgOpenAuthorityToolbar = [{
		text:'确定',
		iconCls:'icon-add',
		handler:function(){
			var rows = dgOpenAuthority.datagrid('getChecked');
			var editRow = dgRole.edatagrid('getSelected');
			var editIndex =dgRole.edatagrid('getRowIndex',editRow);
			dgRole.datagrid('endEdit',editIndex);
			$.ajax({
				url : 'roleAuthorityAction/saveRoleAuthority', // 后台处理程序
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
							dgOpenAuthority.datagrid('clearSelections');
							dgAuthority.datagrid("reload");
						});
					} 
				},
				error : commerror
			});
			$('#winAuthority').window('close');
		}
	},{
		text:'取消',
		iconCls:'icon-remove',
		handler:function(){
			//dgOpenResource.datagrid('clearSelections');
			$('#winAuthority').window('close');
		}
	}];
	var dgOpenAuthorityOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'authorityResourceAction/findAuthorityPage',
		singleSelect:false,
		toolbar:dgOpenAuthorityToolbar,
		columns : [ [  {
			field : dgAuthorityId,
			checkbox : true
		},{
			title : '权限编码',
			field : 'authorityCode',
			width : 60,
			align : 'left'
		},{
			title : '权限名称',
			field : 'authorityName',
			width : 180
		}
		] ]
	});
	dgOpenAuthority.datagrid(dgOpenAuthorityOption);
})
