package com.softylabs.models.entity


import spock.lang.Specification

class TeamTest extends Specification {
    Team team
    League league

    void setup() {
        league = new League([leagueId: 1, name: 'liga'])
    }

    def "try build team and get all information"() {
        given:
        team = new Team()
        team.setTeamId(1L)
        team.setTeamName("team")
        team.setLogoUrl("url")
        team.setRank(1)
        team.setPoints(100)
        team.setLeague(league)
        team.setForm("WWWWW")
        team.setMatchesPlayed(1)
        team.setGoalsDiff(2)
        team.setWinCount(1)
        team.setDrawCount(0)
        team.setLoseCount(0)
        team.setGoalsFor(3)
        team.setGoalsAgainst(1)


        expect:
        team.getTeamId() == 1L
        team.getTeamName() == "team"
        team.getLogoUrl() == "url"
        team.getRank() == 1
        team.getPoints() == 100
        team.getLeague().getName() == league.getName()
        team.getForm() == "WWWWW"
        team.getMatchesPlayed() == 1
        team.getWinCount() == 1
        team.getDrawCount() == 0
        team.getLoseCount() == 0
        team.getGoalsFor() == 3
        team.getGoalsAgainst() == 1
        team.getGoalsDiff() == 2
    }
}
