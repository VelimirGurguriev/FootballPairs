package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Match;
import com.exam.FootballPairs.model.Player;
import com.exam.FootballPairs.model.Record;
import com.exam.FootballPairs.model.Team;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FootballService {

    @Autowired
    public CsvService csvService;

    public List<Player> getPlayers() {
        return csvService.readPlayers();
    }

    public List<Team> getTeams() {
        return csvService.readTeams();
    }

    public List<Match> getMatches() {
        return csvService.readMatches();
    }

    public List<Record> getRecords() {
        return csvService.readRecords();
    }
}
