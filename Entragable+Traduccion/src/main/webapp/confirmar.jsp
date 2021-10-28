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
	
	<jsp:useBean id="reserva" scope="request" class="org.iesalixar.servidor.cpp.model.Reserva"/>
            <h1>Reserva Confirmada</h1>

            <h4> Fecha Inicio: <%= reserva.getfInicio() %></h4>
            <h4> Fecha Fin: <%= reserva.getfFin() %></h4>
            <h4> Numero de Personas <%= reserva.getNumPer() %></h4>
            <h4> Servicios reservados: </h4>
            
            <% String[] servicios = reserva.getServicios(); %>
            
            <% for (String s:servicios) { %>
            
            	<p> <%= s %> </p>
            	
            <% } %>
            
            


</body>
</html>