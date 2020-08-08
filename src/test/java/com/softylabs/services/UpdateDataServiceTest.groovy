package com.softylabs.services

import com.softylabs.dto.LeagueDTO
import com.softylabs.dto.TeamDTO
import com.softylabs.mappers.LeagueMapper
import com.softylabs.mappers.TeamMapper
import com.softylabs.models.entity.League
import com.softylabs.models.entity.Team
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UpdateDataServiceTest extends Specification {

    private UpdateDataService service
    private League league1
    private League league2
    private LeagueDTO leagueDTO1
    private LeagueDTO leagueDTO2
    private TeamDTO teamDTO1
    private TeamDTO teamDTO2


    void setup() {
        service = Mock(UpdateDataService)
        league1 = new League(leagueId: 1L)
        league2 = new League(leagueId: 2L)
        leagueDTO1 = LeagueMapper.mapToDtoWithId(league1)
        leagueDTO2 = LeagueMapper.mapToDtoWithId(league2)
        teamDTO1 = TeamMapper.mapToDtoWithId(new Team([teamId: 1L, teamName: "team1", league: league1]))
        teamDTO2 = TeamMapper.mapToDtoWithId(new Team([teamId: 2L, teamName: "team2", league: league2]))
    }

    def "try update leagues"() {
        given:
        service.updateLeagues() >> Arrays.asList(leagueDTO1, leagueDTO2)

        expect:
        service.updateLeagues().get(0).leagueId == leagueDTO1.getLeagueId()
        service.updateLeagues().get(1).leagueId == leagueDTO2.getLeagueId()
    }

    def "try update league"() {
        given:
        service.updateLeague(1L) >> leagueDTO1

        expect:
        service.updateLeague(1L).getLeagueId() == leagueDTO1.getLeagueId()
    }

    def "try update teams"() {
        given:
        service.updateTeams() >> Arrays.asList(teamDTO1, teamDTO2)

        expect:
        service.updateTeams().get(0).getTeamId() == teamDTO1.getTeamId()
        service.updateTeams().get(1).getTeamId() == teamDTO2.getTeamId()
    }
}
