$(function(){
	$('#mainTree').tree({
	    url: "menuAction/menuTree",
	    onClick: function(node){
	    	if($('#centerTab').tabs('exists',node.text)){
	    		$('#centerTab').tabs('select',node.text);
	    		var tab = $('#centerTab').tabs('getSelected');
	    		tab.panel('refresh', node.attributes);
	    	}else{
	    		$('#centerTab').tabs('add',{
					id:node.id,
					title: node.text,
					closable:true,
					href: node.attributes
				})
	    	}
		}
	});
})