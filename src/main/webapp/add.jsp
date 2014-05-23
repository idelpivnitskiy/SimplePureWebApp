<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new student</title>
        <style>
            label {
                margin-right: 20px;
                width: 100px;
                display: inline-block;
                text-align: right;
            }
        </style>
    </head>
    <body>
        <section class="container">
            <div class="add">
                <h1>Add new student to database</h1>
                <c:if test="${not empty msg}">
                    <p>${msg}</p>
                </c:if>
                <form method="post">
                    <p><label for="name">Student name</label>
                        <input id="name" type="text" name="name">
                    </p>
                    <p><label for="mark1">Mark 1</label>
                        <select id="mark1" name="mark1">
                            <c:forEach var="mark" items="${marks}" varStatus="status">
                                <option value="${status.index}">${mark}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p><label for="mark2">Mark 2</label>
                        <select id="mark2" name="mark2">
                            <c:forEach var="mark" items="${marks}" varStatus="status">
                                <option value="${status.index}">${mark}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p class="submit"><input type="submit" name="commit" value="Add"></p>
                </form>
            </div>
            <p>Go to <a href="/">list</a></p>
        </section>
    </body>
</html>
