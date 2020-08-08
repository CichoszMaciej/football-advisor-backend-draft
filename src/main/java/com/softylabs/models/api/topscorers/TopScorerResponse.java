package com.softylabs.models.api.topscorers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopScorerResponse {
    @JsonProperty("results")
    private Integer results;
    @JsonProperty("topscorers")
    private List<TopScorerFromAPI> topScorers;
}
