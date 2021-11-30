<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>

<div class="container mt-5">
        <jsp:include page="include/barra.jsp" />

        <div class="row justify-content-center">
            <div class="col-10">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>employeeNumber</th>
                            <th>lastName</th>
                            <th>firstName</th>
                            <th>extension</th>
                            <th>email</th>
                            <th>officeCode</th>
                            <th>reportsTo</th>
                            <th>jobTitle</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="empl">
                            <tr>
                                <td>${empl.employeeNumber}</td>
                                <td>${empl.lastName}</td>
                                <td>${empl.firstName}</td>
                                <td>${empl.extension}</td>
                                <td>${empl.email}</td>
                                <td>${empl.officeCode}</td>
                                <td>${empl.reportsTo}</td>
                                <td>${empl.jobTitle}</td></tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>