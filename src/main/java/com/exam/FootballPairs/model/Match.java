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

//    @Column(nullable = false)
//    private long aTeamId;

    @ManyToOne
    @JoinColumn(name = "aTeamId", nullable = false)
    private Team aTeamId;

//    @Column(nullable = false)
//    private long bTeamId;

    @ManyToOne
    @JoinColumn(name = "bTeamId", nullable = false)
    private Team bTeamId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String score;

    @OneToMany(mappedBy = "matchId")
    private Set<Record> records;

    public Match() {
    }

//    public Match(long id, long aTeamId, long bTeamId, LocalDate date, String score) {
//        this.id = id;
//        this.aTeamId = aTeamId;
//        this.bTeamId = bTeamId;
//        this.date = date;
//        this.score = score;
//    }


    public Match(long id, Team aTeamId, Team bTeamId, LocalDate date, String score) {
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

//    public long getaTeamId() {
//        return aTeamId;
//    }
//
//    public void setaTeamId(long aTeamId) {
//        this.aTeamId = aTeamId;
//    }
//
//    public long getbTeamId() {
//        return bTeamId;
//    }
//
//    public void setbTeamId(long bTeamId) {
//        this.bTeamId = bTeamId;
//    }

    public long getaTeamId() {
        if(aTeamId != null) {
            return aTeamId.getId();
        } else {
            return 0;
        }
    }

    public long getbTeamId() {
        if(bTeamId != null) {
            return bTeamId.getId();
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
}
