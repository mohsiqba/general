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
	<title><fmt:message key="Emp.Title"/></title>
	<spring:url value="/resources/core/css/hello.css" var="coreCss" />
	<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
	<spring:url value="/resources/core/img/loader.gif" var="spinner" />
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
	<div class="jumbotron">
		<div class="col-xs-6 col-md-offset-3">
			<div id="fadeEffect"></div>
			<div id='loader' class="col-xs-3 col-md-offset-5"><img src="${spinner}" alt="Loading Data....."/></div>
		</div>
	</div>
</div>

<div class="container">

	<table class="table table-hover table-bordered" id="EmpTable">
		<!-- class condensed table-->
		<thead>
			<!-- table head-->
			<tr class="active">
				<th class="text-center"><fmt:message key="Radio.Select"/></th>
				<th class="text-center"><fmt:message key="Emp.EmployeeId"/></th>
				<th class="text-center"><fmt:message key="Emp.EmployeeName"/></th>
				<th class="text-center"><fmt:message key="Emp.EmployeePosition"/></th>
				<th class="text-center"><fmt:message key="Emp.EmployeeDOJ"/></th>
			</tr>
		</thead>

		<tbody>
			<c:if test="${not empty empList}">
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td class="text-center"><input type="radio" name="mod" id="${emp.empId}" /></td>
						<td>${emp.empId}</td>
						<td>${emp.empName}</td>
						<td>${emp.empPosition}</td>
						<td>${emp.empDoj}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty empList}">
				<tr id="tempRow">
					<td colspan="5" class="alert alert-danger text-center"><fmt:message key="No_Rows_Found"/></td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<div class="text-center">
		<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#AddModal"><fmt:message key="Emp.Add"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#EditModal" id="EditButton"><fmt:message key="Emp.Edit"/></button>
		<button type="button" class="btn btn-primary btn-sm disabled" disabled="disabled" data-toggle="modal" data-target="#DeleteModal" id="DelButton"><fmt:message key="Emp.Remove"/></button>
	</div>
	
	  <!-- Modal For Add -->
	<div class="modal fade" id="AddModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"><fmt:message key="Emp.NewDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="newEmployeeForm" data-toggle="validator" action="${pageContext.request.contextPath}/employee/add.json" commandName="empObject" method="post">
						<%-- <div class="form-group">
							<label for="AOrgId"><fmt:message key="Dept.SelectOrganization"/></label> 
							<select name="orgId" path="orgId" id="AOrgId" class="form-control">
							    <c:forEach items="${orgIdNameMap}" var="orgIdNameMap">
							        <option value="${orgIdNameMap.key}">${orgIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div> 
						<div class="form-group">
							<label for="ADepId"><fmt:message key="Emp.SelectDepartment"/></label> 
							<select name="deptId" path="deptId" id="ADepId" class="form-control">
							    <c:forEach items="${depIdNameMap}" var="depIdNameMap">
							        <option value="${depIdNameMap.key}">${depIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div> --%>
						<div class="form-group">
							<label for="AOrgId"><fmt:message key="Org.OrganizationId"/></label> <input path="orgId" type="text" class="form-control" id="AOrgId" placeholder="Organization Id" required="true" value="${OrgID}" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="ADepId"><fmt:message key="Dept.DepartmentId"/></label> <input path="deptId" type="text" class="form-control" id="ADepId" placeholder="Organization Id" required="true" value="${DeptID}" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="AEmpName"><fmt:message key="Emp.EmployeeName"/></label> <input path="empName" type="text" class="form-control" id="AEmpName" placeholder="Employee Name" required="true"/>
						</div>
						<div class="form-group">
							<label for="AEmpPosition"><fmt:message key="Emp.EmployeePosition"/></label> <input path="empPosition" type="text" class="form-control" id="AEmpPosition" placeholder="Employee Designation"  required="true"/>
						</div>
						<div class="form-group">
							<label for="AEmpDoj"><fmt:message key="Emp.EmployeeDOJ"/></label> <input path="empDoj" type="date" class="form-control" id="AEmpDoj" placeholder="Employee Date Of Joining"  required="true"/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="closeAddEmp"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="addEmp(${OrgID},${DeptID});"><fmt:message key="Button.Add"/></button>
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
					<h4 class="modal-title"><fmt:message key="Emp.EditDetails"/></h4>
				</div>
				<div class="modal-body">
					<p></p>
					<form id="editEmployeeForm" action="${pageContext.request.contextPath}/employee/edit" commandName="empObject" method="PUT">
						<div class="form-group">
							<label for="EOrgId"><fmt:message key="Dept.SelectOrganization"/>Select Organization :</label> 
							<select name="orgId" path="orgId" id="EOrgId" class="form-control">
							    <c:forEach items="${orgIdNameMap}" var="orgIdNameMap">
							        <option value="${orgIdNameMap.key}">${orgIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="EDepId"><fmt:message key="Emp.SelectDepartment"/></label> 
							<select name="deptId" path="deptId" id="EDepId" class="form-control">
							    <c:forEach items="${depIdNameMap}" var="depIdNameMap">
							        <option value="${depIdNameMap.key}">${depIdNameMap.value}</option>
							    </c:forEach>
							</select>
						</div>
						<!-- <div class="form-group">
							<label for="EOrgId"><fmt:message key="Org.OrganizationId"/></label> <input path="orgId" type="text" class="form-control" id="EOrgId" placeholder="Organization Id" disabled="disabled"/>
						</div>
						<div class="form-group">
							<label for="EDepId"><fmt:message key="Dept.DepartmentId"/></label> <input path="deptId" type="text" class="form-control" id="EDepId" placeholder="Organization Id" disabled="disabled"/>
						</div> -->
						<div class="form-group">
							<label for="EEmpId"><fmt:message key="Emp.EmployeeId"/></label> <input path="empId" type="text" class="form-control" id="EEmpId" placeholder="Employee Id" disabled="disabled"></input>
						</div>
						<div class="form-group">
							<label for="EEmpName"><fmt:message key="Emp.EmployeeName"/></label> <input path="empName" type="text" class="form-control" id="EEmpName" placeholder="Employee Name" required="true"/>
						</div>
						<div class="form-group">
							<label for="EEmpPosition"><fmt:message key="Emp.EmployeePosition"/></label> <input path="empPosition" type="text" class="form-control" id="EEmpPosition" placeholder="Employee Designation"  required="true"/>
						</div>
						<div class="form-group">
							<label for="EEmpDoj"><fmt:message key="Emp.EmployeeDOJ"/></label> <input path="empDoj" type="date" class="form-control" id="EEmpDoj" placeholder="Employee Date Of Joining"  required="true"/>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateEmp(${OrgID},${DeptID});"><fmt:message key="Button.Save"/></button>
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
					<h4 class="modal-title"><fmt:message key="Emp.DeleteWarning_1"/></h4>
				</div>
				<div class="modal-body">
					<p class="text-warning"><small><fmt:message key="Emp.DeleteWarning_2"/></small></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="Button.Close"/></button>
					<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="deleteEmp('${pageContext.request.contextPath}');"><fmt:message key="Button.Delete"/></button>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<footer>
		<p>&copy; Mohsin Iqbal</p>
	</footer>
</div>

<spring:url value="/resources/core/js/employee.js" var="coreJs" />
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