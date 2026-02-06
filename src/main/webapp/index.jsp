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
<html>
<head>
    <title>Store-Project</title>
</head>
<body>
<ul>
    <%
        // findAll success = true
        // insert success = true
        // findBy success = true
        UserDaoImpl dao = new UserDaoImpl();
        user u = new user();
        u.setId(2);
        u.setFirstName("Laura Nathalia");
        u.setLastName("Padilla Castaño");
        u.setEmail("lauranathalia@gmail.com");
        u.setPasswordHash("$2a$10$hash_de_prueba_insert");
        u.setPhone("2001234567");
        u.setBirthDate("1999-08-15");
        u.setRegisterDate("2026-02-04 14:45:00");
        u.setLastLogin(null);
        u.setRoleId(3);
        u.setState(true);
        System.out.println(dao.update(u));
    %>
</ul>
</body>
</html>
