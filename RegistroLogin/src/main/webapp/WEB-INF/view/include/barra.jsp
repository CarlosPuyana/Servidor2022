<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="bootstrap.jsp" />
<c:if test="${sessionScope.usuario!=null}">
	<div class="row justify-content-end" >
		<div class="col-12 text-end">
			<p class="bg-primary text-white p-2"><a class="link-dark" href="Profile?user=${sessionScope.usuario}"><i class="bi bi-person"></i><c:out value="${sessionScope.usuario}" /></a>
				<a class="text-white" href="${pageContext.request.contextPath}/LogOut"><i class="bi bi-box-arrow-left"></i></a>
			</p>
		</div>	
	</div> 

</c:if>
