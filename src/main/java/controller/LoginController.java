package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.entities.User;
import repository.UserDaoImpl;
import service.AuthenticationService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet{
    private AuthenticationService auth;

    @Override
    public void init() {
        UserDaoImpl DAO = new UserDaoImpl();
        this.auth = new AuthenticationService(DAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/profile-checkout");
            return;
        }

        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (!auth.validateLoginInput(email, password)) {
            sendError(req, resp, "Invalid input format.");
            return;
        }

        try {
            User found = this.auth.authenticationUser(email, password);

            if (found == null) {
                sendError(req, resp, "Invalid username or password.");
                return;
            }

            req.setAttribute("resp", "success");
            req.getSession(false);
            HttpSession session = req.getSession(true);

            found.setPasswordHash(null);
            session.setAttribute("user", found);
            resp.sendRedirect(req.getContextPath() + "/profile-checkout");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void sendError(HttpServletRequest req, HttpServletResponse resp, String msg) throws ServletException, IOException {
        req.setAttribute("resp", "rejected");
        req.setAttribute("message", msg);
        req.getRequestDispatcher("/views/auth/login.jsp").forward(req, resp);
    }

    }