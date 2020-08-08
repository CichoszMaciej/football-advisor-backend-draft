package com.softylabs.mappers;

import com.softylabs.dto.TopScorerDTO;
import com.softylabs.models.api.topscorers.ApiTopScorerResponse;
import com.softylabs.models.api.topscorers.TopScorerFromAPI;
import com.softylabs.models.entity.TopScorer;

import java.util.List;
import java.util.stream.Collectors;

public class TopScorerMapper {

    public static TopScorerDTO mapToDto(TopScorer topScorer) {
        return TopScorerDTO.builder()
                .playerId(topScorer.getPlayerId())
                .firstName(topScorer.getFirstName())
                .lastName(topScorer.getLastName())
                .nationality(topScorer.getNationality())
                .position(topScorer.getPosition())
                .teamName(topScorer.getTeamName())
                .goals(topScorer.getGoals())
                .leagueId(topScorer.getLeagueId())
                .build();
    }

    public static TopScorer mapToEntity(TopScorerDTO topScorerDTO) {
        return TopScorer.builder()
                .playerId(topScorerDTO.getPlayerId())
                .firstName(topScorerDTO.getFirstName())
                .lastName(topScorerDTO.getLastName())
                .nationality(topScorerDTO.getNationality())
                .position(topScorerDTO.getPosition())
                .teamName(topScorerDTO.getTeamName())
                .goals(topScorerDTO.getGoals())
                .leagueId(topScorerDTO.getLeagueId())
                .build();

    }

    public static TopScorerDTO mapFromApiToDto(TopScorerFromAPI topScorerFromAPI) {
        return TopScorerDTO.builder()
                .playerId(topScorerFromAPI.getPlayerId())
                .firstName(topScorerFromAPI.getFirstname())
                .lastName(topScorerFromAPI.getLastname())
                .nationality(topScorerFromAPI.getNationality())
                .position(topScorerFromAPI.getPosition())
                .teamName(topScorerFromAPI.getTeamName())
                .goals(topScorerFromAPI.getGoals().getTotal())
                .build();
    }

    public static List<TopScorerDTO> mapToDtoListFromApiResponse(ApiTopScorerResponse apiTopScorerResponse) {
        List<TopScorerFromAPI> topScorerFromAPIList = apiTopScorerResponse.getTopScorerResponse().getTopScorers();
        return topScorerFromAPIList.stream()
                .map(TopScorerMapper::mapFromApiToDto)
                .collect(Collectors.toList());
    }
}