package com.softylabs.services;

import com.softylabs.dao.TeamRepository;
import com.softylabs.dto.TeamDTO;
import com.softylabs.mappers.TeamMapper;
import com.softylabs.models.entity.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public List<TeamDTO> findAll() {
        return teamRepository.findAll()
                .stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<TeamDTO> findAllWithIds() {
        return teamRepository.findAll()
                .stream()
                .map(TeamMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }

    public List<TeamDTO> findByLeagueId(Long leagueId) {
        return teamRepository.findByLeague_LeagueId(leagueId)
                .stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public Optional<TeamDTO> findById(Long id) {
        return teamRepository.findById(id)
                .map(TeamMapper::mapToDto);
    }

    public TeamDTO save(TeamDTO teamDTO) {
        Team team = TeamMapper.mapToEntity(teamDTO);

        return TeamMapper.mapToDtoWithId(teamRepository.save(team));
    }

    public List<TeamDTO> saveAll(List<TeamDTO> teamsDTOS) {
        List<Team> teams = teamsDTOS.stream()
                .map(TeamMapper::mapToEntity)
                .collect(Collectors.toList());

        return teamRepository.saveAll(teams)
                .stream()
                .map(TeamMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
