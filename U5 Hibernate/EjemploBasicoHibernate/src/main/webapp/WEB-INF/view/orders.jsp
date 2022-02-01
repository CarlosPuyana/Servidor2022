<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Lista de Orders</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<h1 class="bg-primary text-white text-center mb-5">Lista de Pedidos de <b>"${ customers.customerName }"</b></h1>
				 <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Número de Pedido</th>
                            <th>Fecha</th>
                            <th>Fecha de envío</th>
                            <th>Estado</th>
                            <th>Comentarios</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${orders}" var="o">
                            <tr>
                                <td><p>${o.orderNumber}</p></td>
                                <td>${o.orderDate}</td>
                                <td>${o.shippedDate}</td>
                                <td>${o.status}</td>
                                <td>${o.comments}</td>
                                <td>${customers.customerNumber}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table> 
			</div>
		</div>
	</div>
</body>
</html>