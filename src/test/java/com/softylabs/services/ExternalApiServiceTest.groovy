package com.softylabs.services

import com.softylabs.dto.LeagueDTO
import com.softylabs.mappers.LeagueMapper
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import org.springframework.web.client.RestTemplate
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ExternalApiServiceTest extends Specification {
    private RestTemplate restTemplate
    private ExternalApiService service
    private League testLeague
    private Team testTeam1
    private Team testTeam2
    private Team testTeam3
    private LeagueDTO testLeagueDTO

    void setup() {
        restTemplate = Mock(RestTemplate)
        service = Mock(ExternalApiService)
        testLeague = new League([leagueId: 524L])
        testTeam1 = new Team([teamId: 1L])
        testTeam2 = new Team([teamId: 2L])
        testTeam3 = new Team([teamId: 3L])
        testLeagueDTO = LeagueMapper.mapToDtoWithId(testLeague)
    }

    def "try get league by id"() {
        given:
        service.getLeague(524L) >> testLeagueDTO

        expect:
        service.getLeague(524L).getLeagueId() == 524L
    }

    def "try get teams by league"() {
        given:
        service.getTeamsByLeague(testLeagueDTO) >> Arrays.asList(testTeam1, testTeam2, testTeam3)

        expect:
        service.getTeamsByLeague(testLeagueDTO).size() == 3
    }
}
