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
@Table(name = "task")
public class Task {
    @Id
    @Column(nullable = false, name = "taskId")
    private String taskId;

    @Column(nullable = false, name = "courseId")
    private String courseId;

    @Column(nullable = false, name = "taskName")
    private String taskName;

    @Column(name = "description")
    private String description;

    @Column(nullable = false, name = "type")
    private Integer type;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "createTime")
    private String createTime;
}
