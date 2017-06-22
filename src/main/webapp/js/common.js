var com = {
		
		//ajaxSetup用来给全部的ajax设置参数
		ajaxInit : function(){
			$.ajaxSetup({   
	             contentType:"application/x-www-form-urlencoded;charset=utf-8",   
	             //在success或者error之后执行
	             complete:function(XMLHttpRequest,textStatus){   
	                     var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
	                     if(sessionstatus=="timeout"){   
	                                 //如果超时就处理 ，指定要跳转的页面  
	                                         window.location.replace(com.getRootPath()+"/timeOut.html");   
	                                 }   
	                      }   
	           });
		},
		//js获取项目根路径，如： http://localhost:8083/uimcardprj
		getRootPath : function(){
		 //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
		 var curWwwPath=window.document.location.href;
		 //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
		 var pathName=window.document.location.pathname;
		var pos=curWwwPath.indexOf(pathName);
		 //获取主机地址，如： http://localhost:8083
		 var localhostPaht=curWwwPath.substring(0,pos);
		 //获取带"/"的项目名，如：/uimcardprj
		 var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
		 return(localhostPaht+projectName);
		},
		
		toolClickEvent : function(){
			$('#btnAdd').bind('click', docMain.addEvent);
			
			$('#btnEdit').bind('click',docMain.editEvent);
			
			$('#btnDelete').bind('click',docMain.deleteEvent);
			
			$('#btnReload').bind('click',docMain.reloadEvent);
			
			$('#btnSaveForm').bind('click',docMain.saveEvent);
			
			$('#btnUploadForm').bind('click',docMain.uploadEvent);
		},
		
		url:{
			baseHostname : window.location.hostname,//主机地址
			baseHostnameAndPort: window.location.host,//主机地址和端口号
			basePort: window.location.port,//端口号
			basePathname: window.location.pathname,//url路径部分（除主机和端口号）
			baseSearchurl: window.location.searchURL//查询部分的url
		}
}