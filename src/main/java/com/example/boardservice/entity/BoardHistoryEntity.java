package com.example.boardservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "board_history", schema = "public")
public class BoardHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private BoardStatus status;

    @Column
    private LocalDateTime timestamp;

    @Column
    private Long board;
}