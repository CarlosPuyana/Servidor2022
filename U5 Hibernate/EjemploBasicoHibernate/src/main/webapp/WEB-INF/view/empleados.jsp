<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Lista de Empleados</title>
</head>
<body>

<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Correo Electronico</th>
							<th>Ciudad</th>
							<th>Titulo</th>
							<th>Jefe</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${empleados.employeesList}" var="p">
						
							<tr>
								<td><p>${p.firstName} ${p.lastName}</p></td>
								<td>${p.email}</td>
								<td>${empleados.city}</td>
								<td>${p.jobTitle}</td>
								<td>${p.reportsTo}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>


</body>
</html>