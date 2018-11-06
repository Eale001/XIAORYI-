//客户端显示的待批准时间
$(function(){
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
				
				var $sches=$("#sches");
				var arr=obj.data;
				if(arr.length>0){
					$("#nothing").hide();
				}
				for (var i = 0; i < arr.length; i++) {
					var html=$(".schels").html();
					
					var clockinfo=arr[i];
					
					html=html.replace("$请假","请假");
					html=html.replace("$开始时间",clockinfo.ask_leave_begin);
					html=html.replace("$结束时间",clockinfo.ask_leave_end);
					html=html.replace("$请假类型",clockinfo.ask_leave_type);
					html=html.replace("$请假原因",clockinfo.ask_leave_reason);
					html=html.replace("$准驳",clockinfo.ask_leave_accept);
					
					$sches.append(html);
				}
				
			}
		},
		
		dataType:'JSON'
	})
})