package mapper;

import jakarta.servlet.http.HttpServletRequest;
import model.entities.User;

public class UserRequestMapper {
    public static User toEntity(HttpServletRequest req) {
        User user = new User();
        user.setFirstName(req.getParameter("first_name"));
        user.setLastName(req.getParameter("last_name"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setBirthDate(req.getParameter("birth_date"));
        return user;
    }
}
