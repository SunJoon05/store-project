package service;

import model.entities.User;
import org.mindrot.jbcrypt.BCrypt;
import repository.UserImplementation;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class AuthenticationService {

    private final UserImplementation DAO;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    public AuthenticationService(UserImplementation DAO) {
        this.DAO = DAO;
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
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
        if (email == null || (password == null || password.isEmpty())) return false;
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
    public Boolean registerUser(String email, String password) throws SQLException {
        User user = new User();
        user.setProfilePicture(null);
        user.setEmail(email);
        user.setPasswordHash(hashPassword(password));
        user.setRegisterDate(getLocalDateTime());
        return this.DAO.insert(user);
    }

    public User authenticationUser(String email, String password) throws SQLException {
        User current = this.DAO.findBy("email", email);

        if (current == null || !BCrypt.checkpw(password, current.getPasswordHash())) return null;

        String previous_login = current.getLastLogin() == null ? getLocalDateTime() : current.getLastLogin();
        current.setLastLogin(getLocalDateTime());
        this.DAO.update(current);

        current.setLastLogin(previous_login);

        return current;
    }
}
