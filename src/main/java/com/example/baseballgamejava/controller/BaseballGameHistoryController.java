package com.example.baseballgamejava.controller;

import com.example.baseballgamejava.dto.baseballGameHistory.BaseballGameHistoryResponseDto;
import com.example.baseballgamejava.dto.common.ResponseDto;
import com.example.baseballgamejava.service.BaseballGameHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseballGameHistoryController {

    private final BaseballGameHistoryService baseballGameHistoryService;

    @GetMapping("/game/{baseballGameId}/history")
    public ResponseDto<BaseballGameHistoryResponseDto> getBaseballGameHistory(@PathVariable Long baseballGameId) {
        return ResponseDto.<BaseballGameHistoryResponseDto>builder()
                .success(true)
                .data(baseballGameHistoryService.getBaseballGameHistory(baseballGameId))
                .build();
    }
}
