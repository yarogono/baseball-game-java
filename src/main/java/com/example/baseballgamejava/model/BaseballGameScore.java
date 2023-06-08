package com.example.baseballgamejava.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BaseballGameScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baseballGameScoreRecordId;

    private int strike;

    private int ball;

    private int out;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "baseballGameId", nullable = false)
    private BaseballGame baseballGame;
}
