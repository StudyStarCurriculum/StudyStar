package com.curriculum.studystar.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(nullable = false, name = "userId")
    private String userId;

    @Column(nullable = false, name = "userName")
    private String userName;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(name = "realName")
    private String realName;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "userLevel")
    private Integer userLevel;

    @Column(name = "phone")
    private String phone;

    @Column(nullable = false, name = "role")
    private Integer role;

    @Column(name = "userImagePath")
    private String userImagePath;
}
