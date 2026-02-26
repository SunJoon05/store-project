package service;


import model.entities.User;
import repository.UserDaoImpl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// este servicio se encarga de la autenticacion y seguridad
// la registrar un nuevo usuario en la aplicacion
public class AuthService {

    private final UserDaoImpl DAO;
    private final User user;
    private final String regex;

    public AuthService(UserDaoImpl DAO) {
        this.DAO = DAO;
        this.user = new User();
        this.regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    }

    // verificar los datos ingresados
    public Boolean checkCredentials(String email, String password, String confirmPassword) {
        if (email == null || password == null || confirmPassword == null) return false;

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches() && password.equals(confirmPassword);
    }

    // hacer la contraseña mas seguro hasheandola
    public String toHash(String password) {


        return password;
    }

    // paso final, primero debe pasar por una validacion de los datos que se estan ingresando
    public void registerCredentials(String email, String password) throws SQLException {
        this.user.setEmail(email);
        this.user.setPasswordHash(password);
        this.DAO.insert(this.user);
    }
}
