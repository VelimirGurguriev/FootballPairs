package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Player;
import com.exam.FootballPairs.model.Team;
import com.exam.FootballPairs.repository.PlayerRepository;
import com.exam.FootballPairs.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerCsvService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    private static final String PLAYERS_FILE = "./src/main/resources/players.csv";

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
                Team team = teamRepository.findById(teamId).orElse(null);
                // Adding a new class object to the ArrayList
                if (team != null) {
                    playersList.add(new Player(playerId, teamNumber, position, fullName, team));
                } else {
                    System.err.println("Team with ID " + teamId + " not found");
                }
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return playersList;
    }

    public void loadPlayersToDB() {
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
                Team team = teamRepository.findById(teamId).orElse(null);
                // Adding a new class object to the ArrayList
                if (team != null) {
                    playersList.add(new Player(playerId, teamNumber, position, fullName, team));
                } else {
                    System.err.println("Team with ID " + teamId + " not found");
                }
            }
            playerRepository.saveAll(playersList);
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
