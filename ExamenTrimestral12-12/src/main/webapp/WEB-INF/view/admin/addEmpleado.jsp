<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Empleados</title>
</head>
<body>

	<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
	
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="customerNumber mt-3" class="form-label">Numero de Empleado</label>
					<input type="text" class="form-control" id="employeeNumber" name="employeeNumber" required >	
					<label for="checkNumber" class="form-label mt-3">Apellidos</label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >	
    				<label for="paymentDate" class="form-label mt-3">Nombre</label>
    				<input type="text" class="form-control" id="firstName" name="firstName" required>
    				<label for="amount" class="form-label mt-3">Extension</label>
    				<input type="text" class="form-control" id="extension" name="extension" required>
    				<label for="amount" class="form-label mt-3">Puesto</label>
    				<input type="text" class="form-control" id="puesto" name="puesto" required>
    				<label for="amount" class="form-label mt-3">Oficina</label>
    				<select class="form-select" id="oficina" name="oficina">
						<c:forEach  items="${offices}" var="o">
							<option value="${o.city}">${o.city}</option>
						</c:forEach>					
					</select>
    				<label for="amount" class="form-label mt-3">Jefe</label>
    				<input type="int" class="form-control" id="jefe" name="jefe" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR EMPLEADO" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>