<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
    </head>
    <body>
        <section class="container">
            <h2>Hello!</h2>
            <c:if test="${sessionScope.auth == null}">
                <p><a href="/login">Login</a></p>
            </c:if>
            <c:if test="${sessionScope.auth != null}">
                <p><a href="/logout">Logout</a></p>
            </c:if>
        </section>
    </body>
</html>