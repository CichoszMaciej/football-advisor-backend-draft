package com.softylabs.dao;

import com.softylabs.models.entity.TopScorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopScorerRepository extends JpaRepository<TopScorer, Long> {
    List<TopScorer> findByLeagueId(Long leagueId);
}
