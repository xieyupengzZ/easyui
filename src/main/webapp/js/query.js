$(function(){
	
	com.ajaxInit();
	
	$('#parentPanel').panel({
		fit:true,
		border:false,
		height:'100%'
	})
	/*$('#selectCombobox').combobox({
		url:com.getRootPath()+'/user/queryRes.do',
		valueField:'id',
		textField:'text'
	})
	$('#btnquery').linkbutton({
		iconCls:'icon-search',
		plain:true
	})
	$('#btnquery').click(function(){
		var  comvalue = $('#selectCombobox').combobox('getValue');
		createdatagrid(comvalue);
	})*/
	$('#selectPanel').panel({
		title:'查询条件',
		height:100,
		width:$('#parentPanel').width(),
		iconCls:'icon-search'
	})
	$('#resultPanel').panel({
		title:'结果',
		height:$('#parentPanel').height()-$('#selectPanel').height()-40,
		width:$('#parentPanel').width(),
		iconCls:'icon-save'
	})
	
})
function clicker(value,name){
	if((typeof(name)!=undefined||name!=null)&&name.length!=0){
		createdatagrid(name);
	}
	else{
		createdatagrid(value);
	}
}
function createdatagrid(comvalue){
	$('#menudatagrid').datagrid({
		url:com.getRootPath()+'/user/queryFoodByResid.do',
		queryParams:{
			resid:comvalue||0
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
		        	 title:'价格'
		         },{
		        	 field:'extrafee',
		        	 title:'额外价格'
		         }
		         ]],
	 singleSelect : true,
     rownumbers : true,
     pagination:true,
     pageSize:10,
	 pageNumber:1,
	 pageList:[10,20,30],
     sortName: 'id',
	 sortOrder: 'desc',
	 remoteSort: false
	})
}