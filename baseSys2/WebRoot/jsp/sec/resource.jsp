<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/sec/resource.js" />
	<div class="easyui-layout" style="width: 100%;height: 100%;" id="resource">
		<div  data-options="region:'center'" style="padding:5px;background:#eee;">
			<table id="dg" ></table>
		</div>
		<div data-options="region:'east',split:true" style="width:40%;">
			<div class="pageFormContent" >
			<form id="form">
				<input type="hidden" id="resourceId" name="resourceId"/>
				<dl>
					<dt>资源编码：</dt>
					<input class="easyui-textbox"  name="resourceCode" ></input>
				</dl>
				<dl>
					<dt>资源内容：</dt>
					<input class="easyui-textbox" name="resourceContent" ></input>
				</dl>
				<dl>
					<dt>资源类型：</dt>
					<input id="resourceType" name="resourceType" />
				</dl>
				<dl>
					<dt>是否启用：</dt>
					<input id="isValid" name="isValid" />
				</dl>
			</form>
			</div>
		</div>
		</div>
	</div>
</body>
