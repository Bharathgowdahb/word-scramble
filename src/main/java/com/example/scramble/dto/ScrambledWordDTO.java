package com.example.scramble.dto;

public class ScrambledWordDTO {
    private int id;
    private String scrambled;
    private String hint;
    private int length;

    public ScrambledWordDTO() {}
    public ScrambledWordDTO(int id, String scrambled, String hint, int length) {
        this.id = id; this.scrambled = scrambled; this.hint = hint; this.length = length;
    }
    public int getId() { return id; }
    public String getScrambled() { return scrambled; }
    public String getHint() { return hint; }
    public int getLength() { return length; }
    public void setId(int id) { this.id = id; }
    public void setScrambled(String scrambled) { this.scrambled = scrambled; }
    public void setHint(String hint) { this.hint = hint; }
    public void setLength(int length) { this.length = length; }
}
