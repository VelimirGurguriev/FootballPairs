package com.exam.FootballPairs.model;

import java.time.LocalDate;

public class Match {
    private long id;
    private long aTeamId;
    private long bTeamId;
    private LocalDate date;
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
