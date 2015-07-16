$(function() {
	//权限grid
	var dgAuthority = $('#authorityResource #dgAuthority');
	var dgAuthorityId = 'authorityId';
	var dgAuthorityToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			dgAuthority.edatagrid('addRow');
		}
	}];
	var dgAuthorityOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'authorityResourceAction/findAuthorityPage',
		saveUrl :'authorityResourceAction/saveAuthority',
		updateUrl :'authorityResourceAction/updateAuthority',
		autoSave:true,
		toolbar :dgAuthorityToolbar,
		onError :function(index,row){
			alert(row.msg);
		},
		onSelect: function(index,row){
//			dgResourceOption.queryParams = {
//				authorityId: row.authorityId
//			}
//			dgResource.datagrid(dgResourceOption);
			dgResource.datagrid('load',{
				authorityId: row.authorityId
			});
		},
		columns : [ [  
		    {
				field : dgAuthorityId,
				hidden : true
			},{
				title : '权限编码',
				field : 'authorityCode',
				width : 60,
				editor : 'textbox',
				align : 'left'
			},{
				title : '权限名称',
				field : 'authorityName',
				editor : 'textbox',
				width : 180
			}
		] ]
	});
	dgAuthority.edatagrid(dgAuthorityOption);
	
	//资源grid
	var dgResource = $('#authorityResource #dgResource');
	var dgResourceId = 'resourceId';
	var dgResourceToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			$('#winResource').window('open');
		}
	},{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			var row = dgResource.datagrid("getSelected");
			if(row == null ){
				alert("请先选中要删除的数据！");
				return;
			}
			$.ajax({
				url : 'authorityResourceAction/deleteResource', // 后台处理程序
				type : 'post', // 数据发送方式
				dataType : 'text', // 返回数据格式
				data :{
					"authorityId":dgAuthority.datagrid("getSelected").authorityId,
					"resourceId":row.resourceId
				},// 要传递的数据
				success : function(result) {
					if (result=='fail') {
						alert("删除失败");
					}else{
						dgResource.datagrid("reload");
					} 
				},
				error : commerror
			});
		}
	}];
	var dgResourceOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'authorityResourceAction/findResourcesByAuthorityId',
		region:'center',
		toolbar :dgResourceToolbar,
		pagination : false,
		onSelect: function(index,row){
		},
		columns : [ [  {
			field : dgResourceId,
			hidden : true
		},{
			title : '资源编码',
			field : 'resourceCode',
			width : 60,
			align : 'left'
		},{
			title : '资源内容',
			field : 'resourceContent',
			width : 180
		},{
			title : '资源类型',
			field : 'resourceType',
			width : 180
		},{
			title : '是否启用',
			field : 'isValid',
			formatter:function(value,rowData,rowindex){
				if(value){
					return "<input id='isCheck' onclick='return false' type='checkbox' checked='checked' />";
				}else{
					return "<input id='isCheck' onclick='return false' type='checkbox' />"; 
				}
			},
			width : 180
		}
		] ]
	});
	dgResource.datagrid(dgResourceOption);
	
	//弹出grid
	var dgOpenResource = $('#authorityResource #dgOpenResource');
	var dgOpenResourceToolbar = [{
		text:'确定',
		iconCls:'icon-add',
		handler:function(){
			debugger;
			var rows = dgOpenResource.datagrid('getChecked');
			var editRow = dgAuthority.edatagrid('getSelected');
			var editIndex =dgAuthority.edatagrid('getRowIndex',editRow);
			dgAuthority.datagrid('endEdit',editIndex);
			$.ajax({
				url : 'authorityResourceAction/saveAuthorityResource', // 后台处理程序
				type : 'post', // 数据发送方式
				//contentType:'application/json;charset=UTF-8',
				dataType : 'text', // 返回数据格式
				data : {
					json : JSON.stringify(rows),
					authorityId :dgAuthority.datagrid('getSelected').authorityId
				},
				success : function(result) {
					if (result=='fail') {
						alert("保存失败");
					}else{
						$.messager.alert('提示','保存成功!','info',function(){
							dgOpenResource.datagrid('clearSelections');
							dgResource.datagrid("reload");
						});
					} 
				},
				error : commerror
			});
			$('#winResource').window('close');
		}
	},{
		text:'取消',
		iconCls:'icon-remove',
		handler:function(){
			//dgOpenResource.datagrid('clearSelections');
			$('#winResource').window('close');
		}
	}];
	var dgOpenResourceOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'authorityResourceAction/findResourcePage',
		region:'center',
		singleSelect:false,
		toolbar:dgOpenResourceToolbar,
		onSelect: function(index,row){
		},
		columns : [ [  {
			field : dgResourceId,
			checkbox : true
		},{
			title : '资源编码',
			field : 'resourceCode',
			width : 60,
			align : 'left'
		},{
			title : '资源内容',
			field : 'resourceContent',
			width : 180
		},{
			title : '资源类型',
			field : 'resourceType',
			width : 180
		},{
			title : '是否启用',
			field : 'isValid',
			formatter:function(value,rowData,rowindex){
				if(value){
					return "<input id='isCheck' onclick='return false' type='checkbox' checked='checked' />";
				}else{
					return "<input id='isCheck' onclick='return false' type='checkbox' />"; 
				}
			},
			width : 180
		}
		] ]
	});
	dgOpenResource.datagrid(dgOpenResourceOption);
})
