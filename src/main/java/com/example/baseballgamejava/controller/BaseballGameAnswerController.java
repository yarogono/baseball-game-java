package com.example.baseballgamejava.controller;

import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerRequestDto;
import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerResponseDto;
import com.example.baseballgamejava.dto.common.ResponseDto;
import com.example.baseballgamejava.service.BaseballGameAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BaseballGameAnswerController {

    private final BaseballGameAnswerService baseballGameAnswerService;

    @PostMapping("/game/{baseballGameId}/answer")
    public ResponseDto<BaseballGameAnswerResponseDto> getBaseballGameAnswer(@PathVariable Long baseballGameId,
                                                                            @RequestBody BaseballGameAnswerRequestDto requestDto) {

        return ResponseDto.<BaseballGameAnswerResponseDto>builder()
                .success(true)
                .data(baseballGameAnswerService.getBaseballGameAnswer(baseballGameId, requestDto))
                .build();
    }
}
