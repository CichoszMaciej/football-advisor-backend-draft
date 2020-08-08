package com.softylabs.models.entity


import spock.lang.Specification

import java.time.LocalDate

class LeagueTest extends Specification {
    League league

    def "try build league and get, all information"() {
        given:
        league = new League()
        league.setLeagueId(1L)
        league.setName("la liga")
        league.setCountry("england")
        league.setCountryCode("gb")
        league.setSeason(2019)
        league.setCurrent(true)
        league.setSeasonStart(LocalDate.of(2020, 7, 30))
        league.setSeasonEnd(LocalDate.of(2021, 7, 30))
        league.setLogo("test url")
        league.setFlag("test url")


        expect:
        league.getLeagueId() == 1L
        league.getName() == "la liga"
        league.getCountry() == "england"
        league.getCountryCode() == "gb"
        league.getSeason() == 2019
        league.getCurrent()
        league.getSeasonStart().getYear() == 2020
        league.getSeasonEnd().getYear() == 2021
        league.getLogo() == "test url"
        league.getFlag() == "test url"

    }
}
