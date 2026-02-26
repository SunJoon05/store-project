package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.entities.User;
import repository.UserDaoImpl;
import service.AuthService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class loginController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDaoImpl DAO = new UserDaoImpl();
        AuthService auth = new AuthService(DAO);

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        boolean is_valid = auth.validateLoginInput(email, password);

        if (!is_valid) {
            req.setAttribute("error", "ERROR");
            System.out.println("ERROR");
            return;
        }

        try {
            User found = auth.authenticationUser(email, password);
            req.setAttribute("User", found);
            System.out.println(found);
            // determinar la vista a mostrar con un servicio de la  clase autenticacion

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }