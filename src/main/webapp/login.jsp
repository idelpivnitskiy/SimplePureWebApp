<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <section class="container">
            <div class="login">
                <h1>Login to studenst base</h1>
                <form method="post">
                    <c:if test="${error}">
                        <p style="color: red">"Wrong data, try again"</p>
                    </c:if>
                    <p><input type="text" name="login" placeholder="Username"></p>
                    <p><input type="password" name="password" placeholder="Password"></p>
                    <p class="submit"><input type="submit" name="commit" value="Login"></p>
                </form>
            </div>
        </section>
    </body>
</html>
