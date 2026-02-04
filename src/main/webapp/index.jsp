<%--
  Created by IntelliJ IDEA.
  User: alexs
  Date: 4/02/2026
  Time: 1:15 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page import="repository.UserDaoImpl" %>
<%@page import="model.entities.user" %>
<%@page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Store-Project</title>
</head>
<body>
<ul>
    <%
        user u = new user();
        UserDaoImpl dao = new UserDaoImpl();
        List<user> list = dao.findAll();
    %>
</ul>
</body>
</html>
