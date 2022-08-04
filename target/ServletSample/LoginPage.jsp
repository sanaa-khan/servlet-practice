<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Login Page</title>
</head>

<body>
<form action="LoginServlet">

    Please enter your username
    <input type="text" name="un"/><br>

    Please enter your password
    <input type="text" name="pw"/>

    <input type="submit" value="submit">

</form>

    <%
        // check error status (e.g. for incorrect credentials)
        String errStatus = request.getAttribute("errStatus") != null ? request.getAttribute("errStatus").toString() : null ;
    %>

    <c:set var="err" value="<%=errStatus %>"/>

    <c:choose>
        <c:when test="${(errStatus == 'invalid-credentials')}">
            <h2>Invalid Credentials!</h2>
        </c:when>
    </c:choose>

</body>
</html>
