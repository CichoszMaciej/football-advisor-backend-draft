package com.softylabs.controllers;

import com.softylabs.dto.PredictionDTO;
import com.softylabs.services.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prediction")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @GetMapping("/{matchId}")
    public ResponseEntity<PredictionDTO> findPrediction(@PathVariable("matchId") Long matchId) {
        return predictionService.findPrediction(matchId);
    }
}
