package com.softylabs.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class Team {
    @Id
    private Long teamId;
    private Integer rank;
    private String teamName;
    private String logoUrl;
    private Integer points;
    private String form;
    private Integer matchesPlayed;
    private Integer winCount;
    private Integer drawCount;
    private Integer loseCount;
    private Integer goalsFor;
    private Integer goalsAgainst;
    private Integer goalsDiff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    private League league;
}
