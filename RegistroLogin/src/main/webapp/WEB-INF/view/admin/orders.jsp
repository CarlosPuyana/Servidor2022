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


	<div class="container">

		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-stripped">
					<thead>
						<tr>
							<th>Número</th>
							<th>Fecha</th>
							<th>Fecha Envio</th>
							<th>Estado</th>
							<th>Acciones</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${pedidos}" var="pedido">
							<tr>
								<td>${pedido.orderNumber }</td>
								<td>${pedido.requiredDate }</td>
								<td>${pedido.shippedDate }</td>
								<td>${pedido.status }</td>
								<td><a href="Details?orderNumber=${pedido.orderNumber}"><i class="bi bi-eye"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>

	</div>

</body>
</html>