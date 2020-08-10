package com.softylabs.controllers;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.models.entity.Fixture;
import com.softylabs.services.FixtureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/fixtures")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class FixtureController {
    private final FixtureService fixtureService;

    @GetMapping("/")
    public List<FixtureDTO> findAllFixture(Pageable pageable) {
        return fixtureService.findAll(pageable);
    }

    @GetMapping("/byTwoTeams/{firstTeamId}/{secondTeamId}")
    public List<FixtureDTO> findFixturesByTwoTeams(@PathVariable("firstTeamId") Long firstTeamId,
                                                   @PathVariable("secondTeamId") Long secondTeamId) {
        return fixtureService.findFixturesByTwoTeams(firstTeamId, secondTeamId);
    }

    @GetMapping("/league/{leagueId}")
    public List<FixtureDTO> findFixturesByLeague(@PathVariable("leagueId") Long leagueId) {
        return fixtureService.findFixturesByLeagueId(leagueId);
    }

    @GetMapping("/last/team/{teamId}")
    public List<FixtureDTO> findLastFixturesByTeamId(@PathVariable("teamId") Long teamId) {
        return fixtureService.findLastFixturesByTeamId(teamId);
    }

    @GetMapping("/last/league/{leagueId}")
    public List<FixtureDTO> findLastFixturesByLeagueId(@PathVariable("leagueId") Long leagueId) {
        return fixtureService.findLastFixturesByLeagueId(leagueId);
    }

    @GetMapping("/next/team/{teamId}")
    public List<FixtureDTO> findNextFixturesByTeamId(@PathVariable("teamId") Long teamId) {
        return fixtureService.findNextFixturesByTeamId(teamId);
    }

    @GetMapping("/next/league/{leagueId}")
    public List<FixtureDTO> findNextFixturesByLeagueId(@PathVariable("leagueId") Long leagueId) {
        return fixtureService.findLastFixturesByLeagueId(leagueId);
    }

    @GetMapping("/next")
    public List<FixtureDTO> find10NextFixturesFromAllLeague() {
        return fixtureService.find10NextFixturesFromAllLeague();
    }
}
