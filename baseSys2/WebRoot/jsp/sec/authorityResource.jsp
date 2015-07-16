<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/sec/authorityResource.js" />
	<div class="easyui-layout" style="width: 100%;height: 100%;" id="authorityResource">
		<div data-options="region:'center',split:true" style="width:40%;padding:5px;background:#eee;">
			<table id="dgAuthority" ></table>
		</div>
		<div  data-options="region:'east'" style="width:60%;padding:5px;background:#eee;">
			<table id="dgResource" ></table>
		</div>
		<div id="winResource" class="easyui-window" title="资源选择" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:600px;padding:10px;">
	        <table id="dgOpenResource" ></table>
	    </div>
	</div>
</body>
