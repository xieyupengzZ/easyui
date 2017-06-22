//ajaxSetup用来给全部的ajax设置参数
/*$.ajaxSetup({   
             contentType:"application/x-www-form-urlencoded;charset=utf-8",   
             //在success或者error之后执行
             complete:function(XMLHttpRequest,textStatus){   
                     var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
                     if(sessionstatus=="timeout"){   
                                 //如果超时就处理 ，指定要跳转的页面  
                                         window.location.replace(com.getRootPath()+"/timeOut.html");   
                                 }   
                      }   
           });*/
$(function(){
	
	//alert(com.url.baseUrl);
	com.ajaxInit();
	createResTree();
	
});
function createResTree(){
	$('#resTree').tree({
		url:com.getRootPath()+'/user/queryRestree.do',
		onClick : function(node) {
			if (node.attributes) {
				openNewTab(node.text,node.attributes);
			}
	}	
	})
}
function openNewTab(text,attributes) {
	
		if ($('#newtab').tabs('exists', text)) {
			$('#newtab').tabs('select', text);
		} else {
			var tabid = "tab"+attributes;
			$('#newtab').tabs('add', {
				title : text,
				closable : true,
				border:false,
				content : '<table id='+tabid+'></table>'
			});
			createDatagrid(tabid,attributes);
		}
		
	}

function createDatagrid(tabid,attributes){
	
	var $datable = $('#'+tabid);
	//初始化数据
	$datable.datagrid({
		url:com.getRootPath()+'/user/queryFoodByResid.do',
		queryParams : {
			resid : attributes
		},
		//width:600,
		//title:'菜馆列表',
		 frozenColumns:[[
	      	                //{field:'ck',checkbox:true}, //每行前面加个复选框
	      	                {field:'id',title:'Code',width:80,sortable:true}
	      				]],
			columns:[[
			          {
			        	  field:'food',
			        	  title:'菜名',
			          },
			          {
			        	  field:'price	',
			        	  title:'价格',
			        	  sortable:true
			          },
			          {
			        	  field:'extrafee',
			        	  title:'额外费用',
			          },
			          {
			        	  field:'restaurantid',
			        	  title:'餐馆',
			          },
			          {
			        	  field:'createtime',
			        	  title:'操作',
			        	  align:'center',
			        	  formatter:function(value,row,index){
			        		  return '<a class="orderlink" onclick="order('+row.id+',\''+row.food+'\','+row.price+','+row.extrafee+')"></a>'
			        	  }
			          }
			          ]],
         
      				toolbar:[{
      					id:'btnadd',
    					text:'Add',
    					iconCls:'icon-add',
    					handler:function(){
    						alert('add')
    					}
      				},{
      					id:'btncut',
    					text:'Cut',
    					iconCls:'icon-cut',
    					handler:function(){
    						alert('Cut')
    					}
      				},{
      					id:'btnsave',
    					text:'Save',
    					iconCls:'icon-save',
    					handler:function(){
    						alert('Save')
    					}
      				},{
      					id:'btnrmove',
    					text:'Remove',
    					iconCls:'icon-remove',
    					handler:function(){
    						alert('Remove')
    					}
      				},{
      					id:'btnrok',
    					text:'Ok',
    					iconCls:'icon-ok',
    					handler:function(){
    						alert('Ok')
    					}
      				},{
      					id:'btnno',
    					text:'No',
    					iconCls:'icon-no',
    					handler:function(){
    						alert('No')
    					}
      				},{
      					id:'btncancel',
    					text:'Cancel',
    					iconCls:'icon-cancel',
    					handler:function(){
    						alert('Cancel')
    					}
      				},{
      					id:'btnsearch',
    					text:'Search',
    					iconCls:'icon-search',
    					handler:function(){
    						alert('Search')
    					}
      				},{
      					id:'btnprint',
    					text:'Print',
    					iconCls:'icon-print',
    					handler:function(){
    						alert('Print')
    					}
      				},{
      					id:'btnhelp',
    					text:'Help',
    					iconCls:'icon-help',
    					handler:function(){
    						alert('Help')
    					}
      				},{
      					id:'btnback',
    					text:'Back',
    					iconCls:'icon-back',
    					handler:function(){
    						alert('Back')
    					}
      				},{
      					id:'btnrefresh',
    					text:'Refresh',
    					iconCls:'icon-reload',
    					handler:function(){
    						alert('Refresh')
    					}
      				}],
		 singleSelect : true,
         rownumbers : true,
         pagination:true,
         pageSize:10,
 		 pageNumber:1,
 		 pageList:[10,20,30],
	     sortName: 'id',
		 sortOrder: 'desc',
		 remoteSort: false,
		 onLoadSuccess:
				function(data){
				 $(".orderlink").linkbutton({ 
		                text:'订餐',
		                iconCls:'icon-ok'
		            });
			}
	});
}
function order(id,food,price,extrafee){
	//alert(id+food+price+extrafee);
	var fee = price + extrafee;
	$.messager.confirm('订单确认',food+'-共'+fee+'元',function(r){
			if(r){
				/*$.ajax({
					type:"post",
					url:"",
					data:{foodid : id},
					dataType:"json",
					success:function(data){
						
					}
				})*/
				//return '操作成功！已添加到\'我的菜单\'';
			
					$.messager.show({
						title:'温馨提示',
						timeout:2000,
						showType:'slide',
						msg:"<span style='color:red;'>操作成功！已添加到\'我的菜单\'</span>"
					});
				}
	})
}