package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Match;
import com.exam.FootballPairs.repository.MatchRepository;
import com.exam.FootballPairs.utils.DateFormatConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatchCsvService {

    @Autowired
    private MatchRepository matchRepository;

    private static final String MATCHES_FILE = "./src/main/resources/matches.csv";

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
                //LocalDate date = LocalDate.parse(fields[3]);
                String dateToString = fields[3];
                LocalDate date = DateFormatConverter.convertDateFormat(dateToString);
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

    public void loadMatchesToDB() {
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
                //LocalDate date = LocalDate.parse(fields[3]);
                String dateToString = fields[3];
                LocalDate date = DateFormatConverter.convertDateFormat(dateToString);
                String score = fields[4];
                // Adding a new class object to the ArrayList
                matchesList.add(new Match(matchId, aTeamID, bTeamID, date, score));
            }
            matchRepository.saveAll(matchesList);
        } catch (FileNotFoundException exc) {
            throw new RuntimeException(exc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
