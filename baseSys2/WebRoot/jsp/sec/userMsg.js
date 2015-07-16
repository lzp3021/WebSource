$(function(){
	$("#userlist").datagrid({
		singleSelect:true,
		url : 'userAction/findEasyPage',
		idField : 'userid',// 定义标识字段
		columns : [ [
			{field:'userId',title:'用户ID',width:$(this).width()*0.2},
			{field:'userCode',title:'用户证号',width:$(this).width()*0.2},
			{field:'password',title:'密码',width:$(this).width()*0.18},
			{field:'userName',title:'用户名',width:$(this).width()*0.3}
			] ], 
		pagination : true,
		rownumbers : true,
	});
	var save = function(){
		$("#userForm").form('submit',{
			url:"userAction/save",
			success:function(result){
				if(result == "success"){
					$.messager.alert('提示','保存成功!',null,function(){
						$("#add").dialog('close');
						$("#userlist").datagrid('reload');
					});
				}else{
					$.messager.alert('提示','保存失败!');
				}
			}
			
		});
	};
	var back = function(){
		$("#add").dialog('close');
	};
	//定义点击添加时的弹出窗口
	$("#add").dialog({
		title:"新增员工",
		closed:true,
		width:"400px",
		height:"200px",
		toolbar:[{
			text:"保存",
			iconCls:'icon-save',
			handler:save
		},{
			text:"返回",
			iconCls:'icon-back',
			handler:back
		}]
	});
	
	
});

function query(){
	var username = $("#condition_username").textbox('getValue');
	$.ajax({
		type : 'post',
		url : 'userAction/conditionquery',
		data : {username:username},
		dataType : 'text', 
		success : function(result) {
			if(result == 'success'){
				$.messager.alert('提示','删除成功');
				$("#userlist").datagrid('reload');
			}else{
				$.messager.alert('提示','删除失败');
			}
		},
		
	});
}
//新增员工
function add(){
	$("#add").dialog('open');
	
}
function del(){
	var data = $("#userlist").datagrid('getSelected');
	if(data==null){
		$.messager.alert('提示','请选择要删除的数据行!');
		return ;
	}
	$.ajax({
		type : 'post',
		url : 'userAction/del',
		data : {userId:data.userId},
		dataType : 'text', 
		success : function(result) {
			if(result == 'success'){
				$.messager.alert('提示','删除成功');
				$("#userlist").datagrid('reload');
			}else{
				$.messager.alert('提示','删除失败');
			}
		},
		
	});
}
function modify(){
	var data = $("#userlist").datagrid('getSelected');
	if(data==null){
		$.messager.alert('提示','请选择要修改的数据行!');
		return ;
	}
	
	$("#userForm").form('load',{
		userId:data.userId,
		userName:data.userName,
		userCode:data.userCode,
		password:data.password
		
	});
	$("#add").dialog('open');
}