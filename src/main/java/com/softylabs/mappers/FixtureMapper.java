package com.softylabs.mappers;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.models.api.fixtures.ApiFixturesResponse;
import com.softylabs.models.api.fixtures.FixtureFromApi;
import com.softylabs.models.entity.Fixture;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FixtureMapper {
    public static FixtureDTO mapFromApiToDto(FixtureFromApi fixtureFromApi, LeagueDTO leagueDTO, TeamDTO homeTeam,
                                             TeamDTO homeAway) {
        return FixtureDTO.builder()
                .matchId(fixtureFromApi.getMatchId())
                .league(leagueDTO)
                .eventDate(fixtureFromApi.getEventDate())
                .status(fixtureFromApi.getStatus())
                .statusShort(fixtureFromApi.getStatusShort())
                .elapsed(fixtureFromApi.getElapsed())
                .goalsHomeTeam(fixtureFromApi.getGoalsHomeTeam())
                .goalsAwayTeam(fixtureFromApi.getGoalsAwayTeam())
                .homeTeam(homeTeam)
                .awayTeam(homeAway)
                .scoreHalfTime(fixtureFromApi.getScoreHalfTime())
                .scoreFullTime(fixtureFromApi.getScoreFullTime())
                .build();
    }

    public static Fixture mapToEntity(FixtureDTO fixtureDTO) {
        Fixture fixture = new Fixture();

        fixture.setMatchId(fixtureDTO.getMatchId());
        fixture.setLeague(LeagueMapper.mapToEntity(fixtureDTO.getLeague()));
        fixture.setEventDate(fixtureDTO.getEventDate());
        fixture.setStatus(fixtureDTO.getStatus());
        fixture.setStatusShort(fixtureDTO.getStatusShort());
        fixture.setElapsed(fixtureDTO.getElapsed());
        fixture.setGoalsHomeTeam(fixtureDTO.getGoalsHomeTeam());
        fixture.setGoalsAwayTeam(fixtureDTO.getGoalsAwayTeam());
        fixture.setHomeTeam(TeamMapper.mapToEntity(fixtureDTO.getHomeTeam()));
        fixture.setAwayTeam(TeamMapper.mapToEntity(fixtureDTO.getAwayTeam()));
        fixture.setScoreHalfTime(fixtureDTO.getScoreHalfTime());
        fixture.setScoreFullTime(fixtureDTO.getScoreFullTime());

        return fixture;
    }

    public static FixtureDTO mapToDtoWithId(Fixture fixture) {
        return FixtureDTO.builder()
                .matchId(fixture.getMatchId())
                .league(LeagueMapper.mapToDtoWithId(fixture.getLeague()))
                .eventDate(fixture.getEventDate())
                .status(fixture.getStatus())
                .statusShort(fixture.getStatusShort())
                .elapsed(fixture.getElapsed())
                .goalsHomeTeam(fixture.getGoalsHomeTeam())
                .goalsAwayTeam(fixture.getGoalsAwayTeam())
                .homeTeam(TeamMapper.mapToDtoWithId(fixture.getHomeTeam()))
                .awayTeam(TeamMapper.mapToDtoWithId(fixture.getAwayTeam()))
                .scoreHalfTime(fixture.getScoreHalfTime())
                .scoreFullTime(fixture.getScoreFullTime())
                .build();
    }

    public static List<FixtureDTO> mapToDtoListFromApiResponse(ApiFixturesResponse apiFixturesResponse,
                                                               LeagueDTO leagueDTO, List<TeamDTO> teamDTOList) {
        List<FixtureDTO> fixtureDTOList = new ArrayList<>();
        List<FixtureFromApi> fixtureFromApiList = apiFixturesResponse.getFixturesResponse().getMatchFromApiList();

        for (FixtureFromApi fixtureFromApi : fixtureFromApiList) {
            TeamDTO homeTeam = teamDTOList.stream()
                    .filter(teamDTO -> teamDTO.getTeamId().equals(fixtureFromApi.getHomeTeamId()))
                    .findAny()
                    .orElse(null);

            TeamDTO awayTeam = teamDTOList.stream()
                    .filter(teamDTO -> teamDTO.getTeamId().equals(fixtureFromApi.getAwayTeamId()))
                    .findAny()
                    .orElse(null);

            if (homeTeam != null && awayTeam != null) {
                fixtureDTOList.add(mapFromApiToDto(fixtureFromApi, leagueDTO, homeTeam, awayTeam));
            }
        }

        return fixtureDTOList;
    }
}
