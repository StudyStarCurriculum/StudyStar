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
@Table(name = "log")
public class Log {
    @Id
    @Column(nullable = false, name = "logId")
    private String logId;

    @Column(name = "content")
    private String content;

    @Column(name = "createTime")
    private String createTime;

    @Column(nullable = false, name = "userId")
    private String userId;
}
