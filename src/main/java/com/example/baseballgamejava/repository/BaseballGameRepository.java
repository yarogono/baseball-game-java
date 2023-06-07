package com.example.baseballgamejava.repository;

import com.example.baseballgamejava.model.BaseballGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseballGameRepository extends JpaRepository<BaseballGame, Long> {
}
