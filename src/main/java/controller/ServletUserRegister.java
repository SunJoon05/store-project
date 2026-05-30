package controller;

import config.ApplicationConfiguration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UserRepo;
import service.AuthenticationService;

import java.io.IOException;
import java.sql.SQLException;

// lanzar la respuesta adecuada en el setAtributte

@WebServlet("/register")
public class ServletUserRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.auth", "view.register")).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserRepo USER_DAO = new UserRepo();
        AuthenticationService authentication_service = new AuthenticationService(USER_DAO);

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm");

        boolean is_valid = authentication_service.validateRegistrationInput(email, password, confirm_password);

        if (!is_valid) {
            req.setAttribute("resp", "rejected");
            req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.auth", "view.register")).forward(req,resp);
            return;
        }

        try {

            if (authentication_service.registerUser(email, password)) {
                req.setAttribute("resp", "success");
            } else {
                req.setAttribute("resp", "rejected");
            }

            req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.auth", "view.register")).forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
