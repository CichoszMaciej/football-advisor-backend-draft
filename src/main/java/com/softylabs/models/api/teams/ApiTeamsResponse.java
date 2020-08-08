package com.softylabs.models.api.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiTeamsResponse {
    @JsonProperty("api")
    private TeamsResponse teamsResponse;
}
