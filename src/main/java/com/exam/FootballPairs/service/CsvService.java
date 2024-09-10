package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Match;
import com.exam.FootballPairs.model.Player;
import com.exam.FootballPairs.model.Record;
import com.exam.FootballPairs.model.Team;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {
    // Initialising CSV file names as constants for the CSV service
    private static final String PLAYERS_FILE = "./src/main/resources/players.csv";
    private static final String TEAMS_FILE = "./src/main/resources/teams.csv";
    private static final String MATCHES_FILE = "./src/main/resources/matches.csv";
    private static final String RECORDS_FILE = "./src/main/resources/records.csv";

    public List<Player> readPlayers() {
        List<Player> playersList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PLAYERS_FILE))) {
            // TEMP skip first line to validate that its working correctly
            reader.readLine();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // TO DO - add field validations
                // Splitting the text on the current line by a comma as a separator
                String[] fields = currentLine.split(",");
                // Taking the values of each field and assigning to a variable for the constructor
                Long playerId = Long.valueOf(fields[0]);
                int teamNumber = Integer.parseInt(fields[1]);
                String position = fields[2];
                String fullName = fields[3];
                Long teamId = Long.valueOf(fields[4]);
                // Adding a new class object to the ArrayList
                playersList.add(new Player(playerId, teamNumber, position, fullName, teamId));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return playersList;
    }

    public List<Team> readTeams() {
        List<Team> teamsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TEAMS_FILE))) {
            // TEMP skip first line to validate that its working correctly
            reader.readLine();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // TO DO - add field validations
                // Splitting the text on the current line by a comma as a separator
                String[] fields = currentLine.split(",");
                // Taking the values of each field and assigning to a variable for the constructor
                Long teamId = Long.valueOf(fields[0]);
                String teamName = fields[1];
                String managerName = fields[2];
                String group = fields[3];
                // Adding a new class object to the ArrayList
                teamsList.add(new Team(teamId, teamName, managerName, group));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teamsList;
    }

    public List<Match> readMatches() {
        List<Match> matchesList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MATCHES_FILE))) {
            // TEMP skip first line to validate that its working correctly
            reader.readLine();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // TO DO - add field validations
                // Splitting the text on the current line by a comma as a separator
                String[] fields = currentLine.split(",");
                // Taking the values of each field and assigning to a variable for the constructor
                Long matchId = Long.valueOf(fields[0]);
                Long aTeamID = Long.valueOf(fields[1]);
                Long bTeamID = Long.valueOf(fields[2]);
                LocalDate date = LocalDate.parse(fields[3]);
                String score = fields[4];
                // Adding a new class object to the ArrayList
                matchesList.add(new Match(matchId, aTeamID, bTeamID, date, score));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matchesList;
    }

    public List<Record> readRecords() {
        List<Record> recordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RECORDS_FILE))) {
            // TEMP skip first line to validate that its working correctly
            reader.readLine();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // TO DO - add field validations
                // Splitting the text on the current line by a comma as a separator
                String[] fields = currentLine.split(",");
                // Taking the values of each field and assigning to a variable for the constructor
                Long recordId = Long.valueOf(fields[0]);
                Long playerID = Long.valueOf(fields[1]);
                Long matchID = Long.valueOf(fields[2]);
                int fromMinutes = Integer.parseInt(fields[3]);
                int toMinutes = Integer.parseInt(fields[4]);
                // Adding a new class object to the ArrayList
                recordsList.add(new Record(recordId, playerID, matchID, fromMinutes, toMinutes));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return recordsList;
    }
}
