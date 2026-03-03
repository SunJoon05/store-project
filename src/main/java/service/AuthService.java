package service;


import model.entities.User;
import org.mindrot.jbcrypt.BCrypt;
import repository.UserDaoImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// este servicio se encarga de la autenticacion y seguridad
// la registrar un nuevo usuario en la aplicacion
public class AuthService {

    private final UserDaoImpl DAO;
    private final String regex;

    public AuthService(UserDaoImpl DAO) {
        this.DAO = DAO;
        this.regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean matchesPassword(String password, String confirm_password) {
        return password.equals(confirm_password);
    }

    /**
     * function => hace una verificacion de las credenciales ingresadas por el usuario
     * comparandolos con un patron definito como regex.
     * params => (String email, String password, String confirm_password)
     * returns: Boolean => la funcion retorna false si no cumple la verificación de credenciales
     * */
    public Boolean validateRegistrationInput(String email, String password, String confirm_password) {
        if (email == null || password == null || confirm_password == null) return false;
        return matchesPassword(password, confirm_password) && isValidEmail(email);
    }

    public Boolean validateLoginInput(String email, String password) {
        if (email == null || password == null) return false;
        return isValidEmail(email);
    }

    /**
     * function => se encarga de hashear la contraseña antes de guardarla
     * en la base de datos con la dependencia {@link BCrypt}
     * */
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    private String getLocalDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * function => este metodo se encarga de recibir las credenciales y insertar
     * una nueva cuenta con el DAO que recibimos del servlet.
     * params => (String email, String password)
     * */
    public void registerUser(String email, String password) throws SQLException {
        User user = new User();
        user.setEmail(email);
        user.setPasswordHash(hashPassword(password));
        user.setRegisterDate(getLocalDateTime());
        this.DAO.insert(user);
    }

    public User authenticationUser(String email, String password) throws SQLException {
        User found_user = this.DAO.findBy("email", email);

        if (!BCrypt.checkpw(password, found_user.getPasswordHash())) return null;
        if (found_user.getLastLogin() == null) found_user.setLastLogin(getLocalDateTime()); // si nunca ha iniciado sesión se crea si primer registro

        User update_user = new User(found_user);
        update_user.setLastLogin(getLocalDateTime());
        System.out.println(this.DAO.update(update_user));
        return found_user;
    }

}
