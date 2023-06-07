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
@Table(name = "correction")
public class Correction {
    @Id
    @Column(nullable = false, name = "correctionId")
    private String correctionId;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "userId")
    private String userId;

    @Column(name = "questionId")
    private String questionId;

    @Column(name = "wrongAnswer")
    private String wrongAnswer;
}
