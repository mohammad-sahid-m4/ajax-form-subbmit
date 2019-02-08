$(document).ready(
		function() {
			$("#getAllId").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});
			

		    function constractCategoryTable(categories){
		    var catagoryTable = $('#example').DataTable();
		    catagoryTable.clear().draw();
		    $.each(categories, function(i, category){
		    catagoryTable.row.add([
		    "",
		    ++i,
		    category.firstname,
		    category.lastname,
		    category.gender,
		    category.hobby,
		    category.country,
		    category.roll,
		    category.date
//		    getStatusText(category.status),
//		    getActionButtons(category)
		    ]).draw();
		    $('.gettable tbody').append(category);
		    });
		    }
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : $('#baseUrl').attr('href') + "api/customer/all",
					success : function(result) {
						if (result.status == "Done") {
							$.each(result.data, function(i, customer) {
								var customer='<tr>' +
								'<td>' + i + '</td>' +
								'<td>' + customer.firstname + '</td>' +
								'<td>' + customer.lastname + '</td>' +
								'<td>' + customer.gender + '</td>' +
								'<td>' + customer.hobby + '</td>' +
								'<td>' + customer.country + '</td>' +
								'<td>' + customer.roll + '</td>' +
								'<td>' + customer.date + '</td>' +
							  '</tr>';
								$('#example tbody').append(customer);
							});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})
