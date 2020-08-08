package com.softylabs.models.api.fixtures;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.softylabs.dto.LeagueDTO;
import com.softylabs.dto.TeamDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FixtureFromApi {
    @JsonProperty("fixture_id")
    private Long matchId;

    @JsonProperty("league_id")
    private Long leagueId;

    @JsonProperty("event_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime eventDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("statusShort")
    private String statusShort;

    @JsonProperty("elapsed")
    private Integer elapsed;

    @JsonProperty("goalsHomeTeam")
    private Integer goalsHomeTeam;

    @JsonProperty("goalsAwayTeam")
    private Integer goalsAwayTeam;

    private Long homeTeamId;
    private Long awayTeamId;

    private String scoreHalfTime;
    private String scoreFullTime;

    @JsonProperty("homeTeam")
    private void unpackHomeTeamId(Map<String, String> homeTeam) {
        homeTeamId = Long.parseLong(homeTeam.get("team_id"));
    }

    @JsonProperty("awayTeam")
    private void unpackAwayTeamId(Map<String, String> awayTeam) {
        awayTeamId = Long.parseLong(awayTeam.get("team_id"));
    }

    @JsonProperty("score")
    private void unpackScore(Map<String, String> score) {
        scoreHalfTime = score.get("halftime");
        scoreFullTime = score.get("fulltime");
    }

}
