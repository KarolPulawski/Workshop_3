package pl.coderslab.entity;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer user_group_id;

    public User(String username, String password, String email, Integer user_group_id) {
        this.username = username;
        setPassword(password);
        this.email = email;
        this.user_group_id = user_group_id;
    }

    public User() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser_group_id(Integer user_group_id) {
        this.user_group_id = user_group_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Integer getUser_group_id() {
        return user_group_id;
    }

    public String getPassword() {
        return password;
    }
}