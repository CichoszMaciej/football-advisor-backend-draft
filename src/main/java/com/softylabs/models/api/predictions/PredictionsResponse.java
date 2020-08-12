package com.softylabs.models.api.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.softylabs.models.api.fixtures.FixtureFromApi;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PredictionsResponse {
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("predictions")
    private List<PredictionFromApi> predictionFromApiList;
}
