package model.entities;

import java.util.Date;

public class user {
    private String first_name;
    private String last_name;
    private String email;
    private String password_hash;
    private String phone;
    private String birth_date;
    private String register_date;
    private String last_login;
    private String role;
    private Boolean state;

    public user() {
        this.first_name = null;
        this.last_name = null;
        this.email = null;
        this.password_hash = null;
        this.phone = null;
        this.birth_date = null;
        this.register_date = null;
        this.last_login = null;
        this.role = null;
        this.state = false;
    }

    // class methods

    // getters
    public String getFirstName() {
        return first_name;
    }

    public Boolean getState() {
        return state;
    }

    public String getRole() {
        return role;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
