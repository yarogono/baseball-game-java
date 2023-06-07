package com.example.baseballgamejava.service;

import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.dto.baseballGame.BaseballGameStartResponseDto;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class BaseballGameServiceTest {

    @InjectMocks
    private BaseballGameService baseballGameService;

    @Mock
    private BaseballGameRepository baseballGameRepository;

    @Test
    @DisplayName("게임 시작")
    public void 게임_시작() {
        // given
        BaseballGame baseballGame = BaseballGame.builder()
                .build();

        doReturn(baseballGame).when(baseballGameRepository).save(any(BaseballGame.class));

        // when
        BaseballGameStartResponseDto responseDto = baseballGameService.gameStart();

        // then
        assertEquals(responseDto.getBaseballGameId(), baseballGame.getBaseballGameId());
    }
}