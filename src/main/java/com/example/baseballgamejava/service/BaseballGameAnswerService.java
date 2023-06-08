package com.example.baseballgamejava.service;

import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerRequestDto;
import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerResponseDto;
import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseballGameAnswerService {

    private final BaseballGameRepository baseballGameRepository;

    public BaseballGameAnswerResponseDto getBaseballGameAnswer(Long baseballGameId,
                                                               BaseballGameAnswerRequestDto requestDto) {

        BaseballGame baseballGame = getBaseballGameIfExists(baseballGameId);
        int guessNumber = baseballGame.getGuessNumber();

        String answer = requestDto.getAnswer();

        // guessNumber 검증 로직 시작
        int[] answerArray = answer.chars().map(c -> c-'0').toArray();
        int[] guessAnswerArray = Integer.toString(guessNumber).chars().map(c -> c-'0').toArray();

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < answerArray.length; i++) {
            for (int j = 0; j < guessAnswerArray.length; j++) {
                if (answerArray[i] == guessAnswerArray[j]) {
                    if (i == j) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }
            }
        }

        int out = 3 - (strikeCount + ballCount);
        int maxInning = baseballGame.getBaseballMaxInning();
        int currentInning = baseballGame.getBaseballCurrentInning() + 1;
        int remainingCount = maxInning - currentInning;



        return BaseballGameAnswerResponseDto.builder()
                .correct(true)
                .remainingCount(remainingCount)
                .strike(strikeCount)
                .ball(ballCount)
                .out(out)
                .build();
    }

    private BaseballGame getBaseballGameIfExists(Long baseballGameId) {
        return baseballGameRepository.findById(baseballGameId)
                .orElseThrow(
                );
    }
}
