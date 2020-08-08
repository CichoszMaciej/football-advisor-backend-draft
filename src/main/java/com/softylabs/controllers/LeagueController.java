package com.softylabs.controllers;

import com.softylabs.dto.LeagueDTO;
import com.softylabs.services.LeagueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leagues")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class LeagueController {
    private final LeagueService leagueService;

    @GetMapping("/")
    public List<LeagueDTO> findLeagues() {
        return leagueService.findAll();
    }

    @GetMapping("/{league_id}")
    public ResponseEntity<LeagueDTO> findLeague(@PathVariable("league_id") Long leagueId) {
        return ResponseEntity.of(leagueService.findById(leagueId));
    }
}
