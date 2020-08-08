package com.softylabs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LeagueDTO {
    private Long leagueId;
    private String name;
    private String country;
    private String countryCode;
    private Integer season;
    private LocalDate seasonStart;
    private LocalDate seasonEnd;
    private String logo;
    private String flag;
    private Boolean current;
}
