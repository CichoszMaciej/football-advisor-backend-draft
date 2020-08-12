package com.softylabs.mappers;

import com.softylabs.dto.PredictionDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.models.api.league.ApiLeagueResponse;
import com.softylabs.models.api.predictions.ApiPredictionsResponse;
import com.softylabs.models.api.predictions.PredictionFromApi;
import com.softylabs.models.entity.Prediction;
import com.softylabs.models.entity.Team;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PredictionMapper {
    public static Prediction mapToEntity(PredictionDTO predictionDTO) {
        Prediction prediction = new Prediction();

        prediction.setPredictionId(predictionDTO.getPredictionId());
        prediction.setHomeTeam(TeamMapper.mapToEntity(predictionDTO.getHomeTeam()));
        prediction.setAwayTeam(TeamMapper.mapToEntity(predictionDTO.getAwayTeam()));
        prediction.setMatchWinner(predictionDTO.getMatchWinner());
        prediction.setGoalsHome(predictionDTO.getGoalsHome());
        prediction.setGoalsAway(predictionDTO.getGoalsAway());
        prediction.setAdvice(predictionDTO.getAdvice());
        prediction.setHomeTeamChance(predictionDTO.getHomeTeamChance());
        prediction.setAwayTeamChance(predictionDTO.getAwayTeamChance());
        prediction.setDrawChance(predictionDTO.getDrawChance());
        prediction.setUpdateDate(predictionDTO.getUpdateDate());

        return prediction;
    }

    public static PredictionDTO mapToDto(Prediction prediction) {
        return PredictionDTO.builder()
                .predictionId(prediction.getPredictionId())
                .homeTeam(TeamMapper.mapToDtoWithId(prediction.getHomeTeam()))
                .awayTeam(TeamMapper.mapToDtoWithId(prediction.getAwayTeam()))
                .matchWinner(prediction.getMatchWinner())
                .goalsHome(prediction.getGoalsHome())
                .goalsAway(prediction.getGoalsAway())
                .advice(prediction.getAdvice())
                .homeTeamChance(prediction.getHomeTeamChance())
                .awayTeamChance(prediction.getAwayTeamChance())
                .drawChance(prediction.getDrawChance())
                .updateDate(prediction.getUpdateDate())
                .build();
    }

    public static PredictionDTO mapToDtoFromApiResponse(ApiPredictionsResponse apiPredictionsResponse, Long matchId,
                                                        TeamDTO homeTeam, TeamDTO awayTeam) {
        PredictionFromApi predictionFromApi = apiPredictionsResponse.getPredictionsResponse()
                .getPredictionFromApiList()
                .get(0);

        return PredictionDTO.builder()
                .predictionId(matchId)
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .matchWinner(predictionFromApi.getMatchWinner())
                .goalsHome(predictionFromApi.getGoalsHome())
                .goalsAway(predictionFromApi.getGoalsAway())
                .advice(predictionFromApi.getAdvice())
                .homeTeamChance(predictionFromApi.getHomeTeamChance())
                .awayTeamChance(predictionFromApi.getAwayTeamChance())
                .drawChance(predictionFromApi.getDrawChance())
                .updateDate(LocalDate.now())
                .build();
    }
}
