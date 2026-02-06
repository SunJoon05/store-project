package model.entities;

public class user {
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

    public user(Integer id, String  first_name, String last_name, String email,  String password_hash, String phone, String birth_date, String register_date, String last_login, Integer role_id, Boolean state) {
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

    public user() {
    }

    // user methods

    // getters


    public Integer getId() { return id; }

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


    public void setId(int id) { this.id = id; }

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
