package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.entities.User;
import repository.UserDaoImpl;
import service.UserService;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Parameter;
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

        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String phone_number = req.getParameter("phone_number");
        Part file_uploaded = req.getPart("profile_picture");
        String birth_date = req.getParameter("birth_date");

        User user_update = new User();
        user_update.setFirstName(first_name);
        user_update.setLastName(last_name);
        user_update.setEmail(email);
        user_update.setPhone(phone_number);
        user_update.setBirthDate(birth_date);

        if (file_uploaded != null && file_uploaded.getSize() > 0) {
            String file_name = this.user_service.saveProfilePicture(file_uploaded, user.getId(), user.getFirstName());
            user_update.setProfilePicture(file_name);
        }

        HashMap<String, Object> report;
        boolean success;
        User entity;

        try {
            report = this.user_service.updateUserInformation(user_update, user.getId());

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
