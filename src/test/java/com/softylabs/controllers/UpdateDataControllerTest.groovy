package com.softylabs.controllers

import com.softylabs.dto.LeagueDTO
import com.softylabs.dto.TeamDTO
import com.softylabs.mappers.LeagueMapper
import com.softylabs.mappers.TeamMapper
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UpdateDataControllerTest extends Specification {

    UpdateDataController controller
    League league1
    League league2
    LeagueDTO leagueDTO1
    LeagueDTO leagueDTO2
    TeamDTO teamDTO1
    TeamDTO teamDTO2

    void setup() {
        controller = Mock(UpdateDataController)
        league1 = new League(leagueId: 1L)
        league2 = new League(leagueId: 2L)
        leagueDTO1 = LeagueMapper.mapToDtoWithId(league1)
        leagueDTO2 = LeagueMapper.mapToDtoWithId(league2)
        teamDTO1 = TeamMapper.mapToDtoWithId(new Team([teamId: 1L, teamName: "team1", league: league1]))
        teamDTO2 = TeamMapper.mapToDtoWithId(new Team([teamId: 2L, teamName: "team2", league: league2]))
    }

    def "try update leagues"() {
        given:
        controller.updateLeaguesWithoutArgs() >> Arrays.asList(leagueDTO1, leagueDTO2)

        expect:
        controller.updateLeaguesWithoutArgs().get(0).getLeagueId() == leagueDTO1.getLeagueId()
        controller.updateLeaguesWithoutArgs().get(1).getLeagueId() == leagueDTO2.getLeagueId()
    }

    def "try update league"() {
        given:
        controller.updateLeague(1L) >> leagueDTO1

        expect:
        controller.updateLeague(1L).getLeagueId() == leagueDTO1.getLeagueId()
    }

    def "try update teams"() {
        given:
        controller.updateTeams() >> Arrays.asList(teamDTO1, teamDTO2)

        expect:
        controller.updateTeams().get(0).getTeamId() == teamDTO1.getTeamId()
        controller.updateTeams().get(1).getTeamId() == teamDTO2.getTeamId()
    }

}
