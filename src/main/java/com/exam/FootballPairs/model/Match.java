package com.exam.FootballPairs.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long aTeamId;

    @Column(nullable = false)
    private long bTeamId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String score;

    public Match() {
    }

    public Match(long id, long aTeamId, long bTeamId, LocalDate date, String score) {
        this.id = id;
        this.aTeamId = aTeamId;
        this.bTeamId = bTeamId;
        this.date = date;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getaTeamId() {
        return aTeamId;
    }

    public void setaTeamId(long aTeamId) {
        this.aTeamId = aTeamId;
    }

    public long getbTeamId() {
        return bTeamId;
    }

    public void setbTeamId(long bTeamId) {
        this.bTeamId = bTeamId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
