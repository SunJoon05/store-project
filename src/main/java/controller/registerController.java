package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UserDaoImpl;
import service.AuthService;

import java.io.IOException;
import java.sql.SQLException;

// lanzar la respuesta adecuada en el setAtributte

@WebServlet("/register")
public class registerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/auth/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDaoImpl DAO = new UserDaoImpl();
        AuthService auth = new AuthService(DAO);

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm");

        boolean is_valid = auth.validateRegistrationInput(email, password, confirm_password);

        if (!is_valid) {
            req.setAttribute("resp", "ERROR");
            req.getRequestDispatcher("/views/auth/register.jsp").forward(req,resp);
            return;
        }

        try {
            auth.registerUser(email, password);
            req.setAttribute("resp", "SUCCESS");
            req.getRequestDispatcher("/views/auth/register.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
