package com.softylabs.models.api.topscorers;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TopScorerFromAPI {
    @JsonProperty("player_id")
    public Long playerId;

    @JsonProperty("player_name")
    public String playerName;

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("position")
    public String position;

    @JsonProperty("lastname")
    public String lastname;

    @JsonProperty("nationality")
    public String nationality;

    @JsonProperty("team_id")
    public Long teamId;

    @JsonProperty("team_name")
    public String teamName;

    @JsonProperty("goals")
    @JsonAlias("all")
    public TopScorerGoals goals;
}
