package com.example.baseballgamejava.service;

import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.dto.baseballGame.BaseballGameStartResponseDto;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;
    public BaseballGameStartResponseDto gameStart() {

        int guessNumber = guessNumberGenerator();

        BaseballGame baseballGame = BaseballGame.builder()
                .guessNumber(guessNumber)
                .build();

        BaseballGame savedBaseballGame = baseballGameRepository.save(baseballGame);

        return BaseballGameStartResponseDto.builder()
                .baseballGameId(savedBaseballGame.getBaseballGameId())
                .build();
    }

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
}
