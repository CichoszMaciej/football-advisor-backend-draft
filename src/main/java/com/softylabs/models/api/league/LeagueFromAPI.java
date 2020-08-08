package com.softylabs.models.api.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class LeagueFromAPI {
    @JsonProperty("league_id")
    private Long leagueId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("country")
    private String country;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("season")
    private Integer season;

    @JsonProperty("season_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate seasonStart;

    @JsonProperty("season_end")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate seasonEnd;

    @JsonProperty("logo")
    private String logo;

    @JsonProperty("flag")
    private String flag;

    @JsonProperty("is_current")
    private Boolean current;
}
