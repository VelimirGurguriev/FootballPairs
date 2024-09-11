package com.exam.FootballPairs.config;

import com.exam.FootballPairs.service.MatchCsvService;
import com.exam.FootballPairs.service.PlayerCsvService;
import com.exam.FootballPairs.service.RecordCsvService;
import com.exam.FootballPairs.service.TeamCsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private PlayerCsvService playerCsvService;

    @Autowired
    private TeamCsvService teamCsvService;

    @Autowired
    private MatchCsvService matchCsvService;

    @Autowired
    private RecordCsvService recordCsvService;

    @Bean
    public CommandLineRunner loadToDB() {
        return args -> {
            playerCsvService.loadPlayersToDB();
            teamCsvService.loadTeamsToDB();
            matchCsvService.loadMatchesToDB();
            recordCsvService.loadRecordsToDB();
        };
    }
}
