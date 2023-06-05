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
@Table(name = "task_question_set")
public class TaskQuestionSet {
    @Id
    @Column(nullable = false, name = "taskQuestionSetId")
    private String taskQuestionSetId;

    @Column(nullable = false, name = "taskId")
    private String taskId;

    @Column(nullable = false, name = "title")
    private String title;

}
