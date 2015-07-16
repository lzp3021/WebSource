<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/sec/menu.js" />
	<div class="easyui-layout" style="width: 100%;height: 100%;" id="menu">
	<div data-options="region:'center'" style="padding:5px;background:#eee;">
		<table id="tg"></table>
	</div>
	<div data-options="region:'east',split:true" style="width:40%;">
		<div class="pageFormContent" >
			<form id="form">
				<input type="hidden" name="menuId" />
				<input type="hidden" name="parentId" />
				<dl>
					<dt>菜单名称:</dt>
					<input class="easyui-textbox" name="menuName" />
				</dl>
				<dl>
					<dt>菜单编码:</dt>
					<input class="easyui-textbox" name="menuCode" />
				</dl>
				<dl>
					<dt>菜单链接:</dt>
					<input class="easyui-textbox" name="menuUrl" />
				</dl>
				<dl>
					<dt>父节点:</dt>
					<input class="easyui-textbox" name="parentMenuName" />
				</dl>
			</form>
		</div>
		<div style="padding:5px;">
			<a onclick="save()" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
		</div>
	</div>
	</div>
</body>
</html>
