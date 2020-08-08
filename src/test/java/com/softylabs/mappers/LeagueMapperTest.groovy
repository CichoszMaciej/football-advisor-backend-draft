package com.softylabs.mappers

import com.softylabs.dto.LeagueDTO
import com.softylabs.models.api.league.ApiLeagueResponse
import com.softylabs.models.api.league.LeagueFromAPI
import com.softylabs.models.api.league.LeagueResponse
import com.softylabs.models.entity.League
import spock.lang.Specification

class LeagueMapperTest extends Specification {
    def "try map to dto from entity"() {
        given:
        League league = new League()
        league.setLeagueId(1L)
        league.setName("test")

        LeagueDTO leagueDTO = LeagueMapper.mapToDto(league)

        expect:
        leagueDTO.getLeagueId() == null
        leagueDTO.getName() == "test"
    }

    def "try map from entity to dto with id"() {
        given:
        League league = new League()
        league.setLeagueId(1L)
        league.setName("test")

        LeagueDTO leagueDTO = LeagueMapper.mapToDtoWithId(league)

        expect:
        leagueDTO.getLeagueId() == 1L
        leagueDTO.getName() == "test"
    }

    def "try map dto to entity"() {
        given:
        LeagueDTO leagueDTO = LeagueDTO.builder()
                .leagueId(1L)
                .name("test")
                .build()

        League league = LeagueMapper.mapToEntity(leagueDTO)

        expect:
        league.getLeagueId() == 1L
        league.getName() == "test"
    }

    def "try map leagueFromApi to dto"() {
        given:
        LeagueFromAPI league = new LeagueFromAPI()
        league.setLeagueId(1L)
        league.setName("test")

        List<LeagueFromAPI> leagues = Arrays.asList(league)

        LeagueResponse response = new LeagueResponse()
        response.setLeagueFromAPIList(leagues)

        ApiLeagueResponse apiLeagueResponse = new ApiLeagueResponse()
        apiLeagueResponse.setLeagueResponse(response)

        LeagueDTO leagueDTO = LeagueMapper.mapToDtoFromApiResponse(apiLeagueResponse)

        expect:
        leagueDTO.getName() == "test"
        leagueDTO.getLeagueId() == 1L


    }
}
