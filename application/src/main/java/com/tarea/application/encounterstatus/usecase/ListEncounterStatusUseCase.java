package com.tarea.application.encounterstatus.usecase;

import com.tarea.application.encounterstatus.dto.EncounterStatusResponse;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;

import java.util.List;

public class ListEncounterStatusUseCase {

    private final EncounterStatusRepository encounterStatusRepository;

    public ListEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public List<EncounterStatusResponse> execute() {
        return encounterStatusRepository.findAll().stream()
                .map(encounterStatus -> new EncounterStatusResponse(
                    encounterStatus.id().value(),
                    encounterStatus.code(),
                    encounterStatus.name(),
                    encounterStatus.active(),
                    encounterStatus.createdAt(),
                    encounterStatus.updatedAt()
                ))
                .toList();
    }
}
