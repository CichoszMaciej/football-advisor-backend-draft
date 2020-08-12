package com.softylabs.models.api.predictions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PredictionFromApi {
    @JsonProperty("match_winner")
    private String matchWinner;

    @JsonProperty("goals_home")
    private Float goalsHome;

    @JsonProperty("goals_away")
    private Float goalsAway;

    @JsonProperty("advice")
    private String advice;

    private String homeTeamChance;
    private String awayTeamChance;
    private String drawChance;

    @JsonProperty("winning_percent")
    private void unpackChances(Map<String, String> chances) {
        homeTeamChance = chances.get("home");
        drawChance = chances.get("draws");
        awayTeamChance = chances.get("away");
    }
}
