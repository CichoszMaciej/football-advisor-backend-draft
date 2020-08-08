package com.softylabs.services

import com.softylabs.dto.TeamDTO
import com.softylabs.mappers.TeamMapper
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class TeamServiceTest extends Specification {
    TeamService service
    Team team1
    Team team2
    Team teamTest
    TeamDTO team1DTO
    TeamDTO team2DTO
    League league

    void setup() {
        service = Mock(TeamService)
        league = new League([leagueId: 1, name: 'la la liga'])
        team1 = new Team([teamId: 1, teamName: 'team 1', league: league])
        team2 = new Team([teamId: 2, teamName: 'team 2', league: league])
        teamTest = new Team([teamId: 5, teamName: 'team 78'])
        team1DTO = TeamMapper.mapToDtoWithId(team1)
        team2DTO = TeamMapper.mapToDtoWithId(team2)
    }

    def "try find all teams"() {
        given:
        service.findAll() >> Arrays.asList(team1, team2)

        expect:
        service.findAll().size() == 2
    }

    def "try find team by id"() {
        given:
        service.findById(1L) >> Optional.of(team1)

        expect:
        service.findById(1L).get().getTeamName() == team1.getTeamName()
    }

    def "try get find teams by league id"() {
        given:
        service.findByLeagueId(1L) >> Arrays.asList(team1, team2)

        expect:
        service.findByLeagueId(1L).size() == 2
    }

    def "try add team"() {
        given:
        service.save(team1DTO) >> team1DTO

        expect:
        service.save(team1DTO).getTeamId() == team1DTO.getTeamId()
    }

    def "try add all teams"() {
        given:
        service.saveAll(Arrays.asList(team1DTO, team2DTO)) >> Arrays.asList(team1DTO, team2DTO)

        expect:
        service.saveAll(Arrays.asList(team1DTO, team2DTO)).get(0).getTeamId() == team1DTO.getTeamId()
        service.saveAll(Arrays.asList(team1DTO, team2DTO)).get(1).getTeamId() == team2DTO.getTeamId()
    }

    def "try delete team"() {
        given:
        service.deleteById(1L) >> team1DTO.setTeamId(null)

        expect:
        team1DTO.getTeamId() == null
    }

}
