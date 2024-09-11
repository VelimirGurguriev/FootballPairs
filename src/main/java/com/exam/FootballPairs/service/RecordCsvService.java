package com.exam.FootballPairs.service;

import com.exam.FootballPairs.model.Record;
import com.exam.FootballPairs.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordCsvService {

    @Autowired
    private RecordRepository recordRepository;

    private static final String RECORDS_FILE = "./src/main/resources/records.csv";

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
                Integer toMinutes;
                if (fields[4].equalsIgnoreCase("NULL") || fields[4].isEmpty()) {
                    toMinutes = null;
                } else {
                    toMinutes = Integer.parseInt(fields[4]);
                }
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
