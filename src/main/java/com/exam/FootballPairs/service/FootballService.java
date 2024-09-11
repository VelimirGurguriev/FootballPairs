package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Match;
import com.exam.FootballPairs.model.Player;
import com.exam.FootballPairs.model.Record;
import com.exam.FootballPairs.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootballService {

    @Autowired
    public PlayerCsvService playerCsvService;

    @Autowired
    public TeamCsvService teamCsvService;

    @Autowired
    public MatchCsvService matchCsvService;

    @Autowired
    public RecordCsvService recordCsvService;

    public List<Player> getPlayers() {
        return playerCsvService.readPlayers();
    }

    public void loadPlayersToDB() {
        playerCsvService.loadPlayersToDB();
    }

    public List<Team> getTeams() {
        return teamCsvService.readTeams();
    }

    public List<Match> getMatches() {
        return matchCsvService.readMatches();
    }

    public List<Record> getRecords() {
        return recordCsvService.readRecords();
    }
}
