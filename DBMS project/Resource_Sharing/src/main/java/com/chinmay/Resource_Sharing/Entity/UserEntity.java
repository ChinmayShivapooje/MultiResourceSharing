package com.chinmay.Resource_Sharing.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "all_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id ;
 private    String name;
  private   String email;
  private   String password;
  // private Role role;
  private   String department;
  private String userRole;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }




    public UserEntity() {
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public UserEntity(Long id, String name, String email, String password, String department, String userRole) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
