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
	<title><fmt:message key="Dept.Title"/></title>
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

	<table class="table table-hover table-bordered" id="DepTable">
		<!-- class condensed table-->
		<thead>
			<!-- table head-->
			<tr class="active">
				<th class="text-center"><fmt:message key="Radio.Select"/></th>
				<th class="text-center"><fmt:message key="Dept.DepartmentId"/></th>
				<th class="text-center"><fmt:message key="Dept.DepartmentName"/></th>
				<th class="text-center"><fmt:message key="Dept.DepartmentManagerName"/></th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty depList}">
				<c:forEach var="dep" items="${depList}">
				 	<tr>
						<td class="text-center"><input type="radio" name="mod" id="${dep.deptId}" /></td>
						<td><a href="${pageContext.request.contextPath}/employee/get/${dep.orgId}/${dep.deptId}"  target="_blank">${dep.deptId}</a></td>
						<td>${dep.deptName}</td>
						<td>${dep.deptMgrName}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty depList}">
				<tr id="tempRow">
					<td colspan="4" class="alert alert-danger text-center"><fmt:message key="No_Rows_Found"/></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="text-center">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#AddModal"><fmt:message key="Dept.Add"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#EditModal" id="EditButton"><fmt:message key="Dept.Edit"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#DeleteModal" id="DelButton"><fmt:message key="Dept.Remove"/></button>
	</div>
	
	  <!-- Modal For Add -->
	<div class="modal fade" id="AddModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"><fmt:message key="Dept.NewDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="newDepartmentForm" data-toggle="validator" action="${pageContext.request.contextPath}/department/add.json" commandName="depObject" method="post">
						<%-- <div class="form-group">
							<label for="AOrgId"><fmt:message key="Dept.SelectOrganization"/></label> 
							<select name="orgId" path="orgId" id="AOrgId" class="form-control">
							    <c:forEach items="${orgIdNameMap}" var="orgIdNameMap">
							        <option value="${orgIdNameMap.key}">${orgIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div> --%>
						<div class="form-group">
							<label for="AOrgId"><fmt:message key="Org.OrganizationId"/></label> <input path="orgId" type="text" class="form-control" id="AOrgId" placeholder="Organization Id" value="${OrgID}" disabled="disabled"></input>
						</div>
						<div class="form-group">
							<label for="ADepName"><fmt:message key="Dept.DepartmentName"/></label> <input path="deptName" type="text" class="form-control" id="ADepName" placeholder="Department Name" required="true"/>
						</div>
						<div class="form-group">
							<label for="ADepMgrName"><fmt:message key="Dept.DepartmentManagerName"/></label> <input path="deptMgrName" type="text" class="form-control" id="ADepMgrName" placeholder="Department Manager Name"  required="true"/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="closeAddDep"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="addDep(${OrgID});"><fmt:message key="Button.Add"/></button>
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
					<h4 class="modal-title"><fmt:message key="Dept.EditDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="editDepartmentForm" action="${pageContext.request.contextPath}/department/edit" commandName="depObject" method="PUT">
						<div class="form-group">
							<label for="EOrgId"><fmt:message key="Dept.SelectOrganization"/></label> 
							<select name="orgId" path="orgId" id="EOrgId" class="form-control">
							    <c:forEach items="${orgIdNameMap}" var="orgIdNameMap">
							        <option value="${orgIdNameMap.key}">${orgIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div>
						<%-- <div class="form-group">
							<label for="EOrgId"><fmt:message key="Org.OrganizationId"/></label> <input path="orgId" type="text" class="form-control" id="EOrgId" placeholder="Organization Id" value="${OrgID}" disabled="disabled"></input>
						</div> --%>
						<div class="form-group">
							<label for="EDepId"><fmt:message key="Dept.DepartmentId"/></label> <input path="deptId" type="text" class="form-control" id="EDepId" placeholder="Department Id" disabled="disabled"></input>
						</div>
						<div class="form-group">
							<label for="EDepName"><fmt:message key="Dept.DepartmentName"/></label> <input path="deptName" type="text" class="form-control" id="EDepName" placeholder="Department Name"></input>
						</div>
						<div class="form-group">
							<label for="EDepMgrName"><fmt:message key="Dept.DepartmentManagerName"/></label> <input path="deptMgrName" type="text" class="form-control" id="EDepMgrName" placeholder="Department Manager Name"></input>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateDep(${OrgID});"><fmt:message key="Button.Save"/></button>
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
					<h4 class="modal-title"><fmt:message key="Dept.DeleteWarning_1"/></h4>
				</div>
				<div class="modal-body">
					<p class="text-warning"><small><fmt:message key="Dept.DeleteWarning_2"/></small></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteDep('${pageContext.request.contextPath}');"><fmt:message key="Button.Delete"/></button>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<footer>
		<p>&copy; Mohsin Iqbal</p>
	</footer>
</div>

<spring:url value="/resources/core/js/department.js" var="coreJs" />
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