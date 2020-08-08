package com.softylabs.dto


import spock.lang.Specification

import java.time.LocalDate

class LeagueDTOTest extends Specification {
    LeagueDTO dto

    def "test to field's name check"() {
        given:
        dto = LeagueDTO.builder()
                .leagueId(1L)
                .name("la liga")
                .country("england")
                .countryCode("gb")
                .season(2019)
                .current(true)
                .seasonStart(LocalDate.of(2020, 7, 30))
                .seasonEnd(LocalDate.of(2021, 7, 30))
                .logo("test url")
                .flag("test url")
                .build()

        expect:
        dto.getLeagueId() == 1L
        dto.getName() == "la liga"
        dto.getCountry() == "england"
        dto.getCountryCode() == "gb"
        dto.getSeason() == 2019
        dto.getCurrent()
        dto.getSeasonStart().getYear() == 2020
        dto.getSeasonEnd().getYear() == 2021
        dto.getLogo() == "test url"
        dto.getFlag() == "test url"
    }
}
