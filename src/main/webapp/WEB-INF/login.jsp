<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>

<body>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="/login" method="post">
            <h1>Sign in</h1><br>
            <span>${error}</span><br>
                <input type="text" placeholder="Enter Username" name="username" required><br>
                <input type="password" placeholder="Enter Password" name="password" required> <br>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>