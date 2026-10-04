package com.tarea.application.encountertype.usecase;

import com.tarea.application.encountertype.dto.EncounterTypeResponse;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;

import java.util.List;

public class ListEncounterTypeUseCase {

    private final EncounterTypeRepository encounterTypeRepository;

    public ListEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        this.encounterTypeRepository = encounterTypeRepository;
    }

    public List<EncounterTypeResponse> execute() {
        return encounterTypeRepository.findAll().stream()
                .map(encounterType -> new EncounterTypeResponse(
                    encounterType.id().value(),
                    encounterType.code(),
                    encounterType.name(),
                    encounterType.active(),
                    encounterType.createdAt(),
                    encounterType.updatedAt()
                ))
                .toList();
    }
}
