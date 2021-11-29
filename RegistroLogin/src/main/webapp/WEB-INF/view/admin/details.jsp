<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="../include/bootstrap.jsp" />
</head>
<body>


<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-8">				
				<ul>
					<c:forEach items="${detallesPedido.getOrderDetails()}" var="detalle">
						<li>${detalle.product.productName}:${detalle.quantityOrdered} X ${detalle.priceEach} = ${detalle.quantityOrdered*detalle.priceEach} 
					</c:forEach>	
				</ul>
				<h1>${detallesPedido.getTotal()}</h1>
			</div>
		</div>
	</div>

</body>
</html>