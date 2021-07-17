<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }
        li {
            float: left;
        }
        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        li a:hover {
            background-color: #111;
        }
    </style>
    <%--    end navigation head css--%>

    <link rel="stylesheet" href="../../cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            /*max-width: 300px;*/
            width: 25%;
            margin: auto;
            text-align: center;
            /*font-family: arial;*/
        }
        .title {
            color: grey;
            font-size: 18px;
        }
        button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }
        a {
            text-decoration: none;
            font-size: 22px;
            color: black;
        }
        button:hover, a:hover {
            opacity: 0.7;
        }
    </style>
    <%--    end profile card css--%>

    <style>
        #usersTable {
            display: table;
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            /*border-collapse: collapse;*/
            width: 50%;
        }
        #usersTable td, #usersTable th {
        // add
        text-align: center;
            border: 1px solid #ddd;
            padding: 8px;
        }
        #usersTable tr:nth-child(even){background-color: #f2f2f2;}
        #usersTable tr:hover {background-color: #ddd;}
        #usersTable th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: justify-all;
            /*text-align: left;*/
            background-color: #4CAF50;
            color: white;
        }
    </style>
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
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.getUsername()}</td>
            <td>${u.getFirstName()}</td>
            <td>${u.getDisplay_name()}</td>
            <td>
                <div>
                    <form action="/edit" method="get">
                        <button type="submit" name="username" value="${u.getUsername()}">edit</button>
                    </form>
                    <form id="delete-form" action="/delete" method="get">
                        <button type="submit" onclick="return confirm('Confirm to delete this user?');" name="username" value="${u.getUsername()}">delete</button>
                    </form>
                </div>
            </td>
        </tr>
    </c:forEach>

    <h2 style="text-align:center">current user profile</h2>
    <div class="card">
        <p>Username: ${currentUser.getUsername()}</p>
        <p>Display_name: ${currentUser.getDisplay_name()}</p>
    </div>

</table>

</body>
</html>