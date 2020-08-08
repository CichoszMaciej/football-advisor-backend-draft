package com.softylabs.models.api.teams

import com.softylabs.dto.LeagueDTO
import spock.lang.Specification

class TeamFromAPITest extends Specification {
    def "try build TeamFromApi"() {
        given:
        LeagueDTO leagueDTO = LeagueDTO.builder()
                .name("test")
                .build()

        TeamStatisticsFromAPI statistics = new TeamStatisticsFromAPI()
        statistics.setGoalsAgainst(2)
        statistics.setGoalsFor(3)
        statistics.setLose(0)
        statistics.setDraw(0)
        statistics.setWin(1)
        statistics.setMatchesPlayed(1)

        TeamFromAPI team = new TeamFromAPI()
        team.setTeamId(1L)
        team.setTeamName("team")
        team.setLogoUrl("url")
        team.setRank(1)
        team.setPoints(100)
        team.setForm("WWWWW")
        team.setLeague(leagueDTO)
        team.setTeamStatistics(statistics)
        team.setGoalsDiff(2)


        expect:
        team.getTeamId() == 1L
        team.getTeamName() == "team"
        team.getLogoUrl() == "url"
        team.getRank() == 1
        team.getPoints() == 100
        team.getLeague().getName() == leagueDTO.getName()
        team.getForm() == "WWWWW"
        team.getGoalsDiff() == 2

        team.getTeamStatistics().getGoalsAgainst() == 2
        team.getTeamStatistics().getGoalsFor() == 3
        team.getTeamStatistics().getLose() == 0
        team.getTeamStatistics().getDraw() == 0
        team.getTeamStatistics().getWin() == 1
        team.getTeamStatistics().getMatchesPlayed() == 1
    }
}
