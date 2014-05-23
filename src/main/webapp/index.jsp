<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
        <style>
            table {
                border-collapse: collapse;
                width: 400px;
            }
            thead {
                background-color: lightgrey;
            }
            table, th, td {
                border: 1px solid black;
                padding: 5px;
            }
            td {
                text-align: center;
            }
            tbody td:first-child {
                text-align: left;
            }
            thead th:first-child {
                width: 200px;
            }
        </style>
    </head>
    <body>
        <section class="container">
            <c:if test="${sessionScope.auth == null}">
                <p><a href="/login">Login</a></p>
            </c:if>
            <c:if test="${sessionScope.auth != null}">
                <p><a href="/logout">Logout</a></p>
            </c:if>

            <h2>Excellent students</h2>
            <table>
                <thead>
                    <tr>
                        <th>Student</th>
                        <th>Mark 1</th>
                        <th>Mark 2</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${excellentStudents}">
                        <tr>
                            <td>${student.name}</td>
                            <td>${student.mark1}</td>
                            <td>${student.mark2}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <h2>General students</h2>
            <table>
                <thead>
                <tr>
                    <th>Student</th>
                    <th>Mark 1</th>
                    <th>Mark 2</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${generalStudents}">
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.mark1}</td>
                        <td>${student.mark2}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <h2>Unsatisfactory students</h2>
            <table>
                <thead>
                <tr>
                    <th>Student</th>
                    <th>Mark 1</th>
                    <th>Mark 2</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${unsatisfactoryStudents}">
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