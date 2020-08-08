package com.softylabs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamDTO {
    private Long teamId;
    private Integer rank;
    private String teamName;
    private String logoUrl;
    private Integer points;
    private String form;
    private Integer matchesPlayed;
    private Integer winCount;
    private Integer drawCount;
    private Integer loseCount;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalsDiff;
    private LeagueDTO league;
}
