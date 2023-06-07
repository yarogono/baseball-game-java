package com.example.baseballgamejava.service;

import com.example.baseballgamejava.constants.BaseballGameState;
import com.example.baseballgamejava.model.BaseballGame;
import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerRequestDto;
import com.example.baseballgamejava.dto.baseballGameAnswer.BaseballGameAnswerResponseDto;
import com.example.baseballgamejava.repository.BaseballGameRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class BaseballGameAnswerServiceTest {

    @InjectMocks
    private BaseballGameAnswerService baseballGameAnswerService;

    @Mock
    private BaseballGameRepository baseballGameRepository;

    @Test
    @DisplayName("게임 진행")
    public void 게임_진행() {
        // given
        BaseballGame baseballGame = BaseballGame.builder()
                .baseballGameState(BaseballGameState.IN_PROGRESS)
                .baseballMaxInning(10)
                .build();

        BaseballGameAnswerRequestDto requestDto = new BaseballGameAnswerRequestDto("123");

        doReturn(baseballGame).when(baseballGameRepository).save(any(BaseballGame.class));

        // when
        BaseballGameAnswerResponseDto responseDto = baseballGameAnswerService.getBaseballGameAnswer(baseballGame.getBaseballGameId(),requestDto);

        // then
        assertEquals(responseDto.isCorrect(), baseballGame.getBaseballGameId());
    }

    @Test
    @DisplayName("게임 종료가 아닐 시")
    public void 게임_종료가_아닐_시() {
        // given

        // when

        // then

    }


    @Test
    @DisplayName("게임 종료 시")
    public void 게임_종료() {
        // given

        // when

        // then

    }

    @Test
    @DisplayName("게임 결과")
    public void 게임_결과() {
        // given

        // when

        // then

    }
}