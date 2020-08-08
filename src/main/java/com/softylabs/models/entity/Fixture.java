package com.softylabs.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Setter
@Getter
public class Fixture {
    @Id
    private Long matchId;
    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    private OffsetDateTime eventDate;
    private String status;
    private String statusShort;
    private Integer elapsed;
    private Integer goalsHomeTeam;
    private Integer goalsAwayTeam;

    @ManyToOne
    @JoinColumn(name = "homeTeam_id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "awayTeam_id")
    private Team awayTeam;

    private String scoreHalfTime;
    private String scoreFullTime;
}
