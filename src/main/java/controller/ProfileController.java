package controller;

import config.ApplicationConfiguration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entities.User;

import java.io.IOException;

@WebServlet("/data-preparation")
public class ProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/views/auth/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        String incomplete = "incomplete profile";
        req.setAttribute("first_name", user.getFirstName() == null ? incomplete : user.getFirstName());
        req.setAttribute("last_name", user.getLastName() == null ? incomplete : user.getLastName());
        req.setAttribute("full_name", user.getFullName() == null ?  incomplete :  user.getFullName());
        req.setAttribute("email", user.getEmail() == null ? incomplete : user.getEmail());
        req.setAttribute("role", user.getRole().getTag());
        req.setAttribute("state", user.getState() ? "Active" : "Inactive");
        req.setAttribute("last_login", user.getLastLogin());
        req.setAttribute("register_date", user.getRegisterDate());
        req.setAttribute("profile_picture", req.getContextPath() + "/assets/images/profiles/" + user.getProfilePicture());
        req.setAttribute("age", user.getAge() == null ? incomplete : user.getAge());
        req.getRequestDispatcher(ApplicationConfiguration.getPath( "dir.views", "dir.users", "view.profile")).forward(req, resp);
    }
}
