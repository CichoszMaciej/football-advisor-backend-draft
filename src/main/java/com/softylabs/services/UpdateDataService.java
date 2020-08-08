package com.softylabs.services;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateDataService {

    private final TeamService teamService;
    private final LeagueService leagueService;
    private final FixtureService fixtureService;
    private final ExternalApiService externalApiService;

    public List<LeagueDTO> updateLeagues() {
        return leagueService.saveAll(externalApiService.getLeagues());
    }

    public LeagueDTO updateLeague(Long leagueId) {
        return leagueService.save(externalApiService.getLeague(leagueId));
    }

    public List<TeamDTO> updateTeams() {
        List<TeamDTO> teamsList = externalApiService.getTeamsByLeagues(leagueService.findAllWithIds());
        return teamService.saveAll(teamsList);
    }

    public List<FixtureDTO> updateFixtures() {
        List<LeagueDTO> leagueDTOList = leagueService.findAllWithIds();
        List<TeamDTO> teamsList = teamService.findAllWithIds();

        return fixtureService.saveAll(externalApiService.getFixtures(leagueDTOList, teamsList));
    }
}
