<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="include/barra.jsp" />

	<h1 class="text-center">${pro.productName}</h1>

        <div class="row justify-content-center">
            <div class="col-10">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Nº Pedidos</th>
                            <th>Nº Productos en 1 venta</th>
                            <th>Nº Ventas</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                            <tr>
                                <td>${detallesNumPedidos}</td>
                                <td>${detallesNumProductosVentas}</td>
                                <td>${detallesNumVentas}</td>
                            </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</body>
</html>