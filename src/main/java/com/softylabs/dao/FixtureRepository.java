package com.softylabs.dao;

import com.softylabs.models.entity.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface FixtureRepository extends JpaRepository<Fixture, Long> {
    List<Fixture> findByHomeTeam_TeamIdAndAwayTeam_TeamId(Long homeTeam, Long awayTeam);

    List<Fixture> findByLeague_LeagueId(Long leagueId);

    List<Fixture> findByHomeTeam_TeamIdOrAwayTeam_TeamIdAndEventDateLessThanEqual(Long teamId, Long teamId2,
                                                                                  OffsetDateTime dateTime);
}
