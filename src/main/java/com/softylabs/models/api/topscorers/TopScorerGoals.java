package com.softylabs.models.api.topscorers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TopScorerGoals {
    @JsonProperty("total")
    public Integer total;

    @JsonProperty("assists")
    public Integer assists;

    @JsonProperty("conceded")
    public Object conceded;

    @JsonProperty("saves")
    public Object saves;
}
