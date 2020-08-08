package com.softylabs.models.api.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamStatisticsFromAPI {

    @JsonProperty("matchsPlayed")
    private Integer matchesPlayed;

    @JsonProperty("win")
    private Integer win;

    @JsonProperty("draw")
    private Integer draw;

    @JsonProperty("lose")
    private Integer lose;

    @JsonProperty("goalsFor")
    private Integer goalsFor;

    @JsonProperty("goalsAgainst")
    private Integer goalsAgainst;
}
