$(function() {
	
	
	//补签
	$("#restroactive").submit(function(event){
		event.preventDefault();
		
		$.ajax({
			type:'POST',
    		url:'empretroactiveServlet.do',
    		data:{
    			"restroactivein":$("input[name='restroactivein']").val(),
    			"restroactiveinH":$("input[name='restroactiveinH']").val(),
    			"restroactiveout":$("input[name='restroactiveout']").val(),
    			"restroactiveoutH":$("input[name='restroactiveoutH']").val(),
    			"restroactive_reason":$("textarea[name='restroactive_reason']").val(),
    		},
    		success:function(content){
    			alert(content);
    			if("3" == content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
	})
	
	//请假
	$("#ask_leave").submit(function(event){
		event.preventDefault();
		
		$.ajax({
			type:'POST',
    		url:'empask_LeaveServlet.do',
    		data:{
    			"empno":'11',
    			"leave_begin":$("input[name='leave_begin']").val(),
    			"leave_end":$("input[name='leave_end']").val(),
    			"leave_type":$("select[name='leave_type']").val(),
    			"leave_reason":$("textarea[name='leave_reason']").val()
    		},
    		success:function(content){
    			if("true"==content){
    				alert("提交成功!");
    				
    			}else{
    				alert("失败了！");
    			}
    		}
		})
	})
	
	//打卡
	$("#clockin").click(function() {
		var timestamp = new Date().getTime();
		// alert(timestamp);

		var mydate = new Date();
		// alert(mydate);

		$.ajax({
			type : "post",
			url : "empclockInServlet.do",
			data : ({
				"date" : timestamp,
				"empno" : 11
			}),
			success : function(content) {
				if ("1" == content) {
					alert("上班打卡成功!");
				} else if ("2" == content) {
					alert("下班打卡成功!");
				} else {
					alert("现在时间不能打卡!");
				}
			},

		});

	})

})

//		
// $('#exampleModal').on('show.bs.modal', function(event) {
// var button = $(event.relatedTarget) // Button that triggered the modal
// var recipient = button.data('whatever') // Extract info from data-*
// attributes
// // If necessary, you could initiate an AJAX request here (and then do the
// updating in a callback).
// // Update the modal's content. We'll use jQuery here, but you could use a
// data binding library or other methods instead.
// var modal = $(this)
// modal.find('.modal-title').text('New message to ' + recipient)
// modal.find('.modal-body input').val(recipient)
// })
