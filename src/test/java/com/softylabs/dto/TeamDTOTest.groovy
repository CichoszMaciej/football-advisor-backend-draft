package com.softylabs.dto


import spock.lang.Specification

class TeamDTOTest extends Specification {
    TeamDTO dto

    def "test to field's name check"() {
        given:
        LeagueDTO leagueDTO = LeagueDTO.builder()
                .name("test")
                .build()

        dto = TeamDTO.builder()
                .teamName("team")
                .logoUrl("url")
                .rank(1)
                .points(100)
                .league(leagueDTO)
                .form("WWWWW")
                .matchesPlayed(1)
                .winCount(1)
                .drawCount(0)
                .loseCount(0)
                .goalsFor(3)
                .goalsAgainst(1)
                .goalsDiff(2)
                .build()


        expect:
        dto.getTeamName() == "team"
        dto.getLogoUrl() == "url"
        dto.getRank() == 1
        dto.getPoints() == 100
        dto.getLeague().getName() == leagueDTO.getName()
        dto.getForm() == "WWWWW"
        dto.getMatchesPlayed() == 1
        dto.getWinCount() == 1
        dto.getDrawCount() == 0
        dto.getLoseCount() == 0
        dto.getGoalsFor() == 3
        dto.getGoalsAgainst() == 1
        dto.getGoalsDiff() == 2
    }
}
