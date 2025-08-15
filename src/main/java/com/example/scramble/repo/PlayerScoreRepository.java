package com.example.scramble.repo;

import com.example.scramble.model.PlayerScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerScoreRepository extends JpaRepository<PlayerScore, Long> {
    Optional<PlayerScore> findByNameIgnoreCase(String name);
    List<PlayerScore> findTop10ByOrderByScoreDesc();
}
