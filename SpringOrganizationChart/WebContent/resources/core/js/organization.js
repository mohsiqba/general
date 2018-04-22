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
    $('#EOrgId').val(value[1]);
    $('#EOrgName').val(value[2]);
    $('#EOrgDesc').val(value[3]);
});

function addOrg(){
  var form=$('#newOrganizationForm');
  var orgName = $('#AOrgName').val();
  var orgDescription = $('#AOrgDesc').val();
  var json = { "orgId" : null, "orgName" : orgName, "orgDescription": orgDescription};
  $.ajax({
  	url: form.attr( "action"),
  	data: JSON.stringify(json),
  	type: form.attr("method"),
  	dataType : 'json',
  	beforeSend: function(xhr) {
  		xhr.setRequestHeader("Accept", "application/json");
  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
  	},
  	success: function(org) {
  		var rowCount = $('#OrgTable tr').length;
  		if(rowCount==2)
  			$('#tempRow').closest('tr').remove();
  		//window.location.href="organization";
       $('#OrgTable tbody').append('<tr><td class="text-center"><input type="radio" name="mod" id="'+org.orgId+'" /></td><td><a href="department/get/'+org.orgId+'" target="_blank">'+org.orgId+'</a></td><td>'+org.orgName+'</td><td>'+org.orgDescription+'</td></tr>');
  		//form.data('bootstrapValidator').resetForm(true);
  		$('#AOrgName').val('');
  		$('#AOrgDesc').val('');
  		success_alert('Successfully Created New Organization.');
  	},	
    error : function(xhr, ajaxOptions, thrownError){
    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
    	error_alert(xhr.status+" : "+thrownError+"<br>Creation Failed.....!!!!!");
    }
  });
}

function updateOrg(){
	var form=$('#editOrganizationForm');
    var orgId=$('#EOrgId').val();
    var orgName = $('#EOrgName').val();
    var orgDescription = $('#EOrgDesc').val();
    var json = { "orgId" : orgId, "orgName" : orgName, "orgDescription": orgDescription};
    $.ajax({
    	url: form.attr( "action")+"/"+orgId+".json",
    	data: JSON.stringify(json),
    	type: form.attr("method"),
    	dataType : 'json',
    	beforeSend: function(xhr) {
    		xhr.setRequestHeader("Accept", "application/json");
    		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
    	},
    	success: function(org) {
    		var radio='input#'+$('input[type=radio]:checked').attr('id');
    		var $row = $(radio).closest("tr");    // Find the row
    		var $tds = $row.find("td");
    	    var value=[];
    		$.each($tds, function() {
    	        value.push($(this));
    	    });
    		//set the value in Edit Modal
    	    value[2].html($('#EOrgName').val());
    	    value[3].html($('#EOrgDesc').val());
    	    resetAll();
    	    success_alert('organization Updated successfully');
    	},	
      error : function(xhr, ajaxOptions, thrownError){
      	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
      	error_alert(xhr.status+" : "+thrownError+"<br>Updation Failed...!!!!");
      }
    });
}

function deleteOrg(path){
	var id=$('input[type=radio]:checked').attr('id');
	var radio='input#'+id;
	$.ajax({
	  	url: path+"/organization/delete/"+id,
	  	type: "DELETE",
	  	dataType : 'json',
	  	beforeSend: function(xhr) {
	  		xhr.setRequestHeader("Accept", "application/json");
	  		xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	  	},
	  	success: function(org) {
	  		$(radio).closest("tr").remove();
	  		var rowCount = $('#OrgTable tr').length;
	  		if(rowCount==1)
	  			$('#OrgTable tbody').append('<tr id="tempRow"><td colspan="4" class="alert alert-danger text-center">Sorry !!! No More Data To Display</td></tr>');
	  		resetAll();
	  		success_alert('organization deleted successfully');
	  	},	
	    error : function(xhr, ajaxOptions, thrownError){
	    	resetAll();
	    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
	    	error_alert(xhr.status+" : "+thrownError+"<br>Deletion Failed....!!!!!");
	    	
	    }
	  });
}
