package com.softylabs.services;

import com.softylabs.dao.FixtureRepository;
import com.softylabs.dto.FixtureDTO;
import com.softylabs.mappers.FixtureMapper;
import com.softylabs.models.entity.Fixture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FixtureService {
    private final FixtureRepository fixtureRepository;

    public List<FixtureDTO> saveAll(List<FixtureDTO> fixtureDTOList) {
        List<Fixture> fixtures = fixtureDTOList.stream()
                .map(FixtureMapper::mapToEntity)
                .collect(Collectors.toList());

        return fixtureRepository.saveAll(fixtures)
                .stream()
                .map(FixtureMapper::mapToDtoWithId)
                .collect(Collectors.toList());
    }
}
