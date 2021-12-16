<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Lista de Empleados</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h1 class="bg-primary text-white text-center mb-5">Lista de Oficinas</h1>
				<ul>
					<c:forEach items="${oficinas}" var="c">
						<li><a href="${pageContext.request.contextPath}/Empleados?ofi=${c.city}">${c.city}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>