//客户端显示的待批准时间
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
	
	
	$.ajax({
		type:'POST',
		url:"empscheduleServlet.do",
		data:{
			"empno":'25',
			"startin":"2018-10-01",
			"startout":"2018-10-31"
		},
		success:function(obj){
			
			if(obj.code==1){
				
				var $sches=$(".schels");
				var arr=obj.data;
				if(arr.length>0){
					$("#nothing").hide();
				}
				for (var i = 0; i < arr.length; i++) {
					var html=$(".schel").html();
					
					var clockinfo=arr[i];
					
					html=html.replace("$请假","请假");
					
					html=html.replace("$开始时间",datetimeFormat_2(clockinfo.ask_leave_begin));
					html=html.replace("$结束时间",datetimeFormat_2(clockinfo.ask_leave_end));
					html=html.replace("$请假类型",clockinfo.ask_leave_type);
					html=html.replace("$原因",clockinfo.ask_leave_reason);
					
					if(clockinfo.ask_leave_accept==0){
						html=html.replace("$准驳","待处理");
					}else if(clockinfo.ask_leave_accept==1){
						html=html.replace("$准驳","已批准");
					}else if(clockinfo.ask_leave_accept==2){
						html=html.replace("$准驳","已驳回");
					}
					
					
					
					$sches.append(html);
				}
				
			}
		},
		
		dataType:'JSON'
	})
})