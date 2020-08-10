package com.softylabs.mappers;

import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.models.api.teams.ApiTeamsResponse;
import com.softylabs.models.api.teams.TeamFromAPI;
import com.softylabs.models.entity.Team;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeamMapper {
    public static TeamDTO mapToDto(Team team) {
        return TeamDTO.builder()
                .teamName(team.getTeamName())
                .rank(team.getRank())
                .points(team.getPoints())
                .logoUrl(team.getLogoUrl())
                .form(team.getForm())
                .winCount(team.getWinCount())
                .loseCount(team.getLoseCount())
                .drawCount(team.getDrawCount())
                .goalsAgainst(team.getGoalsAgainst())
                .goalsFor(team.getGoalsFor())
                .goalsDiff(team.getGoalsDiff())
                .matchesPlayed(team.getMatchesPlayed())
                .league(LeagueMapper.mapToDto(team.getLeague()))
                .build();
    }

    public static TeamDTO mapToDtoWithId(Team team) {
        return TeamDTO.builder()
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .rank(team.getRank())
                .points(team.getPoints())
                .logoUrl(team.getLogoUrl())
                .form(team.getForm())
                .winCount(team.getWinCount())
                .loseCount(team.getLoseCount())
                .drawCount(team.getDrawCount())
                .goalsAgainst(team.getGoalsAgainst())
                .goalsFor(team.getGoalsFor())
                .goalsDiff(team.getGoalsDiff())
                .matchesPlayed(team.getMatchesPlayed())
                .league(LeagueMapper.mapToDtoWithId(team.getLeague()))
                .build();
    }

    public static TeamDTO mapToDtoWithIdWithoutLeague(Team team) {
        return TeamDTO.builder()
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .rank(team.getRank())
                .points(team.getPoints())
                .logoUrl(team.getLogoUrl())
                .form(team.getForm())
                .winCount(team.getWinCount())
                .loseCount(team.getLoseCount())
                .drawCount(team.getDrawCount())
                .goalsAgainst(team.getGoalsAgainst())
                .goalsFor(team.getGoalsFor())
                .goalsDiff(team.getGoalsDiff())
                .matchesPlayed(team.getMatchesPlayed())
                .build();
    }

    public static TeamDTO mapFromApiToDto(TeamFromAPI teamFromAPI) {
        return TeamDTO.builder()
                .teamId(teamFromAPI.getTeamId())
                .teamName(teamFromAPI.getTeamName())
                .logoUrl(teamFromAPI.getLogoUrl())
                .rank(teamFromAPI.getRank())
                .points(teamFromAPI.getPoints())
                .goalsDiff(teamFromAPI.getGoalsDiff())
                .goalsFor(teamFromAPI.getTeamStatistics().getGoalsFor())
                .goalsAgainst(teamFromAPI.getTeamStatistics().getGoalsAgainst())
                .winCount(teamFromAPI.getTeamStatistics().getWin())
                .drawCount(teamFromAPI.getTeamStatistics().getDraw())
                .loseCount(teamFromAPI.getTeamStatistics().getLose())
                .matchesPlayed(teamFromAPI.getTeamStatistics().getMatchesPlayed())
                .form(teamFromAPI.getForm())
                .league(teamFromAPI.getLeague())
                .build();
    }

    public static Team mapToEntity(TeamDTO teamDTO) {
        Team team = new Team();
        team.setTeamId(teamDTO.getTeamId());
        team.setTeamName(teamDTO.getTeamName());
        team.setLogoUrl(teamDTO.getLogoUrl());
        team.setRank(teamDTO.getRank());
        team.setPoints(teamDTO.getPoints());
        team.setGoalsDiff(teamDTO.getGoalsDiff());
        team.setGoalsFor(teamDTO.getGoalsFor());
        team.setGoalsAgainst(teamDTO.getGoalsAgainst());
        team.setWinCount(teamDTO.getWinCount());
        team.setDrawCount(teamDTO.getDrawCount());
        team.setLoseCount(teamDTO.getLoseCount());
        team.setMatchesPlayed(teamDTO.getMatchesPlayed());
        team.setForm(teamDTO.getForm());
        team.setLeague(LeagueMapper.mapToEntity(teamDTO.getLeague()));

        return team;
    }

    public static List<TeamDTO> mapToDtoListFromApiResponse(ApiTeamsResponse apiTeamsResponse, LeagueDTO sourceLeague) {
        List<TeamFromAPI> teamFromAPIList = apiTeamsResponse.getTeamsResponse().getStandings().get(0);
        List<TeamDTO> teamDTOS = teamFromAPIList.stream()
                .map(TeamMapper::mapFromApiToDto)
                .collect(Collectors.toList());
        teamDTOS.forEach(teamDTO -> teamDTO.setLeague(sourceLeague));
        return teamDTOS;
    }
}
