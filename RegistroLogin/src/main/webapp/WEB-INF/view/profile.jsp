<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="include/bootstrap.jsp" />
<body>


	<h1>Mi cuenta</h1>
	<p>
		Bienvenido a su perfil, ${sessionScope.usuario} (¿No eres
		${sessionScope.usuario} ? <a href="LogOut">Cerrar sesión</a>)
	</p>

	<p>¿Deseas cambiar la contraseña de su cuenta?</p>



	<div class="card card-outline-secondary"
		style="width: 500px; position: relative; left: 100px; top: 10px">
		<div class="card-header">
			<h3 class="mb-0">Change Password</h3>
		</div>
		<div class="card-body">
			<form class="form" role="form" autocomplete="off" method="POST">
				<div class="form-group">
					<label for="inputPasswordOld">Current Password</label> <input
						type="password" class="form-control" id="inputPasswordOld"
						required="" name="currentPswd">
				</div>
				<div class="form-group">
					<label for="inputPasswordNew">New Password</label> <input
						type="password" class="form-control" id="inputPasswordNew"
						required="" name="newPswd"> <span
						class="form-text small text-muted"> The password must be
						8-20 characters, and must <em>not</em> contain spaces.
					</span>
				</div>
				<div class="form-group">
					<label for="inputPasswordNewVerify">Verify</label> <input
						type="password" class="form-control" id="inputPasswordNewVerify"
						required="" name="confirmPswd">

					<c:if test="${requestScope.diferentes == null}">
						<span class="form-text small text-muted"> To confirm, type
							the new password again. </span>
					</c:if>

					<c:if test="${requestScope.diferentes != null}">
						<div class="alert alert-danger" role="alert">Las contraseñas
							no son iguales</div>
					</c:if>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success btn-lg float-right">Save</button>
				</div>
			</form>
		</div>
	</div>


	<div class="card card-outline-secondary"
		style="width: 500px; position: relative; left: 800px; top: -355px">
		<div class="card-header">
			<h3 class="mb-0">Mis pedidos</h3>
		</div>
		<div class="card-body">
			
			
			<table class="table table-striped">
				<thead> 
					<tr>
						<th> ProductCode </th>
						<th> Producto </th>
						<th> Categoria </th>
						<th> Precio </th>
					</tr>
				</thead>
				
				<tbody> 
					<c:forEach items="${requestScope.cesta}" var="cesta">
						<tr>
							<td> ${cesta.productCode} </td>
							<td> ${cesta.productName} </td>
							<td> ${cesta.productLine} </td>
							<td> ${cesta.buyPrice} </td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
			
			
			
			<%--<p> ${requestScope.cesta.getProductCode()} | ${requestScope.cesta.getProductName()} | ${requestScope.cesta.getBuyPrice()}$</p> 
			 ${requestScope.cesta} --%>

		</div>
	</div>

</body>
</html>