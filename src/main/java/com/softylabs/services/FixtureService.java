package com.softylabs.services;

import com.softylabs.dao.FixtureRepository;
import com.softylabs.dto.FixtureDTO;
import com.softylabs.mappers.FixtureMapper;
import com.softylabs.models.entity.Fixture;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FixtureService {
    private final FixtureRepository fixtureRepository;

    public List<FixtureDTO> findAll(Pageable pageable) {
        return fixtureRepository.findAll(pageable)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findLastFixturesByTeamId(Long teamId) {
        OffsetDateTime dateTimeNow = OffsetDateTime.now();

        return fixtureRepository.findFirst5ByHomeTeam_TeamIdOrAwayTeam_TeamIdAndEventDateLessThanEqualOrderByEventDateDesc(teamId, teamId,
                dateTimeNow).stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findLastFixturesByLeagueId(Long leagueId) {
        OffsetDateTime dateTimeNow = OffsetDateTime.now();

        return fixtureRepository.findFirst10ByLeague_LeagueIdAndEventDateLessThanEqualOrderByEventDateDesc(leagueId,
                dateTimeNow)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findNextFixturesByTeamId(Long teamId) {
        OffsetDateTime dateTimeNow = OffsetDateTime.now();

        return fixtureRepository.findFirst5ByHomeTeam_TeamIdOrAwayTeam_TeamIdAndEventDateGreaterThanEqualOrderByEventDate
                (teamId, teamId, dateTimeNow)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findNextFixturesByLeagueId(Long leagueId) {
        OffsetDateTime dateTimeNow = OffsetDateTime.now();

        return fixtureRepository.findFirst10ByLeague_LeagueIdAndEventDateGreaterThanEqualOrderByEventDate(leagueId,
                dateTimeNow)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> find10NextFixturesFromAllLeague() {
        OffsetDateTime dateTimeNow = OffsetDateTime.now();

        return fixtureRepository.findFirst10ByEventDateGreaterThanEqualOrderByEventDate(dateTimeNow)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findFixturesByLeagueId(Long leagueId) {
        return fixtureRepository.findByLeague_LeagueId(leagueId)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> findFixturesByTwoTeams(Long firstTeamId, Long secondTeamId) {
        List<FixtureDTO> fixtureDTOList = fixtureRepository.findByHomeTeam_TeamIdAndAwayTeam_TeamId(firstTeamId, secondTeamId)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());

        List<FixtureDTO> secondFixtureDTOList = fixtureRepository.findByHomeTeam_TeamIdAndAwayTeam_TeamId(secondTeamId,
                firstTeamId)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());

        fixtureDTOList.addAll(secondFixtureDTOList);

        return fixtureDTOList;
    }

    public List<FixtureDTO> saveAll(List<FixtureDTO> fixtureDTOList) {
        List<Fixture> fixtures = fixtureDTOList.stream()
                .map(FixtureMapper::mapToEntity)
                .collect(Collectors.toList());

        return fixtureRepository.saveAll(fixtures)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }
}
