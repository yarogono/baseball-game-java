package com.example.baseballgamejava.service;

import com.example.baseballgamejava.repository.BaseballGameRepository;
import com.example.baseballgamejava.repository.BaseballGameScoreRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BaseballGameHistoryServiceTest {

    @InjectMocks
    private BaseballGameHistoryService baseballGameHistoryService;

    @Mock
    private BaseballGameRepository baseballGameRepository;

    @Mock
    private BaseballGameScoreRepository baseballGameScoreRepository;

    @Test
    @DisplayName("게임 진행 기록")
    public void 게임_진행_기록() {
        // given

        // when

        // then

    }
}