package service;

import jakarta.servlet.http.Part;
import model.entities.User;
import repository.UserDaoImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;

public class UserService {
    private final UserDaoImpl DAO;
    private static final String PATH = "C:\\Users\\alexs\\OneDrive\\Escritorio\\Java\\store-project\\src\\main\\webapp\\assets\\images\\profiles";

    public UserService(UserDaoImpl DAO) { this.DAO = DAO; }

    public String saveProfilePicture(Part file_uploaded, Integer id, String first_name) throws IOException {
        String file_name = "";

        if (file_uploaded != null) {

            file_name = id + "_" + first_name + "_" +file_uploaded.getSubmittedFileName();

            File folder = new File(PATH);
            if (!folder.exists()) folder.mkdirs();

            String full_path = PATH + File.separator + file_name;
            File saved_file = new File(full_path);

            if (!saved_file.exists() || saved_file.length() != file_uploaded.getSize()) {
                file_uploaded.write(full_path);
            }
        }

        return file_name;
    }

    public HashMap<String, Object> updateUserInformation(User latest, Integer id) throws SQLException {
        HashMap<String, Object> report = new HashMap<>();
        report.put("success", false);
        report.put("entity", null);

        User oldest = this.DAO.findBy("id", id);

        if (oldest == null) return report;

        for (Field field: oldest.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object new_value = field.get(latest);
                if (new_value != null) {
                    field.set(oldest, new_value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (this.DAO.update(oldest)) {
            report.put("success", true);
            report.put("entity", oldest);
        }

        return report;
    }
}
