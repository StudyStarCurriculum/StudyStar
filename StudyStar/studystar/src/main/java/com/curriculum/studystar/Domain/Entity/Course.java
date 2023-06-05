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
@Table(name = "course")
public class Course {
    @Id
    @Column(nullable = false, name = "courseId")
    private String courseId;

    @Column(nullable = false, name = "courseKey")
    private String courseKey;

    @Column(nullable = false, name = "courseName")
    private String courseName;

    @Column(nullable = false, name = "teacherId")
    private String teacherId;

    @Column(name = "coureImagePath")
    private String courseImagePath;

    @Column(name = "courseLevel")
    private Integer courseLevel;
}
