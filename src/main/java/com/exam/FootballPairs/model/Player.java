package com.exam.FootballPairs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int teamNumber;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "teamId", nullable = false)
    private Team team;

    public Player() {
    }

    public Player(long id, int teamNumber, String position, String fullName, Team teamId) {
        this.id = id;
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.team = teamId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getTeamId() {
        if(team != null) {
            return team.getId();
        } else {
            return 0;
        }
    }
}
