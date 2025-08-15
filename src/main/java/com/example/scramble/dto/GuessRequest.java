package com.example.scramble.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GuessRequest {
    @NotNull
    private Integer wordId;

    @NotBlank
    private String guess;

    @NotBlank
    private String player;

    public Integer getWordId() { return wordId; }
    public String getGuess() { return guess; }
    public String getPlayer() { return player; }

    public void setWordId(Integer wordId) { this.wordId = wordId; }
    public void setGuess(String guess) { this.guess = guess; }
    public void setPlayer(String player) { this.player = player; }
}
