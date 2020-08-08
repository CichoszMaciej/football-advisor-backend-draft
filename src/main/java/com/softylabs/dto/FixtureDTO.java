package com.softylabs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FixtureDTO {
    private Long matchId;
    private LeagueDTO league;
    private OffsetDateTime eventDate;
    private String status;
    private String statusShort;
    private Integer elapsed;
    private Integer goalsHomeTeam;
    private Integer goalsAwayTeam;
    private TeamDTO homeTeam;
    private TeamDTO awayTeam;
    private String scoreHalfTime;
    private String scoreFullTime;
}
