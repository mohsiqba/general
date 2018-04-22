<? xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title><fmt:message key="Org.Title"/></title>
	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<link href="${bootstrapCss}" rel="stylesheet" />
	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand"></a>
		</div>
	</div>
</nav>

<div class="jumbotron">
		<h2 class="text-center">${title}</h2>
		<p></p>
	
	<div class="jumbotron">
			<div class="col-xs-6 col-md-offset-3">
				<div id="fadeEffect"></div>
			</div>
	</div>
</div>

<div class="container">

	<table class="table table-hover table-bordered" id="OrgTable">
		<!-- class condensed table-->
		<thead>
			<!-- table head-->
			<tr class="active">
				<th class="text-center"><fmt:message key="Radio.Select"/></th>
				<th class="text-center"><fmt:message key="Org.OrganizationId"/></th>
				<th class="text-center"><fmt:message key="Org.OrganizationName"/></th>
				<th class="text-center"><fmt:message key="Org.OrganizationDescription"/></th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty orgList}">
				<c:forEach var="org" items="${orgList}">
					<tr>
						<td class="text-center"><input type="radio" name="mod" id="${org.orgId}" /></td>
						<td><a href="${pageContext.request.contextPath}/department/get/${org.orgId}"  target="_blank">${org.orgId}</a></td>
						<td>${org.orgName}</td>
						<td>${org.orgDescription}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty orgList}">
				<tr id="tempRow">
					<td colspan="4" class="alert alert-danger text-center"><fmt:message key="No_Rows_Found"/></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="text-center">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#AddModal"><fmt:message key="Org.Add"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#EditModal" id="EditButton"><fmt:message key="Org.Edit"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#DeleteModal" id="DelButton"><fmt:message key="Org.Remove"/></button>
	</div>
	
	  <!-- Modal For Add -->
	<div class="modal fade" id="AddModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"><fmt:message key="Org.NewDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="newOrganizationForm" data-toggle="validator" action="${pageContext.request.contextPath}/organization/add.json" commandName="orgObject" method="post">
						<div class="form-group">
							<label for="AOrgName"><fmt:message key="Org.OrganizationName"/></label> <input path="orgName" type="text" class="form-control" id="AOrgName" placeholder="Organization Name" required/>
						</div>
						<div class="form-group">
							<label for="AOrgDesc"><fmt:message key="Org.OrganizationDescription"/></label> <input path="orgDescription" type="text" class="form-control" id="AOrgDesc" placeholder="Organization Description"  required/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="closeAddOrg"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="addOrg();"><fmt:message key="Button.Add"/></button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal For Edit -->
	<div class="modal fade" id="EditModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"><fmt:message key="Org.EditDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="editOrganizationForm" action="${pageContext.request.contextPath}/organization/edit" commandName="orgObject" method="PUT">
						<div class="form-group">
							<label for="EOrgId"><fmt:message key="Org.OrganizationId"/></label> <input path="orgId" type="text" class="form-control" id="EOrgId" placeholder="Organization Id" disabled="disabled"></input>
						</div>
						<div class="form-group">
							<label for="EOrgName"><fmt:message key="Org.OrganizationName"/></label> <input path="orgName" type="text" class="form-control" id="EOrgName" placeholder="Organization Name"></input>
						</div>
						<div class="form-group">
							<label for="EOrgDesc"><fmt:message key="Org.OrganizationDescription"/></label> <input path="orgDescription" type="text" class="form-control" id="EOrgDesc" placeholder="Organization Description"></input>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateOrg();"><fmt:message key="Button.Save"/></button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal For Delete -->
	<div class="modal fade" id="DeleteModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"><fmt:message key="Org.DeleteWarning_1"/></h4>
				</div>
				<div class="modal-body">
					<p class="text-warning"><small><fmt:message key="Org.DeleteWarning_2"/></small></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteOrg('${pageContext.request.contextPath}');"><fmt:message key="Button.Delete"/></button>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<footer>
		<p>&copy; Mohsin Iqbal</p>
	</footer>
</div>

<spring:url value="/resources/core/js/organization.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"	var="bootstrapJs" />
<spring:url value="/resources/core/js/jquery.min.js" var="minJs"/>
<spring:url value="/resources/core/js/validator.min.js" var="validatorJs"/>
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
<script src="${minJs}"></script>
<script src="${coreJs}"></script>
<script src="${validatorJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>