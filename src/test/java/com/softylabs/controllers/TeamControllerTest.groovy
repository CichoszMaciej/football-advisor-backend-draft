package com.softylabs.controllers

import com.softylabs.dto.TeamDTO
import com.softylabs.mappers.TeamMapper
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class TeamControllerTest extends Specification {
    TeamController controller
    Team team1
    Team team2
    TeamDTO teamDTO1
    TeamDTO teamDTO2
    League league

    void setup() {
        controller = Mock(TeamController)
        league = new League([leagueId: 1, name: 'league'])
        team1 = new Team([teamId: 1, teamName: 'team 1', league: league])
        team2 = new Team([teamId: 2, teamName: 'team 2', league: league])
        teamDTO1 = TeamMapper.mapToDtoWithId(team1)
        teamDTO2 = TeamMapper.mapToDtoWithId(team2)
    }

    def 'get teams return a list of teams'() {
        given:
        controller.findAllTeams() >> Arrays.asList(teamDTO1, teamDTO2)

        when:
        def result = controller.findAllTeams()

        then:
        result == controller.findAllTeams()

    }

    def 'find team by id'() {
        given:
        controller.findTeam(1L) >> ResponseEntity.ok(teamDTO1)

        expect:
        controller.findTeam(1L).getBody().getTeamName() == teamDTO1.getTeamName()
    }

    def 'find teams by league'() {
        given:
        controller.findTeamsByLeagueId(1L) >> Arrays.asList(teamDTO1, teamDTO2)

        expect:
        controller.findTeamsByLeagueId(1L).size() == 2
    }
}
