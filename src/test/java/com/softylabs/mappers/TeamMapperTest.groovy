package com.softylabs.mappers

import com.softylabs.dto.LeagueDTO
import com.softylabs.dto.TeamDTO
import com.softylabs.models.api.teams.ApiTeamsResponse
import com.softylabs.models.api.teams.TeamFromAPI
import com.softylabs.models.api.teams.TeamStatisticsFromAPI
import com.softylabs.models.api.teams.TeamsResponse
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import spock.lang.Specification

class TeamMapperTest extends Specification {
    def "try map team entity to dto"() {
        given:
        Team team = new Team()
        team.setTeamId(1L)
        team.setTeamName("test")
        team.setLeague(new League())

        TeamDTO dto = TeamMapper.mapToDto(team)

        expect:
        dto.getTeamId() == null
        dto.getTeamName() == "test"
    }

    def "map from team entity to dto with id"() {
        given:
        Team team = new Team()
        team.setTeamId(1L)
        team.setTeamName("test")
        team.setLeague(new League())

        TeamDTO dto = TeamMapper.mapToDtoWithId(team)

        expect:
        dto.getTeamId() == 1L
        dto.getTeamName() == "test"
    }

    def "try map from dto to entity"() {
        given:
        TeamDTO dto = TeamDTO.builder()
                .teamId(1L)
                .teamName("test")
                .league(LeagueDTO.builder().build())
                .build()

        Team team = TeamMapper.mapToEntity(dto)

        expect:
        team.getTeamId() == 1L
        team.getTeamName() == "test"
    }

    def "try map to dtos list from api teams response"() {
        given:
        LeagueDTO leagueDTO = LeagueDTO.builder()
                .leagueId(20L)
                .build()

        TeamFromAPI teamFromAPI = new TeamFromAPI()
        teamFromAPI.setTeamId(1L)
        teamFromAPI.setTeamStatistics(new TeamStatisticsFromAPI())
        teamFromAPI.setTeamName("test")

        List<List<TeamFromAPI>> list = new ArrayList<>()
        list.add(new ArrayList<TeamFromAPI>())
        list.get(0).add(teamFromAPI)

        TeamsResponse response = new TeamsResponse()
        response.setResults(1)
        response.setStandings(list)

        ApiTeamsResponse apiTeamsResponse = new ApiTeamsResponse()
        apiTeamsResponse.setTeamsResponse(response)

        List<TeamDTO> teamDTOList = TeamMapper.mapToDtoListFromApiResponse(apiTeamsResponse, leagueDTO)

        expect:
        teamDTOList.size() == 1
        teamDTOList.get(0).getTeamName() == "test"
        teamDTOList.get(0).getTeamId() == 1L
        teamDTOList.get(0).getLeague().getLeagueId() == 20L

    }
}
