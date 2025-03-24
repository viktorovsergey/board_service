package com.example.boardservice.dto;

import com.example.boardservice.entity.BoardStatus;

import java.util.List;

public class BoardResponse {
    private Long id;
    private String boardName;
    private String serialNumber;
    private BoardStatus boardStatus;
    private List<BoardHistoryResponse> history;
}
