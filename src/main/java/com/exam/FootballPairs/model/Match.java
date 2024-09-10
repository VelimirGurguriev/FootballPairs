package com.exam.FootballPairs.Model;

import java.time.LocalDate;

public class Match {
    private long id;
    private int aTeamId;
    private int bTeamId;
    private LocalDate date;
    private String score;

    public Match() {
    }

    public Match(long id, int aTeamId, int bTeamId, LocalDate date, String score) {
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

    public int getaTeamId() {
        return aTeamId;
    }

    public void setaTeamId(int aTeamId) {
        this.aTeamId = aTeamId;
    }

    public int getbTeamId() {
        return bTeamId;
    }

    public void setbTeamId(int bTeamId) {
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
