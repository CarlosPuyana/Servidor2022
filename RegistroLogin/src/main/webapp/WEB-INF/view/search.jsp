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
	<jsp:include page="include/barra.jsp" />


	<form method="post">
		<div class="input-group">
			<input type="text" class="form-control rounded" placeholder="Search"
				name="search" id="search" />
			<!-- <input type="text" class="form-control rounded" placeholder="Search"
			aria-label="Search" aria-describedby="search-addon" name="search" id="search" /> -->

			<input type="submit" class="btn btn-outline-primary" value="Search" />

			<!-- <input type="submit" class="btn btn-outline-primary" value="Search"/>
	 -->
		</div>

	</form>
	<c:choose>
		<c:when test="${producto != null and producto.size()>0 }">

			<div class="row justify-content-center mt-4">
				<div class="col-10">
					<table class="table table-striped">
						<thead>
							<th>Nombre Producto</th>
							<th>Precio</th>
							<th>Ver+</th>
						</thead>

						<c:forEach items="${producto}" var="productos">
							<tr>
								<td>${productos.productName}</td>
								<td>${productos.buyPrice}$</td>
								<td><a href="Details?productName=${productos.productName}&productCode=${productos.productCode}"><i
										class="bi bi-eye-fill"></i></a></td>
								</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</c:when>

		<c:when test="${producto != null and producto.size() == 0 }">
			<p>No se encontraron resultados</p>
		</c:when>

		<c:otherwise>

		</c:otherwise>

	</c:choose>



</body>
</html>