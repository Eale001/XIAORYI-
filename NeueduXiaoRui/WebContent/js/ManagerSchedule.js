//服务端 待处理事项

$(function(){
	function datetimeFormat_2(longTypeDate){ 
		var datetimeType = ""; 
		var date = new Date(); 
		date.setTime(longTypeDate); 
		datetimeType = date.getFullYear()+"-"+getMonth(date)+"-"+getDay(date);//yyyy-MM-dd 00:00:00格式日期 
		return datetimeType; 
	} 
	function getMonth(date){  
		 var month = "";  
		 month = date.getMonth() + 1; //getMonth()得到的月份是0-11  
		 if(month<10){  
		  month = "0" + month;  
		 }  
		 return month;  
		}  
		//返回01-30的日期  
		function getDay(date){  
		 var day = "";  
		 day = date.getDate();  
		 if(day<10){  
		  day = "0" + day;  
		 }  
		 return day;  
		} 
		//小时 
		function getHours(date){ 
		 var hours = ""; 
		 hours = date.getHours(); 
		 if(hours<10){  
		  hours = "0" + hours;  
		 }  
		 return hours;  
		} 
		//分 
		function getMinutes(date){ 
		 var minute = ""; 
		 minute = date.getMinutes(); 
		 if(minute<10){  
		  minute = "0" + minute;  
		 }  
		 return minute;  
		} 
		//秒 
		function getSeconds(date){ 
		 var second = ""; 
		 second = date.getSeconds(); 
		 if(second<10){  
		  second = "0" + second;  
		 }  
		 return second;  
		}
	
	var page=1;
	var total=5;
	
	//处理待处理事项  ---同意
	$("table").delegate(".agree","click",function(){
		var AgreeID=$(this).attr("AgreeID");
		$.ajax({
			type:'POST',
    		url:'disposeAskLeaveServlet.action?msg=1',
    		data:{
    			"AgreeID":AgreeID,
    		},
    		success:function(content){
    			alert(content);
    			if("true"==content){
    				alert("处理成功!");
    			}else{
    				alert("处理失败!")
    			}
//    			var code=obj.code;
//    			alert(code);
//    			if("成功" == obj.message){
//    				alert("处理成功!");
//    				
//    			}else{
//    				alert("处理失败！");
//    			}
    		}
		})
	})
	//不同意
	$("table").delegate(".disagree","click",function(){
		var DISAGREEID=$(this).attr("DISAGREEID");
		$.ajax({
			type:'POST',
    		url:'disposeAskLeaveServlet.action?msg=2',
    		data:{
    			"DISAGREEID":DISAGREEID,
    		},
    		success:function(content){
    			alert(content);
    			if("true"==content){
    				alert("处理成功!");
    			}else{
    				alert("处理失败!")
    			}
//    			alert(obj.code);
//    			if("成功" == obj.message){
//    				alert("处理成功!");
//    				
//    			}else{
//    				alert("处理失败！");
//    			}
    		}
		})
	})
	
	
	$.ajax({
		type:'POST',
		url:"managerSechduleServlet.action",
		data:{
			"page":page,
			"total":total,
			"startin":"2018-10-01",
			"startout":"2018-10-31"
		},
		success:function(obj){
			
			if(obj.code==1){
				
				var $sches=$(".schel");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$(".schels").html();
					
					var clockinfo=arr[i];
					
					html=html.replace("$申请人",clockinfo.empno);
					html=html.replace("$请假","请假");
					html=html.replace("$开始时间",datetimeFormat_2(clockinfo.ask_leave_begin));
					html=html.replace("$结束时间",datetimeFormat_2(clockinfo.ask_leave_end));
					html=html.replace("$请假类型",clockinfo.ask_leave_type);
					html=html.replace("$请假原因",clockinfo.ask_leave_reason);
					html=html.replace("$ID",clockinfo.ask_leave_id)
					html=html.replace("$ID",clockinfo.ask_leave_id)
					//html=html.replace("$准驳",clockinfo.ask_leave_accept);
					
					$sches.append(html);
				}
				$("#nothing").hide();
			}
		},
		
		dataType:'JSON'
	})
})