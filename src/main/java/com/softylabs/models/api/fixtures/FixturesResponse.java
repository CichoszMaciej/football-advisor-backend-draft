package com.softylabs.models.api.fixtures;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FixturesResponse {
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("fixtures")
    private List<FixtureFromApi> matchFromApiList;
}
