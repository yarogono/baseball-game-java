package com.example.baseballgamejava.model;

import com.example.baseballgamejava.constants.BaseballGameState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseballGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baseballGameId;

    private int baseballCurrentInning;

    @Column(nullable = false)
    private int baseballMaxInning;

    @Column(nullable = false)
    private int guessNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BaseballGameState baseballGameState;

    @OneToMany(mappedBy = "baseballGame", fetch = FetchType.EAGER)
    private List<BaseballGameScore> baseballGameScoreList = new ArrayList<>();
}
