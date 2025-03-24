package com.example.boardservice.dto;

import com.example.boardservice.entity.BoardStatus;
import lombok.Data;

@Data
public class BoardRequest {
    private String boardName;
    private String serialNumber;
    private BoardStatus boardStatus;
}