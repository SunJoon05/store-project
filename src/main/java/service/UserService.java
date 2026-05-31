package service;

import jakarta.servlet.http.Part;
import model.entities.User;
import repository.UserRepo;
import util.Pagination;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class UserService {
    private final UserRepo DAO;
    private static final String PATH = "C:\\Users\\alexs\\OneDrive\\Escritorio\\Java\\store-project\\src\\main\\webapp\\assets\\images\\profiles";

    public UserService(UserRepo DAO) { this.DAO = DAO; }

    private String saveProfilePicture(Part file_uploaded, Integer id) throws IOException{
        String file_name = "";

        if (file_uploaded != null) {

            file_name = id + "_" + file_uploaded.getSubmittedFileName();

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

        System.out.println(file_name);
        return file_name;
    }

    public HashMap<String, Object> processUserUpdate(User latest, Part file, Integer id) throws SQLException {
        HashMap<String, Object> report = new HashMap<>();
        report.put("success", false);
        report.put("entity", null);

        System.out.println(file);

        try {
            latest.setProfilePicture(this.saveProfilePicture(file, id));
        } catch (IOException e) {
            e.printStackTrace();
        }

        User oldest = this.DAO.findByProperty("id", id);

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

    public HashMap<String, Object> processUserUpdate(User latest, Integer id) throws SQLException {

        HashMap<String, Object> report = new HashMap<>();
        report.put("success", false);
        report.put("entity", null);

        User oldest = this.DAO.findByProperty("id", id);

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

    public Pagination usersPagination(int offset) {

        Pagination users_pagination = null;

        try {
            List<User> content = DAO.findAllPaged(offset);
            long total_records = DAO.count();
            users_pagination = new Pagination(content, total_records, 1, 10);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return users_pagination;
    }

    public User getUserById(Integer user_id) {
        User find = null;

        try {
            find = this.DAO.findByProperty("id", user_id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return find;
    }

    public Boolean deleteUserById(Integer user_id) throws SQLException {
        return this.DAO.delete(user_id);
    }

    public boolean createUser(User entity) throws SQLException {
        boolean result = false;

        try {
            result = this.DAO.insert(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
