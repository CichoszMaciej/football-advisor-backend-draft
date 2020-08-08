package com.softylabs.mappers;

import com.softylabs.dto.LeagueDTO;
import com.softylabs.models.api.league.ApiLeagueResponse;
import com.softylabs.models.api.league.LeagueFromAPI;
import com.softylabs.models.entity.League;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LeagueMapper {
    public static LeagueDTO mapToDto(League league) {
        return LeagueDTO.builder()
                .name(league.getName())
                .country(league.getCountry())
                .countryCode(league.getCountryCode())
                .flag(league.getFlag())
                .logo(league.getLogo())
                .season(league.getSeason())
                .seasonStart(league.getSeasonStart())
                .seasonEnd(league.getSeasonEnd())
                .current(league.getCurrent())
                .build();
    }

    public static LeagueDTO mapToDtoWithId(League league) {
        LeagueDTO leagueDTO = mapToDto(league);
        leagueDTO.setLeagueId(league.getLeagueId());

        return leagueDTO;
    }

    public static League mapToEntity(LeagueDTO leagueDTO) {
        League league = new League();

        league.setLeagueId(leagueDTO.getLeagueId());
        league.setName(leagueDTO.getName());
        league.setCountry(leagueDTO.getCountry());
        league.setCountryCode(leagueDTO.getCountryCode());
        league.setFlag(leagueDTO.getFlag());
        league.setLogo(leagueDTO.getLogo());
        league.setSeason(leagueDTO.getSeason());
        league.setSeasonStart(leagueDTO.getSeasonStart());
        league.setSeasonEnd(leagueDTO.getSeasonEnd());
        league.setCurrent(leagueDTO.getCurrent());

        return league;
    }

    public static LeagueDTO mapToDtoFromApiResponse(ApiLeagueResponse apiLeagueResponse) {
        LeagueFromAPI leagueFromAPI = apiLeagueResponse.getLeagueResponse()
                .getLeagueFromAPIList()
                .get(0);

        return LeagueDTO.builder()
                .leagueId(leagueFromAPI.getLeagueId())
                .name(leagueFromAPI.getName())
                .country(leagueFromAPI.getCountry())
                .countryCode(leagueFromAPI.getCountryCode())
                .flag(leagueFromAPI.getFlag())
                .logo(leagueFromAPI.getLogo())
                .season(leagueFromAPI.getSeason())
                .seasonStart(leagueFromAPI.getSeasonStart())
                .seasonEnd(leagueFromAPI.getSeasonEnd())
                .current(leagueFromAPI.getCurrent())
                .build();
    }
}
