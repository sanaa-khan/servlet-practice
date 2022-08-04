<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
</head>

<body>
    <%
        // get username of logged in user
        String name = request.getAttribute("name") != null ? request.getAttribute("name").toString() : null ;
    %>

    <c:set var="nm" value="<%=name %>"/>

    <c:choose>
        <c:when test="${(nm != null)}">
            <h1>Hello  <c:out value="${nm}"/></h1>
        </c:when>
    </c:choose>

    <h2>You are logged in!</h2>

    <form action="LogoutServlet">
        <input type="submit" value="Log Out">
    </form>
</body>
</html>
