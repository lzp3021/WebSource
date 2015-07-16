// 声明一个全局对象Namespace，用来注册命名空间
namespace = new Object();
// 全局对象仅仅存在register函数，参数为名称空间全路径，如"Grandsoft.GEA"
namespace.reg = function(fullNS) {
	// 将命名空间切成N部分, 比如Grandsoft、GEA等
	var nsArray = fullNS.split('.');
	var sEval = "";
	var sNS = "";
	for (var i = 0; i < nsArray.length; i++) {
		if (i != 0)
			sNS += ".";
		sNS += nsArray[i];
		// 依次创建构造命名空间对象（假如不存在的话）的语句
		// 比如先创建Grandsoft，然后创建Grandsoft.GEA，依次下去
		sEval += "if (typeof(" + sNS + ") == 'undefined') " + sNS
				+ " = new Object();"
	}
	if (sEval != "")
		eval(sEval);
}

namespace.reg('jquery.comm');

var local = window.location;
var contextPath = local.pathname.split("/")[1];
basePath = local.protocol + "//" + local.host + "/" + contextPath + "/";
jquery.comm.fileIndex = 0;


/**
 * easyui datagrid公用基础属性
 */
jquery.comm.baseDG ={
	fit : true,
	remoteSort : true,// 是否从服务器给数据排序
	striped : true,
	pagination : true,
	singleSelect : true,
	rownumbers : true,
	fitColumns :true,
	nowrap : true,
	autoRowHeight : false
}

/** 
 * 合并两个json对象属性为一个对象 
 * @param jsonbject1 
 * @param jsonbject2 
 * @returns resultJsonObject 
 */  
$.mergeJsonO = function(jsonbject1, jsonbject2){  
	var resultJsonObject={};  
	for(var attr in jsonbject1){  
		resultJsonObject[attr]=jsonbject1[attr];  
	}  
	for(var attr in jsonbject2){  
		resultJsonObject[attr]=jsonbject2[attr];  
	}  
	return resultJsonObject;  
};  
/**
 * @param boxName
 *            名称
 * @param typeCode
 *            码表对应代码
 * @returns 拼装后html内容
 */
function creatCheckboxList(boxName, typeCode) {
	var html = '';
	$.ajax({
		url : 'commonAction!commCombox.action',
		data : 'typeCode=' + typeCode,
		dataType : 'json',
		async : false,
		type : 'post',
		success : function(result) {
			for (i = 0; i < result.length; i++) {
				var n = result[i];
				html += '<input type="checkbox" name="' + boxName + '" value="'
						+ n.dataCode + '">' + n.dataName;
			}
		},
		error : commerror
	});
	return html;
}
/**
 * 
 * @param result
 *            公共弹出信息
 * @returns
 */
function commerror(result) {
	parent.$.messager.progress('close');
	if (result.responseText.indexOf("注册") > -1) {
		window.location.href = "newindex/index.html?newReg=g";
	} else if (result.responseText == "") {
		alert("访问信息不正确，请稍后再试或重新登录！");
	} else {
		alert(result.responseText);
	}
}
// isClosable:true显示关闭按钮，false隐藏关闭按钮
var alert = function(obj, fun, isClosable) {
	$.messager.alert('温馨提示', obj, "info", fun, isClosable);
};
/**
 * easyui datagrid 格式化日期使用
 * 
 * @param value
 * @param rowData
 * @param rowIndex
 * @returns yyyy-MM-dd
 */
function formatDatetime(value, rowData, rowIndex) {
	if (value != "" && value != undefined) {
		value = value.substring(0, 10);
	}
	return value;
}
function formatLongtext(value, rowData, rowIndex) {
	return '<span title=' + value + '>' + value + '</span>'
}

/**
 * 
 * @returns {当前日期yyyy-MM-dd}
 */
function getCurrDate() {
	var d = new Date(), str = '';
	str += d.getFullYear() + '-'; // 获取当前年份
	str += d.getMonth() + 1 + '-'; // 获取当前月份（0——11）
	str += d.getDate();
	return str;
}

jquery.comm.FileUtil = function() {
}
/**
 * 文件操作帮助类 主要包含上传下载等功能
 */
jquery.comm.FileUtil.delFile = function(img) {
	fileid = $(img).attr('fileid');
	$.ajax({
		url : 'uploadFileAction!delFile.action',
		data : {
			'fileInfo.fileid' : fileid
		},
		dataType : 'json',
		async : false,
		type : 'post',
		success : function(result) {
			$(img).parent().remove();
		},
		error : commerror
	});
}
/**
 * @param span
 *            文件列表容器的js对象
 * @param tableName
 *            业务表表名
 * @param pk
 *            业务表主键
 * @param canDel
 *            是否有删除按钮
 */
