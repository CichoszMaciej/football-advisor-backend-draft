package com.softylabs.services;

import com.softylabs.dao.TopScorerRepository;
import com.softylabs.dto.TopScorerDTO;
import com.softylabs.mappers.TopScorerMapper;
import com.softylabs.models.entity.TopScorer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TopScorersService {

    private final TopScorerRepository topScorerRepository;

    public List<TopScorerDTO> saveAll(List<TopScorerDTO> topScorersDTO) {
        List<TopScorer> topScorers = topScorersDTO.stream()
                .map(TopScorerMapper::mapToEntity)
                .collect(Collectors.toList());

        return topScorerRepository.saveAll(topScorers)
                .stream()
                .map(TopScorerMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<TopScorerDTO> findTopScorersByLeague(Long leagueId) {
        return topScorerRepository.findByLeagueId(leagueId).stream()
                .map(TopScorerMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
