<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesion</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>

<%@taglib prefix="fmt"     uri="http://java.sun.com/jstl/fmt_rt"    %>
<%@taglib prefix="c"     uri="http://java.sun.com/jsp/jstl/core"     %>
<fmt:setBundle basename="interface" />




	<div class="container">
	
	<h1 style="color:navy; text-align:center">Travel Center</h1>
		<div class="row justify-content-center mt-5">
		
			<% if (!session.isNew() && session.getAttribute("LOGEADO") != null && (boolean) session.getAttribute("LOGEADO")) { %>
			<jsp:include page="barra.jsp"></jsp:include>
			<div class="col-3">
				<img alt="error" src="https://live.staticflickr.com/8252/29246200874_524569dffe.jpg">
				
				
				
			</div>
			
		
			<% } else { %>
			
			
			
			<div class="col-3">
			
				
			
				<form method="post">
				
					<label class="form-label"><fmt:message key="user" /></label>
					<input class="form-control" type="text" name="nombre" required/>
					<label class="form-label"><fmt:message key="pass" /></label>
					<input class="form-control" type="password" name="pass" required/>
					<label class="form-label"><fmt:message key="pass2" /></label>
					<input class="form-control" type="password" name="pass2" required/>
					<label class="form-label"><fmt:message key="email" /></label>
					<input class="form-control" type="email" name="email" required/>
					
					
					<br> <br>
				
				
					<input name="registrar" type="submit" class="btn btn-primary w-100" value="<fmt:message key="register" />"/>
				
				</form>
			</div>
			
			
			<% } %>
		
		
		</div>
	
	
	</div>


</body>
</html>