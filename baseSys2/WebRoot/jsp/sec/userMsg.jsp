<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<body class="easyui-layout">
	<script type="text/javascript" src="jsp/sec/userMsg.js"></script>
	<div data-options="region:'north'" style="height:50px;background-color:#ECF2FE;">
		<span style="line-height:50px;margin-left:15px;">用户名</span>:<input id="condition_username" class="easyui-textbox" />
		<a onclick="query()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
		<a onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
		<a onclick="modify()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
		<a onclick="del()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">删除</a>
	</div>
	<div id="userlist" style="width: 100%;height: 90%;" id="role" data-options="region:'center'"></div>
	<div  id="add" style="text-align:center;line-height:30px;">
		<form id="userForm"  method="post"  >
			<input id="userId" name="userId" type="hidden"/>
			用户姓名:<input id="userName"  class="easyui-textbox" name="userName" /><br/>
			登录证号:<input id="userCode" class="easyui-textbox" name="userCode"/><br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码:<input id="password" type="password" class="easyui-textbox" name="password"/><br/>
			确认密码:<input id="posswordV" type="password" class="easyui-textbox" />
		</form>	
	</div>
 </body>
</html>
	