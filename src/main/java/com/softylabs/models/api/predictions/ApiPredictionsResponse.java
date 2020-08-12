package com.softylabs.models.api.predictions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiPredictionsResponse {
    @JsonProperty("api")
    private PredictionsResponse predictionsResponse;
}
