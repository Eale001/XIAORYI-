$(function(){
	var page=1;
	var total=5;
	$.ajax({
		type:'POST',
		url:"managerClockServlet.action",
		data:{
			"page":page,
			"total":total,
		},
		success:function(obj){
			
			if(obj.code==1){
				
				var $clocknames=$("#clocknames");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$("#clockname").html();
					
					var name=arr[i];
					
					html=html.replace("$考勤人",name.neu_name)
					
					$clocknames.append(html);
				}
			}
		},
		
		dataType:'JSON'
	})
})