package com.softylabs.services;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.dto.TopScorerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateDataService {

    private final TeamService teamService;
    private final LeagueService leagueService;
    private final FixtureService fixtureService;
    private final ExternalApiService externalApiService;
    private final TopScorersService topScorersService;

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

    public List<TopScorerDTO> updateTopScorers() {
        List<LeagueDTO> leagueDTOList = leagueService.findAllWithIds();
        List<TopScorerDTO> topScorerFromLeagueDTOList = new ArrayList<>();
        List<TopScorerDTO> topScorerDTOList = new ArrayList<>();
        leagueDTOList.forEach(leagueDTO -> {
            topScorerFromLeagueDTOList.addAll(externalApiService.getTopScorersByLeague(leagueDTO.getLeagueId()));
            topScorerFromLeagueDTOList.forEach(topScorerDTO -> topScorerDTO.setLeagueId(leagueDTO.getLeagueId()));
            topScorerDTOList.addAll(topScorerFromLeagueDTOList);
            topScorerFromLeagueDTOList.clear();
        });
        return topScorersService.saveAll(topScorerDTOList);
    }

    public List<TopScorerDTO> updateTopScorersByLeague(Long leagueId) {
        return topScorersService.saveAll(externalApiService.getTopScorersByLeague(leagueId));
    }
}
