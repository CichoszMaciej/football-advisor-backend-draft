package com.softylabs.services;

import com.softylabs.dao.PredictionRepository;
import com.softylabs.dto.FixtureDTO;
import com.softylabs.dto.PredictionDTO;
import com.softylabs.dto.TeamDTO;
import com.softylabs.mappers.PredictionMapper;
import com.softylabs.models.entity.Prediction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PredictionService {
    private final ExternalApiService externalApiService;
    private final FixtureService fixtureService;
    private final PredictionRepository predictionRepository;

    public ResponseEntity<PredictionDTO> findPrediction(Long matchId) {
        FixtureDTO fixtureDTO = fixtureService.findById(matchId);
        Optional<Prediction> prediction = predictionRepository.findById(matchId);
        TeamDTO homeTeam;
        TeamDTO awayTeam;

        if (fixtureDTO == null) {
            return ResponseEntity.notFound()
                    .build();
        } else {
            homeTeam = fixtureDTO.getHomeTeam();
            awayTeam = fixtureDTO.getAwayTeam();
        }

        if (prediction.isPresent() && prediction.get().getUpdateDate().equals(LocalDate.now())) {
            PredictionDTO predictionDTO = PredictionMapper.mapToDto(prediction.get());

            return ResponseEntity.of(Optional.of(predictionDTO));
        } else {
            PredictionDTO predictionDTO = save(PredictionMapper.mapToDtoFromApiResponse(
                    externalApiService.getPrediction(matchId), matchId, homeTeam, awayTeam));

            return ResponseEntity.of(Optional.of(predictionDTO));
        }
    }

    private PredictionDTO save(PredictionDTO predictionDTO) {
        return PredictionMapper.mapToDto(predictionRepository.save(PredictionMapper.mapToEntity(predictionDTO)));
    }
}
