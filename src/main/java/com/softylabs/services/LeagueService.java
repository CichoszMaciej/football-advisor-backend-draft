package com.softylabs.services;

import com.softylabs.dao.LeagueRepository;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.mappers.LeagueMapper;
import com.softylabs.models.entity.League;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeagueService {
    private final LeagueRepository leagueRepository;

    public List<LeagueDTO> findAll() {
        return leagueRepository.findAll()
                .stream()
                .map(LeagueMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<LeagueDTO> findById(Long id) {
        return leagueRepository.findById(id).map(LeagueMapper::mapToDtoWithId);
    }

    public List<LeagueDTO> findAllWithIds() {
        return leagueRepository.findAll()
                .stream()
                .map(LeagueMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public LeagueDTO save(LeagueDTO leagueDTO) {
        League league = LeagueMapper.mapToEntity(leagueDTO);

        return LeagueMapper.mapToDto(leagueRepository.save(league));
    }

    public List<LeagueDTO> saveAll(List<LeagueDTO> leaguesDTO) {
        List<League> leagues = leaguesDTO.stream()
                .map(LeagueMapper::mapToEntity)
                .collect(Collectors.toList());

        return leagueRepository.saveAll(leagues)
                .stream()
                .map(LeagueMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        leagueRepository.deleteById(id);
    }
}
