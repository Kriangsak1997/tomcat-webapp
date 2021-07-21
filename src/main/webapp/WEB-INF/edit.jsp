<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Edit Profile</title>
<body>
<p>
<form action="/edit" method="post">
    Password<input type="password" placeholder="Enter a new Password" name="password" value="" required ><br>

   Display_name <input type="text" placeholder="Enter your first name" name="firstName" value="${currentUser.getDisplay_name()}" ><br>

    <input type="hidden" name="username" value="${currentUser.getUsername()}" ><br>
    <button type="submit">submit</button>
</form>
</p>
</body>
</html>