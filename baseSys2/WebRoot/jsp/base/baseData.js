$(function() {
	var dgData = $('#baseData #dgData');
	var dgDataId = 'dataId';
	var dgDataToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			dgData.edatagrid('addRow');
		}
	}];
	var dgDataOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'baseDataAction/findBaseDataPage',
		saveUrl :'baseDataAction/saveData',
		updateUrl :'baseDataAction/updateData',
		autoSave:true,
		toolbar :dgDataToolbar,
		onError :function(index,row){
			alert(row.msg);
		},
		onSelect: function(index,row){
			dgDataDetailOption.queryParams = {
				dataId: row.dataId
			}
			dgDataDetail.edatagrid(dgDataDetailOption);
		},
		columns : [ [  
		    {
				field : dgDataId,
				hidden : true
			},{
				title : '编码值',
				field : 'dataCode',
				width : 60,
				editor : 'textbox',
				align : 'left'
			},{
				title : '编码名称',
				field : 'dataName',
				editor : 'textbox',
				width : 180
			}
		] ]
	});
	dgData.edatagrid(dgDataOption);
	
	var dgDataDetail = $('#baseData #dgDataDetail');
	var dgDataDetailId = 'dataDetailId';
	var dgDataDetailToolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			dgDataDetail.edatagrid('addRow');
		}
	}];
	var dgDataDetailOption =$.mergeJsonO(jquery.comm.baseDG,{
		url : 'baseDataAction/findBaseDataDetailPage',
		saveUrl :'baseDataAction/saveDataDetail',
		updateUrl :'baseDataAction/updateDataDetail',
		autoSave:true,
		toolbar :dgDataDetailToolbar,
		onAdd :function(index,row){
			var sel = dgData.edatagrid('getSelected');
			if(isNotNull(sel)){
				row.dataId = sel.dataId
			}else{
				alert("请先选中编码!");
			}
		},
		onError :function(index,row){
			alert(row.msg);
		},
		columns : [ [  
		    {
				field : dgDataDetailId,
				hidden : true
			},{
				field : 'dgDataCode',
				hidden : true
			},{
				title : '数据编码',
				field : 'dataDetailCode',
				width : 60,
				editor : 'textbox',
				align : 'left'
			},{
				title : '数据名称',
				field : 'dataDetailName',
				editor : 'textbox',
				width : 180
			}
		] ]
	});
	
	$('#baseData #sex').combobox({    	
    	url:'baseDataAction/findCacheBaseData?dataCode=sex',
	    valueField:'dataDetailCode',  
	    textField:'dataDetailName',
	    editable:false
	})
})
