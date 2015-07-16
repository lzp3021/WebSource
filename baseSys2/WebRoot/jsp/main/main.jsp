<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>主页</title>
<link rel="stylesheet" type="text/css"	href="js/jquery-easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"	href="js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css"	href="css/style.css">
<script type="text/javascript" src="js/jquery-easyui/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui/edatagrid/jquery.edatagrid.js"></script>
<script type="text/javascript" src="js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/jquery.comm.js"></script>
<script type="text/javascript" src="jsp/main/main.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:127px">
		<h1>spring mvc+spring+hibernate+shiro</h1>
	</div>
	<div data-options="region:'west',split:true" title="菜单"		style="width:200px;">
		 <ul id="mainTree"></ul>
	</div>
	<div data-options="region:'center'" 	>
		<div id="centerTab" class="easyui-tabs" data-options="fit:true,border:false,plain:true">
		</div>
	</div>
 </body>
</html>
	