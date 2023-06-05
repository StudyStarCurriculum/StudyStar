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
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "answerId")
    private Integer answerId;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "taskQuestionId")
    private Integer taskQuestionId;

    @Column(name = "myAnswer")
    private String myAnswer;

    @Column(name = "myScore")
    private Integer myScore;

    @Column(name = "state")
    private Integer state;

    @Column(name = "answerPath")
    private String answerPath;

}
