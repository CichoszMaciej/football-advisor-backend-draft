package com.softylabs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class TopScorerDTO {
    private Long playerId;
    private String firstName;
    private String lastName;
    private String position;
    private String nationality;
    private String teamName;
    private Integer goals;
    private Long leagueId;
}
