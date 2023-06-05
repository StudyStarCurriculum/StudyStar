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
@Table(name = "answer")
public class Answer {
    @Id
    @Column(nullable = false, name = "answerId")
    private String answerId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "taskQuestionId")
    private String taskQuestionId;

    @Column(name = "myAnswer")
    private String myAnswer;

    @Column(name = "myScore")
    private Integer myScore;

    @Column(name = "state")
    private Integer state;

    @Column(name = "answerPath")
    private String answerPath;

}
