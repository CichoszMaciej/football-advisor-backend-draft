package com.softylabs.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Setter
@Getter
public class League {
    @Id
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
