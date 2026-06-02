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
import service.UserService;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet("/user-edit")
@MultipartConfig
public class ServletUserEdit extends HttpServlet {

    public UserService user_service;

    @Override
    public void init(ServletConfig config) {
        UserRepo USER_DAO = new UserRepo();
        this.user_service = new UserService(USER_DAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer user_id = Integer.valueOf(req.getParameter("modify"));
        User find = this.user_service.getUserById(user_id);

        find.setPasswordHash(null);

        // Si el dato es null, simplemente no se pone nada en el value
        // El placeholder del JSP se encarga de comunicar la ausencia
        req.setAttribute("id",            find.getId());
        req.setAttribute("first_name",    find.getFirstName());
        req.setAttribute("last_name",     find.getLastName());
        req.setAttribute("email",         find.getEmail());
        req.setAttribute("phone",         find.getPhone());
        req.setAttribute("birth_date",    find.getBirthDate());
        req.setAttribute("register_date", find.getRegisterDate());
        req.setAttribute("last_login",    find.getLastLogin());
        req.setAttribute("role",          find.getRole().getTag());
        req.setAttribute("state",         find.getState() ? "Active" : "Inactive");
        req.setAttribute("profile_picture", ApplicationConfiguration.getPath("app.root", "dir.assets", "dir.images", "dir.profiles") + File.separator +  find.getProfilePicture());

        req.getRequestDispatcher(ApplicationConfiguration.getPath("dir.views", "dir.users", "view.profile")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> report;
        User updated_data = new User();

        boolean success = false;
        User entity = new User();

        // extraer el id del usuario desde la request
        Integer user_id = Integer.valueOf(req.getParameter("id"));

        // capturar los datos desde la request y asignarlos a un objeto actualizado
        updated_data.setFirstName(req.getParameter("first_name"));
        updated_data.setLastName(req.getParameter("last_name"));
        updated_data.setEmail(req.getParameter("email"));
        updated_data.setPhone(req.getParameter("phone_number"));
        updated_data.setBirthDate(req.getParameter("birth_date"));
        updated_data.setRole(Integer.parseInt(req.getParameter("role")));
        updated_data.setState(req.getParameter("state") != null ? true : false);

        // foto de perfil actualizada
        Part file_part = req.getPart("profile_picture");

        try {
            report = this.user_service.processUserUpdate(updated_data, file_part, user_id);

            success = (boolean) report.get("success");
            entity = (User) report.get("entity");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        if (success) {
            resp.sendRedirect(ApplicationConfiguration.getPath("app.root", "servlet.check") + "?section=management");
        }
    }
}
