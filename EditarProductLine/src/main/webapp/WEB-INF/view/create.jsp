<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="productLine" class="form-label">productLine</label>
    				<input name="productLine" type="text" class="form-control" id="productLine">
    				<c:if test="${requestScope.error != null}">
    					<p><small class="text-danger"> Categoria ya existente </small> </p>
    				</c:if>
    				<label for="textDescription" class="form-label">textDescription</label>
    				<textarea class="form-control" id="textDescription" name="textDescription">
    					<c:if test="${requestScope.error != null}">
    						<c:out value="${requestScope.textDescription}"></c:out>	
    					</c:if>
    				</textarea>
    				<label for="htmlDescription" class="form-label">htmlDescription</label>
    				<textarea class="form-control" id="htmlDescription" name="htmlDescription">
    					<c:if test="${requestScope.error != null}">
    						<c:out value="${requestScope.htmlDescription}"></c:out>	
    					</c:if>
    				</textarea>
    				<input type="submit" value="Insertar" class="btn btn-primary w-100 mt-5">
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>