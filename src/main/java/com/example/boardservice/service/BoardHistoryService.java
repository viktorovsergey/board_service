package com.example.boardservice.service;

import com.example.boardservice.entity.BoardEntity;
import com.example.boardservice.entity.BoardHistoryEntity;
import com.example.boardservice.entity.BoardStatus;
import com.example.boardservice.repository.BoardHistoryRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BoardHistoryService {
    BoardHistoryRepository repository;

    /**
     * Получаем все записи статуса платы
     */
    public List<BoardHistoryEntity> getHistoryById(Long boardId) {
        return repository.findByBoard(boardId).stream().toList();
    }

    /**
     * Сохраняем запись статуса платы
     */
    public void saveHistory(BoardEntity board, BoardStatus boardStatus) {
        if(boardStatus == null) {
            throw new NullPointerException("Не допустимый статус");
        }

        if(board == null) {
            throw new NullPointerException("Не допустимая информация о плате");
        }

        BoardHistoryEntity historyEntity = new BoardHistoryEntity();
        historyEntity.setBoard(board.getId());
        historyEntity.setStatus(boardStatus);
        historyEntity.setTimestamp(LocalDateTime.now());

        repository.save(historyEntity);
    }
}