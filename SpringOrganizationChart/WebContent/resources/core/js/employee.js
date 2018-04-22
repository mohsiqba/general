$(document).on('change', 'input:radio[name="mod"]', function (event) {
	enableAll();
});

function enableAll(){
	$('#DelButton').prop('disabled', false);
	$('#EditButton').prop('disabled', false);
	$('#DelButton').removeClass('disabled');
	$('#EditButton').removeClass('disabled');
}

function resetAll(){
	$('input[type=radio]').prop('checked', false);
	$('#DelButton').prop('disabled', true);
	$('#EditButton').prop('disabled', true);	
	$('#DelButton').addClass('disabled');
	$('#EditButton').addClass('disabled');
}

function success_alert(msg){
	$('#fadeEffect').removeClass();
	$('#fadeEffect').addClass('alert alert-success');
	$('#fadeEffect').html('<strong>Success!</strong>'+'<br>'+msg);
	$('#fadeEffect').fadeIn(2000,function(){$(this).fadeOut(2000);});
}

function error_alert(msg){
	$('#fadeEffect').removeClass();
	$('#fadeEffect').addClass('alert alert-danger');
	$('#fadeEffect').html('<strong>Error!</strong> A problem has been occurred while processing data.'+'<br>'+msg);
	$('#fadeEffect').fadeIn(2000,function(){$(this).fadeOut(2000);});
}

$('#loader').hide();

$('#AOrgId').on('change', function (e) {
    var selectedOrgId = this.value;
    $.ajax({
      	url:'/SpringOrganizationChart/employee/get/'+selectedOrgId+'.json' ,
      	type: 'POST',
      	dataType : 'json',
      	beforeSend: function(xhr) {
      		xhr.setRequestHeader("Accept", "application/json");
      		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
      		$('#loader').show();
      	},
        complete: function(){
            $('#loader').hide();
         },
      	success: function(data, textStatus, xhr) {
      		 var select = $("#ADepId");
             select.empty();      
         	$.each(data, function(key, value) {
         		select.append($('<option/>', {
         			value : key,
         			text : value
         		}));
         	});
      	},	
        error : function(xhr, ajaxOptions, thrownError){
        	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
        	error_alert(xhr.status+" : "+thrownError+"<br>Process Failed.....!!!!!");
        }
      });
    
});

$('#EOrgId').on('change', function (e) {
    var selectedOrgId = this.value;
    $.ajax({
      	url:'/SpringOrganizationChart/employee/get/'+selectedOrgId+'.json' ,
      	type: 'POST',
      	dataType : 'json',
      	beforeSend: function(xhr) {
      		xhr.setRequestHeader("Accept", "application/json");
      		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
      	},
      	success: function(data, textStatus, xhr) {
      		 var select = $("#EDepId");
             select.empty();      
         	$.each(data, function(key, value) {
         		select.append($('<option/>', {
         			value : key,
         			text : value
         		}));
         	});
      	},	
        error : function(xhr, ajaxOptions, thrownError){
        	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
        	error_alert(xhr.status+" : "+thrownError+"<br>Process Failed.....!!!!!");
        }
      });
});

$("#EditButton").click(function() {
    //get the selected radio button by scanning the radio type
	var radio='input#'+$('input[type=radio]:checked').attr('id');
	var $row = $(radio).closest("tr");    // Find the row
	var $tds = $row.find("td");
    var value=[];
	$.each($tds, function() {
        value.push($(this).text());
    });
	//set the value in Edit Modal
    $('#EEmpId').val(value[1]);
    $('#EEmpName').val(value[2]);
    $('#EEmpPosition').val(value[3]);
    $('#EEmpDoj').val(value[4]);
});

