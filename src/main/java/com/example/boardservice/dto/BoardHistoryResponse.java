package com.example.boardservice.dto;


import com.example.boardservice.entity.BoardStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardHistoryResponse {
    private BoardStatus status;
    private LocalDateTime timestamp;
}
