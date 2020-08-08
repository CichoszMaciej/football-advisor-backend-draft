package com.softylabs.controllers;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.services.UpdateDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/update")
@CrossOrigin(origins = "http://localhost:4200")
public class UpdateDataController {
    private final UpdateDataService updateDataService;

    public UpdateDataController(UpdateDataService updateDataService) {
        this.updateDataService = updateDataService;
    }

    @GetMapping("/leagues")
    public List<LeagueDTO> updateLeaguesWithoutArgs() {
        return updateDataService.updateLeagues();
    }

    @GetMapping("/league/{league_id}")
    public LeagueDTO updateLeague(@PathVariable("league_id") Long leagueId) {
        return updateDataService.updateLeague(leagueId);
    }

    @GetMapping("/teams")
    public List<TeamDTO> updateTeams() {
        return updateDataService.updateTeams();
    }

    @GetMapping("/fixtures")
    public List<FixtureDTO> updateFixturesByLeagueId() {
        return updateDataService.updateFixtures();
    }
}
