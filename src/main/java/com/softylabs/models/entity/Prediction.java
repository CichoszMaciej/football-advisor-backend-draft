package com.softylabs.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Prediction {
    @Id
    private Long predictionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_team")
    private Team homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "away_team")
    private Team awayTeam;

    private String matchWinner;
    private Float goalsHome;
    private Float goalsAway;
    private String advice;
    private String homeTeamChance;
    private String awayTeamChance;
    private String drawChance;
    private LocalDate updateDate;
}
