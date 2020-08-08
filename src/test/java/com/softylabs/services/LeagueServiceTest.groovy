package com.softylabs.services

import com.softylabs.dto.LeagueDTO
import com.softylabs.mappers.LeagueMapper
import com.softylabs.models.entity.League
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LeagueServiceTest extends Specification {
    LeagueService service
    League league1
    League league2
    League league5
    LeagueDTO league1DTO
    LeagueDTO league2DTO
    LeagueDTO league5DTO

    void setup() {
        service = Mock(LeagueService)
        league1 = new League([leagueId: 1, name: 'la liga'])
        league2 = new League([leagueId: 2, name: 'liga la'])
        league5 = new League([leagueId: 5, name: 'lala liga'])
        league1DTO = LeagueMapper.mapToDtoWithId(league1)
        league2DTO = LeagueMapper.mapToDtoWithId(league2)
        league5DTO = LeagueMapper.mapToDtoWithId(league5)
    }

    def "try find all league"() {
        given:
        service.findAll() >> [league1, league2, league5]

        expect:
        service.findAll().size() == 3
    }

    def "try find league by id"() {
        given:
        service.findById(1L) >> Optional.of(league1)

        expect:
        service.findById(1L).get().getName() == league1.getName()
    }

    def "try find all with ids"() {
        given:
        service.findAllWithIds() >> Arrays.asList(league1, league2, league5)

        expect:
        service.findAllWithIds().get(0).getLeagueId() == league1.getLeagueId()
        service.findAllWithIds().get(1).getLeagueId() == league2.getLeagueId()
        service.findAllWithIds().get(2).getLeagueId() == league5.getLeagueId()
    }

    def "try find league by id, when league doesn't exist"() {
        given:
        service.findById(3L) >> null

        expect:
        service.findById(3L) == null
    }

    def "try add league"() {
        given:
        service.save(league1DTO) >> league1DTO

        expect:
        service.save(league1DTO).getLeagueId() == league1DTO.getLeagueId()
    }

    def "try add all leagues"() {
        given:
        service.saveAll(Arrays.asList(league1DTO, league2DTO, league5DTO)) >> Arrays.asList(league1DTO, league2DTO, league5DTO)

        expect:
        service.saveAll(Arrays.asList(league1DTO, league2DTO, league5DTO)).get(0).getLeagueId() == league1DTO.getLeagueId()
        service.saveAll(Arrays.asList(league1DTO, league2DTO, league5DTO)).get(1).getLeagueId() == league2DTO.getLeagueId()
        service.saveAll(Arrays.asList(league1DTO, league2DTO, league5DTO)).get(2).getLeagueId() == league5DTO.getLeagueId()
    }

    def "try delete league"() {
        given:
        service.deleteById(1L) >> league1DTO.setLeagueId(null)

        expect:
        league1DTO.getLeagueId() == null
    }

}
