<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oficinas</title>
</head>
<jsp:include page="include/bootstrap.jsp" />

<body>
	<jsp:include page="include/barra.jsp" />

	<br> <br>

	<div class="container mt-5">

	<form action="" method="POST">
	
	<label> Oficina: </label> <br>
	<select name="oficinas" id="oficinas" required> 
		<option value="San Francisco"> San Francisco </option>
		<option value="Boston"> Boston </option>
		<option value="NYC"> NYC </option>
		<option value="Paris"> Paris </option>
		<option value="Tokyo"> Tokyo </option>
		<option value="Sydney"> Sydney </option>
		<option value="London"> London </option>
	</select>
	
	<br><br><br><br>
	<input type="submit" class="btn btn-primary" value="OBTENER DATOS">
	
	</form>
	
	<br><br>
	
	<c:if test="${oficinas !=null}">
	<div id="resultado">
	
		<p> DATOS DE LA OFICINA DE ${oficinas.city.toUpperCase()} </p>
		
		<p> Code: ${oficinas.officeCode}</p>
		<p> Ciudad: ${oficinas.city}</p>
		<p> Teléfono: ${oficinas.phone}</p>
		<p> Dirección 1: ${oficinas.addressLine1}</p>
		<p> Direccion 2: ${oficinas.addressLine2}</p>
		<p> Estado: ${oficinas.state}</p>
		<p> País: ${oficinas.country}</p>
		<p> Código Postal: ${oficinas.postalCode}</p>
		<p> Territorio: ${oficinas.territory}</p>
		
	
	</div>
	
	</c:if>
		
	
	</div>

</body>
</html>