package com.tarea.application.encountermodality.usecase;

import com.tarea.application.encountermodality.dto.EncounterModalityResponse;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;

import java.util.List;

public class ListEncounterModalityUseCase {

    private final EncounterModalityRepository encounterModalityRepository;

    public ListEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        this.encounterModalityRepository = encounterModalityRepository;
    }

    public List<EncounterModalityResponse> execute() {
        return encounterModalityRepository.findAll().stream()
                .map(encounterModality -> new EncounterModalityResponse(
                    encounterModality.id().value(),
                    encounterModality.code(),
                    encounterModality.name(),
                    encounterModality.active(),
                    encounterModality.createdAt(),
                    encounterModality.updatedAt()
                ))
                .toList();
    }
}
