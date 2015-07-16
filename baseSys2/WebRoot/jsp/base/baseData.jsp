<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<body>
	<script type="text/javascript" src="jsp/base/baseData.js" />
	<div class="easyui-layout" style="width: 100%;height: 100%;" id="baseData">
		<div data-options="region:'center',split:true" style="width:50%;padding:5px;background:#eee;">
			<input id="sex" name="性别">
			<table id="dgData" ></table>
		</div>
		<div  data-options="region:'east'" style="width:50%;padding:5px;background:#eee;">
			<table id="dgDataDetail" ></table>
		</div>
	</div>
</body>
