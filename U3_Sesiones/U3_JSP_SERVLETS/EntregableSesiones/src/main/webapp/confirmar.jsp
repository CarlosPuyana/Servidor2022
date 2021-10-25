<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONFIRMAR</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>


	<jsp:include page="barra.jsp"></jsp:include>
	
	<jsp:useBean id="loginBean" scope="application" class="org.iesalixar.servidor.cpp.model.Reserva">
	
		<jsp:setProperty name="useBean" property="fInicio" />
		<jsp:setProperty name="useBean" property="fFin" />
		<jsp:setProperty name="useBean" property="numPer" />
		<jsp:setProperty name="useBean" property="" />
	 </jsp:useBean>
	<div class="container">
        <div class="row mt-5 justify-content-center">
            <h1 style="color:navy; text-align: center;">RESERVA CONFIRMADA</h1>
            <div class="col-4 fs-2">
                
                
                hola
            </div>
        </div>
    </div>



</body>
</html>