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

    private String saveProfilePicture(Part file_uploaded, Integer id) throws IOException{
        String file_name = "";

        if (file_uploaded != null) {

            file_name = id + "_" +file_uploaded.getSubmittedFileName();

            File folder = new File(PATH);
            if (!folder.exists()) {
                boolean mkdirs = folder.mkdirs();
            }

            String full_path = PATH + File.separator + file_name;
            File saved_file = new File(full_path);

            if (!saved_file.exists() || saved_file.length() != file_uploaded.getSize()) {
                file_uploaded.write(full_path);
            }
        }

        return file_name;
    }

    public HashMap<String, Object> processUserUpdate(User latest, Part file, Integer id) throws SQLException {
        HashMap<String, Object> report = new HashMap<>();
        report.put("success", false);
        report.put("entity", null);

        try {
            latest.setProfilePicture(this.saveProfilePicture(file, id));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
