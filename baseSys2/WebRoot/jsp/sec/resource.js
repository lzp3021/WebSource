$(function() {
	var datagrid = $('#resource #dg');
	//1.加载下拉控件
	$('#resource #resourceType').combobox({
		valueField : 'id',
		textField : 'text',
		editable : false,
		data : [ {
			"id" : "01",
			"text" : "菜单"
		} ,{
			"id" : "02",
			"text" : "按钮"
		},{
			"id" : "03",
			"text" : "操作"
		}]
	})
	$('#resource #isValid').combobox({
		valueField : 'id',
		textField : 'text',
		editable : false,
		data : [ {
			"id" : true,
			"text" : "是"
		} ,{
			"id" : false,
			"text" : "否"
		}]
	})
	//2.grid工具栏
	var toolbar = [{
		text:'增加',
		iconCls:'icon-add',
		handler:function(){
			$("#resource #form").form('clear');
			$('#resource #isValid').combobox('select',true);
		}
	},{
		text:'删除',
		iconCls:'icon-remove',
		handler:function(){
			var row = datagrid.datagrid("getSelected");
			if($("#resource #resourceId").val()!='' && row == null ){
				alert("请先选中要删除的数据！");
				return;
			}
			$.ajax({
				url : 'resourceAction/delete', // 后台处理程序
				type : 'post', // 数据发送方式
				dataType : 'text', // 返回数据格式
				data :{"resourceId":row.resourceId},// 要传递的数据
				success : function(result) {
					if (result=='fail') {
						alert("删除失败");
					}else{
						datagrid.datagrid("reload");
					} 
				},
				error : commerror
			});
		}
	},'-',{
		text:'保存',
		iconCls:'icon-save',
		handler:function(){
			var row = datagrid.datagrid("getSelected");
			//修改时
			if($("#resource #resourceId").val()!='' && row == null ){
				alert("请先选中要编辑的数据！");
				return;
			}
			if($('#resource #form').form('validate')){
				$.ajax({
					url : 'resourceAction/saveForm', // 后台处理程序
					type : 'post', // 数据发送方式
					dataType : 'text', // 返回数据格式
					data : $("#resource #form").serialize(),// 要传递的数据
					success : function(result) {
						if (result=='fail') {
							alert("保存失败");
						}else{
							$.messager.alert('提示','保存成功!','info',function(){
								datagrid.datagrid("reload");
								if($("#resource #resourceId").val()!=''){
									datagrid.datagrid("selectRecord",result);
								}
							});
						} 
					},
					error : commerror
				});
			}
		}
	}];
	//grid内容
	var gridOption =$.extend(jquery.comm.baseDG,{
		idField : 'resourceId',
		url : 'resourceAction/findEasyPage',
		toolbar :toolbar,
		region:'center',
		onSelect: function(index,row){
			$('#resource #form').form('load',row);
		},
		columns : [ [  {
			field : 'resourceId',
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
	//4.加载grid
	datagrid.datagrid(gridOption);
})
