package com.example.baseballgamejava.dto.baseballGameAnswer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseballGameAnswerResponseDto {

    private boolean correct;

    private int remainingCount;

    private int strike;

    private int ball;

    private int out;
}
