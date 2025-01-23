package com.aniljadhav2833.mysite.mysiteBackend.dto;

public class ProjectDTO {

    private int projectid;
    private String projectName;
    private String projectDesc;

    private String projectPath;
    private String projectPhoto;

    public ProjectDTO() {
    }

    public ProjectDTO(int projectid, String projectName, String projectDesc, String projectPath, String projectPhoto) {
        this.projectid = projectid;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectPath = projectPath;
        this.projectPhoto = projectPhoto;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getProjectPhoto() {
        return projectPhoto;
    }

    public void setProjectPhoto(String projectPhoto) {
        this.projectPhoto = projectPhoto;
    }
}
