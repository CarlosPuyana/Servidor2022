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
<body>
	<jsp:include page="include/bootstrap.jsp" />
	<div class="m-5">
		<a href="Search" class="btn btn-primary">Volver</a>
	</div>

	<div class="row justify-content-center mt-4">
		<div class="col-10">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ProductCode</th>
						<th>Nombre del Producto</th>
						<th>Categoria</th>
						<th>Vendedor</th>
						<th>Descripcion</th>
						<th>Stock</th>
						<th>Precio</th>
						<th>MSRP</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${producto}" var="productos">
						<tr>
							<td>${productos.productCode}</td>
							<td>${productos.productName}</td>
							<td>${productos.productLine}</td>
							<td>${productos.productVendor}</td>
							<td>${productos.productDescription}</td>
							<td>${productos.quantityInStock}</td>
							<td>${productos.buyPrice}$</td>
							<td>${productos.MSRP}$</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<form action="" method="POST">
				<input type="submit" class="btn btn-primary w-100 mt-3"
					value="AÑADIR A LA CESTA" />
			</form>

		</div>



	</div>

</body>
</html>