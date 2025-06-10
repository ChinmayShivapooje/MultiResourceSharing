package com.chinmay.Resource_Sharing.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(
        name = "upload_data"
)
public class UploadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;
    private    String name;
    private   String email;
    private   String department;
    @Lob
  private   byte[] file;
    private String FileType;
    private LocalDateTime uploadTime;

    // Constructor
    public UploadEntity() {
        this.uploadTime = LocalDateTime.now(); // sets current time by default
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileType() {
        return FileType;
    }

    public void setFileType(String fileType) {
        FileType = fileType;
    }

    public LocalDateTime getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(LocalDateTime uploadTime) {
        this.uploadTime = uploadTime;
    }

    public UploadEntity(String name, String email, String department, byte[] file, String fileType, LocalDateTime uploadTime) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.file = file;
        FileType = fileType;
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "UploadEntity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", file=" + Arrays.toString(file) +
                ", FileType='" + FileType + '\'' +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
