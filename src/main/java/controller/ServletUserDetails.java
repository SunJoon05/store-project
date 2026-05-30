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

@WebServlet("/user-details")
public class ServletUserDetails extends HttpServlet {
    private UserService user_service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        UserRepo USER_DAO = new UserRepo();
        this.user_service = new UserService(USER_DAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer user_id = Integer.valueOf(req.getParameter("search"));

        User find = this.user_service.getUserById(user_id);

        find.setPasswordHash(null);

        req.setAttribute("id", find.getId());
        req.setAttribute("full_name", find.getFullName() == null ? "Name not provided" : find.getFullName());
        req.setAttribute("email", find.getEmail());
        req.setAttribute("phone", find.getPhone() == null ? "Phone not provided" : find.getPhone());
        req.setAttribute("birth_date", find.getBirthDate()  == null ? "Birth date not provided" : find.getBirthDate());
        req.setAttribute("register_date", find.getRegisterDate() == null ? "No access" : find.getLastLogin());
        req.setAttribute("last_login", find.getLastLogin() == null ? "No access" : find.getLastLogin());
        req.setAttribute("role", find.getRole().getTag());
        req.setAttribute("state", find.getState() == true ? "Active" : "Inactive");
        req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.users", "view.profile")).forward(req, resp);
    }
}
