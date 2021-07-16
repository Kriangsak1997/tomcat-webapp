
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Edit Profile</title>
<body>
<p>
<form action="/edit" method="post">
    Password<input type="password" placeholder="Enter a new Password" name="password" value="" required ><br>
    Email<input type="text" placeholder="Enter a new email" name="email" value="${currentUser.getEmail()}" ><br>
    First Name<input type="text" placeholder="Enter your first name" name="firstName" value="${currentUser.getFirstName()}" ><br>
    Last Name<input type="text" placeholder="Enter your last name" name="lastName" value="${currentUser.getLastName()}" ><br>
    <input type="hidden" name="username" value="${currentUser.getUsername()}" ><br>
    <button type="submit">submit</button>
</form>
</p>
</body>
</html>