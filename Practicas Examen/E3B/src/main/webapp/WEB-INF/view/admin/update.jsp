<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../include/bootstrap.jsp"/>
</head>
<body>
<jsp:include page="../include/barra.jsp"/>
    <div class="container">

        <div class="m-5">
            <a href="DatosUsuario" class="btn btn-primary">Volver</a>
        </div>

        <div class="row justify-content-center mt-5">
            <div class="col-8">
                <form method="post">

                    <h2>MODIFICAR DATOS</h2>
                    <label for="productCode" class="form-label mt-3">Código</label>
                    <input value="${sessionScope.product.productCode}" type="text" class="form-control" id="productCode" name="productCode" required disabled>
                    <label for="productName" class="form-label mt-3">Nombre</label>
                    <input value="${sessionScope.product.productName}" type="text" class="form-control" id="productName" name="productName" required disabled>
                    <label for="productLine" class="form-label mt-3">Categoría</label>
                    <input value="${sessionScope.product.productLine}" type="text" class="form-control" id="productLine" name="productLine" required disabled>
                    <label for="quantityInStock" class="form-label mt-3">Stock</label>
                    <input value="${sessionScope.product.quantityInStock}" type="text" class="form-control" id="quantityInStock" name="quantityInStock" required>
                    <label for="buyPrice" class="form-label mt-3">Precio</label>
                    <input value="${sessionScope.product.buyPrice}" type="text" class="form-control" id="buyPrice" name="buyPrice" required>

                    <input type="submit" class="btn btn-primary w-100 mt-3" value="ACTUALIZAR DATOS" />
                </form>
            </div>
        </div>

    </div>
</body>
</html>