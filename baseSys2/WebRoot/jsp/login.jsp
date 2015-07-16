<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Custom TextBox - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui/demo/demo.css">
	<style type="text/css">
		.panel {
			position: absolute;
			top: 50%;
			left: 50%;
			width: 400px;
			height: 300px;
			margin-top: -150px;
			margin-left: -200px;
		}
	</style>
	<script type="text/javascript" src="js/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	function login(){
		$('#ff').submit()
		$('#ff3').form('submit', {
			url: "loginAction/login",
			onSubmit: function(){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	// hide progress bar while the form is invalid
				}
				return isValid;	// return false will stop the form submission
			},
			success: function(){
				$.messager.progress('close');	// hide progress bar while submit successfully
			}
		});
	}
	</script>
	
</head>
<body>
	<div class="easyui-panel" title="系统登陆"  style="padding:30px 70px 20px 70px">
		<form id="ff" action="loginAction/login" method="post">
			<div style="margin-bottom:10px">
				<input class="easyui-textbox" name="usercode" style="width:100%;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="password" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
			</div>
			<div style="margin-bottom:20px">
				<input type="checkbox" checked="checked">
				<span>记住账号</span>
			</div>
			<div>
				<a href="javascript:void(0)" onclick="login();" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;">
					<span style="font-size:14px;">登录</span>
				</a>
			</div>
		</form>
	</div>
</body>
</html>