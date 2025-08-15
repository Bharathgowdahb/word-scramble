package com.example.scramble.model;

import jakarta.persistence.*;

@Entity
@Table(name = "player_scores", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class PlayerScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    private int score;

    public PlayerScore() {}
    public PlayerScore(String name, int score) { this.name = name; this.score = score; }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }
}
