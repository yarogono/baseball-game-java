package com.example.baseballgamejava.controller;

import com.example.baseballgamejava.dto.baseballGame.BaseballGameStartResponseDto;
import com.example.baseballgamejava.dto.common.ResponseDto;
import com.example.baseballgamejava.service.BaseballGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseballGameController {

    private final BaseballGameService baseballGameService;

    @PostMapping("/game/start")
    public ResponseDto<BaseballGameStartResponseDto> gameStart() {

        return ResponseDto.<BaseballGameStartResponseDto>builder()
                .success(true)
                .data(baseballGameService.gameStart())
                .build();
    }
}
