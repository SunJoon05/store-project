package controller;

import config.ApplicationConfiguration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.entities.User;
import repository.UserRepo;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/user-delete")
public class ServletUserDelete extends HttpServlet {
    private UserService auth_service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        UserRepo USER_DAO = new UserRepo();
        this.auth_service = new UserService(USER_DAO);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // actualización del usuario
        HashMap<String, Object> report;
        Integer user_id = Integer.valueOf(req.getParameter("delete"));
        User find = this.auth_service.getUserById(user_id);
        find.setState(false);

        // atributos del hash map
        boolean success;
        User entity;

        try {

            report = this.auth_service.processUserUpdate(find, user_id);
            success = (boolean) report.get("success");
            entity = (User) report.get("entity");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(ApplicationConfiguration.getPath("app.root", "dir.views", "dir.users", "view.profile") + "?section=management");
    }
}
