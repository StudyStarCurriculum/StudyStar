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
@Table(name = "total_score")
public class TotalScore {
    @Id
    @Column(nullable = false, name = "totalScoreId")
    private String totalScoreId;

    @Column(nullable = false, name = "userId")
    private String userId;

    @Column(nullable = false, name = "taskId")
    private String taskId;

    @Column(name = "score")
    private Integer score;

    @Column(name = "state")
    private Integer state;
}
