<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="IBM MaaS360 REST-API">
    <meta name="author" content="IBM MaaS360">
    <spring:url value="/resources/core/images/maas360.png" var="maasico" />
    <spring:url value="/resources/core/css/dashboard.css" var="customCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <title>RestApi's - Web Interface</title>
    <link rel="icon" href="${maasico}" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${customCss}" rel="stylesheet" />
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand">IBM MaaS360 REST-API</a>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li id="sb_custprop"><a href="#">Customer Properties</a></li>
            <li id="sb_polipayl"><a href="#">Policy Payload</a></li>
<!--             <li id="sb_analy"><a href="#">Analytics</a></li> -->
<!--             <li id="sb_payl"><a href="#">Reports</a></li> -->
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="bc_custprop" style="display:none">
			<h2 class="page-header">Customer Properties</h2>
			<div class="jumbotron">
				<div class="form-group"></div>
				<!-- form here -->
				<form role="form" method="get" action="#" class="form-inline" id="myForm">
					<div class="form-group">
						<label for="environment">Select Environment : </label>
						<select class="form-control" id="environment" placeholder="Select Environment" >
							<option value="iq1">QA1</option>
							<option value="iq2">QA2</option>
							<option value="iq3">QA3</option>
						</select>
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label for="custId" class="required">Customer Id : </label>
						<input type="text" class="form-control" id="custId" placeholder="Enter Customer Id" required/>
					</div>
					&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary" id="submitBtn">Submit</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" class="btn btn-danger" id="clearBtn">Clear Result</button>
					&nbsp;&nbsp;&nbsp;
				</form>
			</div>

			<div class="jumbotron" id="content" style="display:none">
				<div class="col-xs-12 col-md-offset-0">
					<div id="fadeEffect"></div>
				</div>
				<div id="tblContent">
				</div>
			</div>
        </div>
		
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="bc_polipayl" style="display:none">
			<h2 class="page-header">Policy Payloads</h2>
			<div class="jumbotron">
				<div class="form-group"></div>
				<!-- form here -->
				<form role="form" method="get" action="#" class="form-inline">

					<div class="form-group">
						<label for="environment">Select Environment : </label>
						<select class="form-control" id="environment" placeholder="Select Environment" >
							<option>QA1</option>
							<option>QA2</option>
							<option>QA3</option>
							<option>QA4</option>
							<option>QA5</option>
						</select>
					</div>
					&nbsp;&nbsp;&nbsp;
					<div class="form-group">
						<label for="custId">Customer Id : </label>
						<input type="text" class="form-control" id="custId" placeholder="Enter Customer Id" />
					</div>
					&nbsp;&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary">Submit</button>
					&nbsp;&nbsp;&nbsp;
				</form>
			</div>
			<div class="jumbotron">
				<div id="content">
					<p>No Results </p>
					<table class="table">
						<thead>
							<tr class="info">
								<th>Row</th>
								<th>Property Name</th>
								<th>Property Value</th>
							</tr>
						</thead>
						<tbody>
							<tr class="active">
								<td>1</td>
								<td>John</td>
								<td>Carter</td>
							</tr>
							<tr class="active">
								<td>2</td>
								<td>Peter</td>
								<td>Parker</td>
							</tr>
							<tr class="active">
								<td>3</td>
								<td>John</td>
								<td>Rambo</td>
							</tr>
						</tbody>
						<thead>
							<tr>
								<th colspan="3">
									<button type="button" class="btn btn-primary">Export</button>
								</th>
							</tr>
						</thead>
						
					</table>
				</div>
			</div>
        </div>	
		
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="bc_anal" style="display:none">
			<div class="panel panel-primary">
			  <div class="panel-heading">
				<h3 class="panel-title">Panel title</h3>
			  </div>
			  <div class="panel-body">
				Panel content
			  </div>
			  <div class="panel-footer">Panel footer</div>
			</div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <spring:url value="/resources/core/js/jquery.min.js" var="coreJs" />
    <spring:url value="/resources/core/js/dashboard.js" var="customJs" />
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
    <spring:url value="/resources/core/js/validator.min.js" var="validatorJs"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${coreJs}"><\/script>')</script>
	<script src="${bootstrapJs}"></script>
	<script src="${customJs}"></script>
	<script src="${validatorJs}"></script>
  </body>
</html>
