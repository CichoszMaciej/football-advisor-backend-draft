package com.softylabs.models.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopScorer {
    @Id
    private Long playerId;
    private String firstName;
    private String lastName;
    private String position;
    private String nationality;
    private String teamName;
    private Integer goals;
    private Long leagueId;
}
