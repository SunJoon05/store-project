package model.entities;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class User {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String password_hash;
    private String phone;
    private String birth_date;
    private String register_date;
    private String last_login;
    private Integer role_id;
    private Boolean state;

    public User(Integer id, String first_name, String last_name, String email, String password_hash, String phone, String birth_date, String register_date, String last_login, Integer role_id, Boolean state) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password_hash = password_hash;
        this.phone = phone;
        this.birth_date = birth_date;
        this.register_date = register_date;
        this.last_login = last_login;
        this.role_id = role_id;
        this.state = state;
    }

    public User(User other) {
        this.id = other.id;
        this.first_name = other.first_name;
        this.last_name = other.last_name;
        this.email = other.email;
        this.password_hash = other.password_hash;
        this.phone = other.phone;
        this.birth_date = other.birth_date;
        this.register_date = other.register_date;
        this.last_login = other.last_login;
        this.role_id = other.role_id;
        this.state = other.state;
    }

    public User() {
    }

    // user methods
    public Integer getAge() {
        final double miliseconds_in_year = 3.1536E+10;
        Integer age = 0;

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

            // validar que la fecha de nacimiento no sea mayor que la fecha actual al dia de hoy
            if (age_in_miliseconds < 0) throw new IllegalArgumentException("The birth date cannot be later than the current date");

            age = to_years(age_in_miliseconds, miliseconds_in_year);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return age;
    }

    // getters

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public Boolean getState() {
        return state;
    }

    public Integer getRoleId() {
        return role_id;
    }

    public String getLastLogin() {
        return last_login;
    }

    public String getBirthDate() {
        return birth_date;
    }

    public String getRegisterDate() {
        return register_date;
    }

    public String getPhone() {
        return phone;
    }

    public String getPasswordHash() {
        return password_hash;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return last_name;
    }

    // setters


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String password_hash) {
        this.password_hash = password_hash;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setRegisterDate(String register_date) {
        this.register_date = register_date;
    }

    public void setLastLogin(String last_login) {
        this.last_login = last_login;
    }

    public void setRoleId(int role_id) {
        this.role_id = role_id;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    // helpers
    public Integer to_years (long age, double year) {
        return (int) Math.floor(age / year);
    }

    public String toString() {
        return "User  { id="+ id +", " +
                "first_name="+first_name+", " +
                "last_name="+last_name+", " +
                "email="+email+", " +
                "password_hash="+password_hash+", " +
                "phone="+phone+", " +
                "birth_date="+birth_date+", " +
                "register_date="+register_date+", " +
                "last_login="+last_login+", " +
                "role_id="+role_id+", " +
                "state="+state+"}";
    }
}
