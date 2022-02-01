<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Lista de Customers</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-10">
				<h1 class="bg-primary text-white text-center mb-5">Lista de Clientes</h1>
				<ul>
					<c:forEach items="${customers}" var="c">
						<li><a href="${pageContext.request.contextPath}/Orders?customerNumber=${c.customerNumber}">${c.customerName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>