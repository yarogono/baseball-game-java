package com.example.baseballgamejava.repository;

import com.example.baseballgamejava.model.BaseballGameScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseballGameScoreRepository extends JpaRepository<BaseballGameScore, Long> {
}
