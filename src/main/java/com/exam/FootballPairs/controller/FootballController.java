package com.exam.FootballPairs.controller;

import com.exam.FootballPairs.service.FootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/football")
public class FootballController {

    @Autowired
    private FootballService footballService;

    @GetMapping("/players")
    public String viewPlayers(Model model) {
        model.addAttribute("players", footballService.getPlayers());
        return "players";
    }

    @GetMapping("/teams")
    public String viewTeams(Model model) {
        model.addAttribute("teams", footballService.getTeams());
        return "teams";
    }

    @GetMapping("/matches")
    public String viewMatches(Model model) {
        model.addAttribute("matches", footballService.getMatches());
        return "matches";
    }
}
