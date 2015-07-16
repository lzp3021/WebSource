<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/sec/roleUser.js" />
	<div class="easyui-layout" style="width: 100%;height: 100%;" id="roleUser">
		<div data-options="region:'center',split:true" style="width:40%;padding:5px;background:#eee;">
			<table id="dgRole" ></table>
		</div>
		<div  data-options="region:'east'" style="width:60%;padding:5px;background:#eee;">
			<table id="dgUser" ></table>
		</div>
		<div id="winUser" class="easyui-window" title="用户选择" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:800px;height:600px;padding:10px;">
	        <table id="dgOpenUser" ></table>
	    </div>
	</div>
</body>
