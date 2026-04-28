package model.entities;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class User {
    public final String DEFAULT_AVATAR = "default-avatar-profile.png";

    private Integer id;
    private String profile_picture;
    private String first_name;
    private String last_name;
    private String email;
    private String password_hash;
    private String phone;
    private String birth_date;
    private String register_date;
    private String last_login;
    private Role role;
    private Boolean state;

    public User(Integer id,String profile_picture, String first_name, String last_name, String email, String password_hash, String phone, String birth_date, String register_date, String last_login, int role, Boolean state) {
        this.id = id;
        this.profile_picture = profile_picture == null || profile_picture.isEmpty() ? DEFAULT_AVATAR : profile_picture;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password_hash = password_hash;
        this.phone = phone;
        this.birth_date = birth_date;
        this.register_date = register_date;
        this.last_login = last_login;
        this.role = Role.fromId(role);
        this.state = state;
    }

    public User(User other) {
        this.id = other.id;
        this.profile_picture = other.profile_picture;
        this.first_name = other.first_name;
        this.last_name = other.last_name;
        this.email = other.email;
        this.password_hash = other.password_hash;
        this.phone = other.phone;
        this.birth_date = other.birth_date;
        this.register_date = other.register_date;
        this.last_login = other.last_login;
        this.role = other.role;
        this.state = other.state;
    }

    public User() {
    }

    // getters

    public Integer getId() {
        return id;
    }

    public String getProfilePicture() { return this.profile_picture; }

    public String getFirstName() {
        return this.first_name;
    }

    public Boolean getState() {
        return this.state;
    }

    public Role getRole() {
        return this.role;
    }

    public String getLastLogin() {
        return this.last_login;
    }

    public String getBirthDate() {
        return this.birth_date;
    }

    public String getRegisterDate() {
        return this.register_date;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPasswordHash() {
        return this.password_hash;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLastName() {
        return this.last_name;
    }

    public String getFullName() {
        if (hasValue(this.first_name) || hasValue(this.last_name)) return null;

        return  this.first_name + " " + this.last_name;
    }

    public boolean hasValue(String value) {
        return (value == null || value.isEmpty());
    }

    public Integer getAge() {
        final double miliseconds_in_year = 3.1536E+10;
        Integer age = null;

        if (this.birth_date == null) return null;

        // capturar excepciones para evitar que el sistema se congele
        try {
            // formato de fechas
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // llevarlos a un formato en común
            LocalDate today_date = LocalDate.now();
            LocalDate birth_date = LocalDate.parse(this.birth_date, formatter); // formatear la fecha al formato solicitado

            ZoneId zone_id = ZoneId.systemDefault(); // id de la zona sea UTC o local
            // convertir a toInstant para obtener los milisegundos
            Instant instant_today = today_date.atStartOfDay(zone_id).toInstant();
            Instant instant_birth = birth_date.atStartOfDay(zone_id).toInstant();

            long today_miliseconds = instant_today.toEpochMilli();
            long birth_miliseconds = instant_birth.toEpochMilli();

            // obtener la diferencia entre fechas
            long age_in_miliseconds = today_miliseconds - birth_miliseconds;

            // validar que la fecha de nacimiento no sea mayor que la fecha actual
            if (age_in_miliseconds < 0) throw new IllegalArgumentException("The birth date cannot be later than the current date");

            age = to_years(age_in_miliseconds, miliseconds_in_year);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return age;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setProfilePicture(String profile_picture) {
        this.profile_picture = profile_picture == null || profile_picture.isEmpty() ? DEFAULT_AVATAR : profile_picture;
    }

    public void setFirstName(String first_name) {
        this.first_name = (first_name == null || first_name.isBlank()) ? null : first_name.trim();
    }

    public void setLastName(String last_name) {
        this.last_name = (last_name == null || last_name.isBlank()) ? null : last_name.trim();
    }

    public void setEmail(String email) {
        this.email = (email == null || email.isBlank()) ? null : email.trim();
    }

    public void setPasswordHash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setPhone(String phone) {
        this.phone = (phone == null || phone.isBlank()) ? null : phone.trim();
    }

    public void setBirthDate(String birth_date) {
        this.birth_date = (birth_date == null || birth_date.isBlank()) ? null : birth_date.trim();
    }

    public void setRegisterDate(String register_date) {
        this.register_date = register_date.trim();
    }

    public void setLastLogin(String last_login) {
        this.last_login = (last_login == null || last_login.isBlank()) ? null : last_login.trim();
    }

    public void setRole(int role) {
        this.role = Role.fromId(role);
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    // helpers
    public Integer to_years (long age, double year) {
        return (int) Math.floor(age / year);
    }

    public String toString() {
        return "User  { id="+ this.id +", " +
                "profile_picture="+ this.profile_picture + ", " +
                "first_name="+ this.first_name+", " +
                "last_name="+ this.last_name+", " +
                "email="+ this.email+ ", " +
                "password_hash="+ this.password_hash+", " +
                "phone="+ this.phone +", " +
                "birth_date="+ this.birth_date +", " +
                "register_date="+ this.register_date +", " +
                "last_login="+ this.last_login +", " +
                "role_id="+ this.role +", " +
                "state="+ this.state +"}";
    }
}
