<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<nav class="navbar navbar-expand-lg navbar-light w-100" style="background-color: blue">
	  <div class="container-fluid">
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarText">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0 text-white">
	        <li class="nav-item">
	        	<a href="${pageContext.request.contextPath}/OfficesServlet" class="nav-link" active>
	        	<i onmouseover="this.style.color='navy';"
				onmouseout="this.style.color='yellowgreen';" class="bi bi-house-door-fill"
				style="color: yellowgreen"></i></a>
	        </li>
	        
	          <li class="nav-item">
	          	<a href="${pageContext.request.contextPath}/Categorias" class="nav-link text-white">Categorías</a>
	          </li>
	          
	          <li class="nav-item">
	          	<a href="${pageContext.request.contextPath}/Offices" class="nav-link text-white">Oficinas</a>
	          </li>
	          
	          <li class="nav-item">
	          	<a href="${pageContext.request.contextPath}/Customers" class="nav-link text-white">Clientes</a>
	          </li>
	        
	          <li class="nav-item">
	          	<a href="${pageContext.request.contextPath}/Payments" class="nav-link text-white">Pagos</a>
	          </li>
	        
	       </ul>
	    </div>
	  </div>
	</nav>