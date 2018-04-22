$(document).ready(function(){
	$('#myForm').validator().on('submit', function (e) {
	  if (e.isDefaultPrevented()) {
	
	  } else {
	    // everything looks good!
		var env=$('#environment').val();
		var custId=$('#custId').val();
		console.log('env:'+env+' |custId:'+custId );
		var url='/Dynamicwebproject/getCustomerProperties/'
		$.ajax({
		    url: url+env+'/'+custId,
		    type: 'get',
		    accepts: {
		        text: "text/xml"
		    },
		    dataType:'xml',
		    success: function(data) {
		    	console.log('data :'+data);
		    	parseXmlIntoTable(data);
		    	success_alert("");
		    },
		    error : function(xhr, ajaxOptions, thrownError){
		    	console.log("error: "+xhr.status+" : "+thrownError+" : "+xhr.responseText);
		    	clearResult();
		    	$('#content').show();
		    	error_alert(xhr.status+" : "+thrownError+"<br>Creation Failed.....!!!!!");
		        }
		 });
	  }
	});
	
	function parseXmlIntoTable(xml){
		var prop_size = $(xml).find('properties_length').text();
		var tbl='<table class="table table-condensed"><thead><tr class="info"><th>#</th><th>Property Name</th><th>Property Value</th></tr></thead>';
		var exportBtn='<thead id="tblDownloadBtn"><tr> '+
		'<th colspan="3" class="text-center"> '+
		'<div class="btn-group"> '+
		'<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"> '+
		'Export As <span class="caret"></span></button> '+
		'<ul class="dropdown-menu"> '+
		'<li><a href="#">CSV/EXCEL</a></li> '+
		'<li><a href="#">XML</a></li> '+
		'<li><a href="#">JSON</a></li> '+
		'</ul> '+
		'</div> '+
		'</th> '+
		'</tr> '+
		'</thead>';
		if(prop_size == 0){
			$('#content').show();
			$('#tblContent').html(tbl+'<tbody><tr id="tempRow" class="active"><td colspan="3" class="alert alert-danger text-center">No Data To Display</td></tr></tbody></table>');
		}else{
			var row='<tbody>';
			$(xml).find('property').each(function(i,j){
				row+='<tr class="active"><td>'+(i+1)+'</td><td>'+($(j).attr('name'))+'</td><td>'+($(j).attr('value'))+'</td></tr>';
			});
			row+='</tbody>';
			$('#content').show();
			$('#tblContent').empty();
			$('#tblContent').html(tbl+row+exportBtn+'</table>');
		}
	}
	
	$("div div div ul li").click(function() {
		var id=$(this).prop('id');
		if(id!=$('.active').prop('id'))
			$(this).toggleClass("active");
		$(this).siblings().removeClass("active");
		var cid =id.replace("sb_","bc_");
		$(".main:visible").hide();
		$('#'+cid).show();
	});
	
	$('#clearBtn').click(function(){
		clearResult();
	});
	
	function clearResult(){
		$('#fadeEffect').removeClass();
		$('#fadeEffect').empty();
		$('#tblContent').empty();
		$('#content').hide();
	}
	function error_alert(msg){
		$('#fadeEffect').removeClass();
		$('#fadeEffect').addClass('alert alert-danger');
		$('#fadeEffect').html('<strong>Error!</strong>'+'<br>'+msg);
		//$('#fadeEffect').fadeIn(2000,function(){$(this).fadeOut(2000);});
	}
	
	function success_alert(msg){
		$('#fadeEffect').removeClass();
		$('#fadeEffect').addClass('alert alert-success');
		$('#fadeEffect').html('<strong>Success!</strong>'+'<br>'+msg);
		//$('#fadeEffect').fadeIn(2000,function(){$(this).fadeOut(2000);});
	}
	
	
	
});


