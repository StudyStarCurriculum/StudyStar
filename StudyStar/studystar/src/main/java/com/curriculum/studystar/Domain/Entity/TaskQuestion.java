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
@Table(name = "task_question")
public class TaskQuestion {
    @Id
    @Column(nullable = false, name = "taskQuestionId")
    private String taskQuestionId;

    @Column(nullable = false, name = "taskQusetionSetId")
    private String taskQuestionSetId;

    @Column(nullable = false, name = "questionId")
    private String questionId;

}
