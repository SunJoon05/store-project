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
<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/main.css?v=2">
    <title>Store-Project</title>
</head>
<body>
<%@ include file="includes/header.jsp" %>
<%@ include file="includes/homePage.jsp" %>

<%
        user u = new user();
        u.setBirthDate("2006-03-05");
        System.out.println("Edad calculada: " + u.getAge());
%>

<script src="assets/js/homePage-carousel.js"></script>
</body>
</html>
