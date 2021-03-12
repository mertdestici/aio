<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#getAllStudent").click(function deneme() {
				$.ajax({
					type : "POST",
					url : "rest/student/getallstudent",
// 					dataType: "application/json",
					beforeSend: function () {
						alert ("test");
					},
					success: function(response) {
						alert (response);
// 						if (response != null) {
// 							console.log(response);
// 						}					
					},
					error: function () {
						alert ("error");
					}
				});
			});
			$("#add_Student").click(function(){
				$.ajax({
					type : "POST",
					url : 'rest/student/addstudent',
					data : {
						name : $("#studentName").val(),
						sname : $("#studentSurame").val(),
						email : $("#email").val()
					},
					success : function (response){
						console.log(response);
						$("#studentName").val("");
						$("#studentSurame").val("");
						$("#email").val("");
					}
				});
			});
		});
	</script>
</head>
<body>
	<button id="getAllStudent">Get All</button>
	<button id="getStudent">Get Student</button>
	<button id="addStudent" data-target="#add_Modal" data-toggle="modal">Add</button>
	<div class="modal fade" id="add_Modal" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Student</h5>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<table class="m-3" id="form_table">
							<tbody>
								<tr>
									<td><label>Name : </label></td>
									<td class="p-2"><label><input id="studentName" type="text" name="studentName" placeholder="Enter Student Name" /></label></td>
								</tr>
								<tr>
									<td><label>Surname : </label></td>
									<td class="p-2"><label><input id="studentSurame" type="text" name="studentSurame" placeholder="Enter Surname" /></label></td>
								</tr>
								<tr>
									<td><label>Email : </label></td>
									<td class="p-2"><input id="email" type="text" name="email" placeholder="Enter Email" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button class="btn btn-default" data-dismiss="modal">Cancel</button>
						<button class="btn btn-primary" id="add_Student" data-dismiss="modal">Add Student</button>
					</div>
				</div>
			</div>
		</div>
</body>
</html>