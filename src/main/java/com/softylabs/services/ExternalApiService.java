package com.softylabs.services;

import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.dto.TopScorerDTO;
import com.softylabs.mappers.FixtureMapper;
import com.softylabs.mappers.LeagueMapper;
import com.softylabs.mappers.TeamMapper;
import com.softylabs.mappers.TopScorerMapper;
import com.softylabs.models.api.fixtures.ApiFixturesResponse;
import com.softylabs.models.api.league.ApiLeagueResponse;
import com.softylabs.models.api.predictions.ApiPredictionsResponse;
import com.softylabs.models.api.teams.ApiTeamsResponse;
import com.softylabs.models.api.topscorers.ApiTopScorerResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Log
public class ExternalApiService {
    private final String apiKeyHeaderName = "x-rapidapi-key";
    private final String apiHostHeaderName = "x-rapidapi-host";
    private final RestTemplate restTemplate;
    @Value("${rapidapi.key}")
    private String apiKey;
    @Value("${rapidapi.url}")
    private String apiUrl;
    @Value("${rapidapi.host}")
    private String apiHost;
    @Value("${leagues}")
    private String leaguesIdsAsString;

    public ExternalApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TeamDTO> getTeamsByLeague(LeagueDTO leagueDTO) {
        HttpEntity httpEntity = new HttpEntity(getDefaultHeaders());
        ResponseEntity<ApiTeamsResponse> response = restTemplate.exchange(
                buildTeamsURL(leagueDTO.getLeagueId()),
                HttpMethod.GET,
                httpEntity,
                ApiTeamsResponse.class
        );

        return TeamMapper.mapToDtoListFromApiResponse(Objects.requireNonNull(response.getBody()), leagueDTO);
    }

    public List<TeamDTO> getTeamsByLeagues(List<LeagueDTO> leagues) {
        return leagues.stream()
                .map(this::getTeamsByLeague)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public LeagueDTO getLeague(Long leagueId) {
        HttpEntity httpEntity = new HttpEntity(getDefaultHeaders());
        ResponseEntity<ApiLeagueResponse> response = restTemplate.exchange(
                buildLeagueURL(leagueId),
                HttpMethod.GET,
                httpEntity,
                ApiLeagueResponse.class
        );

        return LeagueMapper.mapToDtoFromApiResponse(Objects.requireNonNull(response.getBody()));
    }

    public List<LeagueDTO> getLeagues() {
        return getLeaguesIdsAsList()
                .stream()
                .map(this::getLeague)
                .collect(Collectors.toList());
    }

    public List<FixtureDTO> getFixturesByLeague(LeagueDTO leagueDTO, List<TeamDTO> teamDTOList) {
        HttpEntity httpEntity = new HttpEntity(getDefaultHeaders());
        ResponseEntity<ApiFixturesResponse> response = restTemplate.exchange(
                buildFixturesURL(leagueDTO.getLeagueId()),
                HttpMethod.GET,
                httpEntity,
                ApiFixturesResponse.class
        );

        return FixtureMapper.mapToDtoListFromApiResponse(Objects.requireNonNull(response.getBody()),
                leagueDTO, teamDTOList);
    }

    public List<FixtureDTO> getFixtures(List<LeagueDTO> leagueDTOList, List<TeamDTO> teamDTOList) {
        List<FixtureDTO> fixtureDTOList = new ArrayList<>();

        for (LeagueDTO leagueDTO : leagueDTOList) {
            List<TeamDTO> teamDTOS = teamDTOList.stream()
                    .filter(teamDTO -> teamDTO.getLeague().getLeagueId().equals(leagueDTO.getLeagueId()))
                    .collect(Collectors.toList());

            fixtureDTOList.addAll(getFixturesByLeague(leagueDTO, teamDTOS));
        }

        return fixtureDTOList;
    }

    public ApiPredictionsResponse getPrediction(Long matchId) {
        HttpEntity httpEntity = new HttpEntity(getDefaultHeaders());
        ResponseEntity<ApiPredictionsResponse> response = restTemplate.exchange(
                buildPredictionsURL(matchId),
                HttpMethod.GET,
                httpEntity,
                ApiPredictionsResponse.class
        );
        return response.getBody();
    }

    public List<TopScorerDTO> getTopScorersByLeague(Long leagueId) {
        HttpEntity httpEntity = new HttpEntity(getDefaultHeaders());
        ResponseEntity<ApiTopScorerResponse> response = restTemplate.exchange(
                buildTopScorersURL(leagueId),
                HttpMethod.GET,
                httpEntity,
                ApiTopScorerResponse.class
        );
        return TopScorerMapper.mapToDtoListFromApiResponse(Objects.requireNonNull(response.getBody()));
    }

    private List<Long> getLeaguesIdsAsList() {
        return Arrays.stream(leaguesIdsAsString.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private HttpHeaders getDefaultHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(apiHostHeaderName, apiHost);
        httpHeaders.add(apiKeyHeaderName, apiKey);

        return httpHeaders;
    }

    private String buildTeamsURL(Long leagueId) {
        return apiUrl + "leagueTable/" + leagueId;
    }

    private String buildLeagueURL(Long leagueId) {
        return apiUrl + "leagues/league/" + leagueId;
    }

    private String buildFixturesURL(Long leagueId) {
        return apiUrl + "fixtures/league/" + leagueId;
    }

    private String buildPredictionsURL(Long matchId) { return apiUrl + "predictions/" + matchId; }

    private String buildTopScorersURL(Long leagueId) {
        return apiUrl + "topscorers/" + leagueId;
    }
}