function creatFileList(span, tableName, pk, canDel) {
	$
			.ajax({
				url : 'uploadFileAction!findFiles.action',
				data : {
					'fileInfo.tablename' : tableName,
					'fileInfo.tablekeyid' : pk
				},
				dataType : 'json',
				async : false,
				type : 'post',
				success : function(result) {
					span.empty();
					for (i = 0; i < result.length; i++) {
						n = result[i];
						// div
						var div = $('<div></div>');
						div.attr('style', 'width:100%;float:"left"');
						// a
						var a = $('<a>' + n.filename + '</a>');
						var url = "downloadFileAction!download.action?fileid="
								+ n.fileid;
						a.attr('href', url);
						a
								.attr(
										'style',
										'padding:15px;background-image:url(images/fujian.gif);background-repeat:no-repeat;background-position:left center');
						a.appendTo(div);
						// img
						if (canDel == true) {
							var img = $('<img src="images/del.gif">');
							img.attr('fileid', n.fileid);
							img.click(function() {
								jquery.comm.FileUtil.delFile(this);
							});
							img.appendTo(div);
						}
						div.appendTo(span);
					}
				},
				error : commerror
			});
}
/**
 * @param tableName
 *            关联表名
 * @param pk
 *            关联主键值
 * @returns html
 */
function creatPicView(span, tableName, pk) {
	$.ajax({
		url : 'uploadFileAction!findFiles.action',
		data : {
			'fileInfo.tablename' : tableName,
			'fileInfo.tablekeyid' : pk
		},
		dataType : 'json',
		async : false,
		type : 'post',
		success : function(result) {
			span.empty();
			for (i = 0; i < result.length; i++) {
				n = result[i];
				var div = $('<div ></div>');
				var a = $('<img width="130px" hight="130px"/>');
				a.attr('src', basePath + n.filedir);
				a.appendTo(div);
				div.appendTo(span);
			}
		},
		error : commerror
	});
}
/**
 * 对jsonObj中的属性增加对象名，如userId——》user.userId
 * 
 * @param perStr
 *            对象名
 * @param jsonData
 *            json数据
 * @returns {Array}
 */
function creatFormJson(perStr, jsonData) {
	var jsonarr = new Array();
	for ( var key in jsonData) {
		jsonarr[perStr + '.' + key] = jsonData[key];
	}
	return jsonarr;
}
// 弹出代表简单信息
function opendelmsgwindow(v_delid) {
	// 这里这一步是因为当v_delid是null的时候，传到后台的值会变成string类型的如下的:"null",如果是要往数据库存入这个值就会存为带引号的"null"，是一个字符串,
	// 而不是真正的null,会给后续的工作带来很大的麻烦，所以这里做如下的转换！
	if (v_delid == null) {
		v_delid = '';
	}
	$("#delmsgwindow").window({
		//原来标题为通讯信息,现标题代表信息
		title:'代表信息',
		width:575,
		height:390,
		modal: true,
		minimizable : false,
		maximizable : false,
		collapsible : false
	});
  var url = "delMsgInfoScAction!view.action?delid=" +v_delid;
  var content = '<iframe  id="delmsg_window" name="delmsg_window" frameborder="0" style="width:100%;height:98%;"></iframe>';
  $("#delmsgwindow").html(content);
  $("#delmsgwindow").window('open');
  $('#delmsgwindow').find("#delmsg_window").attr("src",url);
}
// 导出excel
function download(URL, PARAMS) {
	var temp = document.createElement("form");
	temp.action = URL;
	temp.method = "POST";
	temp.style.display = "none";
	for ( var x in PARAMS) {
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = PARAMS[x];
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	temp.submit();
	return temp;
}

/*
 * 方法:Array.remove(dx) 通过遍历,重构数组 功能:删除数组元素. 参数:dx删除元素的下标.
 */
Array.prototype.remove = function(dx) {
	if (isNaN(dx) || dx > this.length) {
		return false;
	}
	for (var i = 0, n = 0; i < this.length; i++) {
		if (this[i] != this[dx]) {
			this[n++] = this[i]
		}
	}
	this.length -= 1
}
Date.prototype.format = function(format){ 
	var o = { 
	"M+" : this.getMonth()+1, //month 
	"d+" : this.getDate(), //day 
	"h+" : this.getHours(), //hour 
	"m+" : this.getMinutes(), //minute 
	"s+" : this.getSeconds(), //second 
	"q+" : Math.floor((this.getMonth()+3)/3), //quarter 
	"S" : this.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
	if(new RegExp("("+ k +")").test(format)) { 
	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	} 
	} 
	return format; 
	} 
/**
 * @param s 非空空判断
 * @returns {Boolean}
 */
function isNotNull(s){
	if(typeof(s)!="undefined" && s!=null){
		return true
	}else{
		return false
	}
}