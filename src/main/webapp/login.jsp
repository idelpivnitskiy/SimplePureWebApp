<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
    </head>
    <body>
        <section class="container">
            <div class="login">
                <h1>Login to studenst base</h1>
                <form method="post" action="/login">
                    <p><input type="text" name="login" value="" placeholder="Username"></p>
                    <p><input type="password" name="password" value="" placeholder="Password"></p>
                    <p class="submit"><input type="submit" name="commit" value="Login"></p>
                </form>
            </div>
        </section>
    </body>
</html>
