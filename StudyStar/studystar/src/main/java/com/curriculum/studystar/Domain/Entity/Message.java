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
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "messageId")
    private Integer messageId;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(nullable = false, name = "receiverId")
    private Integer receiverId;

    @Column(nullable = false, name = "senderId")
    private Integer senderId;

    @Column(name = "sendTime")
    private String sendTime;

    @Column(nullable = false, name = "isRead")
    private Integer isRead;
}