function addEmp(oldOrgId,oldDepId){
  var form=$('#newEmployeeForm');
  var orgId = $('#AOrgId').val();
  var deptId = $('#ADepId').val();
  var empName= $('#AEmpName').val();
  var empPosition=$('#AEmpPosition').val();
  var empDoj = $('#AEmpDoj').val();
  var json = { "orgId" : orgId, "deptId" : deptId, "empId" : null, "empName": empName, "empPosition":empPosition, "empDoj" : empDoj };
  $.ajax({
  	url: form.attr( "action"),
  	data: JSON.stringify(json),
  	type: form.attr("method"),
  	dataType : 'json',
  	beforeSend: function(xhr) {
  		xhr.setRequestHeader("Accept", "application/json");
  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
  	},
  	success: function(emp) {
  		if(emp.orgId==oldOrgId && emp.deptId==oldDepId){
  			var rowCount = $('#EmpTable tr').length;
  			if(rowCount==2)
  				$('#tempRow').closest('tr').remove();
  			//window.location.href="employee/get/emp.orgId";	
  			$('#EmpTable tbody').append('<tr><td class="text-center"><input type="radio" name="mod" id="'+emp.empId+'" /></td><td>'+emp.empId+'</td><td>'+emp.empName+'</td><td>'+emp.empPosition+'</td><td>'+emp.empDoj+'</td></tr>');
  			//form.data('bootstrapValidator').resetForm(true);
  			$('#AEmpId').val('');
  			$('#AEmpName').val('');
  			$('#AEmpDoj').val('');
  		}
  		success_alert('Successfully Added New Employee.');
  	},	
    error : function(xhr, ajaxOptions, thrownError){
    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
    	error_alert(xhr.status+" : "+thrownError+"<br>Creation Failed.....!!!!!");
    }
  });
}

function updateEmp(oldOrgId,oldDepId){
	var form=$('#editEmployeeForm');
	var orgId = $('#EOrgId').val();
	var deptId = $('#EDepId').val();
	var empId = $('#EEmpId').val();
	var empName= $('#EEmpName').val();
	var empPosition=$('#EEmpPosition').val();
	var empDoj = $('#EEmpDoj').val();
	var json = { "orgId" : orgId, "deptId" : deptId, "empId" : empId, "empName": empName, "empPosition":empPosition, "empDoj" : empDoj };
	$.ajax({
		url: form.attr( "action")+"/"+empId+".json",
		data: JSON.stringify(json),
		type: form.attr("method"),
		dataType : 'json',
		beforeSend: function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
		},
		success: function(emp) {
			if(emp.orgId==oldOrgId && emp.deptId==oldDepId){
				var radio='input#'+$('input[type=radio]:checked').attr('id');
				var $row = $(radio).closest("tr");    // Find the row
				var $tds = $row.find("td");
				var value=[];
				$.each($tds, function() {
					value.push($(this));
				});
				//set the value in Edit Modal
				value[1].html(emp.empId);
				value[2].html(emp.empName);
				value[3].html(emp.empPosition);
				value[4].html(emp.empDoj);
			}
			resetAll();
			success_alert('Employee Information Updated successfully');
		},	
		error : function(xhr, ajaxOptions, thrownError){
			console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
			error_alert(xhr.status+" : "+thrownError+"<br>Updation Failed...!!!!");
		}
	});
}

function deleteEmp(path){
	var id=$('input[type=radio]:checked').attr('id');
	var radio='input#'+id;
	$.ajax({
	  	url: path+"/employee/delete/"+id,
	  	type: "DELETE",
	  	dataType : 'json',
	  	beforeSend: function(xhr) {
	  		xhr.setRequestHeader("Accept", "application/json");
	  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	  	},
	  	success: function(Dept) {
	  		$(radio).closest("tr").remove();
	  		var rowCount = $('#EmpTable tr').length;
	  		if(rowCount==1)
	  			$('#EmpTable tbody').append('<tr id="tempRow"><td colspan="5" class="alert alert-danger text-center">Sorry !!! No More Data To Display</td></tr>');
	  		resetAll();
	  		success_alert('Employee now removed successfully');
	  	},	
	    error : function(xhr, ajaxOptions, thrownError){
	    	resetAll();
	    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
	    	error_alert(xhr.status+" : "+thrownError+"<br>Deletion Failed....!!!!!");
	    	
	    }
	  });
}
