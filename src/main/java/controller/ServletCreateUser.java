package controller;

import config.ApplicationConfiguration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.entities.User;
import repository.UserRepo;
import service.AuthenticationService;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create-user")
@MultipartConfig
public class ServletCreateUser extends HttpServlet {

    private UserService user_service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        UserRepo USER_DAO = new UserRepo();
        this.user_service = new UserService(USER_DAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // capturar los datos de la request para guardar el usuario en la bd
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phone_number = req.getParameter("phone_number");
        String birth_date = req.getParameter("birth_date");
        int role = Integer.parseInt(req.getParameter("role"));
        boolean state = req.getParameter("state") != null ? true : false;
        Part file_upload = req.getPart("profile_picture");

        // crear una instancia con los datos recolectados
        User new_user = new User();
        new_user.setFirstName(first_name);
        new_user.setLastName(last_name);
        new_user.setEmail(email);
        new_user.setPasswordHash(password);
        new_user.setPhone(phone_number);
        new_user.setBirthDate(birth_date);
        new_user.setRole(role);
        new_user.setState(state);
        new_user.setProfilePicture(null);

        // redireccionar a la tabla de usuarios
        resp.sendRedirect(ApplicationConfiguration.getPath("app.root", "servlet.check") + "?section=management");
    }
}
