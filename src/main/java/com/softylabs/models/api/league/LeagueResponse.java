package com.softylabs.models.api.league;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LeagueResponse {
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("leagues")
    private List<LeagueFromAPI> leagueFromAPIList;
}
