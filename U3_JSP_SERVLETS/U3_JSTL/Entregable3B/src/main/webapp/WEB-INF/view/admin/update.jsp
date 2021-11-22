<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="../include/bootstrap.jsp"/>
<body>


<jsp:include page="../include/barra.jsp"/>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="productCode" class="form-label">productCode</label>
    				<input name="cn" value="${p.productCode}" type="text" class="form-control" id="productCode" disabled>
    				<label for="productCode" class="form-label">ProductName</label>
    				<input name="checkn" value="${p.productName}" type="text" class="form-control" id="productName" disable>
    				<label for="ProductLine" class="form-label">ProductLine</label>
    				<input name="productLine" value="${p.productLine}" type="text" class="form-control" id="productline">
    				<label for="ProductScale" class="form-label">ProductScale</label>
    				<input name="productScale" value="${p.productScale}" type="text" class="form-control" id="productScale">
    				<label for="ProductVendor" class="form-label">ProductVendor</label>
    				<input name="productVendor" value="${p.productVendor}" type="text" class="form-control" id="productVendor">
    				<label for="ProductDescription" class="form-label">ProductDescription</label>
    				<input name="productVendor" value="${p.productVendor}" type="text" class="form-control" id="productVendor">
    				<label for="ProductDescription" class="form-label">ProductDescription</label>
    				<input name="quantityInStock" value="${p.productScale}" type="text" class="form-control" id="productScale">
    				
    				
    				
    				
    				<input type="submit" value="Actualizar" class="btn btn-primary w-100 mt-5">
				</form>
			
			</div>
		</div>
		
	</div>
</body>
</html>