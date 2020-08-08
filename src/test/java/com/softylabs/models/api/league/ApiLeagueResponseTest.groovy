package com.softylabs.models.api.league


import spock.lang.Specification

import java.time.LocalDate

class ApiLeagueResponseTest extends Specification {
    def "try build ApiLeagueResponse"() {
        given:
        LeagueFromAPI league = new LeagueFromAPI()
        league.setLeagueId(1L)
        league.setName("la liga")
        league.setCountry("england")
        league.setCountryCode("gb")
        league.setSeason(2019)
        league.setCurrent(true)
        league.setSeasonStart(LocalDate.of(2019, 7, 9))
        league.setSeasonEnd(LocalDate.of(2020, 7, 9))
        league.setLogo("test url")
        league.setFlag("test url")

        List<LeagueFromAPI> leagues = Arrays.asList(league)

        LeagueResponse response = new LeagueResponse()
        response.setResults(1)
        response.setLeagueFromAPIList(leagues)

        ApiLeagueResponse apiLeagueResponse= new ApiLeagueResponse()
        apiLeagueResponse.setLeagueResponse(response)

        LeagueFromAPI leagueFromAPI = apiLeagueResponse.getLeagueResponse().getLeagueFromAPIList().get(0)

        expect:
        apiLeagueResponse.getLeagueResponse().getResults() == 1
        apiLeagueResponse.getLeagueResponse().getLeagueFromAPIList().size() == 1

        leagueFromAPI.getLeagueId() == 1L
        leagueFromAPI.getName() == "la liga"
        leagueFromAPI.getCountry() == "england"
        leagueFromAPI.getCountryCode() == "gb"
        leagueFromAPI.getSeason() == 2019
        leagueFromAPI.getCurrent()
        leagueFromAPI.getSeasonStart().getYear() == 2019
        leagueFromAPI.getSeasonEnd().getYear() == 2020
        leagueFromAPI.getLogo() == "test url"
        leagueFromAPI.getFlag() == "test url"


    }
}
