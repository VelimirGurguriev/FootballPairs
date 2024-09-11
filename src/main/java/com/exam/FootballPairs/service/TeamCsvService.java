package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Team;
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
public class TeamCsvService {

    @Autowired
    private TeamRepository teamRepository;

    private static final String TEAMS_FILE = "./src/main/resources/teams.csv";

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
                String teamGroup = fields[3];
                // Adding a new class object to the ArrayList
                teamsList.add(new Team(teamId, teamName, managerName, teamGroup));
            }
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teamsList;
    }

    public void loadTeamsToDB() {
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
                String teamGroup = fields[3];
                // Adding a new class object to the ArrayList
                teamsList.add(new Team(teamId, teamName, managerName, teamGroup));
            }
            teamRepository.saveAll(teamsList);
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
