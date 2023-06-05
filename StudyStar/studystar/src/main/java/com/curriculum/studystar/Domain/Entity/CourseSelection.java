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
@Table(name = "course_selection")
public class CourseSelection {
    @Id
    @Column(nullable = false, name = "selectionId")
    private String selectionId;

    @Column(nullable = false, name = "studentId")
    private String studentId;

    @Column(nullable = false, name = "courseId")
    private String courseId;
    
}
