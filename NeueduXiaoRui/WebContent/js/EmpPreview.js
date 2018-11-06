//客户端 预览自己的出勤情况
$(function(){
	$.ajax({
		type:'POST',
		url:"emppreviewServlet.do",
		data:{
			"startin":"2018-10-01",
			"startout":"2018-10-31"
		},
		success:function(obj){
			
			if(obj.code==1){
//				if(!null==obj.data){
					var $clockInfos=$("#clockInfos");
					var arr=obj.data;
					var html=$(".clockInfo").html();
					html=html.replace("$empno",arr.empno);
					html=html.replace("$应到",arr.needwork);
					html=html.replace("$实到",arr.realitywork);
					html=html.replace("$缺勤",arr.absencework);
					html=html.replace("$迟到",arr.latework);
					html=html.replace("$早退",arr.earlywork);
					html=html.replace("$请假",arr.askleavework);
					$clockInfos.append(html);
//				}else{
//					
//				}
				
//				for (var i = 0; i < arr.length; i++) {
//					var html=$(".clockInfo").html();
//					
//					var clockinfo=arr[i];
//					
//					html=html.replace("$empno",clockinfo.empno);
//					html=html.replace("$应到",clockinfo.needwork);
//					html=html.replace("$实到",clockinfo.realitywork);
//					html=html.replace("$缺勤",clockinfo.absencework);
//					html=html.replace("$迟到",clockinfo.latework);
//					html=html.replace("$早退",clockinfo.earlywork);
//					html=html.replace("$请假",clockinfo.askleavework);
//					$clockInfos.append(html);
//				}
			}
		},
		
		dataType:'JSON'
	})
})