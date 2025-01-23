package com.aniljadhav2833.mysite.mysiteBackend.dto;

import org.springframework.http.MediaType;

public class DownloadFile {

    private String fileName;
    private byte[] data;

    private MediaType fileType;

    public DownloadFile() {
    }


    public DownloadFile(String fileName, byte[] data, MediaType fileType) {
        this.fileName = fileName;
        this.data = data;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public MediaType getFileType() {
        return fileType;
    }

    public void setFileType(MediaType fileType) {
        this.fileType = fileType;
    }
}
