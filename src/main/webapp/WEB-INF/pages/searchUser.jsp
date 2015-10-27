<%--
  Created by IntelliJ IDEA.
  User: Wajih Sid
  Date: 10/25/2015
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h4>User email:
  <p>${User.getEmail()}</p>
</h4>
<h4>
  User Name:
  <p>${User.getUsername()} </p>
</h4>

<h4>
  User Fav Language:
  <p>${User.getFavProgrammingLanguage()} </p>
</h4>

</body>
</html>
