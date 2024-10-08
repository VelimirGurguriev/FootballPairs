package com.exam.FootballPairs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "playerId", nullable = false)
    private Player player;

    @ManyToOne
    @JoinColumn(name = "matchId", nullable = false)
    private Match match;

    @Column(nullable = false)
    private int fromMinutes;

    private Integer toMinutes;

    public Record() {
    }

    public Record(long id, Player playerId, Match matchId, int fromMinutes, Integer toMinutes) {
        this.id = id;
        this.player = playerId;
        this.match = matchId;
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
        if(player != null) {
            return player.getId();
        } else {
            return 0;
        }
    }

    public long getMatchId() {
        if(match != null) {
            return match.getId();
        } else {
            return 0;
        }
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
