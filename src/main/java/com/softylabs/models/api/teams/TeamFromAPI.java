package com.softylabs.models.api.teams;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.softylabs.dto.LeagueDTO;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TeamFromAPI {
    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("team_id")
    private Long teamId;

    @JsonProperty("teamName")
    private String teamName;

    @JsonProperty("logo")
    private String logoUrl;

    @JsonProperty("group")
    private String group;

    @JsonProperty("forme")
    private String form;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;

    @JsonProperty("teamStatistics")
    @JsonAlias("all")
    private TeamStatisticsFromAPI teamStatistics;

    @JsonProperty("goalsDiff")
    private Integer goalsDiff;

    @JsonProperty("points")
    private Integer points;

    @JsonProperty("lastUpdate")
    private String lastUpdate;

    private LeagueDTO league;
}
