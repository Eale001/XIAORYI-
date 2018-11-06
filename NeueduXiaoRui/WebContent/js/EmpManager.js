$(function(){
	
	var total=3;
	var page=1;
	
	//修改工号表
	$("table").delegate(".updadaacc","click",function(){
		var fid=$(this).attr("fid");
		
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=5',
    		data:{
    			"f_id":fid,
    		},
    		success:function(obj){
    			if("1"==obj.code){
    				alert(555);
    				var arr=obj.data;
    				$("input[name='updateneu_account']").val(arr.nei_empno);
        			$("input[name='updateneu_password']").val(arr.neu_pwd);
        			$("input[name='updatwneu_power_level']").val(arr.neu_power_level);
    			}
    		},
    		dataType:'JSON'
		})
		alert(1);
		$("#updateaccount").submit(function(event){
		//取消默认提交
		event.preventDefault();
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=3',
    		data:{
    			"updateneu_account":$("input[name='updateneu_account']").val(),
    			"updateneu_password":$("input[name='updateneu_password']").val(),
    			"updatwneu_power_level":$("input[name='updatwneu_power_level']").val(),
    		},
    		success:function(content){
    			alert(content);
    			if("true" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
		
		
	})
	})
	
	//修改信息表
	$("table").delegate(".updateemp","click",function(){
		var upid=$(this).attr("up_id");
		
		$.ajax({
			type:'POST',
    		url:'manageUserServlet.action?msg=5',
    		data:{
    			"upid":upid,
    		},
    		success:function(obj){
    			if("1"==obj.code){
    				alert(555);
    				var arr=obj.data;
    				$("input[name='updateempname']").val(arr.neu_name);
        			$("input[name='updateempemail']").val(arr.neu_email);
        			$("input[name='updateemptel']").val(arr.neu_tel);
        			$("input[name='updateempaddre']").val(arr.neu_addre);
        			$("input[name='updateempage']").val(arr.neu_age);
        			$("input[name='updateempsex']").val(arr.neu_sex);
        			$("input[name='updateempno']").val(arr.neu_empno);
        			
    			}
    		},
    		dataType:'JSON'
		})
		alert(1);
		$("#updateemp").submit(function(event){
		//取消默认提交
		event.preventDefault();
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=3',
    		data:{
    			"updateempname":$("input[name='updateempname']").val(),
				"updateempemail":$("input[name='updateempemail']").val(),
				"updateemptel":$("input[name='updateemptel']").val(),
				"updateempaddre":$("input[name='updateempaddre']").val(),
				"updateempage":$("input[name='updateempage']").val(),
				"updateempsex":$("input[name='updateempsex']").val(),
				"updateempno":$("input[name='updateempno']").val(),
    		},
    		success:function(content){
    			alert(content);
    			if("true" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
		
		
	})
	})
	
	
	
	//增加一个员工工号
	$("#addaccount").submit(function(event){
		//取消默认提交
		event.preventDefault();
		
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=2',
    		data:{
    			"addneuaccount":$("input[name='addneuaccount']").val(),
    			"addneupassword":$("input[name='addneupassword']").val(),
    			"addneupowerlevel":$("input[name='addneupowerlevel']").val(),
    		},
    		success:function(content){
    			alert(content);
    			if("true" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
	})
	
	$("#account_1").click(function(){
		$.ajax({
			type:'POST',
			url:"manageAccountServlet.action?msg=1",
			data:{
				"page":$("#account_1").text(),
				"total":total,
			},
			success:function(obj){
				if(obj.code==1){
					
					var $accountinfos=$("#accountinfos");
					var arr=obj.data;
					for (var i = 0; i < arr.length; i++) {
						var html=$(".accountinfo").html();
						
						var accountinfo=arr[i];
						
						html=html.replace("$Neu_EmpNo",accountinfo.nei_empno)
						html=html.replace("$Neu_pwd",accountinfo.neu_pwd)
						html=html.replace("$Neu_power_level",accountinfo.neu_power_level)
						html=html.replace("$ID",accountinfo.m_id)
						$accountinfos.append(html);
						
//						$("input[name='updateneu_account']").text(accountinfo.nei_empno);
//						$("input[name='updateneu_password']").text(accountinfo.neu_pwd);
//						$("input[name='addneupowerlevel']").text(accountinfo.neu_power_level)
					}
				}
			},
			dataType:'JSON'
		})
	})
	
	$("#account_2").click(function(){
		page=$("#account_2").text()
		$.ajax({
			type:'POST',
			url:"manageAccountServlet.action?msg=1",
			data:{
				"page":page,
				"total":total,
			},
			success:function(obj){
				if(obj.code==1){
					
					var $accountinfos=$("#accountinfos");
					var arr=obj.data;
					for (var i = 0; i < arr.length; i++) {
						
						var parent=$(".addline");
						var child=$(".addline tr");
						//parent.empty(child);	
						
						
						var html=$(".accountinfo").html();
						
						var accountinfo=arr[i];
						
						html=html.replace("$Neu_EmpNo",accountinfo.nei_empno)
						html=html.replace("$Neu_pwd",accountinfo.neu_pwd)
						html=html.replace("$Neu_power_level",accountinfo.neu_power_level)
						html=html.replace("$ID",accountinfo.m_id)
						$accountinfos.append(html);
						
						
						
//						$("input[name='updateneu_account']").text(accountinfo.nei_empno);
//						$("input[name='updateneu_password']").text(accountinfo.neu_pwd);
//						$("input[name='addneupowerlevel']").text(accountinfo.neu_power_level)
					}
				}
			},
			dataType:'JSON'
		})
	})
	
	//获取员工工号表
	$.ajax({
		type:'POST',
		url:"manageAccountServlet.action?msg=1",
		data:{
			"page":page,
			"total":total,
		},
		success:function(obj){
			if(obj.code==1){
				
				var $accountinfos=$("#accountinfos");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$(".accountinfo").html();
					
					var accountinfo=arr[i];
					
					html=html.replace("$Neu_EmpNo",accountinfo.nei_empno)
					html=html.replace("$Neu_pwd",accountinfo.neu_pwd)
					html=html.replace("$Neu_power_level",accountinfo.neu_power_level)
					html=html.replace("$ID",accountinfo.m_id)
					html=html.replace("$ID",accountinfo.m_id)
					$accountinfos.append(html);
					
//					$("input[name='updateneu_account']").text(accountinfo.nei_empno);
//					$("input[name='updateneu_password']").text(accountinfo.neu_pwd);
//					$("input[name='addneupowerlevel']").text(accountinfo.neu_power_level)
				}
			}
		},
		dataType:'JSON'
	})
	//获取员工信息表
	$.ajax({
		type:'POST',
		url:"manageUserServlet.action?msg=1",
		data:{
			"page":page,
			"total":total,
		},
		success:function(obj){
			if(obj.code==1){
				alert(1);
				var $empInfos=$("#empInfos");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$(".empInfo").html();
					
					var empInfo=arr[i];
					
					html=html.replace("$ID",empInfo.neu_id)
					html=html.replace("$NAME",empInfo.neu_name)
					html=html.replace("$EMAIL",empInfo.neu_email)
					html=html.replace("$TEL",empInfo.neu_tel)
					html=html.replace("$ADDRE",empInfo.neu_addre)
					html=html.replace("$AGE",empInfo.neu_age)
					html=html.replace("$GENDER",empInfo.neu_sex)
					html=html.replace("$EMPNO",empInfo.neu_empno)
					html=html.replace("$ID",empInfo.neu_id)
					html=html.replace("$ID",empInfo.neu_id)
					$empInfos.append(html);
					
				}
			}
		},
		dataType:'JSON'
	})
	//删除一个用户  员工表
	$("table").delegate(".deleteacc","click",function(){
		var did=$(this).attr("did");
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=4',
    		data:{
    			"m_id":did,
    		},
    		success:function(content){
    			alert(content);
    			if("true" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
	})
	
	//删除一个员工 信息表
	$("table").delegate(".deleteemp","click",function(){
		var de_id=$(this).attr("de_id");
		$.ajax({
			type:'POST',
    		url:'manageAccountServlet.action?msg=4',
    		data:{
    			"de_id":de_id,
    		},
    		success:function(content){
    			alert(content);
    			if("true" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
	})
})