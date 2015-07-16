<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/sec/role.js" />
	<div style="width: 100%;height: 100%;" id="role">
		<table id="dg"></table>
	</div>
	<div id="mm" class="easyui-menu" style="width:120px;">
		<div onclick="append()" data-options="iconCls:'icon-add'">增加</div>
		<div onclick="save()" data-options="iconCls:'icon-save'">保存</div>
		<div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
		<div class="menu-sep"></div>
		<div onclick="collapse()">Collapse</div>
		<div onclick="expand()">Expand</div>
	</div>
</body>
