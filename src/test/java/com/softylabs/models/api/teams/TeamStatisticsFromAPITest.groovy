package com.softylabs.models.api.teams

import spock.lang.Specification

class TeamStatisticsFromAPITest extends Specification {

    def "try create TeamStatisticsFromApiTest"() {
        given:
        TeamStatisticsFromAPI statistics = new TeamStatisticsFromAPI()
        statistics.setGoalsAgainst(2)
        statistics.setGoalsFor(3)
        statistics.setLose(0)
        statistics.setDraw(0)
        statistics.setWin(1)
        statistics.setMatchesPlayed(1)

        expect:
        statistics.getGoalsAgainst() == 2
        statistics.getGoalsFor() == 3
        statistics.getLose() == 0
        statistics.getDraw() == 0
        statistics.getWin() == 1
        statistics.getMatchesPlayed() == 1
    }
}
