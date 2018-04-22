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
    $('#EDepId').val(value[1]);
    $('#EDepName').val(value[2]);
    $('#EDepMgrName').val(value[3]);
});

function addDep(oldOrgId){
  var form=$('#newDepartmentForm');
  var orgId = $('#AOrgId').val();
  var deptName= $('#ADepName').val();
  var deptMgrName=$('#ADepMgrName').val();
  var json = { "orgId" : orgId, "deptId" : null, "deptName": deptName, "deptMgrName":deptMgrName};
  $.ajax({
  	url: form.attr( "action"),
  	data: JSON.stringify(json),
  	type: form.attr("method"),
  	dataType : 'json',
  	beforeSend: function(xhr) {
  		xhr.setRequestHeader("Accept", "application/json");
  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
  	},
  	success: function(dept) {
  		if(dept.orgId==oldOrgId){
  			var rowCount = $('#DepTable tr').length;
  			if(rowCount==2)
  				$('#tempRow').closest('tr').remove();
  			//window.location.href="organization";
  			$('#DepTable tbody').append('<tr><td class="text-center"><input type="radio" name="mod" id="'+dept.deptId+'"/></td><td><a href="employee/get/'+dept.orgId+'/'+dept.deptId+'" target="_blank">'+dept.deptId+'</a></td><td>'+dept.deptName+'</td><td>'+dept.deptMgrName+'</td></tr>');
  			//form.data('bootstrapValidator').resetForm(true);
  			$('#ADepId').val('');
  			$('#ADepName').val('');
  			$('#ADepMgrName').val('');
  		}
  		success_alert('Successfully Created New Department For Org Id :'+dept.orgId);
  	},	
    error : function(xhr, ajaxOptions, thrownError){
    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
    	error_alert(xhr.status+" : "+thrownError+"<br>Creation Failed.....!!!!!");
    }
  });
}

function updateDep(oldOrgId){
	var form=$('#editDepartmentForm');
    var orgId=$('#EOrgId').val();
    var deptId=$('#EDepId').val();
    var deptName = $('#EDepName').val();
    var deptMgrName = $('#EDepMgrName').val();
    var json = { "orgId" : orgId, "deptId" : deptId , "deptName" : deptName, "deptMgrName": deptMgrName};
    $.ajax({
    	url: form.attr( "action")+"/"+deptId+".json",
    	data: JSON.stringify(json),
    	type: form.attr("method"),
    	dataType : 'json',
    	beforeSend: function(xhr) {
    		xhr.setRequestHeader("Accept", "application/json");
    		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    	},
    	success: function(dept) {
    		var radio='input#'+$('input[type=radio]:checked').attr('id');
    		var $row = $(radio).closest("tr");    // Find the row
    		console.log(dept.orgId+':'+oldOrgId);
    		if(dept.orgId==oldOrgId){
    			var $tds = $row.find("td");
    			var value=[];
    			$.each($tds, function() {
    				value.push($(this));
    			});
    			value[1].html($('#EOrgId').val());
    			value[3].html($('#EDepName').val());
    			value[4].html($('#EDepMgrName').val());
    		}else{
    			$row.remove();
    	  		var rowCount = $('#DepTable tr').length;
    	  		if(rowCount==1)
    	  			$('#DepTable tbody').append('<tr id="tempRow"><td colspan="4" class="alert alert-danger text-center">Sorry !!! No More Data To Display</td></tr>');
    		}
    		resetAll();
    	    success_alert('department Updated Successfully For Org Id :'+dept.orgId);
    	},	
      error : function(xhr, ajaxOptions, thrownError){
      	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
      	error_alert(xhr.status+" : "+thrownError+"<br>Updation Failed...!!!!");
      }
    });
}

function deleteDep(path){
	var id=$('input[type=radio]:checked').attr('id');
	var radio='input#'+id;
	$.ajax({
	  	url: path+"/department/delete/"+id,
	  	type: "DELETE",
	  	dataType : 'json',
	  	beforeSend: function(xhr) {
	  		xhr.setRequestHeader("Accept", "application/json");
	  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	  	},
	  	success: function(Dept) {
	  		$(radio).closest("tr").remove();
	  		var rowCount = $('#DepTable tr').length;
	  		if(rowCount==1)
	  			$('#DepTable tbody').append('<tr id="tempRow"><td colspan="4" class="alert alert-danger text-center">Sorry !!! No More Data To Display</td></tr>');
	  		resetAll();
	  		success_alert('Department Deleted Successfully');
	  	},	
	    error : function(xhr, ajaxOptions, thrownError){
	    	resetAll();
	    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
	    	error_alert(xhr.status+" : "+thrownError+"<br>Deletion Failed....!!!!!");
	    	
	    }
	  });
}
