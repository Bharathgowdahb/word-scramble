package com.example.scramble.controller;

import com.example.scramble.dto.*;
import com.example.scramble.model.PlayerScore;
import com.example.scramble.repo.PlayerScoreRepository;
import com.example.scramble.service.WordService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class GameController {

    private final WordService wordService;
    private final PlayerScoreRepository repo;

    public GameController(WordService wordService, PlayerScoreRepository repo) {
        this.wordService = wordService;
        this.repo = repo;
    }

    // Get a scrambled word
    @GetMapping("/word")
    public ScrambledWordDTO getWord() {
        return wordService.randomScramble();
    }

    // Submit a guess -> returns whether correct, delta, new total, message, and the correct word
    @PostMapping("/guess")
    public ResponseEntity<GuessResponse> guess(@RequestBody @Valid GuessRequest req) {
        String playerName = req.getPlayer().trim();
        boolean correct = wordService.isCorrect(req.getWordId(), req.getGuess());

        int delta = correct ? 10 : 0;
        PlayerScore ps = repo.findByNameIgnoreCase(playerName)
                .orElseGet(() -> repo.save(new PlayerScore(playerName, 0)));

        if (correct) {
            ps.setScore(ps.getScore() + delta);
            repo.save(ps);
        }

        String correctWord = wordService.getWordById(req.getWordId());
        String message = correct ? "Correct! +" + delta + " points" : "Oops! Try again.";

        return ResponseEntity.ok(new GuessResponse(correct, delta, ps.getScore(), message, correctWord));
    }

    // Top 10 leaderboard
    @GetMapping("/leaderboard")
    public List<Map<String, Object>> leaderboard() {
        List<PlayerScore> top = repo.findTop10ByOrderByScoreDesc();
        List<Map<String, Object>> out = new ArrayList<>();
        int rank = 1;
        for (PlayerScore ps : top) {
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("rank", rank++);
            row.put("name", ps.getName());
            row.put("score", ps.getScore());
            out.add(row);
        }
        return out;
    }
}
