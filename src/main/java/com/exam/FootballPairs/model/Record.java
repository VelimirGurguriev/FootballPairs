package com.exam.FootballPairs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long playerId;

    @Column(nullable = false)
    private long matchId;

    @Column(nullable = false)
    private int fromMinutes;

    private Integer toMinutes;

    public Record() {
    }

    public Record(long id, long playerId, long matchId, int fromMinutes, Integer toMinutes) {
        this.id = id;
        this.playerId = playerId;
        this.matchId = matchId;
        this.fromMinutes = fromMinutes;
        this.toMinutes = toMinutes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public int getFromMinutes() {
        return fromMinutes;
    }

    public void setFromMinutes(int fromMinutes) {
        this.fromMinutes = fromMinutes;
    }

    public Integer getToMinutes() {
        return toMinutes;
    }

    public void setToMinutes(Integer toMinutes) {
        this.toMinutes = toMinutes;
    }
}
