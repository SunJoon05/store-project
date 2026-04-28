package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import mapper.UserRequestMapper;
import model.entities.User;
import repository.UserDaoImpl;
import service.UserService;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/update-user-data")
@MultipartConfig
public class UpdateUserData extends HttpServlet {
    private UserService user_service;

    @Override
    public void init(ServletConfig config) {
        UserDaoImpl DAO = new UserDaoImpl();
        this.user_service = new UserService(DAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        HashMap<String, Object> report;
        boolean success;
        User entity;

        User updated_data = UserRequestMapper.toEntity(req);
        Part file_part = req.getPart("profile_picture");

        try {
            report = this.user_service.processUserUpdate(updated_data, file_part, user.getId());

            success = (boolean) report.get("success");
            entity = (User) report.get("entity");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (success) {
            req.getSession().setAttribute("user", entity);
            resp.sendRedirect(req.getContextPath() + "/profile-checkout");
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
