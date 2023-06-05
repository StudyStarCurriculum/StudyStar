package com.curriculum.studystar.Domain.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "taskQuestionId")
    private Integer taskQuestionId;

    @Column(nullable = false, name = "taskQusetionSetId")
    private Integer taskQuestionSetId;

    @Column(nullable = false, name = "questionId")
    private Integer questionId;

    @Column(name = "score")
    private Integer score;
}
