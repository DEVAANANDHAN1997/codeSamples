$(document).ready(function(){
	
	$('#searchEmpBut').click(function(){
		var empno = $('#empno').val();
		if(empno.trim() =="")
		{
			$('#empnoMsg').html('Please Enter EmpNo');
		}
		else
		{
			$('#empnoMsg').hide();
			console.log("searching..");
			$.ajax({
				type:"GET",
				url:"getEmployee?empno=" + $('#empno').val(),
				dataType: "json",
				success: function(output)
				{
					console.log("received...");
					$('#ename').val(output.ename);
					$('#job').val(output.job);
					$('#salary').val(output.salary);
				},
				error:function(req, status, error)
				{
					$('#ename').val("");
					$('#job').val("");
					$('#salary').val("");
					$('#empnoMsg').show();
					$('#empnoMsg').html("Error Loading Employee Details");
				}
			});
		}
	});
});