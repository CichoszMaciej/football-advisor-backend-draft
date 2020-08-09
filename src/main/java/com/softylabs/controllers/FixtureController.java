package com.softylabs.controllers;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.models.entity.Fixture;
import com.softylabs.services.FixtureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixtures")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class FixtureController {
    private final FixtureService fixtureService;

    @GetMapping("/")
    public List<FixtureDTO> findAllFixture() {
        return fixtureService.findAll();
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

    @GetMapping("/last/{teamId}")
    public List<FixtureDTO> findLastFixturesByTeamId(@PathVariable("teamId") Long teamId) {
        return fixtureService.findLastFixturesByTeamId(teamId);
    }
}
