package com.softylabs.controllers;

import com.softylabs.dto.TeamDTO;
import com.softylabs.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/")
    public List<TeamDTO> findAllTeams() {
        return teamService.findAll();
    }

    @GetMapping("/{team_id}")
    public ResponseEntity<TeamDTO> findTeam(@PathVariable("team_id") Long teamId) {
        return ResponseEntity.of(teamService.findById(teamId));
    }

    @GetMapping("/league/{league_id}")
    public List<TeamDTO> findTeamsByLeagueId(@PathVariable("league_id") Long leagueId) {
        return teamService.findByLeagueId(leagueId);
    }
}
