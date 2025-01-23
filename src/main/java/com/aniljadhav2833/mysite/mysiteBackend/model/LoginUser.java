package com.aniljadhav2833.mysite.mysiteBackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    @Column(unique = true, nullable = false, updatable = false )
    private String userName;
    @Column(nullable = false )
    private String password;

    private String roleName;

    public LoginUser() {
    }

    public LoginUser(int userId, String userName, String userPassword, String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.password = userPassword;
        this.roleName = roleName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
