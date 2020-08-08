package com.softylabs.models.api.teams;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamsResponse {
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("standings")
    private List<List<TeamFromAPI>> standings;
}
