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
@Table(name = "total_score")
public class TotalScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "totalScoreId")
    private Integer totalScoreId;

    @Column(nullable = false, name = "userId")
    private Integer userId;

    @Column(nullable = false, name = "taskId")
    private Integer taskId;

    @Column(name = "score")
    private Integer score;

    @Column(name = "state")
    private Integer state;
}
