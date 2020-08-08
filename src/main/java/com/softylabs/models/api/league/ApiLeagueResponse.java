package com.softylabs.models.api.league;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiLeagueResponse {
    @JsonProperty("api")
    private LeagueResponse leagueResponse;
}
