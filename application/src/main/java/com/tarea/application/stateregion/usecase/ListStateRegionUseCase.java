package com.tarea.application.stateregion.usecase;

import com.tarea.application.stateregion.dto.StateRegionResponse;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;

import java.util.List;

public class ListStateRegionUseCase {

    private final StateRegionRepository stateRegionRepository;

    public ListStateRegionUseCase(StateRegionRepository stateRegionRepository) {
        this.stateRegionRepository = stateRegionRepository;
    }

    public List<StateRegionResponse> execute() {
        return stateRegionRepository.findAll().stream()
                .map(stateRegion -> new StateRegionResponse(
                    stateRegion.id().value(),
                    stateRegion.nameRegion(),
                    stateRegion.codeRegion(),
                    stateRegion.description(),
                    stateRegion.active(),
                    stateRegion.countryId().value(),
                    stateRegion.createdAt(),
                    stateRegion.updatedAt()
                ))
                .toList();
    }
}
