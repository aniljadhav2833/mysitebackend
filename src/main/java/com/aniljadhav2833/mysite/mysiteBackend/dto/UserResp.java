package com.aniljadhav2833.mysite.mysiteBackend.dto;

public class UserResp {

    private String userName;
    private String roleName;

    public UserResp() {


    }

    public UserResp(String userName, String roleName) {
        this.userName = userName;
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
