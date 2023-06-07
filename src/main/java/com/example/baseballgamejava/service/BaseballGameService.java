package com.example.baseballgamejava.service;

import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.dto.baseballGame.BaseballGameStartResponseDto;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BaseballGameService {

    private final BaseballGameRepository baseballGameRepository;
    public BaseballGameStartResponseDto gameStart() {

        BaseballGame baseballGame = BaseballGame.builder()
                .build();

        BaseballGame savedBaseballGame = baseballGameRepository.save(baseballGame);

        return BaseballGameStartResponseDto.builder()
                .baseballGameId(savedBaseballGame.getBaseballGameId())
                .build();
    }
}
