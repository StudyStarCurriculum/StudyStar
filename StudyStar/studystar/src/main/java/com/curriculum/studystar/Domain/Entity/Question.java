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
@Table(name = "question")
public class Question {
    @Id
    @Column(nullable = false, name = "questionId")
    private String questionId;

    @Column(nullable = false,name = "questionType")
    private Integer questionType;

    @Column(nullable = false, name = "courseId")
    private String courseId;

    @Column(nullable = false, name = "score")
    private Integer score;

    @Column(name = "difficult")
    private Integer difficult;

    @Column(name = "description")
    private String description;
    
    @Column(name = "answer")
    private String answer;
    
    @Column(name = "analysis")
    private String analysis;

    @Column(name = "options")
    private String options;

    @Column(name = "questionFilePath")
    private String questionFilePath;

    @Column(name = "chapter")
    private String chapter;

}
