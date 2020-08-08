package com.softylabs.controllers

import com.softylabs.dto.LeagueDTO
import com.softylabs.mappers.LeagueMapper
import com.softylabs.models.entity.League
import com.softylabs.services.LeagueService
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import spock.lang.Specification

@SpringBootTest
class LeagueControllerTest extends Specification {
    LeagueController controller
    LeagueService service
    League league1
    League league2
    LeagueDTO leagueDTO1
    LeagueDTO leagueDTO2


    void setup() {
        controller = Mock(LeagueController)
        service = new LeagueService()
        league1 = new League([leagueId: 1, name: 'la liga'])
        league2 = new League([leagueId: 2, name: 'liga la'])
        leagueDTO1 = LeagueMapper.mapToDtoWithId(league1)
        leagueDTO2 = LeagueMapper.mapToDtoWithId(league2)
    }

    def "try get all league"() {
        given:
        controller.findLeagues() >> Arrays.asList(leagueDTO1, leagueDTO2)

        expect:
        controller.findLeagues().size() == 2
    }

    def "try get league by id"() {
        given:
        controller.findLeague(1L) >> ResponseEntity.ok(leagueDTO1)

        expect:
        controller.findLeague(1L).getBody().getName() == leagueDTO1.getName()
    }

    def "try get league by not exist id"() {
        given:
        controller.findLeague(666L) >> ResponseEntity.notFound().build()

        expect:
        controller.findLeague(666L).getStatusCodeValue() == 404
    }
}
