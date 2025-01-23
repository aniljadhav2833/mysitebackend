package com.aniljadhav2833.mysite.mysiteBackend.dto;

public class UserDTO {

    private int userId;

    private String userName;
    private String password;

    private String roleName;


    public UserDTO() {
    }

    public UserDTO(int userId, String userName, String password, String roleName) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
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
