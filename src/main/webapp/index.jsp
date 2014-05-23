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
            <table border="1px">
                <thead>
                    <tr>
                        <th>Student</th>
                        <th>Mark 1</th>
                        <th>Mark 2</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${students}">
                        <tr>
                            <td>${student.name}</td>
                            <td>${student.mark1}</td>
                            <td>${student.mark2}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </body>
</html>