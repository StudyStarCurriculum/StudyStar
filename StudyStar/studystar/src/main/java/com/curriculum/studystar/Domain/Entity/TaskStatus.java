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
@Table(name = "task_status")
public class TaskStatus {
    @Id
    @Column(nullable = false, name = "taskStatusId")
    private String taskStatusId;

    @Column(nullable = false, name = "studentId")
    private String studentId;

    @Column(nullable = false, name = "taskId")
    private String taskId;

    @Column(name = "submitTime")
    private String submitTime;

    @Column(name = "totalScore")
    private Integer totalScore;

    // 0:未完成  1:已完成未批改  3:已批改
    @Column(nullable = false, name = "status")
    private Integer status;
}
