//服务端 待处理事项

$(function(){
	function datetimeFormat_2(longTypeDate){ 
		var datetimeType = ""; 
		var date = new Date(); 
		date.setTime(longTypeDate); 
		datetimeType = date.getFullYear()+"-"+getMonth(date)+"-"+getDay(date)+"&nbsp;"+getHours(date)+":"+getMinutes(date)+":"+getSeconds(date);//yyyy-MM-dd 00:00:00格式日期 
		return datetimeType; 
	} 
	

	
	$.ajax({
		type:'POST',
		url:"managerSechduleServlet.action",
		data:{
			"empno":'2',
			"startin":"2018-10-01",
			"startout":"2018-10-31"
		},
		success:function(obj){
			
			if(obj.code==1){
				
				var $sches=$("#sches");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$(".schels").html();
					
					var clockinfo=arr[i];
					
					html=html.replace("$申请人",clockinfo.empno);
					html=html.replace("$请假","请假");
					html=html.replace("$开始时间",clockinfo.ask_leave_begin);
					html=html.replace("$结束时间",clockinfo.ask_leave_end);
					html=html.replace("$请假类型",clockinfo.ask_leave_type);
					html=html.replace("$请假原因",clockinfo.ask_leave_reason);
					//html=html.replace("$准驳",clockinfo.ask_leave_accept);
					
					$sches.append(html);
				}
				$("#nothing").hide();
			}
		},
		
		dataType:'JSON'
	})
})