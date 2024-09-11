package com.exam.FootballPairs.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "aTeamId", nullable = false)
    private Team aTeam;

    @ManyToOne
    @JoinColumn(name = "bTeamId", nullable = false)
    private Team bTeam;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String score;

    @OneToMany(mappedBy = "match")
    private Set<Record> records;

    public Match() {
    }


    public Match(long id, Team aTeamId, Team bTeamId, LocalDate date, String score) {
        this.id = id;
        this.aTeam = aTeamId;
        this.bTeam = bTeamId;
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
        if(aTeam != null) {
            return aTeam.getId();
        } else {
            return 0;
        }
    }

    public long getbTeamId() {
        if(bTeam != null) {
            return bTeam.getId();
        } else {
            return 0;
        }
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

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
