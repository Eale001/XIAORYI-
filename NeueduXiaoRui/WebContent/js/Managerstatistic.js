$(function(){
	$.ajax({
		type:'POST',
		url:"managerstatisticalAnalysisServlet.action",
		data:{
			"empno":2,
			"startin":"2018-10-01",
			"startout":"2018-10-31"
		},
		success:function(obj){
			
			if(obj.code==1){
				
				var $clockInfos=$("#clockInfos");
				var arr=obj.data;
				for (var i = 0; i < arr.length; i++) {
					var html=$(".clockInfo").html();
					
					var clockinfo=arr[i];
					
					html=html.replace("$empno",clockinfo.empno);
					html=html.replace("$应到",clockinfo.needwork);
					html=html.replace("$实到",clockinfo.realitywork);
					html=html.replace("$缺勤",clockinfo.absencework);
					html=html.replace("$迟到",clockinfo.latework);
					html=html.replace("$早退",clockinfo.earlywork);
					html=html.replace("$请假",clockinfo.askleavework);
					$clockInfos.append(html);
				}
			}
		},
		
		dataType:'JSON'
	})
})