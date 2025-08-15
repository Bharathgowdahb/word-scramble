package com.example.scramble.dto;

public class GuessResponse {
    private boolean correct;
    private int scoreDelta;
    private int totalScore;
    private String message;
    private String correctWord;

    public GuessResponse() {}
    public GuessResponse(boolean correct, int scoreDelta, int totalScore, String message, String correctWord) {
        this.correct = correct;
        this.scoreDelta = scoreDelta;
        this.totalScore = totalScore;
        this.message = message;
        this.correctWord = correctWord;
    }

    public boolean isCorrect() { return correct; }
    public int getScoreDelta() { return scoreDelta; }
    public int getTotalScore() { return totalScore; }
    public String getMessage() { return message; }
    public String getCorrectWord() { return correctWord; }

    public void setCorrect(boolean correct) { this.correct = correct; }
    public void setScoreDelta(int scoreDelta) { this.scoreDelta = scoreDelta; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }
    public void setMessage(String message) { this.message = message; }
    public void setCorrectWord(String correctWord) { this.correctWord = correctWord; }
}
