package com.example.baseballgamejava.dto.baseballGameHistory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseballGameHistoryResponseDto {
    private String answer;

    private List<BaseballGameResult> result;

    class BaseballGameResult {
        private int strike;

        private int ball;

        private int out;
    }
}
