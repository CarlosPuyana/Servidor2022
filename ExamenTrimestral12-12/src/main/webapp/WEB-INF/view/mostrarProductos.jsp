<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
<jsp:include page="include/bootstrap.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de PRODUCTS</title>
</head>
<body>

	<jsp:include page="include/barra.jsp" />
	<div class="container mt-5">


<c:if test="${requestScope.categoria!=null}">
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th><fmt:message key="nombre"/></th>
							<th><fmt:message key="desc"/></th>
							<th><fmt:message key="vendor"/></th>
							<th><fmt:message key="price"/></th>
							<th><fmt:message key="stock"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="p">
						
							<tr>
								<td>${p.productName}</td>
								<td>${p.productDescription}</td>
								<td>${p.productVendor}</td>
								<td>${p.buyPrice}</td>
								<td>${p.quantityInStock}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		</c:if>
		<c:if test="${requestScope.categoria eq null}">
		<p> Categoría NO SELECCIONADA </p>
		</c:if>
	</div>
</body>
</html>