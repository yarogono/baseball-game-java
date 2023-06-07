package com.example.baseballgamejava.service;

import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerRequestDto;
import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerResponseDto;
import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseballGameAnswerService {

    private final BaseballGameRepository baseballGameRepository;

    public BaseballGameAnswerResponseDto getBaseballGameAnswer(Long baseballGameId,
                                                               BaseballGameAnswerRequestDto requestDto) {

        BaseballGame baseballGame = getBaseballGameIfExists(baseballGameId);

        String answer = requestDto.getAnswer();

        // guessNumber 검증 로직 시작
        int[] answerArray = answer.chars().map(c -> c-'0').toArray();
        int[] guessAnswerArray = Integer.toString(guessNumberGenerator()).chars().map(c -> c-'0').toArray();

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

        return BaseballGameAnswerResponseDto.builder()
                .correct()
                .remainingCount()
                .strike(strikeCount)
                .ball(ballCount)
                .out()
                .build();
    }

    // ToDo: guessNumber 로직을 baseballGame 내부로 변경
    private int guessNumberGenerator() {
        List<Integer> randomNumbers = new Random()
                .ints(1, 9)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
        int sum = 0;
        for (int j = 0; j < randomNumbers.size(); j++) {
            sum += randomNumbers.get(j) * (Math.pow(10, randomNumbers.size() - j - 1));
        }
        return sum;
    }

    private BaseballGame getBaseballGameIfExists(Long baseballGameId) {
        return baseballGameRepository.findById(baseballGameId)
                .orElseThrow(
                );
    }
}
