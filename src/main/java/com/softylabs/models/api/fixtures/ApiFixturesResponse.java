package com.softylabs.models.api.fixtures;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiFixturesResponse {
    @JsonProperty("api")
    private FixturesResponse fixturesResponse;
}
