package com.softylabs.models.api.topscorers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiTopScorerResponse {
    @JsonProperty("api")
    private TopScorerResponse topScorerResponse;
}
