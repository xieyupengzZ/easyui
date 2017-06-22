$(document).ready(function(){
	//alert(com.url.baseHostname+"|"+com.url.baseHostnameAndPort+"|"+com.url.basePort+"|"+com.url.basePathname+"|"+com.url.baseSearchurl);
	com.ajaxInit();
	docMain.main()
});
var docMain={
			
			main : function(){
				
				com.toolClickEvent();
				docMain.queryEvent();
				docMain.loadData();
			},
			
			queryEvent : function(){
				$('#btnSearch').click(function(){
						var residO = $('#queryConditionO').val();
						$('#tbDataGrid').datagrid({
								queryParams:{
									resId : residO||''
								}
						});
						docMain.loadData();
				})
			},
			
			addEvent : function(){
				/*$('#dlf').form('clear');
				$('#dl').dialog('open').dialog('setTitle', '编辑');*/
				$('#dl2').dialog('open').dialog('setTitle','上传');
			},
			
			uploadEvent : function(){
				$('#uploadfm').form('submit',{
					url:com.getRootPath()+'/user/uploadFile.do',
					onSubmit : function(){
						return $(this).form('validate');
					},
				success : function(result){
					var data = eval('(' + result + ')');
					if (parseInt(data.info.code) != 0) {
						$.messagers.show({
						title:'温馨提示',
						timeout:2000,
						showType:'slide',
						msg:"<span style='color:red;'>"+data.info.mes+"</span>"
					});
					} else {
						$('#uploadfm').form('clear');
						$('#dl2').dialog('close'); 
						$.messager.show({
							title:'温馨提示',
							timeout:2000,
							showType:'slide',
							msg:"<span style='color:green;'>"+data.info.mes+"</span>"
						});
					}
				}
				})
			},
			
			editEvent : function(){
				var rows = $('#tbDataGrid').datagrid('getSelections');
				
				if(rows == null||rows == ''){
						$.messager.show({
							title:'温馨提示',
							timeout:2000,
							showType:'slide',
							msg:"<span style='color:red;'>请选择一行</span>"
						});
				}
				else{
					$('#dl').dialog('open').dialog('setTitle', '编辑');
					//form表单load json 数据是和页面的name匹配的
					$('#dlf').form('load', rows[0]);//如果数据表格的属性没有设定只能点击一行，就必须加个索引
				}
			},
			
			deleteEvent : function(){
				
				rows = $('#tbDataGrid').datagrid('getSelections');
				
				if(rows == null||rows == ''){
						$.messager.show({
							title:'温馨提示',
							timeout:2000,
							showType:'slide',
							msg:"<span style='color:red;'>请选择一行</span>"
						});
				}
				else{
					var s = "";
					for(var i = rows.length;i>0;i--){
						s+=rows[i-1].food;
					}
					alert("delete-"+s);
				}
			},
			reloadEvent : function(){
				window.location.reload();
			},
			/*saveEvent : function(){
				$('#dlf').form('submit',{
					url : docMain.url.urlSave,
					onSubmit : function() {
						return $(this).form('validate');
					},
					success : function(result) {
						var data = eval('(' + result + ')');
						if (parseInt(data.result.code) != 0) {
							com.showError(data.result.msgcn);
						} else {
							com.show(data.result.msgcn);
							$('#dl').dialog('close'); // close the dialog
							$('#tbDataGrid').datagrid('clearSelections');
							$('#tbDataGrid').datagrid('reload'); // reload
						}
					}
				})
			},*/
			loadData : function(){
					
				$('#tbDataGrid').datagrid({
					loadMsg : "loading......",
					url:com.getRootPath()+'/user/queryFoodByResid.do',
					title : "食物",
					iconCls : "icon-search",
					sortName : 'price',
					sortOrder : 'desc',
					idField : "id",
					rownumbers : true,
					pagination : true,
					 pageSize:10,
			 		 pageNumber:1,
			 		 pageList:[10,20,30],
					columns:[[
					          {
					        	  field:'food',
					        	  title:'菜名',
					          },
					          {
					        	  field:'price	',
					        	  title:'价格',
					          },
					          {
					        	  field:'extrafee',
					        	  title:'额外费用',
					          },
					          {
					        	  field:'restaurantid',
					        	  title:'餐馆',
					          }
				]]
				});
			}
}