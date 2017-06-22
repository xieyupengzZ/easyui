/*$(function(){
		$('#x').dialog();
		$('#y').draggable();
})
$.parser.auto = false;//放在$function函数外，关闭自动解析功能，easyui不会自动绚烂了，无效了
$.parser.onComplete = function(){
	alert('UI组件解析完毕');//放在$function函数外，组件解析完毕后回调执行
}*/
/*$(function(){
	$('#z').layout({
			fit:true//自动适应屏幕
		});
})*/
$(function(){
	/*$('#ultree').tree({
		url: 'tijiao.do',
		animate: true,
		checkbox:true,
		cascadeCheck:false,
		onlyLeftCheck:true,
		lines:true,
		dnd:true
	});*/
	/*alert("执行");
	$.ajax({
		url:"tijiao.do",
		type:"get",
		datatype:"json",
		success:function(data){
			var data2 = eval(data);
			alert(data2.info.code);
		}
	})*/
	firstEvent();
	
	//createTree();
	if((com.url.baseHostname == 'localhost'||com.url.baseHostname == '172.0.0.1')&& $.cookie("easyuiUser")!="null" && typeof($.cookie("easyuiUser"))!= "undefined"){
		createTree();
	}else{
		$("#winLogin").dialog({
			title:"登陆"
		})
	}
	
	
})
function firstEvent(){
	
	$('#tabs').tabs({
		fit : true,
		border : false,
	});
	
	
	//	按下回车键提交登陆
	$(document).keypress(function(event){
	    var keycode = (event.keyCode ? event.keyCode : event.which);//firefox支持which，ie同时支持
	    if(keycode == '13'){
	    		$('#loginBtn').click();
	    }
	});
	
	$('#loginBtn').click(function(){
		$('#Login').form('submit',{
			url:com.getRootPath()+"/user/login.do",
			onSubmit : function() {
				return $(this).form('validate');
			},
		success:function(result){
			var data = eval('('+result+')');
			if (data.info.code == -1) {
				$('#winLogin').form('clear');
				$.messager.show({
					title : 'Error',
					msg : "用户不存在或密码输入错误"
				});
			}
			// 如果查找到用户，关掉登录对话框
			if (data.info.code != -1) {
				//logout();
				$('#winLogin').dialog('close');
				$('#username').text(data.data.user.username + '，您好！');
				// 登录成功就创建菜单
				createTree();
			}
		}
		})
	});
	$('#btnClear').click(function(){
		$('#winLogin').form('clear');
	})
}

function createTree(){
	$('#ultree').tree({
		url:com.getRootPath()+"/user/tijiao.do",
		onClick : function(node) {
			if (node.attributes) {
				openNewTab(node.text, node.attributes);
			}
		}
	})
}

function openNewTab(text, url) {
	//alert("标签页");
	if ($("#tabs").tabs('exists', text)) {
		//alert("存在");
		$('#tabs').tabs('select', text);
//		var tab = $('#tabs').tabs('getSelected');  
//		$('#tabs').tabs('update', {
//			tab: tab,
//			options: {
//				href: url
//			}
//		});
	} else if(url == 'query.html'){
		
		$('#tabs').tabs('add', {
			title : text,
			closable : true,
			content : createFrame(url),
		});
	}else if(url == 'objectDesign.html'){
		$('#tabs').tabs('add', {
			title : text,
			closable : true,
			content : createFrame(url),
		});
	}
		else {
		$('#tabs').tabs('add', {
			title : text,
			closable : true,
			content : '<table id="'+url+'"></table>',
		});
		createdatagrid(url);
	}
	//需要在tab生成函数之后再初始化tab的点击绑定事件，否则无效
	tabClose();
	tabCloseEven();

}

function createdatagrid(url){
	$('#'+url).datagrid({
		url:com.getRootPath()+'/user/queryFoodByResid.do',
		queryParams : {
			resid : url
		},
		columns:[[	
		         	{
		         		field:'id',
		         			title:'id',
		         			hidden:true
		         	},{
		         		field:'food',
		         		title:'菜名',
		         	},{
		         		field:'price',
		         		title:'价格',
		         	},{
		         		field:'extrafee',
		         		title:'额外费用',
		         	},{
		         		field:'restaurantid',
		         		title:'餐馆'
		         	}
		         ]],
				singleSelect:true,
				rownumbers:true,
				 pagination:true,
		         pageSize:10,
		 		 pageNumber:1,
		 		 pageList:[10,20,30],
			     sortName: 'id',
				 sortOrder: 'desc',
				 remoteSort: false
	})
}
function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="' + url
			+ '" style="width:100%;height:100%;"></iframe>';
	return s;
}

function tabCloseEven() {
	// 刷新
	$('#mm-tabupdate').click(function() {
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		$('#tabs').tabs('update', {
			tab : currTab,
			options : {
				content : createFrame(url)
			}
		})
	})
	// 关闭当前
	$('#mm-tabclose').click(function() {
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close', currtab_title);
	})
	// 全部关闭
	$('#mm-tabcloseall').click(function() {
		$('.tabs-inner span').each(function(i, n) {
			var t = $(n).text();
			$('#tabs').tabs('close', t);
		});
	});
	// 关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function() {
		$('#mm-tabcloseright').click();
		$('#mm-tabcloseleft').click();
	});
	// 关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function() {
		var nextall = $('.tabs-selected').nextAll();
		if (nextall.length == 0) {
			// msgShow('系统提示','后边没有啦~~','error');
			// alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});
	// 关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function() {
		var prevall = $('.tabs-selected').prevAll();
		if (prevall.length == 0) {
			// alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i, n) {
			var t = $('a:eq(0) span', $(n)).text();
			$('#tabs').tabs('close', t);
		});
		return false;
	});

	// 退出
	$("#mm-exit").click(function() {
		$('#mm').menu('hide');
	})
}

function tabClose() {
	/* 双击关闭TAB选项卡 */
	$(".tabs-inner").dblclick(function() {
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close', subtitle);
	})
	/* 为选项卡绑定右键 */
	$(".tabs-inner").bind('contextmenu', function(e) {
		$('#mm').menu('show', {
			left : e.pageX,
			top : e.pageY
		});

		var subtitle = $(this).children(".tabs-closable").text();

		$('#mm').data("currtab", subtitle);
		$('#tabs').tabs('select', subtitle);
		return false;
	});
}