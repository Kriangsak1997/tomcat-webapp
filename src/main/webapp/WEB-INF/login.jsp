<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Home Page</title>
<body>
<div class="container" id="container">
    <div class="form-container sign-in-container">
        <form action="/login" method="post">
            <h1>Log in</h1>
            <span>${error}</span>
            <%--            <span>or use your account</span>--%>
            <input type="text" placeholder="Enter Username" name="username" required>
            <input type="password" placeholder="Enter Password" name="password" required>
            <a href="#">Forgot your password?</a>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>
</html>