$( document ).ready(function() {
    $("#studentForm").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});
    function ajaxPost(){
    	
//    	var formData = {
//    		email : $("#email").val(),
//    		password :  $("#password").val(),
//    		gender : $("#gridRadios1").val(),
//    		hobby : $("#gridCheck1"),
//    		country : $("#inputState"),
//    		roll : $("#roll"),
//    		birth : $("#date")
//    	}
    	$.ajax({
			type : "POST",
			url : $('#baseUrl').attr('href') + "api/customer/save",
			data : $("#studentForm").serializeArray(),
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> Customer's Info: FirstName = " + 
												result.data.email + " ,LastName = " + result.data.password + "</p>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});	
    	constractCategoryTable(result);
    	resetData();
 
    }

    function resetData(){
    	$("#firstname").val("");
    	$("#lastname").val("");
    	$("#gender").val("");
    	$("#hobby").val("");
    	$("#country").val("");
    	$("#roll").val("");
    	$("#date").val("");
    }
})