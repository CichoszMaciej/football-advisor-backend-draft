package com.softylabs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.softylabs.models.entity.Team;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PredictionDTO {
    private Long predictionId;
    private TeamDTO homeTeam;
    private TeamDTO awayTeam;
    private String matchWinner;
    private Float goalsHome;
    private Float goalsAway;
    private String advice;
    private String homeTeamChance;
    private String awayTeamChance;
    private String drawChance;
    private LocalDate updateDate;
}
