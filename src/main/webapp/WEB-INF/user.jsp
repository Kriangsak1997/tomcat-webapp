<%@ page import="io.muzoo.ooc.webapp.basic.security.UserService" %>
<%@ page import="io.muzoo.ooc.webapp.basic.security.User" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

</head>
<body>

<ul>
    <li><a class="active" href="/">Home</a></li>
    <li><a href="/add_user">Add User</a></li>
    <li><a href="/logout">Logout</a></li>
</ul>

<h1>
    <p>${error}</p>
</h1>

<table id="usersTable">

    <tr>
        <th>username</th>
        <th>display_name</th>
        <th>action</th>
    </tr>
    <%
        UserService database=new UserService();
        List<User> userList =  database.getUsers();
        for (User u: userList){
            String username = u.getUsername();
            String display_name = u.getDisplay_name();
    %>
        <tr>
            <td><%=username%></td>
            <td><%=display_name%></td>
            <td>
                <div>
                    <form action="/edit" method="get">
                        <button type="submit" name="username" value="<%=username%>">edit</button>
                    </form>
                    <form id="delete-form" action="/delete" method="get">
                        <button type="submit" onclick="return confirm('Are you sure you want to delete this user?');" name="username" value="<%=username%>">delete</button>
                    </form>
                </div>
            </td>
        </tr>
    <%
        }
    %>

    <h2 style="text-align:center">current user profile</h2>
    <div class="card">
        <p>Username: ${currentUser.getUsername()}</p>
        <p>Display Name: ${currentUser.getDisplay_name()}</p>
    </div>

</table>



</body>
</html>